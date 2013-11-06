/** *	Práctica 10-1: Division.java 
 * 
 * El siguiente código:
 * 
 *	   	public class Division{
 *	      	public static void main(String args[]){
 *	         int x,y,z;
 *	         x=2;
 *	         y=0;
 *	         z=x/y;
 *	         System.out.println("El resultado es: "+z);
 *			} 
 *		}
 *
 *	genera una excepción al ejecutarse.¿Qué excepción se genera? ¿Por qué?
 *	Modifique el código utilizando try-catch, para que despliegue en pantalla la
 *	razón de la excepción. Además, haga que el programa reciba parámetros desde
 *	la línea de comandos.
 *
 * @authors 
 *	César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *	Magnus Henkel (magnus.henkel at zoho.com)
 *
 */
import java.util.*;

public class Division{

	public static int ReadData(){
		Scanner keyb = new Scanner(System.in);
		int w;
		
		w = keyb.nextInt();
		return w;
	}
	
	public static void main(String args[]) throws InterruptedException {

	    int x = 2;
	    int y = 0;
	    int z;
	
	    try{
	
	        z = x / y;
	        System.out.println("'x' divided by 'y' equals: " + z);
	
	    }catch(ArithmeticException var){
	    	System.out.println("x value: " + x + "\ny value: " + y);
	    	System.out.println("Trying the following operation: x/y");
	    	for (int i = 0; i < 3; i++) {
	    		System.out.print(".");
	    		Thread.sleep(1000);
			}

	        System.out.println("\nERROR! (Division by zero). \n\nEnter any value except zero for 'y'\n");

	    }finally{
	    	try{
		        System.out.println("x value:");
		        x = Division.ReadData();
		        System.out.println("y value:");
		        y = Division.ReadData();
		        z = x / y;
		        System.out.println("Result: " + z);
	    	}catch (ArithmeticException var){
	    		System.out.println( "Input invalid. Exiting...");
	    		System.exit(1);
		    }catch(InputMismatchException var){
		    	System.out.println("Input invalid. Exiting");
		    	System.exit(1);
		    }
	    }
	}
}
