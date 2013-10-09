public class matrix{
	
	//*** Propiedades
	int [][]mat={{2,56,77},{4,80,2},{7,9,32}};


	//**** Definición de métodos


	// Método para imprimir la matriz
	public void print(int size){
		for (int i = 0; i < size ; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print([i][j]mat + " ");
			}
			System.out.println();
		}
	}


	//Metodo para obtener la diagonal de la matriz
	public int diagonalizar(int size){
		int [sizeof][]diag;

		for (int k = 0; k < sizeof ; k++) {
			[k][]diag = [k][k]mat;
		}

		return [k][]diag;
	}


	//Metodo para verificar si los elementos del arreglo son par o impar
	public void check(int [int i][int j]matriz){
		int u = i;
		int w = j;

		for (int o = 0; o < u; o++) {
			for (int p = 0; p < w ; p++) {
				if ([u][w]matriz % 2 == 0) {
					System.out.println("El elemento " + [u][w]matriz + "  es par");
				}
				else{
					System.out.println("El elemento " + [u][w]matriz + "  es impar");
				}
			}
		}
	}

}