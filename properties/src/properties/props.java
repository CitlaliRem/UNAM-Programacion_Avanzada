/**
 * 
 */
package properties;

/**
 * @author arytloc
 *
*/

 	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class props {

		public static void main(String[] args) {
			propGetter("favoriteSeason");
			
			propSetter("favCol3", "black");
	}
		
		/**
		 * @param string
		 * @param string2
		 */
		private static void propSetter(String string, String string2) {
			try {
				
				File file = new File("test.xml");
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.loadFromXML(fileInput);
				fileInput.close();

				properties.setProperty(string, string2);

				FileOutputStream fileOut = new FileOutputStream(file);
				properties.storeToXML(fileOut, "Favorite Things");
				fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		private static void propGetter(String key) {

			try {
				File file = new File("test.xml");
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.loadFromXML(fileInput);
				fileInput.close();
	
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
	/*
				Enumeration enuKeys = properties.keys();
				while (enuKeys.hasMoreElements()) {
					String key = (String) enuKeys.nextElement();
					String value = properties.getProperty(key);
					System.out.println(key + ": " + value);
			}
					*/
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
}
