/**
 * test.java
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

public class test{

	public static void main(String args[]){

		matrix m1=new matrix();
		m1.print();
		m1.diagonalizar();
		System.out.println("\n>>> Analizando matriz: \n");
		m1.check(m1.mat);
		System.out.println("\n>>> Analizando diagonal: \n");
		m1.check(m1.diag);
	}
}