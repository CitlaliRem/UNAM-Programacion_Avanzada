/**
 * 
 *
 */

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientHandler extends Thread{


	//private static final String USER_DATABASE = "users.xml";
	private static final String HISTORYLOG = "chatlog.txt";
    Socket clientSocket;
    static int numSockets;
    PrintStream serverOutput = null;
    //DataInputStream userInput;
    Scanner userInput = null;
    private SimpleDateFormat timeStamp;
    int id;
    String nickname;
    String passwd;
    String inputString;
    ArrayList <ClientHandler> clientCount = new  ArrayList <ClientHandler>();
	private ArrayList<String> chatLog;

	public ClientHandler(Socket socket,ArrayList <ClientHandler> tmpClient, ArrayList<String> chatLog){

		this.chatLog = chatLog;
		this.clientSocket = socket;
		this.clientCount = tmpClient;
		numSockets = numSockets + 1;
		id = numSockets;
		timeStamp = new SimpleDateFormat("E MMM dd yyyy  HH:mm:ss  ");
		//System.out.println(this);
	}

    public String toString() {
        return "ID : " + id + " ,Socket: " + numSockets;

    }
    public static String RecordUserInput(Scanner userInput) {
    	String outputString = null;
    	try {
    	if (userInput.hasNextLine()) {
    		 outputString = userInput.nextLine();
    	}
		} catch (IllegalStateException e) {
			return outputString;
		} catch(NullPointerException e) {
			return outputString;
		}
    	return outputString;
    }

    public static void closeConnections(Scanner userInput, PrintStream serverOutput, Socket clientSocket) {
    	System.out.println("Debugging: inside closeConnections");
    	try {
			serverOutput.println("User connection closed");
			userInput.close();
			serverOutput.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Can't close client connection");
		}
    }
    
    
    public void run() {
        int i;
        String time = null;
	
        try {
        	userInput = new Scanner(clientSocket.getInputStream());

            System.out.println("Debugging: after scanner " + userInput);
        	//userInput.useDelimiter("\n"); 
            serverOutput = new PrintStream(clientSocket.getOutputStream());

            serverOutput.println("**********************************");
            serverOutput.println("*** Welcome to the Chat Server ***");
            serverOutput.println("**********************************");

            serverOutput.print("Nick: ");

            		System.out.println("Debugging: before recorduserinput" + userInput);
            nickname = RecordUserInput(userInput);
            
            Boolean signedUp = PasswordCheck.checkSignUp(nickname);

            if (signedUp == false) {
            	serverOutput.println(nickname + " not found in database");
            	serverOutput.println("Do you want to register? (y/n)");

            	String option = RecordUserInput(userInput);
            	System.out.println("Debugging1: " + option);

            	if(! option.equals("y")) {
            		numSockets -= 1;
            		System.out.println("Debugging: before closeConnections" + userInput);
            		closeConnections(userInput, serverOutput, clientSocket);
            		
            	} else {
	            	System.out.println("LOG: User choose option: " + option);
	            	System.out.println("inside else: " + userInput);
	            	PasswordCheck.SignUp(serverOutput, userInput, clientSocket, nickname, numSockets);
            	}
            }

            serverOutput.print("Password: ");

            passwd = RecordUserInput(userInput);

			Boolean validPass = PasswordCheck.checkCredentials(nickname, passwd);
			
			if (validPass == false) {
				serverOutput.println("Sorry, you have no access to this chat");
				closeConnections(userInput, serverOutput, clientSocket);
				numSockets -= 1;
			}
            nickname = Tools.capitalizeFirstLetter(nickname);
            serverOutput.println("\nSERVER:\tHi " + nickname + "\n>> : ");

            for(i=0; i<clientCount.size(); i++) {
                if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                	clientCount.get(i).serverOutput.print("\n++ " + nickname  + " entered the room ++\n>> :");
            }

            while(true) {
            	serverOutput.print(">> : ");
            	inputString = RecordUserInput(userInput);
            	System.out.println("Debugging inside while: " + inputString);
            	
                if (! inputString.startsWith("/")) {
                	time = timeStamp.format(new Date());
                	chatLog.add(time + " " + nickname + ": " + inputString);
	                for(i=0; i<clientCount.size(); i++) {
	                    if(clientCount.get(i)!=null && clientCount.get(i)!= this) {
	                    	clientCount.get(i).serverOutput.print("\n" + time + " " + nickname +": " + inputString + "\n>> : ");
	                    }
	                }
                } else {
                	if (UserCommands.ExitChat(serverOutput, inputString, nickname)) break;

                		UserCommands.CommandSwitch(serverOutput, inputString, nickname);
                }
            }

            /* Terminando la conxión del cliente después de /exit */
            for(i=0; i<clientCount.size();i++){
                if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                	clientCount.get(i).serverOutput.print("\n++ " + nickname + " left ++\n>> : ");
                	closeConnections(userInput, serverOutput, clientSocket);
            }
            
            Tools.WriteToFile(chatLog, HISTORYLOG);
            
            
        } catch(IOException var){
        }
    }    


}