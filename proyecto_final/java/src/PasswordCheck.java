import java.util.*;  
import java.io.*;
import java.lang.String;  
import java.lang.Character;  

public class PasswordCheck { 

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
        	 System.out.println("Password not correct");
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