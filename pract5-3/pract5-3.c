/*
 * pract_5-3.c
 *
 *  Created on: Sep 22, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 */

#include <stdio.h>

void swapColumns(int ceroCol,float A[3][3]);

	float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
	float B[3] ={ 2.4,6.4,7.6};
	float cte;

int main(){

	int i, j ,k;

	for(i=0; i<3;i++){
	    for(j=i+1; j<3; j++){
	    	if (A[i][i]==0){
			}
			cte = A[j][i]/A[i][i];
		
			for(k=i; k<3; k++){
				A[j][k] = A[j][k] - cte * A[i][k];
			}
			B[j] = B[j] - cte * B[i];
	    }
	}

	for(i=0; i<3; i++){
		for(j=0; j<3; j++){
			printf("%0.2f\t", A[i][j]);
		}
		printf("| %0.2f\n", B[i]);
	}
	return 0;
}

void swapColumns(int ceroCol,float A[3][3]) {
	float temp[1][3];
	int l;

	ceroCol = 1;
	printf("\nA[ceroCol][1]", A[1][1]);
	for(l=0;l<3;l++) {
		temp[1][l] = A[ceroCol][l];
		A[ceroCol][l] = A[ceroCol+1][l];
		A[ceroCol+1][l] = temp[1][l];
	}

}
