/* * EvalMatrix.java
 * Authors: 
 * 		César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 * 		Magnus Henkel (magnus.henkel at zoho.com)
 * 
 *
 * MultiplyComplexNumbers.java
 * Authors: 
 * 		César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 * 		Magnus Henkel (magnus.henkel at zoho.com)
 * 
 * Programa que recibe una matriz de 3 x 3, determina el valor máximo, así
 * como su posición. Si existen valores iguales, obtiene todas las posiciones.
 * 
 */

import java.lang.String;

public class EvalMatrix {

	double matrix[][];
	static double maximum;

	public EvalMatrix(double matrix[][], double maximum) {
		this.matrix = matrix;
		EvalMatrix.maximum = maximum;
	} 
	
	public static double MinMaxVal(double matrix[][]){

		double maximum = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length - 1; j++) {
				
				if (maximum > matrix[i][j+1]) {
					continue;
				} else {
					maximum = matrix[i][j+1];
				}
			}
		}
		return maximum;
	}
	
	public static boolean Position(double ArrayVal, double MaxVal) {
		if( ArrayVal == MaxVal)
			return true;
		else 
			return false;
	}

	public static void main(String args[]) {

		double matrix[][] = new double[3][3]; 
		int storePosition[][] = new int[3][3];
		int l = 0; // recorre la matriz storePosition
		java.util.Scanner scr = new java.util.Scanner(System.in);

        for (int i = 0; i < 3; i++ ) {
        	for (int j = 0; j < 3; j++) {
		
        		System.out.print("Enter [" + (i+1) + "] [" + (j+1) + "]: ");
        		matrix[i][j] = scr.nextDouble();
        	}
        }
        scr.close();

    	System.out.println("\nYou entered: ");
        for (int i = 0; i < matrix.length; i++ ) {
        	for (int j = 0; j < matrix.length; j++) {
        		System.out.print(matrix[i][j] + "\t");
			}
        	System.out.print("\n");
        }
        
		EvalMatrix.maximum = MinMaxVal(matrix);
		System.out.println("\nMaximum: " + EvalMatrix.maximum);

        for (int i = 0; i < matrix.length; i++ ) {
        	for (int j = 0; j < matrix.length; j++) {

        		boolean positionCheck = Position(matrix[i][j], EvalMatrix.maximum);

        		if (positionCheck == true) {
        			System.out.println("Maximum value at matrix position: [" + (i+1) + "]" + "[" + (j+1) + "]");
        			storePosition[l][0] = i;
        			storePosition[l][1] = j;
        			l++;
        		}
			}
        }

	} /* end of main */
} /* end of EvalMatrix */