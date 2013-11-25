/**
 * 
 *
 */

import java.net.*;
import java.io.*;
//import java.util.*; // no se necesita de momento

public class ClientHandler extends Thread{

    Socket clientSocket;
    static int numSockets;
    PrintStream serverOutput;
    int id;
    DataInputStream userInput;
    String nickname;
    String passwd;
    String inputString;
    ClientHandler clientCount[];

    public ClientHandler(Socket socket, ClientHandler clientCount[]){

        this.clientSocket = socket;
        this.clientCount = clientCount;

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

            for(i=0; i<10; i++) {
                if(clientCount[i]!=null && clientCount[i]!= this)
                	clientCount[i].serverOutput.print("\n++ " + nickname  + " entered the room ++\n>> :");
            }

            while(true) {
            	serverOutput.print(">> :\t");
                inputString = userInput.readLine();

                if(inputString.startsWith("/exit")) {
                	serverOutput.println("SERVER:\tGoodbye " + nickname);
                	break;
                }
                for(i=0; i<10; i++) {
                    if(clientCount[i]!=null && clientCount[i]!= this)
                    	clientCount[i].serverOutput.print("\n" + nickname +": " + inputString + "\n>> : ");
                }
            }

            for(i=0; i<10;i++){
                if(clientCount[i]!=null && clientCount[i]!= this)
                	clientCount[i].serverOutput.print("\n++ " + nickname + " left ++\n>> : ");
                	userInput.close();
		            serverOutput.close();
		            clientSocket.close();
            }
            

            for(i=0; i<10; i++) {
                if(clientCount[i] == this) clientCount[i] = null;
            }

        }catch(IOException var){


        }
    }
    
}