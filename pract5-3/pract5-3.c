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
int test();

float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
float B[3] ={ 2.4,6.4,7.6};
float cte;

int main(){

	int i = 0;
	int j = 0;
	int k = 0;

<<<<<<< HEAD
	swapRows(test());
=======
	do{
	zero = test();
	reset();
	swapRows(zero); // Aquí se debe asignar el argumente dependiendo del resultado del test
	}while (zero == 1);
>>>>>>> b2cac590129df1c11a1fbb17cb6f9e113ffba297

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
	printf("\nx_3 value: %0.2f\n", B[2]/A[2][2]);

	return 0;
}

/*****************************/
/* funtion swapRows          */
/*****************************/
void swapRows(int zeroRow) {
	float temp[1][3];
	float Btemp1;
	int l;

<<<<<<< HEAD
	if(zeroRow<2) { // asegurando que no intenta cambiar el último renglón con el que sigue
		for(l=0;l<3;l++) {
=======
	printMatrix();

	if(zeroRow<2) { // asegurando que no intenta
		for(l=0;l<3;l++) {  // aqui esta el problema
>>>>>>> b2cac590129df1c11a1fbb17cb6f9e113ffba297
			temp[0][l] = A[zeroRow][l];
			A[zeroRow][l] = A[zeroRow+1][l];
			A[zeroRow+1][l] = temp[0][l];
		}

		Btemp1 = B[zeroRow];
		B[zeroRow] = B[zeroRow+1];
		B[zeroRow+1] = Btemp1;
	}
}

/*****************************/
/* funtion printMatrix       */
/*****************************/
void printMatrix() {
	int z, x;
	for(z=0; z<3; z++){
		for(x=0; x<3; x++){
			printf("%0.2f\t", A[z][x]);
		}
		printf("| %0.2f\n", B[z]);
	}
	printf("\n");
}

/*****************************/
/* funtion test 	         */
/*****************************/
int test(){
<<<<<<< HEAD
	int i,j,k;
	float Atemp[3][3];
	float Btemp[3];

	/* Hacemos una copia de la matriz para el test*/
	for(i=0; i<3; i++){
		for(j=0; j<3; j++){
			Atemp[i][j] = A[i][j];
			Btemp[i] = B[i];

		}
	}

	for(i=0; i<3;i++){
		if (Atemp[i][i]==0) {
			return i;
		}
	    for(j=i+1; j<3; j++){
		cte = Atemp[j][i]/Atemp[i][i];
		for(k=i; k<3; k++){
			Atemp[j][k] = Atemp[j][k] - cte * Atemp[i][k];
		}
		Btemp[j] = Btemp[j] - cte * Btemp[i];
=======
	int m, p, o;
	int cnst;

	for(m=0; m<3;m++){
		if (A[m][m]==0) {
			printf("Exists 0 in main diagonal\n");
			return 1;
		}
	    for(p=m+1; p<3; p++){
		cnst = A[p][m]/A[m][m];
		for(o=m; o<3; o++){
			A[p][o] = A[p][o] - cte * A[m][o];
		}
		B[p] = B[p] - cte * B[m];
>>>>>>> b2cac590129df1c11a1fbb17cb6f9e113ffba297
	    }
	}
	return 2;
}
<<<<<<< HEAD
=======

/*****************************/
/* funtion reset 	         */
/*****************************/
void reset() {
	float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
	float B[3] = { 2.4,6.4,7.6};
}
>>>>>>> b2cac590129df1c11a1fbb17cb6f9e113ffba297
