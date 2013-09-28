/*

 * swap_cols.c
 *
 *  Created on: Sep 28, 2013
 *      Author: arytloc
 */


#include<stdio.h>

//void swapColumns(int zeroCol,float A[3][3]);
void swapColumns(int zeroCol);
//void printMatrix(float A[3][3]);
void printMatrix();

float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
float B[3] ={ 2.4,6.4,7.6};
float cte;


int main() {

	int i, j ,k;

		swapColumns(1);
		printf("\n");

	return 0;
}

//void swapColumns(int zeroCol,float A[3][3]) {
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

	printf("\n");
	printMatrix();

}

//void printMatrix(float A[3][3]) {
void printMatrix() {
	int i, j;
	for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				printf("%0.2f\t", A[i][j]);
			}
			printf("| %0.2f\n", B[i]);
		}
}
