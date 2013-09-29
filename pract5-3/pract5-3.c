/*
 * pract_5-3.c
 *
 *  Created on: Sep 22, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 */

#include <stdio.h>

void swapRows(int zeroRow);
void printMatrix();

float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
float B[3] ={ 2.4,6.4,7.6};
float cte;

int main(){

	int i, j ,k;



	swapRows(1); // Aquí se debe asignar el argumente dependiendo del resultado del test

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
/* funtion swapRows       */
/*****************************/
void swapRows(int zeroRow) {
	float temp[1][3];
	float Btemp1;
	int l;

	printMatrix();

	if(zeroRow<2) { // asegurando que no intenta
		for(l=0;l<3;l++) {
			temp[0][l] = A[zeroRow][l];
			A[zeroRow][l] = A[zeroRow+1][l];
			A[zeroRow+1][l] = temp[0][l];
		}

		Btemp1 = B[zeroRow];
		B[zeroRow] = B[zeroRow+1];
		B[zeroRow+1] = Btemp1;
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
