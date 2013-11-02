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
	

	String stateList[] = act.stateSet.toArray(new String[act.stateSet.size()]);		 
	
	/*
		for (int i = 0; i < stateList.length; i++) {
			System.out.println("Found state on position " + (i+1) + ":" + stateList[i]);
		}
		
		*/
 
	File file1 = new File("CPdescarga.txt");
	Scanner s = new Scanner(file1, "ISO-8859-1");

	ArrayList<String> wholeFile = new ArrayList<String>();
	while (s.hasNextLine()){
		act.ScanFile(s);
        //System.out.println("dEBuGG lineOfText: " + lineOfText);
	}
	s.close();
	
	//System.out.println(wholeFile);
	for (String elem : wholeFile) {
		System.out.println("Printing lines of wholeFile: " + elem);
	}
		
	
	/*
	
	Scanner scanSubCats = new Scanner(file, "ISO-8859-1");

	while (scanSubCats.hasNextLine()) {
		act.lineOfFile = act.ScanFile(scanSubCats); /// create a new linebuffer
		
		int k = 0;
		//for (int stateindex = 0; stateindex < stateList.length; stateindex++) {
		while(k < stateList.length) {
			System.out.println("Processing: " + stateList[k]);	
			String state = act.lineOfFile.get(4);
			System.out.println("state: " + state);
			String township = act.lineOfFile.get(3);
	
			if(stateList[k] == state) {
				act.AddToSet(act.townshipSet, township);
			}	
			//System.out.println("state: " + stateList[k] + " number of township; " + act.townshipSet.size());
			k += 1;
		}
		
	/*	
		for (int k = 0; k < stateList.length; k++) {
			while(stateList[k] == act.lineOfFile.get[4]) {
				
			}
			*/

//	}

	}
       
}