// Project #2
// Gauss-Jordan
// Authors: Magnus Henkel & César Alberto Trejo Juárez
// Universidad Nacional Autónoma de México
// Programación Avanzada y Métodos Numéricos
// Created on: Monday 30 September 2013
// ©
// 

#include <stdio.h>

void printMatrix();

float A[5][5] = {{2.0,1.0,3.0,6.0,-10.0},{-9.0,-4.0,-6.0,12.0,4.0},{-1.0,0.0,5.0,13.0,-17.0},{1.0,2.0,3.0,9.0,24.0},{23.0,14.0,5.0,7.0,19.0}};
float B[5] = {56.0,70.0,12.0,-30.0,45.0};

/*********************/
/*   Funtion Main    */
/*********************/
int main(int argc, char const *argv[])
{
	int i, j, k;
	float cte;

	printf("Matriz:");
	printf("\n---------\n");
	printMatrix();
	for(i = 0; i < 5; i++){

		//Normalizamos el renglon pivote
		cte = A[i][i];
		for (j = 0; j < 5; j++)
		{
			A[i][j] = A[i][j]/cte;
		}
		B[i] = B[i] / cte;
		//Fin normalizar

		// Eliminación gaussiana
		for (j = i+1; j < 5; j++)
		{
			cte = A[j][i] / A[i][i];
			for (k = 0; k < 5; k++)
			{
				A[j][k] = A[j][k] - cte * A[i][k];
			}
			B[j] = B[j] - cte * B[i];
		}
	}

	// Eliminacion inversa
	for ( i = 4; i >= 0; i--)
	{
		for (j = i -1; j >= 0; j--)
		{
			cte = A[j][i];
			A[j][i] = A[j][i] - cte * A[i][i];
			B[j] = B[j] - cte * B[i];
		}
	}
	printf("\nResultados: ");
	printf("\n--------------\n");
	printMatrix();
}

/*****************************/
/* funtion printMatrix       */
/*****************************/
void printMatrix() {
	int i, j;

	for(i = 0; i < 5; i++){
		for(j = 0; j < 5; j++){
			printf("%f\t", A[i][j]);
		}
		printf("| %f\n", B[i]);
	}
	printf("\n");
}