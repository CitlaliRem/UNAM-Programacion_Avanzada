/**
 * 
 */
package test_chat;

/**
 * @author arytloc
 *
 */
	import java.net.*;
	import java.io.*;
	import java.util.*;

	public class Client  {

		// for I/O
		private ObjectInputStream sInput;		// to read from the socket
		private ObjectOutputStream sOutput;		// to write on the socket
		private Socket socket;
		
		// the server, the port and the username
		private String server, username;
		private int port;

		// Constructor
		Client(String server, int port, String username) {
			this.server = server;
			this.port = port;
			this.username = username;
		}
		
		/*
		 * To start the dialog
		 */
		public boolean start() {
			// try to connect to the server
			try {
				socket = new Socket(server, port);
			} 
			// if it failed not much I can so
			catch(Exception ec) {
				display("Error connectiong to server:" + ec);
				return false;
			}
			
			String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
			display(msg);
		
			/* Creating both Data Stream */
			try
			{
				sInput  = new ObjectInputStream(socket.getInputStream());
				sOutput = new ObjectOutputStream(socket.getOutputStream());
			}
			catch (IOException eIO) {
				display("Exception creating new Input/output Streams: " + eIO);
				return false;
			}

			// creates the Thread to listen from the server 
			new ListenFromServer().start();
			// Send our username to the server this is the only message that we
			// will send as a String. All other messages will be ChatMessage objects
			try
			{
				sOutput.writeObject(username);
			}
			catch (IOException eIO) {
				display("Exception doing login : " + eIO);
				disconnect();
				return false;
			}
			// success we inform the caller that it worked
			return true;
		}

		/*
		 * To send a message to the console or the GUI
		 */
		private void display(String msg) {
			System.out.println(msg);      // println in console mode
		}
		
		/*
		 * To send a message to the server
		 */
		void sendMessage(ChatMessage msg) {
			try {
				sOutput.writeObject(msg);
			}
			catch(IOException e) {
				display("Exception writing to server: " + e);
			}
		}

		/*
		 * When something goes wrong
		 * Close the Input/Output streams and disconnect not much to do in the catch clause
		 */
		private void disconnect() {
			try { 
				if(sInput != null) sInput.close();
			}
			catch(Exception e) {} // not much else I can do
			try {
				if(sOutput != null) sOutput.close();
			}
			catch(Exception e) {} // not much else I can do
	        try{
				if(socket != null) socket.close();
			}
			catch(Exception e) {} // not much else I can do
		}	
		
		public static void main(String[] args) {
			// default values
			int portNumber = 1500;
			String serverAddress = "localhost";
			String userName = "Anonymous";
			
			// create the Client object
			Client client = new Client(serverAddress, portNumber, userName);
			// test if we can start the connection to the Server
			// if it failed nothing we can do
			if(!client.start())
				return;
			
			// wait for messages from user
			Scanner scan = new Scanner(System.in);
			// loop forever for message from the user
			while(true) {
				System.out.print("> ");
				// read message from user
				String msg = scan.nextLine();

				client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
			}
			// done disconnect
			// client.disconnect();	
		}

		/*
		 * a class that waits for the message from the server and append them to the JTextArea
		 * if we have a GUI or simply System.out.println() it in console mode
		 */
		class ListenFromServer extends Thread {

			public void run() {
				while(true) {
					try {
						String msg = (String) sInput.readObject();
						System.out.println(msg);
						System.out.print("> ");
					}
					catch(IOException e) {
						display("Server has close the connection: " + e);
						break;
					}
					// can't happen with a String object but need the catch anyhow
					catch(ClassNotFoundException e2) {
					}
				}
			}
		}
}
