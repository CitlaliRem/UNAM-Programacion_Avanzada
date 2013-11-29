import java.io.*;
import java.util.Properties;



public class Tools {

	public static String capitalizeFirstLetter(String original){
	    if(original.length() == 0)
	        return original;
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	

	public static void propSetter(String nick, String password, String datafile) {
		try {
			File file = new File(datafile);
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
}
