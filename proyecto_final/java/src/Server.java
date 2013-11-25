/**
 *  TODO: Comentarios cabezales proyecto 
 *
 */

import java.net.*;
//import java.util.Scanner;
import java.util.*; 
//import java.io.*; // no se necesita de momento

public class Server{


    static Socket client;
    static ClientHandler clientCount[] = new ClientHandler[10];

    public static void main(String args[]){
        int i=0;
        //String shutdown = null ; // variable para entrada del usuario 

        try{
        	//while
            ServerSocket chatServer = new ServerSocket(8888);
            System.out.println("Server up and running!!");

            while(i<10){
                client = chatServer.accept();
                ClientHandler clientObj = new ClientHandler(client, clientCount);
                clientCount[i] = clientObj;
                clientObj.start();
                i++;


            }

            /* TODO: este código espera una entrada del usuario para salir
             * Para que funcione necesitamos que chatServer.accept() trabaje el en background 
             * porque de otra forma esta esperando a dos eventos a la vez: la
             * entrada del usuario y un nuevo cliente que se conecte
             * 
	            System.out.println("Type 'q' for quitting the server");
	            Scanner userInterrupt = new Scanner(System.in);
	            shutdown = userInterrupt.next();
	            System.out.println(shutdown);

            	if(shutdown == "q") {
            		System.out.println("Exiting the server");
            		System.exit(0);
            	}
            	*/
        }catch(Exception var){
            System.out.println("An exception ocurred");
            System.out.println(var);
        }

    }
}
