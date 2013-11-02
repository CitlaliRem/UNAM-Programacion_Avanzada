/**      
 *     Proyecto 4:
 *     Programa que efectua una busqueda sobre un archivo de texto (.txt) y muestra u ordena
 *           la lista por los siguientes criterios:
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
    *        Main
    */
    public static void main(String args[]){

        StringTokenizer str;
        listas listaS = new listas();
        File file = new File("CPdescarga.txt");

        try {
 
            Scanner scanner = new Scanner(file, "ISO-8859-1");
 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listaS.archivo.add(line);
                
            }
            scanner.close();
            listaS.forLoops(listaS.cP, listaS.estados, listaS.delMunRan, listaS.archivo); //Albert
            System.out.println("Estados con conteos:\n");
            System.out.println(listaS.listaAmostrar);
            
        }catch(FileNotFoundException var){
            System.out.println("No existe el archivo");
            var.printStackTrace();
        }catch(IOException var){
            System.out.println("Error en el archivo");
        }
    }
}
