/**
 * matrix.java
 *
 * Proyecto que permite conocer si los elementos de una matriz
 * son pares o impares; o si los elementos de la diagonal de
 * la matriz, lo son.
 */
 
/**
 *
 * @authors: Magnus Henkel (magnus.henkel at zoho.com)
 *         César Alberto Trejo Juárez (cesaratj27 at gmail.com) 
 */


import java.util.*;

public class matrix{
	
	//*** Propiedades
	public int [][]mat={{2,56,77},{4,80,2},{7,9,32}};
	public int [][]diag = new int [3][1];

	// Constructor
	public matrix(){
		System.out.print("Creando matriz…\n");
	}
	
	/*
 	* Metódos
 	*/

	// Método para imprimir la matriz
	public void print(){
		System.out.print("Matriz:\n");
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println();
		}
	}


	//Metodo para obtener la diagonal de la matriz
	public void diagonalizar(){

		for(int k = 0; k < 3 ; k++){
			diag[k][0] = mat[k][k];
		}
	}


	//Metodo para verificar si los elementos del arreglo son par o impar
	public void check(int arrayChecked[][]){
		int o, p;

		for(o = 0; o < arrayChecked.length; o++){
			for(p = 0; p < arrayChecked[o].length; p++){
				if(arrayChecked[o][p] % 2 == 0){
					System.out.println("El elemento " + arrayChecked[o][p] + "  es par");
				}else{
					System.out.println("El elemento " + arrayChecked[o][p] + "  es impar");
				}
			}
		}
	}
}