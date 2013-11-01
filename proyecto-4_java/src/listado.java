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

public class listado{

	String estado;
	String cp;
	int countDeleg;
	int countMuni;
	int countRanch;
	int countCP;
	int coord;
	
	ArrayList <String> lineOfFile = new ArrayList <String>();
	HashSet <String> listaEdo = new HashSet <String>();
	HashSet <String> listaCP = new HashSet <String>();
	Set inOrderEdo;

	public listado(){
		System.out.println("List created");
	}
	
	public void CountElements(HashSet <String> setName, ArrayList <String> textFile) {
			System.out.println("I arrived :)");
			for (String s: setName)
				System.out.println("element en ArrayList: " + s);
	}

	/**
	* 	searchEdoCountCP
	* 	@return void
	* 	@para ArrayList <String> & String
	*/
	public void setEdo(HashSet <String> listEdo, String edo){
		listEdo.add(edo);
	}

	/**
	* 	setCP
	* 	@return void
	* 	@para ArrayList <String> & String
	*/
	public void setCP(HashSet <String> listCP, String cp){
		listCP.add(cp);
	}

	/**
	* 	setInOrderEdo mostrar alfabeticamente
	* 	@return void
	* 	@para ArrayList <String>
	*/
	public void setInOrderEdo(HashSet <String> listEdo){		
    	inOrderEdo = new TreeSet(listEdo);
	}

	/**
	* 	printInOrder
	* 	@return void
	* 	@para Set listEdo in order
	*/
	public void printInOrder(Set listEdo){		
    	System.out.println(listEdo);
	}

}