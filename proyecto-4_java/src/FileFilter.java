/**      
 *     Proyecto 4:
 *     Programa que efectua una busqueda sobre un textFile de texto (.txt) y muestra u ordena
 *           la lista por los siguientes criterios:
 *              -> muestra la lista de states (sin repeticón)
 *              -> muestra número de delegaciones, municipios, rancherías por states
 *              -> ordena los states por la cantidad de códigos postales
 * 
 *      @authors: 
 *      César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      Magnus Henkel (magnus.henkel at zoho.com)
 *      
 *          Created on: Oct 27, 2013
 */

import java.io.*;
import java.util.*;

public class FileFilter{
    /**
    *        Main
    */
    public static void main(String args[]) throws IOException{
    	
    	System.out.println("Hold the line, your request is being attended...");
    	

        ListTools listObj = new ListTools();
        File file = new File("CPdescarga.txt");

        try {
            Scanner scanner = new Scanner(file, "ISO-8859-1");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listObj.textFile.add(line);
            }
            scanner.close();
            listObj.forLoops(listObj.zipcodeSet, listObj.stateSet, listObj.townshipSet, listObj.textFile); 
            System.out.println("\nStates of México sorted by number of zipcodes (ascending order)\n");
            System.out.println(" Number of townships\t\t\tNumber of zipcodes\t\t\tState");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(listObj.listDisplay);
        }catch(FileNotFoundException var){
            System.out.println("File not found");
        }
    }
}
