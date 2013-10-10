/*
 * oddChecker.c
 * 
 * Programa que evalua cada posición de una matriz, comprobando si contiene un valor par o impar.
 * El programa deja la opción de evaluar una matriz de 3x3 o una de 5x5, detecta
 * el tamaño de la matriz seleccionada y procesa primero la diagonal por
 * separado, después analiza cada valor de la matriz completa.
 *
 *      Authors: 
 *      	César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      	Magnus Henkel (magnus.henkel at zoho.com)
 *  
 *  	Created on: Sep 17, 2013
 */

public class Main {
	double matrix_A[][];
    double matrix_B[][];
    
    public Main(double matrix_a[][], double matrix_b[][]) {
    	this.matrix_A = matrix_a;
    	this.matrix_B = matrix_b;
    }
    
    public void Select(int option){
    	double matrix_select[][] = null;

    	switch(option) {
    		case 3:
    			matrix_select = this.matrix_A;
    			break;
            case 5:
            	matrix_select = this.matrix_B;
            	break;
        }
        
        this.doOperations(matrix_select);
    }
    
    public void doOperations(double matrix_select[][]){
        ArrayFunction obj = new ArrayFunction();
        
        System.out.println("You chose matrix:");
        System.out.println(obj.printMatrix(matrix_select));

        System.out.println("Verifying matrix.");
        System.out.println(obj.checkMatrix(matrix_select));

        System.out.println("Verifying diagonal");
        System.out.println(obj.checkDiagonal(matrix_select));
        
    }
    
    public static void main(String args[]) {
        double mA[][] = {{1,2,3},{2,3,4},{5,6,7}}; 
        double mB[][] = {{3,2,0,9,1},{1,2,32,12,3},{4,3,1,3,0},{4,2,2,7,8},{1,8,4,11,9}};
        String option = "";
        java.util.Scanner scnr = new java.util.Scanner(System.in);
        
        Main obj = new Main(mA, mB);
        System.out.println("Choose matrix 3x3 or 5x5 (3/5) ");
        option = scnr.next().toString();
        
        try {
            obj.Select(Integer.parseInt(option));
        } catch (Exception e) {System.out.println("This is not a number");}
        
    }
}
