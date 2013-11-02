/**      
 *     A simple class wich works with Sets to order States by
 *	   the number of CP.
 * 
 *      @authors: 
 *      César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      Magnus Henkel (magnus.henkel at zoho.com)
 *      
 *          Created on: Oct 31, 2013
 */

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ListTools{
	 
	SortedSet <Data> listDisplay = new TreeSet <Data>();
	SortedSet <String> textFile = new TreeSet <String>(); //relacion->textFile
	Set <String> stateSet = new HashSet <String>(); //relacion->setName
	Set <String> zipcodeSet = new HashSet <String>(); //relacion->setName
	Set <String> townshipSet = new HashSet <String>(); //relacion->setName

	 // Metodo que recibe un Set y un objeto de clase data,
	 // que permite almacenar el objeto en el set
	public void addObjToSet(HashSet <Data> setName, Data dataObj){
	 	setName.add(dataObj);
	}

	 // Metodo que recibe un Set y un String para
	 // almacenar el String en el respectivo Set 
	 // que no permite elementos repetidos
	public void addStringToSet(Set <String> setName, String string){
	 	setName.add(string);
	}

	public void forLoops(Set <String> referenceSet, Set <String> setName1, Set <String> setName2, SortedSet <String> textFile){
	 	
	 	int setCount1 = 0;
	 	int setCount2 = 0;
	 	int id = 1;
	 	Set <String> temp1 = new HashSet <String>();
	 	Set <String> temp2 = new HashSet <String>();

	 	for (String line: textFile) {
			String[] result = line.split("\\|");
			addStringToSet(referenceSet,result[4]); /* reference set aquí es el set de los estados */
			addStringToSet(setName1,result[0]);		/* columna de los códigos postales */
			addStringToSet(setName2,result[3]);     /* columna de las delegaciones, municipio, ranchaerías */
	 	}

	 	for (String item: referenceSet) {
	 		setCount1 = 0; /* contador para los códigos postales */
	 		setCount2 = 0; /* contador para las delegaciones, municipios, rancherías */
	 		
	 		for (String line: textFile) {
				String[] result = line.split("\\|");
				if (result[4].equals(item)) {
					if (!temp1.contains(result[0])) {
						temp1.add(result[0]);
						setCount1++;
					}
					if (!temp2.contains(result[3])) {
						temp2.add(result[3]);
						setCount2++;
					}
					
				}
	 		}
	 		Data finalInfo = new Data(id, item, setCount1, setCount2);
	 		addObjToSet(listDisplay, finalInfo);
	 		id++;	 	
	 		temp1.clear();
	 		temp2.clear();
	 	}
	}
}
