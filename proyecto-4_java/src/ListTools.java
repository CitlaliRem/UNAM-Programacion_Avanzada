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
	 
	HashSet <data> listDisplay = new HashSet <data>();
	SortedSet <String> textFile = new TreeSet <String>(); //relacion->textFile
	Set <String> stateSet = new HashSet <String>(); //relacion->setName
	Set <String> zipcodeSet = new HashSet <String>(); //relacion->setName
	Set <String> townshipSet = new HashSet <String>(); //relacion->setName


	 // Metodo que recibe un Set y un objeto de clase data,
	 // que permite almacenar el objeto en el set
	public void addObjToSet(HashSet <data> setName, data dataObj){
	 	setName.add(dataObj);
	}

	 // Metodo que recibe un Set y un String para
	 // almacenar el String en el respectivo Set 
	 // que no permite elementos repetidos
	public void addStringToSet(Set <String> setName, String string){
	 	setName.add(string);
	}

	public void forLoops(Set <String> setNameCP, Set <String> referenceSet, Set <String> setNameDel, SortedSet <String> textFile){
	 	
	 	int cpCount = 0;
	 	int delCount = 0;
	 	int id = 1;
	 	Set <String> tempCP = new HashSet <String>();
	 	Set <String> tempDel = new HashSet <String>();

	 	for (String line: textFile) {
			String[] result = line.split("\\|");
			addStringToSet(referenceSet,result[4]);
			addStringToSet(setNameCP,result[0]);
			addStringToSet(setNameDel,result[3]);
	 	}

	 	for (String eleMent: referenceSet) {
	 		cpCount = 0;
	 		delCount = 0;
	 		
	 		for (String line: textFile) {
				String[] result = line.split("\\|");
				if (result[4].equals(eleMent)) {
					if (!tempCP.contains(result[0])) {
						tempCP.add(result[0]);
						cpCount++;
					}
					if (!tempDel.contains(result[3])) {
						tempDel.add(result[3]);
						delCount++;
					}
					
				}
	 		}
	 		data finalInfo = new data(id, eleMent, cpCount, delCount);
	 		addObjToSet(listDisplay, finalInfo);
	 		id++;	 	
	 		tempCP.clear();
	 		tempDel.clear();
	 	}
	}
}
