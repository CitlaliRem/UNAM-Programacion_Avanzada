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
	ArrayList <String> lineOfFile = new ArrayList <String>();
	ArrayList <String> listaEdo = new ArrayList <String>();


	public listado(){
		System.out.printl("List created");
	}

	/**
	* 	searchEdo
	* 	@return void
	* 	@para ArrayList & String
	*/
	public void searchEdo(ArrayList <String> listEdo, String edo){
		if ( listEdo.contains(edo) == FALSE ){
			listEdo.add(edo);
		}
	}

	/**
	* 	setInOrderEdo
	* 	@return void
	* 	@para ArrayList & String
	*/
	public void setInOrderEdo(ArrayList <String> listEdo){
		int k = 0;
		String aux;

		for(k = 0;k < listEdo.length; k++) {
            if ( listEdo[k].compareTo(listEdo[k+1]) > 0) {
                aux = listEdo[k];
                listEdo[k] = listEdo[k+1];
                listEdo[k+1] = aux;
            }
        }

	}

	/**
	* 	
	* 	@return void
	* 	@para ArrayList & String
	*/
	public void 


}
