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
	int countDeleg;
	int countMuni;
	int countRanch;
	int countCP;
	HashSet listaEdo = new HashSet();
	HashSet archivo = new HashSet();
	ArrayList <String> lineOfFile = new ArrayList <String>();
	ArrayList <Integer> listaCP = new ArrayList <Integer>();
	Set inOrderEdo;

	public listado(){
		System.out.println("List created");
	}

	/**
	* 	searchEdo
	* 	@return void
	* 	@para HashSet & String to put it on
	*/
	public void searchEdo(HashSet listEdo, String edo){
		listEdo.add(edo);
	}

	/**
	* 	setInOrderEdo
	* 	@return void
	* 	@para HashSet to set in order
	*/
	public void setInOrderEdo(HashSet listEdo){		
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

	/**
	* 	listCPxEdo
	* 	@return void
	* 	@para ArrayList <Integer> & String
	*/
	public void listCPxEdo(ArrayList <String> listEdo, ArrayList <Integer> line_of_file,String edo){
		//
		int k;
		for (k = 0; k < line_of_file.size() ; k++) {
			//
		}
	}
}
