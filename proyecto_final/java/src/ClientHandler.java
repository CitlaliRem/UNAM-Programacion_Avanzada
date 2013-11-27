/**
 * 
 *
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
//import java.util.*; // no se necesita de momento
import java.util.ArrayList;

public class ClientHandler extends Thread{

    Socket clientSocket;
    static int numSockets;
    PrintStream serverOutput;
    DataInputStream userInput;
    int id;
    String nickname;
    String passwd;
    String inputString;
    //ClientHandler clientCount[];
    ArrayList clientCount = new ArrayList();

    public ClientHandler(){

    }
    public ClientHandler(Socket socket){

        this.clientSocket = socket;
        //this.clientCount = tmpClient;
        numSockets = numSockets + 1;
        id = numSockets;
        System.out.println(this);
    }

    public String toString() {
        return "ID : " + id + " ,Socket: " + numSockets;

    }

    public void run() {
        int i;
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
	            	serverOutput.print("Choose your nickname: ");
	            	String newNickname = userInput.readLine();

	            	serverOutput.print("Choose your password: ");
	            	String newPassword = userInput.readLine();

	            	/*
	            	public char[] readPassword() {
	                    return readPassword("");
	                }
	            	 */

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

		            		System.out.println("LOG: User choose invalid password " + (tries+1) + " times");
		            		serverOutput.println("Password should be min 8 characters long and contain min 2 digits");
			            	serverOutput.print("Choose your password: ");
			            	newPassword = userInput.readLine();

		            		tries += 1;

	            		}
	            	}

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
            serverOutput.println("\nSERVER:\tHi " + nickname + "\n>> : ");

            for(i=0; i<clientCount.size(); i++) {
                if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                	serverOutput.print(clientCount.get(i)+"\n++ " + nickname  + " entered the room ++");
            }

            while(true) {
            	serverOutput.print(">> :\t");
                inputString = userInput.readLine();

                if(inputString.startsWith("/exit")) {
                	serverOutput.println("SERVER:\tGoodbye " + nickname);
                	break;
                }
                for(i=0; i<clientCount.size(); i++) {
                    if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                    	serverOutput.print(clientCount.get(i)+"\n" + nickname +": " + inputString + "\n>> : ");
                }
            }

            for(i=0; i<clientCount.size();i++){
                if(clientCount.get(i)!=null && clientCount.get(i)!= this)
                	serverOutput.print(clientCount.get(i)+"\n++ " + nickname + " left ++");
                	userInput.close();
		            serverOutput.close();
		            clientSocket.close();
            }
            
            for(i=0; i<clientCount.size(); i++) {
                if(clientCount.get(i) == this) clientCount.remove(null);
            }

        }catch(IOException var){
        }
    }    
//}

	/**
	 * 
	 */
	private void readPassword() {
		// TODO Auto-generated method stub
	}	
	
}