import java.util.*;

public class test{

	public static void main(String args[]){

		matrix m1=new matrix();
		m1.print();
		m1.diagonalizar();
		System.out.print("Analizando mariz: \n");
		m1.check(m1.mat);
		System.out.print("Analizando diagonal: \n");
		m1.check(m1.diag);
	}
}