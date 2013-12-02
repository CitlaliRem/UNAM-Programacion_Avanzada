import java.io.*;
import java.util.ArrayList;
import java.util.Properties;


public class Tools {

	public static String capitalizeFirstLetter(String original){
	    if(original.length() == 0)
	        return original;
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
	static boolean checkFileEntry(String nick, String datafile) { 
    	try {
			File file = new File(datafile);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();

			if (properties.getProperty(nick) == null) return false;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        return true;  
	}

	public static void propSetter(String keyVal, String propertyVal, String datafile, String comment) {
		try {
			File file = new File(datafile);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();

			properties.setProperty(keyVal, propertyVal);

			FileOutputStream fileOut = new FileOutputStream(file);
			properties.storeToXML(fileOut, comment);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

	public static void propEraser(String keyVal, String datafile) {
		try {
			File file = new File(datafile);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();
			System.out.println("keyVal"+ keyVal);

			properties.remove(keyVal);

			FileOutputStream fileOut = new FileOutputStream(file);
			properties.storeToXML(fileOut, null);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

	public static void WriteToFile(ArrayList<String> chatLog, String historyLog) {
		PrintWriter logFile = null;
		try {
			logFile = new PrintWriter(new FileWriter(historyLog));
		} catch (IOException e) {
			System.out.println("ERROR: Can't open logfile");
		}
		
		for (int i = 0; i < chatLog.size(); i++) {
			logFile.println(chatLog.get(i));
		}
		logFile.close();
	}
}