/**
 * Práctica 10-3: Errorhandling3.java 
 *
 * @authors 
 *	César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *	Magnus Henkel (magnus.henkel at zoho.com)
 *
 */

public class ErrorHandling3{
      public static void main(String args[]){
    	  try{
    		  
	         int n = Integer.parseInt(args[0]);
	         int arr[] = new int[n];
	         for(int i=0;i<n;i++){
	            arr[i]=i+1;
	         }
	         for(int i=0;i<n;i++){
	            System.out.println("arr["+i+"]: "+arr[i]);
	         }
    	 } catch(ArrayIndexOutOfBoundsException var) {
    		 System.out.println("Exception caught. Reason:");
    		 var.printStackTrace();
    		 System.out.println("Argument of type integer requiered");
    	 }
      }
}
