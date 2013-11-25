import java.util.*;  
import java.lang.String;  
import java.lang.Character;  

public class PasswordCheck { 

	public static boolean PWInput(String passwd) {
       //Scanner input = new Scanner(System.in);  
       //String password = input.next();  
        if (isValid(passwd)) {  
            return true;
        } else {  
            return false; 
        }  
	}
    private static boolean isValid(String password) {  
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