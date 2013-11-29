import java.io.*;
import java.net.*;
import java.util.*; 

public class Server{

public static final int PORT = 8888;

        static Socket client;
    static ArrayList<ClientHandler> listOfClients = new ArrayList<ClientHandler>();
    static ArrayList<String> chatLog = new ArrayList<String>();
	 static ArrayList usersOnline = new ArrayList(); 
    
    
        public static void recallHistory(ArrayList<String> arrayList) {
                Scanner historyLog = null;
                try {
                        historyLog = new Scanner(new File("./chatLog.txt"));
                        historyLog.useDelimiter("\n");
                } catch (FileNotFoundException e) {
                        System.out.println("ERROR: Logfile not found");
                }
                
                while (historyLog.hasNext()) {
                        String line = historyLog.next();
                        chatLog.add(line);
                }
                historyLog.close();
        }

        
        
    public static void main(String args[]){

        try{
            ServerSocket chatServer = new ServerSocket(PORT);
            recallHistory(chatLog);
            System.out.println("Server up and running!!");
            System.out.println("Waiting for connections on port " + PORT);
            
            while(true){
                   
                client = chatServer.accept();
                ClientHandler clientObj = new ClientHandler(client,listOfClients, chatLog,usersOnline);
                listOfClients.add(clientObj); //agregamos el cliente objeto a la lista dentro de la clase
                clientObj.start(); //clientHandler
                
            }
            
            /* TODO: este cÃƒÂ³digo espera una entrada del usuario para salir
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
