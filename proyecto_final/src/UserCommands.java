/**
 * 
 *
 */

import java.io.PrintStream;

public class UserCommands {
	
	public static void CommandSwitch(PrintStream serverOutput, String inputString, String nickname) {
		System.out.println("Debugging: inputString" + inputString);
		if (inputString.equals("/users")) {
			System.out.println("Debugging: inside CommandSwitch");
			UserCommands.ShowUsers(serverOutput, inputString, nickname);
		}
		else if(inputString.equals("/hist")) {
			UserCommands.ShowHistory(serverOutput, inputString, nickname);
		}
		else if(inputString.equals("/help")) {
			UserCommands.ShowHelp(serverOutput);
		}
	}

	public static void ShowUsers(PrintStream serverOutput, String inputString, String nickname) {
        //if(inputString.startsWith("/showUsers")) {
        	System.out.println("Connected users right now:");
        	serverOutput.println("Connected users right now");
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

}