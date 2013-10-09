import java.util.*;

public class matrix{
	
	//*** Propiedades		={{2,56,77},{4,80,2},{7,9,32}};
	public int [][]mat={{2,56,77},{4,80,2},{7,9,32}};
	public int [][]diagonal = diagonalizar();

	// Constructor
	public matrix(){
		System.out.print("Creando matriz…\n");
		//print();
	}
	

	//**** Definición de métodos ****

	// Método para imprimir la matriz
	public void print(){

		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}


	//Metodo para obtener la diagonal de la matriz
	public int diagonalizar(){
		int []diag = new int [3];

		for(int k = 0; k < 3 ; k++){
			diag[k] = mat[k][k];
		}

		return diag;
	}


	//Metodo para verificar si los elementos del arreglo son par o impar
	public void check(int arrayChecked[][]){
		int o, p;

		for(o = 0; o < arrayChecked.lenght; o++){
			for(p = 0; p < arrayChecked.lenght; p++){
				if(arrayChecked[o][p] % 2 == 0){
					System.out.println("El elemento " + arrayChecked[o][p] + "  es par");
				}else{
					System.out.println("El elemento " + arrayChecked[o][p] + "  es impar");
				}
			}
		}
	}

}
}