/*
 * pract_5-3.c
 *
 *  Created on: Sep 22, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 */

#include <stdio.h>

int main(){

	int i, j ,k, l;
	int flag = 0;

	float A[3][3] = {{1,2,3},{-2,-4,8},{3,1,2}};
	float B[3] ={ 2.4,6.4,7.6};
	float temp[3][3];
	float cte;

	for(i=0; i<3;i++){
	    for(j=i+1; j<3; j++){


			for(k=i; k<3; k++){
				if(flag == 1) {
					for(l=0;l<3;l++) {
						temp[i][l] = A[i+1][l];
						A[i+1][l] = A[i][l];
						A[i][l] = temp[i][l];
					}
				}

			cte = A[j][i]/A[i][i];


				A[j][k] = A[j][k] - cte * A[i][k];

				if (A[i][i]==0){
					k=0;
					flag = 1;
					break;
				}
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

	return 0;
}
