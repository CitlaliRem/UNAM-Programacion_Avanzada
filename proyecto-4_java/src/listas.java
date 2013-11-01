import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class listas{
	 
	 SortedSet <data> listaAmostrar = new TreeSet <data>();
	 SortedSet <String> archivo = new TreeSet <String>();
	 Set <String> estados = new HashSet <String>();
	 Set <String> cP = new HashSet <String>();
	 Set <String> delMunRan = new HashSet <String>();

	 public listas(){

	 }

	 // Metodo que recibe un Set y un objeto de clase data
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

	 public void forLoops(Set <String> setName, SortedSet <String> textFile){
	 	for (String s: setName) {
	 		System.out.println("Element in SortedSet: " + s);
	 	}
	 }
}