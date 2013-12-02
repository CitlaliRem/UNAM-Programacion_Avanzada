import java.io.PrintStream;
import java.util.ArrayList;

public class UserActions {
        private static final String HISTORYLOG = "./chatlog.txt";


        //public static void CommandSwitch(PrintStream serverOutput, String inputString, ArrayList<String> chatLog, String nickname, ArrayList <String> usersOnline) {
        public static void CommandSwitch(PrintStream serverOutput, String inputString, String nickname) {

                if (inputString.equals("/users")) {
                        UserActions.ShowUsers(serverOutput);
                }
                else if(inputString.equals("/hist")) {
                        UserActions.ShowHistory(serverOutput);

                }
                else if(inputString.equals("/help")) {
                        UserActions.ShowHelp(serverOutput);
                }
                else if(inputString.startsWith("/private")){
                        UserActions.PrivateMenssage(serverOutput, inputString, nickname);
                }
        }

        public static void ShowUsers(PrintStream serverOutput) {
                //PrintStream serverOutput = ClientThread.serverOutput;
                ArrayList<String> usersOnline = Server.usersOnline;

                System.out.println("Connected users right now:");
                System.out.println(usersOnline);
                serverOutput.println("Connected users right now:");
                serverOutput.println(usersOnline);
        }

        public static void ShowHistory(PrintStream serverOutput) {
                //PrintStream serverOutput = ClientThread.serverOutput;
                ArrayList<String> chatLog = Server.chatLog;

                serverOutput.println("Showing chat history");
                serverOutput.println("++++++++++++++++++++");
                if(chatLog.isEmpty()) {
                        Server.readFileIntoArray(chatLog, HISTORYLOG);
                }

                for (int j = 0; j < chatLog.size(); j++) {
                        String temp = chatLog.get(j);
                        serverOutput.println(temp);
                }
        }


        public static void ShowHelp(PrintStream serverOutput) {
                //PrintStream serverOutput = ClientThread.serverOutput;
                serverOutput.println("*******************************************");
                serverOutput.println("Options:");
                serverOutput.println("/hist\tshow chat history");
                serverOutput.println("/users\tshow online users");
                serverOutput.println("/help\tshow this help menu");
                serverOutput.println("/private\tprivate message: <user> <message>");
                serverOutput.println("/exit\tdisconnect");
                serverOutput.println("*******************************************");
        }

        public static void PrivateMenssage(PrintStream serverOutput, String inputString, String nickname) {
                //PrintStream serverOutput = ClientThread.serverOutput;
                System.out.println("private message");
                if (inputString == null || nickname == null) {
                        serverOutput.println("Usage: /private <user> <message>");
                } else {

                        ArrayList<ClientThread> clientList = Server.clientList;
                        ArrayList<String> usersOnline = Server.usersOnline;
                
                        String tmpInputString = inputString.substring(inputString.indexOf(' ')+1);
                        tmpInputString = Tools.capitalizeFirstLetter(tmpInputString);
                        try {
                                if (Server.usersOnline.indexOf(tmpInputString.substring(0,tmpInputString.indexOf(' '))) == -1){
                                        serverOutput.println("User not found");
                                }
                        else{
                                if(tmpInputString.indexOf(' ')==-1){
                                        serverOutput.println("Menssage is missing");
                                }else{

                                        Server.clientList.get(Server.usersOnline.indexOf(tmpInputString.substring(0,tmpInputString.indexOf(' ')))).serverOutput.println(nickname+">> "+tmpInputString.substring(tmpInputString.indexOf(' ')));
                                }               
                        }                    
                        } catch(StringIndexOutOfBoundsException e) {
                                // el mensaje no tuvo el formato correcto 
                        }
                }

        }

        public static boolean ExitChat(PrintStream serverOutput, String inputString, String nickname) {
                //PrintStream serverOutput = ClientThread.serverOutput;

                if(inputString.startsWith("/exit")) {
                        serverOutput.println("SERVER:\tGoodbye " + nickname);
                        return true;
                }
                return false;
        }
}
