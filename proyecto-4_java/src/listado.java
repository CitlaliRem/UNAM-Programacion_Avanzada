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
	ArrayList <String> lineOfFile = new ArrayList <String>();
	//ArrayList <String> listaEdo = new ArrayList <String>();
	ArrayList <Integer> listaCP = new ArrayList <Integer>();


	public listado(){
		System.out.println("List created");
	}

	/**
	* 	searchEdo
	* 	@return void
	* 	@para ArrayList & String
	*/
	public void searchEdo(ArrayList <String> listEdo, String edo){
		/*if ( listEdo.contains(edo) ){
			
		}else{
			listEdo.add(edo);
		}*/
		listEdo.add(edo);
	}

	/**
	* 	setInOrderEdo
	* 	@return void
	* 	@para ArrayList <String>
	*/
	public void setInOrderEdo(ArrayList <String> listEdo){
		/*int k;   //todo esto se recude a una línea
		int l;
		String aux;

		for (l = 0; l < listEdo.size(); l++) {
			for(k = 0;k < listEdo.size()-l; k++) {
            	if ( listEdo.get(k).compareTo(listEdo.get(k+1)) > 0) {
                	Collections.swap(listEdo,k,k+1);
            	}
        	}
    	}*/
    	Collections.sort(listEdo);
	}

	/**
	* 	listCPxEdo
	* 	@return void
	* 	@para ArrayList <Integer> & String
	*/
<<<<<<< HEAD
	public void listCPxEdo(ArrayList <String> listEdo, ArrayList <Integer> line_of_file,String edo){
=======
	public void listCPxEdo(ArrayList <String> line_of_file,String edo){
>>>>>>> 8094d6d0241db305f8dd57fd2fbccb380e567a79
		//
		int k;
		for (k = 0; k < listEdo.size() ; k++) {
			//
		}
	}
}
