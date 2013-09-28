/*
 * pract_5-3.c
 *
 *  Created on: Sep 22, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 */

#include <stdio.h>

void swapColumns(int zeroCol);
void printMatrix();

float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
float B[3] ={ 2.4,6.4,7.6};
float cte;

int main(){

	int i, j ,k;

	/** Aquí debe haber un test si en la columna 0 o 1 A[i][i] se hace cero.
	 * Si es el caso se ejecuta swapColumns.
	 * Despues se ejecuta el código que sigue.
	 */

	swapColumns(1);

	for(i=0; i<3;i++){
	    for(j=i+1; j<3; j++){
			cte = A[j][i]/A[i][i];

			for(k=i; k<3; k++){
				A[j][k] = A[j][k] - cte * A[i][k];
			}
			B[j] = B[j] - cte * B[i];
	    }
	}

	printMatrix();
	printf("\nx_3 value: %0.2f", B[2]/A[2][2]);

	return 0;
}

/*****************************/
/* funtion swapColumns       */
/*****************************/
void swapColumns(int zeroCol) {
	float temp[1][3];
	float Btemp1;
	int l;

	printMatrix();

	if(zeroCol<2) { // asegurando que no intenta
		for(l=0;l<3;l++) {
			temp[0][l] = A[zeroCol][l];
			A[zeroCol][l] = A[zeroCol+1][l];
			A[zeroCol+1][l] = temp[0][l];
		}

		Btemp1 = B[zeroCol];
		B[zeroCol] = B[zeroCol+1];
		B[zeroCol+1] = Btemp1;
	}

	printMatrix();

}

/*****************************/
/* funtion printMatrix       */
/*****************************/
void printMatrix() {
	int i, j;
	for(i=0; i<3; i++){
		for(j=0; j<3; j++){
			printf("%0.2f\t", A[i][j]);
		}
		printf("| %0.2f\n", B[i]);
	}
	printf("\n");
}
