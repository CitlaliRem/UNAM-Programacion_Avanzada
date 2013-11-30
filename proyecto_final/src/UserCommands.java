import java.io.PrintStream;
import java.util.*;

public class UserCommands {
        
        public static void CommandSwitch(PrintStream serverOutput, String inputString, String nickname,ArrayList <ClientHandler> clientCount, ArrayList <String> usersOnline) {
                System.out.println("Debugging: inputString " + inputString);
                if (inputString.startsWith("/users")) {
                        System.out.println("si entro a users");
			UserCommands.ShowUsers(serverOutput,usersOnline);
                }
                else if(inputString.equals("/hist")) {
                        UserCommands.ShowHistory(serverOutput, inputString, nickname);
                }
                else if(inputString.equals("/help")) {
                        UserCommands.ShowHelp(serverOutput);
                }
                else if(inputString.startsWith("/private")){
        		System.out.println("si entro a private");                
			UserCommands.PrivateMenssage(serverOutput,inputString,nickname,clientCount,usersOnline);
                }
        }

        public static void ShowUsers(PrintStream serverOutput, ArrayList <String> usersOnline) {
        //if(inputString.startsWith("/showUsers")) {
                System.out.println("Connected users right now:");
					 System.out.println(usersOnline);
                serverOutput.println("Connected users right now");
					 serverOutput.println(usersOnline);
                //TODO:
        //}
        }

        public static void ShowHistory(PrintStream serverOutput, String inputString, String nickname) {
        //if(inputString.startsWith("/showHistory")) {
                System.out.println("Showing chat history:");
                serverOutput.println("Showing chat history");
                //TODO:
        //}
        }
        
        public static void ShowHelp(PrintStream serverOutput) {
                serverOutput.println("*********************************");
                serverOutput.println("Options:");
                serverOutput.println("/hist\tshow chat history");
                serverOutput.println("/users\tshow online users");
                serverOutput.println("/help\tshow this help menu");
                serverOutput.println("/exit\tdisconnect");
                serverOutput.println("*********************************");
        }

        public static boolean ExitChat(PrintStream serverOutput, String inputString, String nickname) {
        if(inputString.startsWith("/exit")) {
                serverOutput.println("SERVER:\tGoodbye " + nickname);
                return true;
        }
        return false;
        }
        public static void PrivateMenssage(PrintStream serverOutput, String inputString, String nickname,ArrayList <ClientHandler> clientCount, ArrayList<String>  usersOnline){
                
                String tmpInputString=inputString.substring(inputString.indexOf(' ')+1);
                tmpInputString = Tools.capitalizeFirstLetter(tmpInputString);
                if(usersOnline.indexOf(tmpInputString.substring(0,tmpInputString.indexOf(' ')))==-1){
                        serverOutput.println("user not found");
                }
                else{
                        clientCount.get(usersOnline.indexOf(tmpInputString.substring(0,tmpInputString.indexOf(' ')))).serverOutput.println(nickname+">> "+tmpInputString.substring(tmpInputString.indexOf(' ')));
                }                    
                
        }
}
