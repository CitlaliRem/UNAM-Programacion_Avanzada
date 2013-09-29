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
void reset();

float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
float B[3] ={ 2.4,6.4,7.6};
float cte;

int main(){

	int i, j ,k;
	int zero;
	do{
	zero = test();
	reset();
	swapRows(zero); // Aquí se debe asignar el argumente dependiendo del resultado del test
	}while (zero == 1);

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

	printMatrix();

	if(zeroRow<2) { // asegurando que no intenta
		for(l=0;l<3;l++) {  // aqui esta el problema
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
	    }
	}
	return 0;
}

/*****************************/
/* funtion reset 	         */
/*****************************/
void reset() {
	float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
	float B[3] = { 2.4,6.4,7.6};
}