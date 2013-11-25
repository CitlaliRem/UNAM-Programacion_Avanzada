
import java.net.*;
import java.io.*;

import java.util.*; // no se necesita de momento

public class ClientHandler extends Thread{

    Socket clientSocket;
    static int numSockets;
    PrintStream serverOutput;
    int id;
    DataInputStream userInput;
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
                	serverOutput.print(clientCount.get(i)+"\n++ " + nickname  + " entered the room ++\n>> :");
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
                	serverOutput.print(clientCount.get(i)+"\n++ " + nickname + " left ++\n>> : ");
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
}
