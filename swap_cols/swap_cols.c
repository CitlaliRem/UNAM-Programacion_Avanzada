/*

 * swap_cols.c
 *
 *  Created on: Sep 28, 2013
 *      Author: arytloc
 */


#include<stdio.h>

void swapColumns(int ceroCol,float A[3][3]);
void printMatrix(float A[3][3]);

float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
float B[3] ={ 2.4,6.4,7.6};
float cte;


int main() {

	int i, j ,k;

	swapColumns(2, A);

	printMatrix(A);

	return 0;
}

void swapColumns(int ceroCol,float A[3][3]) {
	float temp[1][3];
	int i, j;
	for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				printf("dentro de la funcion: %0.2f\t", A[i][j]);
			}
			printf("| %0.2f\n", B[i]);
		}

	printf("ceroCol: %i\n", ceroCol);
	int l;

	//printf("\nA[ceroCol][1] %0.2f", A[1][1]);

	for(l=0;l<3;l++) {
		temp[1][l] = A[ceroCol][l];
		A[ceroCol][l] = A[ceroCol+1][l];
		A[ceroCol+1][l] = temp[1][l];
	}
	printf("hasta aqui");

}

void printMatrix(float A[3][3]) {
	int i, j;
	for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				printf("%0.2f\t", A[i][j]);
			}
			printf("| %0.2f\n", B[i]);
		}
}
