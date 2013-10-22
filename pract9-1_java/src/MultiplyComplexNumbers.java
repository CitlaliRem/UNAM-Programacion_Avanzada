/* 
 * MultiplyComplexNumbers.java
 * Authors: 
 * 		César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 * 		Magnus Henkel (magnus.henkel at zoho.com)
 * 
 * Programa que recibe dos números complejos, y obtiene la multiplicación.
 * 
 */

final class DecisionResult {

    private final String first;
    private final String second;

    public DecisionResult(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}


public class MultiplyComplexNumbers {
	
	double matrix[] = {};

/*    public MultiplyComplexNumbers(double matrix1[], double matrix2[]) {
   	 	this.matrix = matrix1;
     }
*/

      public static DecisionResult FormatDecision(int i, int j) {

		String ordinal = "";
		String label = "";

		if(i == 0) {
			ordinal = "first";
		} else {
			ordinal = "second";
		}

		if(j == 0){
			label = "real";
		} else {
			label = "imaginary";
		}

        return new DecisionResult(ordinal, label);
      }

	public static void main(String args[]) {

		double matrix[][] = new double[2][2]; 

		java.util.Scanner scr = new java.util.Scanner(System.in);

        for (int i = 0; i < 2; i++ ) {
        	for (int j = 0; j < 2; j++) {

		        DecisionResult result = FormatDecision(i, j);
		
        		System.out.print("Enter " + result.getFirst() + " complex number, " + result.getSecond() + " part: ");
        		matrix[i][j] = scr.nextDouble();
        	}
        }

        scr.close();

       	System.out.println("\nYou entered: ");
        for (int i = 0; i < 2; i++ ) {
        	System.out.println(matrix[i][0] +  " + " + matrix[i][1] + "i");
        }
        
        System.out.println("\nProduct of complex numbers: " + matrix[0][0] * matrix[1][0] + " + " + matrix[0][1] * matrix[1][1] +"i");
	}
}
