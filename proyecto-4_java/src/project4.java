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
        //String cadena;
        //int i; 
        StringTokenizer str;
        //listado lisTado = new listado();
        listas listaS = new listas();
        File file = new File("CPdescarga.txt");

        try {
 
            Scanner scanner = new Scanner(file, "ISO-8859-1");
 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //System.out.println(line);

                //str = new StringTokenizer(line);
                
                listaS.archivo.add(line); //albert
                

                /*
                while(str.hasMoreTokens()){
                        lisTado.lineOfFile.add( str.nextToken("|"));
                } */

                /*
                lisTado.estado = lisTado.lineOfFile.get(4);
                lisTado.cp = lisTado.lineOfFile.get(0);
                //funcion de busqueda de estados y almacenamiento sin repetir
                lisTado.setEdo(lisTado.listaEdo,lisTado.estado);
                lisTado.setCP(lisTado.listaCP,lisTado.cp);
                //
                lisTado.addToSet(1,4,lisTado.listaDeleg, lisTado.lineOfFile);
                lisTado.lineOfFile.clear();
                */ 
            }
            scanner.close();
            listaS.forLoops(listaS.cP, listaS.estados, listaS.delMunRan, listaS.archivo); //Albert
            System.out.println("Estados con conteos:\n");
            System.out.println(listaS.listaAmostrar);
            //System.out.println(lisTado.file.get(0));
            //System.out.println(lisTado.listaDeleg);
            //Imprimir lista de cantidad de cp
            //System.out.println("CP's List");
            //System.out.println(lisTado.listaCP);
            //System.out.println("\n");
            //System.out.println(lisTado.listaEdo);
            //
            //imprimir lista de estados sin repetir
            //lisTado.setInOrderEdo(lisTado.listaEdo);
            //System.out.println("\n");
            //lisTado.printInOrder(lisTado.inOrderEdo);
            //System.out.println(lisTado.inOrderEdo.size());
            //
            
            }catch(FileNotFoundException var){
                System.out.println("No existe el archivo");
                var.printStackTrace();
            }catch(IOException var){
                System.out.println("Error en el archivo");
            
            }
        }
}
