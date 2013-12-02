import java.io.PrintStream;
import java.util.ArrayList;

public class UserActions {
	


        //public static void CommandSwitch(PrintStream serverOutput, String inputString, ArrayList<String> chatLog, String nickname, ArrayList <String> usersOnline) {
		public static void CommandSwitch(String inputString) {

            if (inputString.equals("/users")) {
				 			UserActions.ShowUsers();
            }
            else if(inputString.equals("/hist")) {
                    //UserActions.ShowHistory(serverOutput, chatLog);
                    UserActions.ShowHistory();

            }
            else if(inputString.equals("/help")) {
                    UserActions.ShowHelp();
            }
            else if(inputString.startsWith("/private")){
    						System.out.println("si entro");                
							//UserActions.PrivateMenssage(serverOutput,inputString,nickname,clientCount,usersOnline);
            }
        }

        public static void ShowUsers() {
    		PrintStream serverOutput = ClientThread.serverOutput;
    		ArrayList<String> usersOnline = Server.usersOnline;

            System.out.println("Connected users right now:");
				System.out.println(usersOnline);
            serverOutput.println("Connected users right now");
				 serverOutput.println(usersOnline);
        }

	//public static void ShowHistory(PrintStream serverOutput, ArrayList<String> chatLog) {
	public static void ShowHistory() {
		PrintStream serverOutput = ClientThread.serverOutput;
		ArrayList<String> chatLog = Server.chatLog;
		
    	serverOutput.println("Showing chat history");
    	serverOutput.println("++++++++++++++++++++");
    	if(chatLog.isEmpty()) {
    		Server.recallHistory(chatLog);
    	}

    	for (int j = 0; j < chatLog.size(); j++) {
        	String temp = chatLog.get(j);
        	serverOutput.println(temp);
		}
	}
	
/*	public static void ShowHistory(PrintStream serverOutput, ArrayList<String> chatLog) {
        	serverOutput.println("Showing chat history");
        	serverOutput.println("++++++++++++++++++++");
        	if(chatLog.isEmpty()) {
        		Server.recallHistory(chatLog);
        	}

        	for (int j = 0; j < chatLog.size(); j++) {
            	String temp = chatLog.get(j);
            	serverOutput.println(temp);
    		}
	}*/
        
        public static void ShowHelp() {
        	PrintStream serverOutput = ClientThread.serverOutput;
                serverOutput.println("*********************************");
                serverOutput.println("Options:");
                serverOutput.println("/hist\tshow chat history");
                serverOutput.println("/users\tshow online users");
                serverOutput.println("/help\tshow this help menu");
                serverOutput.println("/exit\tdisconnect");
                serverOutput.println("*********************************");
        }

        /*public static void PrivateMenssage(PrintStream serverOutput, String inputString, String nickname,ArrayList <ClientHandler> clientCount, ArrayList<String>  usersOnline){
                
                String tmpInputString=inputString.substring(inputString.indexOf(' ')+1);
                tmpInputString = Tools.capitalizeFirstLetter(tmpInputString);
                if(usersOnline.indexOf(tmpInputString.substring(0,tmpInputString.indexOf(' ')))==-1){
                        serverOutput.println("user not found");
                }
                else{
                        clientCount.get(usersOnline.indexOf(tmpInputString.substring(0,tmpInputString.indexOf(' ')))).serverOutput.println(nickname+">> "+tmpInputString.substring(tmpInputString.indexOf(' ')));
                }                    
                
        }*/

        public static boolean ExitChat(String inputString, String nickname) {
	        PrintStream serverOutput = ClientThread.serverOutput;

	        if(inputString.startsWith("/exit")) {
	                serverOutput.println("SERVER:\tGoodbye " + nickname);
	                return true;
	        }
	        return false;
	        }
}
