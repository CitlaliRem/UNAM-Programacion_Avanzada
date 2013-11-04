/**
 *	Práctica 10-1: Division.java 
 * 
 * @authors 
 *	César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *	Magnus Henkel (magnus.henkel at zoho.com)
 *
 */
public class Division{

    public static void main(String args[]){

        int x, y, z;

        try{
            x = 2;
            y = 0;
            z = x / y;
            System.out.println("El resultado es: " + z);
        }catch(ArithmeticException lol){
            System.out.println("Error division por cero [0]");
        }
        /*
            Genera java.lang.ArithmeticException: / by zero
            Se generá porque no se puede dividir por 0

        */
    }
}