/**
 *	Práctica 10-1: Division.java 
 * 
 * @authors 
 *	César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *	Magnus Henkel (magnus.henkel at zoho.com)
 *
 */
import java.io.*;
import java.util.*;

public class Division{

    public static void main(String args[]){

        int x, y, z;
        Scanner teclado = new Scanner(System.in);

        try{
            System.out.println("Ingrese primer valor:");
        	x = teclado.nextInt();
        	System.out.println("Ingrese segundo valor:");
        	y = teclado.nextInt();
        	z = x / y;
            System.out.println("El resultado es: " + z);
        }catch(ArithmeticException lol){
            System.out.println("Error division por cero [0]");
            lol.printStackTrace();
        }
        /*
            Genera java.lang.ArithmeticException: / by zero
            Se generá porque no se puede dividir por 0

        */
    }
}
