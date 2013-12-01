/**
*  ChatServer.java
*  A simple class wich lets to run a Chat-Server
*  @author: Magnus Henkel
*           César Alberto Trejo Juárez
*           Oscar Díaz
*           Brenda
*/


import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{

   private final static int PORT_NO = 8888;
   private ServerSocket listener;
   public List <Connection> clients;

   public ChatServer() throws IOException{

      listener = new ServerSocket(PORT_NO);
      clients = new ArrayList <>();
      System.out.println("Listening on port " + PORT_NO);
   }

   public void runServer(){
      try{
         while (true){

            Socket socket = listener.accept();
            System.out.println("Accepted connection");
            Connection con = new Connection(socket);
            synchronized(clients){
               clients.add(con);
               con.start();
               if (clients.size() == 1){
                  con.send("Welcome...you're the first user");
               }else{
                  con.send("Welcome...you're the latest of " + clients.size() + " users");
               }
            } 
         }
      }catch (IOException ioe){
         System.err.println("I/O error: "+ioe.getMessage());
      }
   }

   public class Connection extends Thread{

      private volatile BufferedReader br;
      private volatile PrintWriter pw;
      private String clientName;
      private String password;

      public Connection(Socket s) throws IOException{

         br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         pw = new PrintWriter(s.getOutputStream(), true);
      }

      //
      @Override
      public void run(){
         String line;
         try {
            pw.println("Nick:");
            clientName = br.readLine();
            pw.println("Password:");
            password = br.readLine();
            pw.println("Server: Hi " + clientName);
            while ( (line = br.readLine()) != null ){
               if (line.equals("/LOGOUT") == true) {
                  pw.println("Server: Goodbye " + clientName + "!");
                  break;
               }
               if (line.equals("/USERS") == true) {
                  sendClientsList();
               }
               if (!line.equals("") == true) {
                  broadcast(clientName + ": " + line);
               }
            }
         }catch (IOException ioe){
            System.err.println("I/O error: " + ioe.getMessage());
         }catch(NullPointerException npe){
            System.err.println("NullPointer error" + npe.getMessage());
         }finally{
            System.out.println(clientName + ": logout");
            synchronized(clients){
               String tempName = clientName;
               clients.remove(this);
               broadcast(tempName + " logout");
               if (clients.size() == 0) {
                  broadcast("Now nobody is online");
               }else{
                  broadcast("Now " + clients.size() + " users online");
                  sendClientsList();
               }

            }
         }
      }

      /**
      *  broadcast lets to send messages to all users.
      *  @return: void
      *  @param: string
      */
      private void broadcast(String message){

         System.out.println("broadcasting " + message);
         synchronized(clients){
            for (Connection con: clients){
               con.send(message);
            }
         }
      }

      /**
      *  send lets to send a message to clients.
      *  @return: void
      *  @param: string
      */
      private void send(String message){
         pw.println(message);
      }

      /**
      *  sendClientsList lets to shows online users.
      *  @return: void
      *  @param: nothing
      */
      private void sendClientsList(){
         StringBuilder sb = new StringBuilder();
         synchronized(clients){
            for (Connection con: clients){
               sb.append("\n\t\t->");
               sb.append(con.clientName);
            }
            broadcast(">>>Users online: " + sb.toString());
         }
      }
   }
   //
   public static void main(String[] args){
      try{

         System.out.println("ChatServer starting...");
         new ChatServer().runServer();

      }catch (IOException ioe){
         System.err.println("Unable to create server socket");
      }
   }
}
