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
//import java.util.Scanner;

public class project4{
	/**
	*	Main
	*/
	public static void main(String args[]) throws IOException{
		//String cadena;
		//int i; 
		StringTokenizer str;
		listado lisTado = new listado();

		File file = new File("CPdescarga.txt");

        try {
 
            Scanner scanner = new Scanner(file, "ISO-8859-1");
 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //System.out.println(line);

				str = new StringTokenizer(line);

				while(str.hasMoreTokens()){
					lisTado.lineOfFile.add( str.nextToken("|"));
					}

				lisTado.estado = lisTado.lineOfFile.get(4);

				//funcion de busqueda de estados y almacenamiento sin repetir
				lisTado.searchEdoCountCP(lisTado.listaEdo,lisTado.estado);
				//
				lisTado.lineOfFile.clear();

			}

			scanner.close();
			//Imprimir lista de cantidad de cp
			System.out.println("CP's List");
			System.out.println(lisTado.listaCP);
			System.out.println("\n");
			System.out.println(lisTado.listaEdo);
			//
			//imprimir lista de estados sin repetir
			lisTado.setInOrderEdo(lisTado.listaEdo);
			System.out.println("\n");
			lisTado.printInOrder(lisTado.inOrderEdo);
			System.out.println(lisTado.inOrderEdo.size());
			//

		}catch(FileNotFoundException var){
			System.out.println("No existe el archivo");
            var.printStackTrace();
		}
	}
}
