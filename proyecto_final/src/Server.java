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
import java.text.SimpleDateFormat;

public class Server extends Thread{

	private static final int PORT = 8888;
	static Socket client;
    static ArrayList<ClientThread> clientList = new ArrayList<ClientThread>();
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
								System.out.println("Client accepted");
								ClientThread cThread = new ClientThread(client);
								cThread.start();
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
			System.out.println("Server exception");
			//TODO
		}

		finally {
			//chatServer.close(); //TODO: no me funciona esto de momento, habría que ver por qué..
			System.out.println("Shutting down the server");
			if (! clientList.isEmpty()) {
				System.out.println("Shutting down user connections");
				try {
					for(int i = 0; i < clientList.size(); ++i) {
						ClientThread closeThread = clientList.get(i);
						closeThread.serverOutput.println("Server shutting down in 4 seconds");
					}
						Thread.sleep(4000);
					for(int i = 0; i < clientList.size(); ++i) {
						ClientThread closeThread = clientList.get(i);
						closeThread.serverOutput.println("Server shutting down in 4 seconds");
						try {
							closeThread.serverOutput.close();
							closeThread.userInput.close();
							closeThread.socket.close(); 
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
    class ClientThread extends Thread {
		 /* los hilos para cada cliente que se conecta */
		Socket socket;
		DataInputStream userInput;
		PrintStream serverOutput;
		private String nickname;
	    private String passwd;
	    private String inputString;
	    static int numSockets;
	    private SimpleDateFormat timeStamp;
	    private String time;
		private static final String HISTORYLOG = "chatlog.txt";


		// Constructor
		ClientThread(Socket socket) {
			this.socket = socket;

			try
			{
				serverOutput = new PrintStream(socket.getOutputStream());
				userInput  = new DataInputStream(socket.getInputStream());
			}
			catch (IOException e) {
				System.out.println("Exception creating new Input/output Streams: " + e);
				return;
			}
		}


		@Override
		public void run() {
            try {
				serverOutput = new PrintStream(socket.getOutputStream());
				userInput = new DataInputStream(socket.getInputStream());

				serverMsg("**********************************");
				serverMsg("*** Welcome to the Chat Server ***");
				serverMsg("**********************************");

	            serverMsg("Nick: ");

	            nickname = userInput.readLine();
	            		
	            Boolean signedUp = AccessTools.checkSignUp(nickname);

	            if (signedUp == false) {
	            	serverMsg(nickname + " not found in database");
	            	serverMsg("Do you want to register? (y/n)");

	            	String option = userInput.readLine();

	            	if(! option.equals("y")) {
	            		numSockets -= 1;

	            		closeConnections(userInput, serverOutput, socket);
	            		
	            	} else {
		            	System.out.println("LOG: User choose option: " + option);
		            	System.out.println("inside else: " + userInput);
		            	AccessTools.SignUp(serverOutput, userInput, socket, nickname, numSockets);
	            	}
	            }

	            serverOutput.print("Password: ");

	            passwd = userInput.readLine();

				Boolean validPass = AccessTools.checkCredentials(nickname, passwd);
				
				if (validPass == false) {
					serverOutput.println("Sorry, you have no access to this chat");
					closeConnections(userInput, serverOutput, socket);
					numSockets -= 1;
				}
	            nickname = Tools.capitalizeFirstLetter(nickname);

	            serverOutput.println("\nSERVER:\tHi " + nickname + "\n>> : ");

	            for(int i=0; i < Server.clientList.size(); i++) {
	                if(Server.clientList.get(i) != null && Server.clientList.get(i) != this) {
	                	Server.clientList.get(i).serverOutput.print("\n++ " + nickname  + " entered the room ++\n>> :");
	                }
	            }

	            for(int i=0; i< Server.clientList.size(); i++) {
	                if(Server.clientList.get(i)!=null && Server.clientList.get(i)!= this)
	                	Server.clientList.get(i).serverOutput.print("\n++ " + nickname  + " entered the room ++\n>> :");
	            }

	            while(true) {
	            	serverOutput.print(">> : ");
	            	inputString = userInput.readLine();
	            	
	                if (! inputString.startsWith("/")) {
	                	time = timeStamp.format(new Date());
	                	Server.chatLog.add(time + " " + nickname + ": " + inputString);
		                for(int i=0; i<Server.clientList.size(); i++) {
		                    if(Server.clientList.get(i)!=null && Server.clientList.get(i)!= this) {
		                    	Server.clientList.get(i).serverOutput.print("\n" + time + " " + nickname +": " + inputString + "\n>> : ");
		                    }
		                }
	                } else {
	                	if (UserActions.ExitChat(serverOutput, inputString, nickname)) break;

	                		UserActions.CommandSwitch(serverOutput, inputString, nickname);
	                }
	            }

	            // Terminando la conxión del cliente después de /exit
	            for(int i = 0; i < Server.clientList.size(); i++){
	                if(Server.clientList.get(i) != null && Server.clientList.get(i) != this) {
	                	Server.clientList.get(i).serverOutput.print("\n++ " + nickname + " left ++\n>> : ");
	                	closeConnections(userInput, serverOutput, socket);
	                }
	            }
	            
	            Tools.WriteToFile(Server.chatLog, HISTORYLOG);
            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			closeConnections(userInput, serverOutput, socket);

		}

	private void serverMsg(String message) throws IOException {

		if(!socket.isConnected()) {
			closeConnections(userInput, serverOutput, socket);;
		}
		serverOutput.println(message);
	}


    public static void closeConnections(DataInputStream userInput, PrintStream serverOutput, Socket clientSocket) {
    	//System.out.println("Debugging: inside closeConnections");
    	try {
			serverOutput.println("User connection closed");
			userInput.close();
			serverOutput.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Can't close client connection");
		}
    }
 }