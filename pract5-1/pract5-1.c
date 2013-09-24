/*
 * pract_5-1.c
 *
 *  Created on: Sep 22, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 *      Elaborar un programa que implemente la Eliminación Gaussiana para un
 *      sistema de ecuaciones lineales de 3 x 3.
 *
 *      DESDE i= 1HASTA n
 *      	DESDE j = i+1 HASTA n
 *				cte = A(j,i)/A(i,i)
 *				DESDE k=i HASTA n
 *					A(j,k) = A(j,k)-cte*A(i,k)
 *				FIN
 *				B(j) = B(j)-cte*B(i)
 *			FIN
 *		FIN
 */

#include <stdio.h>

int main(){

	int i, j ,k;

	float A[3][3] = {{12,4,11},{2,-33, 9},{3, 0, 22}};
	float B[3] ={-30,8,23};
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
		printf("\t|%.02f\n", B[i]);
	}

	printf("\nx_3 Value: %0.2f", B[2]/A[2][2]);
}
