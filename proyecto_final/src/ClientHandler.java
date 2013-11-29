/**
 * 
 *
 */

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class ClientHandler extends Thread{


    Socket clientSocket;
    static int numSockets;
    PrintStream serverOutput;
    DataInputStream userInput;
    private SimpleDateFormat timeStamp;
    int id;
    String nickname;
    String passwd;
    String inputString;
    ArrayList<String>  usersOnline = new ArrayList<String>();
    ArrayList <ClientHandler> clientCount = new  ArrayList <ClientHandler>();
	private ArrayList<String> chatLog;

	public ClientHandler(Socket socket,ArrayList <ClientHandler> tmpClient, ArrayList<String> chatLog){

		this.chatLog = chatLog;
		this.clientSocket = socket;
		this.clientCount = tmpClient;
		numSockets = numSockets + 1;
		id = numSockets;
		//timeStamp = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		timeStamp = new SimpleDateFormat("E MMM dd yyyy  HH:mm:ss  ");
		System.out.println(this);
	}

	public void SignUp () {
		try {
			serverOutput.print("Choose your nickname: ");
			String newNickname = userInput.readLine();
		    serverOutput.print("Choose your password: ");
		    String newPassword = userInput.readLine();



			int tries = 0;
			while(tries < 4) {
	        	if (PasswordCheck.isValid(newPassword) == true) {
	            	PasswordCheck.propSetter(newNickname, newPassword);
	            	nickname = newNickname;
	            	serverOutput.println("You can now log into your new account");
	            	break;
	
	        	} else {
	
		        	if (tries == 3) {
		            	serverOutput.println("Too many tries... Exiting");
		        		userInput.close();
						serverOutput.close();
						clientSocket.close();
						numSockets -= 1;
		        	}
	        		//System.out.println("LOG: " + time + " User choose invalid password " + (tries+1) + " times");
	        		serverOutput.println("Password should be min 8 characters long and contain min 2 digits");
	            	serverOutput.print("Choose your password: ");
	            	newPassword = userInput.readLine();
	
	        		tries += 1;
	
	    		}
			} 
		}catch (IOException e) {
			e.printStackTrace();
		}  	

    }

	public void WriteToFile(ArrayList<String> chatLog) {
/*
        for (int j = 0; j < chatLog.size(); j++) {
        	String temp = chatLog.get(j);
        	System.out.println(temp);
		}
*/
		PrintWriter logFile = null;
		try {
			logFile = new PrintWriter(new FileWriter("./chatlog.txt"));
		} catch (IOException e) {
			System.out.println("ERROR: Can't open logfile");
		}
		
		for (int i = 0; i < chatLog.size(); i++) {
			logFile.println(chatLog.get(i));
		}
		logFile.close();
	}

    public String toString() {
        return "ID : " + id + " ,Socket: " + numSockets;

    }

    
    public void run() {
        int i;
        String time = timeStamp.format(new Date());
	
        try {
            userInput = new DataInputStream(clientSocket.getInputStream());
            serverOutput = new PrintStream(clientSocket.getOutputStream());

            serverOutput.println("**********************************");
            serverOutput.println("*** Welcome to the Chat Server ***");
            serverOutput.println("**********************************");
            serverOutput.print("Nick: ");
            nickname = userInput.readLine();
            
            Boolean signedUp = PasswordCheck.checkSignUp(nickname);

            if (signedUp == false) {
            	serverOutput.println(nickname + " not found in database");
            	serverOutput.println("Do you want to register? (y/n)");
            	String option = userInput.readLine();
            	if(! option.equals("y")) {
            		userInput.close();
    				serverOutput.close();
    				clientSocket.close();
    				numSockets -= 1;
            	} else {
	            	System.out.println("LOG: User choose option: " + option);
	            	SignUp();
            	}
            }

            serverOutput.print("Password: ");
            passwd = userInput.readLine();

			Boolean validPass = PasswordCheck.checkCredentials(nickname, passwd);
			
			if (validPass == false) {
				serverOutput.println("Sorry, you have no access to this chat");
				userInput.close();
				serverOutput.close();
				clientSocket.close();
				numSockets -= 1;
			}
            nickname = Tools.capitalizeFirstLetter(nickname);
            
            if (usersOnline.contains(nickname)) {
                serverOutput.println("SERVER: Sorry, you have no access to this chat because "+nickname+"  has be online");//mi ingles no es muy bueno no se si se escriba asi
                userInput.close();
                serverOutput.close();
                clientSocket.close();
               
            } else {
            	serverOutput.println("\nSERVER:\tHi " + nickname + "\n>> : ");
            }

            serverOutput.println("\nSERVER:\tHi " + nickname + "\n>> : ");

            for(i=0; i<clientCount.size(); i++) {
                if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                	clientCount.get(i).serverOutput.print("\n++ " + nickname  + " entered the room ++\n>> :");
            }

            while(true) {
            	serverOutput.print(">> : ");
                inputString = userInput.readLine();
                if (! inputString.startsWith("/")) {
                	time = timeStamp.format(new Date());
                	chatLog.add(time + " " + nickname + ": " + inputString);
                } else {
                	System.out.println("String starting with /");
                	System.out.println("String: " + inputString);
                	UserCommands.CommandSwitch(serverOutput, inputString, nickname);
                }

                if (UserCommands.ExitChat(serverOutput, inputString, nickname)) break;

                for(i=0; i<clientCount.size(); i++) {
                    if(clientCount.get(i)!=null && clientCount.get(i)!= this) {
                    	clientCount.get(i).serverOutput.print("\n" + time + " " + nickname +": " + inputString + "\n>> : ");
                    }
                }
            }


            for(i=0; i<clientCount.size();i++){
                if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                	clientCount.get(i).serverOutput.print("\n++ " + nickname + " left ++\n>> : ");
                	userInput.close();
		            serverOutput.close();
		            clientSocket.close();
            }
            
            
            for(i=0; i<clientCount.size(); i++) {
                if(clientCount.get(i) == this) clientCount.set(i,null);///tengo duda en esta linea de codigo, para 
					 //que la estamos implementando
            }
            
            WriteToFile(chatLog);

        } catch(IOException var){
        }
    }    


}