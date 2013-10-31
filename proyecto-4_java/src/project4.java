/**      
 *     Proyecto 4:
 *     Programa que efectua una busqueda sobre un archivo de texto (.txt) y muestra u ordena
 *	   la lista por los siguientes criterios:
 *              -> muestra la lista de estados (sin repeticón)
 *              -> muestra número de delegaciones, municipios, rancherías por estados
 *              -> ordena los estados por la cantidad de códigos postales
 * 
 *      @authors: 
 *      César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      Magnus Henkel (magnus.henkel at zoho.com)
 *      
 *          Created on: Oct 27, 2013
 */

import java.io.*;
import java.util.*;

public class project4{
	/**
	*	Main
	*/
	public static void main(String args[]){
		String cadena;
		int i; 
		StringTokenizer str;
		listado lisTado = new listado();

		try{

			FileReader archivo = new FileReader("CPdescarga.txt");
			BufferedReader entrada = new BufferedReader(archivo);
			while( (cadena = entrada.readLine()) != null ){
				str = new StringTokenizer(cadena);
				// cadena sera un elemento 0 de un arraylist
				while( str.hasMoreTokens() ){
					lisTado.lineOfFile.add( str.nextToken("|") );
				}
				lisTado.estado = lisTado.lineOfFile.get(4);
				// funcion searchEdo
				lisTado.searchEdo(lisTado.listaEdo,lisTado.estado);
				//System.out.println(lisTado.lineOfFile.get(0));
				//System.out.println(lisTado.estado);
				lisTado.lineOfFile.clear();
			}
			//imprimir lista de estados sin repetir
			Set inOrderEdo = new TreeSet(lisTado.listaEdo);
			System.out.println(inOrderEdo);
			System.out.println(lisTado.listaEdo.size());

		}catch(FileNotFoundException var){
			System.out.println("No existe el archivo");
		}catch(IOException var){
			System.out.println("Error en el archivo");
		}
		
	}
}
