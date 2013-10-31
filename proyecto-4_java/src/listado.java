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
	int coord;
	
	ArrayList <String> listaEdo = new ArrayList <String>();
	ArrayList <String> lineOfFile = new ArrayList <String>();
	ArrayList <Integer> listaCP = new ArrayList <Integer>();
	Set inOrderEdo;

	public listado(){
		System.out.println("List created");
	}

	/**
	* 	searchEdoCountCP
	* 	@return void
	* 	@para ArrayList <String> & String
	*/
	public void searchEdoCountCP(ArrayList <String> listEdo, String edo){
		int u = 1;

		if (listEdo.contains(edo)) {
			coord = listEdo.indexOf(edo);
			countCP = listaCP.get(coord);
			countCP++;
			listaCP.add(listEdo.indexOf(edo), countCP);
		}else{
			listEdo.add(edo);
			listaCP.add(u);
		}
	}

	/**
	* 	setInOrderEdo
	* 	@return void
	* 	@para ArrayList <String>
	*/
	public void setInOrderEdo(ArrayList <String> listEdo){		
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
