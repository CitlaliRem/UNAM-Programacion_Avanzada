/**
 *  TODO: Comentarios cabezales proyecto 
 *
 */

import java.net.*;
import java.util.*; 

public class Server{

    static Socket client;
	 static ArrayList<ClientHandler> listOfClients = new ArrayList<ClientHandler>();
    public static void main(String args[]){

        try{
            ServerSocket chatServer = new ServerSocket(8888);
            System.out.println("Server up and running!!");

            while(true){
                client = chatServer.accept();
                ClientHandler clientObj = new ClientHandler(client,listOfClients);
                listOfClients.add(clientObj); //agregamos el cliente objeto a la lista dentro de la clase
                clientObj.start(); //clientHandler


            }

            /* TODO: este cÃ³digo espera una entrada del usuario para salir
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
