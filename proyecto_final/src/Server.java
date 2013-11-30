 /* 	Proyecto Final - Programación Avanzada y Métodos Numéricos
 *  Semestre 14-1
 *  
 * 	Chat Server con las siguientes funcionalidades:	 
 *  1. login y password
 *	2. bitacora de pláticas (chatlog)
 *	3. lista de usuarios conectados (/showUsers)
 *	4. mensajes privados (/msg)
 *	5. Bloqueo de usuarios
 *	6. cliente automático (opcional)
 *
 *
 */

import java.io.*;
import java.net.*;
import java.util.*; 

public class Server extends Thread{

	private static final int PORT = 8888;
	static Socket client;
    static ArrayList<ClientHandler> listOfClients = new ArrayList<ClientHandler>();
    static ArrayList<String> chatLog = new ArrayList<String>(); 
    
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

	
	@Override
	public void start() {
		boolean runServer = true;

		recallHistory(chatLog);

		try {
			final ServerSocket chatServer = new ServerSocket(PORT);

			while(runServer == true) {
				System.out.println("Server waiting for Clients on port " + PORT + ".");
					
				new Thread(new Runnable() {
	                @Override
					public void run() {
	                    try {
	                    	while (true) {
								client = chatServer.accept();
				                ClientHandler clientObj = new ClientHandler(client,listOfClients, chatLog);
				                listOfClients.add(clientObj); //agregamos el cliente objeto a la lista dentro de la clase
				                clientObj.start(); //clientHandler
			                   	}

	                    } catch(IOException e) {
	                    	e.printStackTrace();
	                    }
	                }
	            }).start();

				System.out.println("Press 'q' for quitting the server");
				Scanner scanner = new Scanner(System.in);
				String adminAction1 = scanner.nextLine();
				if (adminAction1.equals("q")) {
					runServer = false;
				}
			} 
		}catch(Exception e) {
			//TODO
		}

		finally {
			//chatServer.close(); //TODO: no me funciona esto de momento, habría que ver por qué..
			System.out.println("Shutting down the server");
			if (! listOfClients.isEmpty()) {
				System.out.println("Shutting down user connections");
				try {
					for(int i = 0; i < listOfClients.size(); ++i) {
						ClientHandler closeThread = listOfClients.get(i);
						closeThread.serverOutput.println("Server shutting down in 4 seconds");
					}
						Thread.sleep(4000);
					for(int i = 0; i < listOfClients.size(); ++i) {
						ClientHandler closeThread = listOfClients.get(i);
						closeThread.serverOutput.println("Server shutting down in 4 seconds");
						try {
							closeThread.serverOutput.close();
							closeThread.userInput.close();
							ClientHandler.clientSocket.close(); 
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				} catch(InterruptedException e) {
				    Thread.currentThread().interrupt();
				}
			}
			System.exit(0);
		}
	}
		
		
    public static void main(String args[]){

        try{
    	Server server = new Server();
		server.start();

            
        }catch(Exception e){
            System.out.println("An exception ocurred");
            System.out.println(e);
        }

    }
}