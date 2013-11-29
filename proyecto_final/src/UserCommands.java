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
        	System.out.println("Showing historial");
        	//TODO:
        //}
	}

	public static boolean ExitChat(PrintStream serverOutput, String inputString, String nickname) {
        if(inputString.startsWith("/exit")) {
        	serverOutput.println("SERVER:\tGoodbye " + nickname);
        	return true;
        }
        return false;
	}

}
