import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class listas{
	 
	 SortedSet <data> listaAmostrar = new TreeSet <data>();
	 SortedSet <String> archivo = new TreeSet <String>(); //relacion->textFile
	 Set <String> estados = new HashSet <String>(); //relacion->setName
	 Set <String> cP = new HashSet <String>(); //relacion->setName
	 Set <String> delMunRan = new HashSet <String>(); //relacion->setName

	 public listas(){

	 }

	 // Metodo que recibe un Set y un objeto de clase data,
	 // que permite almacenar el objeto en el set
	 public void aMostrar(SortedSet <data> listToShow, data dato){
	 	listToShow.add(dato);
	 }

	 // Metodo que recibe un Set y un String para
	 // almacenar el String en el respectivo Set 
	 // que no permite elementos repetidos
	 public void toSets(Set <String> setName, String element){
	 	setName.add(element);
	 }

	 public void forLoops(Set <String> setNameCP, Set <String> setNameEdo, Set <String> setNameDel, SortedSet <String> textFile){
	 	
	 	int cpCount = 0;
	 	int delCount = 0;
	 	int id = 1;
	 	Set <String> tempCP = new HashSet <String>();
	 	Set <String> tempDel = new HashSet <String>();

	 	for (String line: textFile) {
			String[] result = line.split("\\|");
			toSets(setNameCP,result[0]);
			toSets(setNameDel,result[3]);
			toSets(setNameEdo,result[4]);
	 	}

	 	for (String eleMent: setNameEdo) {
	 		cpCount = 0;
	 		delCount = 0;

	 		for (String line: textFile) {
				String[] result = line.split("\\|");
				if (result[4] == eleMent) {
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
	 		aMostrar(listaAmostrar, finalInfo);
	 		//listaAmostrar.add(finalInfo);
	 		id++;

	 			/*aqui revisamos si el elemento 0, 3, 4 ya existen en un set
	 			en caso de no existir en el set, entonces contamos +1
	 			en los respectivos contadores de cp y delgMunRanch */
	 			
	 	}
	 			
	 }
}