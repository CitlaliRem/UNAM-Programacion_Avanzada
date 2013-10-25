/**
*	matrixFour.java
*
*    A simple class for evaluate how many zeros, positive numbers or
*   negative numbers are in a matrix.
*
*    @authors: Magnus Henkel (magnus.henkel at zoho.com)
*         César Alberto Trejo Juárez (cesaratj27 at gmail.com)
*/

import java.util.*;

public class matrixFour{
	/**
	* 	Properties
	*/
	public int [][]mat = { {0,3,-23,0}, {-13,-7,8,0}, {-12,-67,23,2}, {1,0,-1,0} };
	public int plus;
	public int negative;
	public int zero;

	/** 
	* 	Constructor
	*/
	public matrixFour(){
		System.out.println("Creating matrix");
		System.out.println("Ready to read");
	}
	
	/**
	* 	Metodos
	*/

	/**
	* 	Print a matrix
	* 	@return void
	* 	@para nothing
	*/
	public void print(){
		System.out.print("\nMatrix:\n");
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < 4 ; j++){
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	* 	Check how many zeros, negativa or positive
	* 	numbers are in a matrix.
	* 	@return void
	* 	@para nothing
	*/
	public void check(){
		int m,n;
		System.out.println("\nChecking: ");
		for (m = 0; m < 4 ; m++) {
			for (n = 0; n < 4 ; n++) {
				if (mat[m][n] > 0) {
					plus++;
				} else{
					if (mat[m][n] < 0) {
						negative++;
					}else
					 	zero++;
				}
			}
		}
	}
}
