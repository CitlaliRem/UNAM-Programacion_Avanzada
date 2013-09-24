/*
 * pract_5-1.c
 *
 *  Created on: Sep 22, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 */

#include <stdio.h>

int main(){

	int i, j ,k;

	float A[3][3] = {{5,3,-8},{-1,4,-6},{4,-6,1}};
	float B[3] ={ 85.3,14.32,17.61};
	float cte;

	for(i=0; i<3;i++){
	    for(j=i+1; j<3; j++){
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
	printf("\nx_3 Value: %0.2f", B[2]/A[2][2]);
}
