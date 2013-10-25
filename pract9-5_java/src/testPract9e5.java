/**
 * testPract9e5.java
 *
 *  Elabore un programa que reciba una matriz de 4 x 4,
 *  y que determine cuantos numeros son positivos, 
 *  cuantos ceros, y cuantos negativos.
 */
 
/**
 *
 * @authors: Magnus Henkel (magnus.henkel at zoho.com)
 *         César Alberto Trejo Juárez (cesaratj27 at gmail.com) 
 */

public class testPract9e5{

	public static void main(String args[]){
		matrixFour m4 = new matrixFour();
		m4.print();
		m4.check();
		System.out.println("Zeros: " + m4.zero);
		System.out.println("Positive numbers: " + m4.plus);
		System.out.println("Negative numbers: " + m4.negative);
	}
}
