import java.util.*;  
import java.io.*;
import java.lang.String;  
import java.lang.Character;  

public class PasswordCheck { 

	static boolean checkSignUp(String nick) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("users.properties"));
		} catch (FileNotFoundException var) {
			var.printStackTrace();
		} catch (IOException var) {
			var.printStackTrace();
		}
		
		String userName = prop.getProperty(nick);
		if(userName == null) {
			System.out.println("LOG: Nickname does not exist");
			return false;
		}
		return true;
	}

	static void propSetter(String nick, String password) {

        	Properties prop = new Properties();
        	prop.store(new FileOutputStream("users.properties"),null);	

    		prop.setProperty(nick, password);
			System.out.println("You can now log in with your password");
	}

    static boolean checkCredentials(String nick, String password) { 
    	 Properties prop = new Properties();
         try {
			prop.load(new FileInputStream("users.properties"));
		} catch (FileNotFoundException var) {
			var.printStackTrace();
		} catch (IOException var) {
			var.printStackTrace();
		}
         String userPass = prop.getProperty(nick);
         if (! password.equals(userPass)) {
        	 System.out.println("LOG: User entered incorrect password");
        	 return false;
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