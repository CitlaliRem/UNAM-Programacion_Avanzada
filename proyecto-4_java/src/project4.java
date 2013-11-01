/**      
 *     Proyecto 4:
 *     Programa que efectua una busqueda sobre un archivo de texto (.txt) y muestra u ordena
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
//import java.util.Scanner;

public class project4{

public static void main(String args[]) throws FileNotFoundException{
	//StringTokenizer str;
	Actions act = new Actions();
	
	File file = new File("CPdescarga.txt");
	Scanner scanStates = new Scanner(file, "ISO-8859-1");
	
	while (scanStates.hasNextLine()) {
		act.lineOfFile = act.ScanFile(scanStates);
		//System.out.println("Debuugg: " + act.lineOfFile);
	
	    act.state = act.lineOfFile.get(4);
	    
	    //System.out.println(act.state);
	    
	    act.stateSet.add(act.state);
	    
	
	    //act.setEdo(act.stateList,act.state);
	    //act.addToSet(4, 3, act.zipCodeList, act.state);
	
	    act.lineOfFile.clear();
	
	}
	scanStates.close();
	
	System.out.println("Displaying all " + act.stateSet.size() + " states of México:");
	
	for (String s : act.stateSet) {
		System.out.println(s);
	}	
	
		//System.out.println("Printing stateList: " + act.stateList);
		/*
         def listSubCat(self, columnToCompare, columnToAdd, setName, rootFile, linecount, ordered):
		#setItemCount = 0
		for index, state in self.stateDict.items():
		    while state == rootFile[index][columnToCompare] and index < (linecount - 1): 
		        setName.add(rootFile[index][columnToAdd])
		        self.setItemCount = self.countSetItems(setName)
		        index += 1
		    self.printListSubCat(self.setItemCount, state, ordered)
		    #print(self.setItemCount,"\t\t\t", state) 
		    setName = set()
		    self.setItemCount = 0	
		    */

	int i = 0; // representa la linea del archivo

	act.myset.toArray(new String[0]);
		 
         //Scanner scanner = new Scanner(file, "ISO-8859-1");
 
	Scanner scanSubCats = new Scanner(file, "ISO-8859-1");

	while (scanSubCats.hasNextLine()) {
		act.lineOfFile = act.ScanFile(scanSubCats); /// create a new linebuffer
	}

	}
       
}