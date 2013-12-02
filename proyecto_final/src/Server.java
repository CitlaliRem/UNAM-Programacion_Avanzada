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
	private static final String HISTORYLOG = "./chatlog.txt";
	private static final String BLACKLIST = "./banned.txt"; 

	static Socket client;
    static ArrayList<ClientThread> clientList = new ArrayList<ClientThread>();
    static ArrayList<String> chatLog = new ArrayList<String>();
    static ArrayList<String> usersBanned = new ArrayList<String>();
	static ArrayList<String> usersOnline = new ArrayList<String>(); 
    
	 public static void addUsersBanned(ArrayList<String> usersBanned){
         Scanner user = null;
         try{
             user = new Scanner(new File(BLACKLIST));
             user.useDelimiter("\n");
         }catch(FileNotFoundException e){
             System.out.println("File not found");
         }
         while(user.hasNext()){
             String contact = user.next();
             usersBanned.add(contact.substring(contact.indexOf('*')+1,contact.indexOf('#')));
         }
         user.close();
     }

	public static void recallHistory(ArrayList<String> arrayList) {
		Scanner historyLog = null;
		try {
			historyLog = new Scanner(new File(HISTORYLOG));
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

		AdminActions admin = new AdminActions();
		addUsersBanned(usersBanned);
        System.out.println("***Welcome to the Admin panel***");

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
								clientList.add(cThread);
								cThread.start();
			                   	}

	                    } catch(IOException e) {
	                    	e.printStackTrace();
	                    }
	                }
	            }).start();
				
				

				runServer = admin.action();
			} 
		}catch(Exception e) {
			System.out.println("Server exception");
		}

		finally {
			System.out.println("Shutting down the server");
			if (! clientList.isEmpty()) {
				System.out.println("Shutting down user connections");
				try {
					for(int i = 0; i < clientList.size(); ++i) {
						//ClientThread closeThread = clientList.get(i);
						ClientThread.serverOutput.println("Server shutting down in 4 seconds");
					}
						Thread.sleep(4000);
					for(int i = 0; i < clientList.size(); ++i) {
						ClientThread closeThread = clientList.get(i);
						ClientThread.serverOutput.println("Server shutting down in 4 seconds");
						try {
							ClientThread.serverOutput.close();
							ClientThread.userInput.close();
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
		static DataInputStream userInput;
		static PrintStream serverOutput;
		private String nickname;
	    private String passwd;
	    private String inputString;
	    static int numSockets;
	    private SimpleDateFormat timeStamp;
	    //private String time;
		private static final String HISTORYLOG = "chatlog.txt";


		// Constructor
		ClientThread(Socket socket) {
			this.socket = socket;
			timeStamp = new SimpleDateFormat("E MMM dd yyyy  HH:mm:ss  ");

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

				String time = timeStamp.format(new Date());

				serverOutput.println("**********************************");
				serverOutput.println("*** Welcome to the Chat Server ***");
				serverOutput.println("**********************************");
				serverOutput.println("Connecting on " + time);

	            serverOutput.print("Nick: ");

	            nickname = userInput.readLine();
	            		
	            Boolean signedUp = AccessTools.checkSignUp(nickname);

	            if (signedUp == false) {
		            	AccessTools.SignUp(serverOutput, userInput, socket, nickname, numSockets);
	            }
	            
//	            if(! socket.isClosed()) { 	/* si el usuario estaba registrado o se registró....*/
		            serverOutput.print("Password: ");
	
		            passwd = userInput.readLine();
	
		            System.out.println("User entered password " + passwd);

		            /* Validación de la clave */
					Boolean validPass = AccessTools.checkCredentials(nickname, passwd);
					
					System.out.println("socket closed last? " + socket.isClosed());
					if (validPass == false) {
						//System.out.println("socket alive? " + socket.isClosed());
						serverOutput.println("Sorry, you have no access to this chat");
						closeConnections(userInput, serverOutput, socket);
						numSockets -= 1;
					}
		            nickname = Tools.capitalizeFirstLetter(nickname);
	
		            serverOutput.println("\nSERVER:\tHi " + nickname + "\n>> : ");
	
	
		            for(int i=0; i< Server.clientList.size(); i++) {
		                if(Server.clientList.get(i)!=null && Server.clientList.get(i)!= this) {
							Server.clientList.get(i);
							ClientThread.serverOutput.print("\n++ " + nickname  + " entered the room ++\n>> :");
						}
		            }
	
	            if(! socket.isClosed()) { 	/* si el usuario estaba registrado o se registró....*/
		            while(true) {
		            	serverOutput.print(">> : ");
		            	inputString = userInput.readLine();
		            	
		                if (! inputString.startsWith("/")) {
		                	//time = timeStamp.format(new Date());
		                	Server.chatLog.add(time + " " + nickname + ": " + inputString);
			                for(int i=0; i<Server.clientList.size(); i++) {
			                    if(Server.clientList.get(i)!=null && Server.clientList.get(i)!= this) {
			                    	//Server.clientList.get(i).serverOutput.println("\n" + time + " " + nickname +": " + inputString + "\n>> : ");
			                    	Server.clientList.get(i).serverMsg(inputString);
			                    }
			                }
		                } else {
		                	if (UserActions.ExitChat(inputString, nickname)) break;
	
		                		UserActions.CommandSwitch(inputString);
		                }
		            }
	
		            // Terminando la conxión del cliente después de /exit
		            for(int i = 0; i < Server.clientList.size(); i++){
		                if(Server.clientList.get(i) != null && Server.clientList.get(i) != this) {
		                	Server.clientList.get(i);
							ClientThread.serverOutput.print("\n++ " + nickname + " left ++\n>> : ");
		                	closeConnections(userInput, serverOutput, socket);
		                }
		            }
	            }

	            Tools.WriteToFile(Server.chatLog, HISTORYLOG);
            
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	private void serverMsg(String message) throws IOException {

        String time = timeStamp.format(new Date());

		if(!socket.isConnected()) {
			closeConnections(userInput, serverOutput, socket);;
		}

		serverOutput.println("\n" + time + " " + nickname +": " + message + "\n>> : ");
		serverOutput.println(time + message);
	}


    public static void closeConnections(DataInputStream userInput, PrintStream serverOutput, Socket socket) {
    	try {
			serverOutput.println("User connection closed");
			userInput.close();
			serverOutput.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Can't close client connection");
		}
    }
}
