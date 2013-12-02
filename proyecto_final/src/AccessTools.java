import java.util.*;  
import java.io.*;
import java.lang.String;  
import java.lang.Character;  
import java.net.Socket;

public class AccessTools { 

	private static final String USER_DATABASE = "users.xml";

	public static void SignUp (PrintStream serverOutput, DataInputStream userInput, Socket socket, String nickname, int numSockets) throws IOException {
		String newNickname = null;
		String newPassword = null;

		if(! socket.isClosed()) {
			serverOutput.println(nickname + " not found in database");
			serverOutput.println("Do you want to register? (y/n)");

			String option = userInput.readLine();

			if(! option.equals("y")) {
				numSockets -= 1;

				ClientThread.closeConnections(userInput, serverOutput, socket);

			} else {
				System.out.println("LOG: User choose option: " + option);
				System.out.println("inside else: " + userInput);
				serverOutput.print("Choose your nickname: ");
				newNickname = userInput.readLine();
				serverOutput.print("Choose your password: ");
				newPassword = userInput.readLine();
			}

			int tries = 0;
			while(tries < 4) {
				try {

					if (AccessTools.isValid(newPassword) == true) {
						Tools.propSetter(newNickname, newPassword, USER_DATABASE, "User Access");
						nickname = newNickname;
						serverOutput.println("You can now log into your new account");
						break;

					} else {

						if (tries == 3) {
							serverOutput.println("Too many tries... Exiting");
							ClientThread.closeConnections(userInput, serverOutput, socket);
							numSockets -= 1;
						}
						//System.out.println("LOG: " + time + " User choose invalid password " + (tries+1) + " times");
						if (! socket.isClosed()) {
							serverOutput.println("Password should be min 8 characters long and contain min 2 digits");
							serverOutput.print("Choose your password: ");
							//newPassword = ClientHandler.RecordUserInput(userInput);
							newPassword = userInput.readLine();

							tries += 1;
						}

					}
				} catch(NullPointerException e) {
					/* respuesta era un enter */
				}
			} 
		}
	}

	static boolean checkCredentials(String nick, String password) { 

		if (password == null) return false;

		try {
			File file = new File(USER_DATABASE);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();

			String userPass = properties.getProperty(nick);

			if (! password.equals(userPass)) {
				System.out.println("User entered incorrect password");
				return false;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;  
	}

	static boolean isValid(String password) { 

		if (password.length() < 8) {   
			return false;  
		} else {      
			char c;  
			int count = 0;   
			for (int i = 0; i < password.length(); i++) {  
				c = password.charAt(i);  
				if (!Character.isLetterOrDigit(c)) {          
					return false;  
				} else if (Character.isDigit(c)) {  
					count++;  
				}  

			}  

			if (count < 2)   {     
				return false;  
			}     
		}
		return true;
	}
}