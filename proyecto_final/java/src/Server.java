/**
 *  TODO: Comentarios cabezales proyecto 
 *
 */

import java.net.*;
import java.util.*; 
import java.io.*; // no se necesita de momento


public class Server{

    static ArrayList clientes = new ArrayList();
    static Socket client;
    //ClientHandler lista=new ClientHandler();
	 static ArrayList<ClientHandler> listOfClients = new ArrayList<ClientHandler>();//generamos una lista
    //static ClientHandler clientCount[] = new ClientHandler[10];                 que nos acepte guardar
//                                                                               objetos en ella
    public static void main(String args[]){
        // int i = 0; // ya no se usa
        //String shutdown = null ; // variable para entrada del usuario 

        try{
        	//while
            ServerSocket chatServer = new ServerSocket(8888);
            System.out.println("Server up and running!!");

            while(true){
                client = chatServer.accept();
                ClientHandler clientObj = new ClientHandler(client,listOfClients,clientes);
                //clientCount[i] = clientObj;
                listOfClients.add(clientObj);//agregamos el cliente objeto a la lista dentro de la clase
                clientObj.start();//clientehandler
                //i++;


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
