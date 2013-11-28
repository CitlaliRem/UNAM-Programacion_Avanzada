import java.util.*;  
import java.io.*;
import java.lang.String;  
import java.lang.Character;  

public class PasswordCheck { 

	static boolean checkSignUp(String nick) {

			try {
				File file = new File("./users.xml");
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.loadFromXML(fileInput);
				fileInput.close();
	
				String userName = properties.getProperty(nick);

				if(userName == null) {
					System.out.println("LOG: Nickname does not exist");
					return false;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return true;
	}

	static void propSetter(String nick, String password) {

			try {
				
				File file = new File("./users.xml");
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.loadFromXML(fileInput);
				fileInput.close();

				properties.setProperty(nick, password);

				FileOutputStream fileOut = new FileOutputStream(file);
				properties.storeToXML(fileOut, "User Access");
				fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }

    static boolean checkCredentials(String nick, String password) { 

    	try {
			File file = new File("./users.xml");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();

			String userPass = properties.getProperty(nick);

	         if (! password.equals(userPass)) {
	        	 System.out.println("LOG: User entered incorrect password");
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
        //return true if and only if password:
        //1. have at least eight characters.
        //2. consists of only letters and digits.
        //3. must contain at least two digits.
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