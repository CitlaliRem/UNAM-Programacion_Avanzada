/**      
 *     A simple class wich works with list to consult a data base,
 *	   CPdescarga.txt
 * 
 *      @authors: 
 *      César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      Magnus Henkel (magnus.henkel at zoho.com)
 *      
 *          Created on: Oct 27, 2013
 */

import java.util.*;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;

public class Actions{

	public String state;
//	int countDeleg;
//	int countMuni;
//	int countRanch;
//	int countCP;
//	int coord;
	
	ArrayList <String> lineOfFile = new ArrayList <String>();
	//ArrayList <String> stateList = new ArrayList <String>();
	ArrayList <String> townshipList = new ArrayList <String>();
	ArrayList <String> zipCodeList = new ArrayList <String>();
	HashSet <String> stateSet = new HashSet <String>();
	HashSet <String> zipCodeSet = new HashSet <String>();
	HashSet <String> townshipSet = new HashSet <String>();


	public ArrayList<String> ScanFile(Scanner scannerObj){

		ArrayList <String> lineReader = new ArrayList <String>();
        String lineOfText = scannerObj.nextLine();
        //System.out.println("dEBuGG lineOfText: " + lineOfText);
        StringTokenizer str = new StringTokenizer(lineOfText, "|");

        while(str.hasMoreTokens()){
                lineReader.add( str.nextToken());
        }

        //System.out.println("dEBuGG: ReadLine" + lineReader);

        return lineReader;
	}

	/**
	* 	setInOrderEdo mostrar alfabeticamente
	 * @param <data>
	* 	@return void
	* 	@para ArrayList <String>
	*
	public void setInOrderEdo(HashSet <String> listEdo){		
    	inOrderEdo = new TreeSet(listEdo);
	}
	*/


	// Metodo que recibe un Set y un objeto de clase data
	// que permite almacenar el objeto en el set
	public void saveToSet(SortedSet <data> listToShow, data dato){
		listToShow.add(dato);
	}
	
	// Metodo que recibe un Set y un String para
	// almacenar el String en el respectivo Set 
	// que no permite elementos repetidos
	public void toSets(Set <String> setName, String element){
		setName.add(element);
	}
	
	public void forLoops(Set <String> setName, SortedSet <String> textFile){
		for (String s: setName) {
			System.out.println("Element in SortedSet: " + s);
		}
	}

}