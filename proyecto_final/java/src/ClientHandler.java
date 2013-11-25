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

            serverOutput.println("*** Welcome to the Chat Server ***");
            serverOutput.print("Choose alias: ");
            nickname = Tools.capitalizeFirstLetter(userInput.readLine());
            serverOutput.println("SERVER: Welcome " + nickname);

            for(i=0; i<10; i++) {
                if(clientCount[i]!=null && clientCount[i]!= this)
                    clientCount[i].serverOutput.print("\n++ " + nickname  + " entered the room ++\nME: ");
            }

            while(true) {
            	serverOutput.print("ME: ");
                inputString = userInput.readLine();

                if(inputString.startsWith("/exit")) {
                	serverOutput.println("Goodbye " + nickname);
                	break;
                }
                for(i=0; i<10; i++) {
                    if(clientCount[i]!=null && clientCount[i]!= this)
                        clientCount[i].serverOutput.print("\n" + nickname +": " + inputString + "\nME: ");
                }
            }

            for(i=0; i<10;i++){
                if(clientCount[i]!=null && clientCount[i]!= this)
                   clientCount[i].serverOutput.print("\n++ " + nickname + " left ++\nME: ");
            }

            userInput.close();
            serverOutput.close();
            clientSocket.close();

            for(i=0; i<10; i++) {
                if(clientCount[i] == this) clientCount[i] = null;
            }

        }catch(IOException var){


        }
    }
}