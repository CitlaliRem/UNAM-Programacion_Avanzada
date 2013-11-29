/**
 * 
 *
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserCommands {
	
	public static void CommandSwitch(PrintStream serverOutput, String inputString, String nickname) {
		if (inputString.equals("/users")) {
			UserCommands.ShowUsers(serverOutput, inputString, nickname);
		}
		else if(inputString.equals("/hist")) {
			UserCommands.ShowHistory(serverOutput, Server.chatLog);
		}
		else if(inputString.equals("/help")) {
			UserCommands.ShowHelp(serverOutput);
		}
	}

	public static void ShowUsers(PrintStream serverOutput, String inputString, String nickname) {
        	System.out.println("Connected users right now:");
        	serverOutput.println("Connected users right now");
        	//TODO:
	}

	public static void ShowHistory(PrintStream serverOutput, ArrayList<String> chatLog) {
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

}