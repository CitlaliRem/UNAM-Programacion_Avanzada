/*
 * pract6-1.c
 *
 *  Created on: Sep 28, 2013
 *      Authors: Magnus Henkel, César Alberto Trejo Juárez
 *
 *      Elaborar un programa que implemente el método de LU, para resolver
 *      sistemas de 3 incógnitas.
 */

#include<stdio.h>
void enterCoefficients(int unknowns);
void enterIndTerm(int unknowns);
float summation(int prim_counter, int sec_counter, int flag);
void printMatrix(float matrix[3][3],char name);

float M[3][3];
float B[3];
float L[3][3];
float U[3][3];

float y_1 = 0, y_2 = 0, y_3 = 0;
float x_1 = 0, x_2 = 0, x_3 = 0;


int main () {

	int i = 0;
	int j = 0;
	int k = 0;
	int l = 0;


	enterCoefficients(3);
	enterIndTerm(3);

	for(k=0; k<3; k++) {
		for(l=0; l<3; l++) {
			U[k][l] = 0;
			if(k==l) {
					U[k][l] = 1;
			}

			L[k][k] = M[k][k] - summation(k,-1, 0);

			for(i=k+1;i<3;i++) {
				L[i][k] = M[i][k] - summation(k, i, 1);
			}

			for(j=k+1;j<3;j++) {
				U[k][j] = (M[k][j] - summation(k, j, 2)) / L[k][k];
			}
		}
	}

	printMatrix(U, 'U');
	printMatrix(L, 'L');

	y_1 = B[0] / L[0][0];
	y_2 = (B[1] - L[1][0] * y_1) / L[1][1];
	y_3 = (B[2] - (L[2][0] * y_1) - (L[2][1] * y_2)) / L[2][2];

	printf("\ny_1, y_2, y_3: %0.2f, %0.2f, %0.2f\n", y_1, y_2, y_3);

	x_3 = y_3;
	x_2 = y_2 - U[1][2] * x_3;
	x_1 = y_1 - U[0][1] * x_2 - U[0][2] * x_3;

	printf("\nSolution:\n x_1: \%0.2f\n x_2: %0.2f\n x_3: %0.2f\n ", x_1, x_2, x_3);
	return 0;
}

void enterCoefficients(int unknowns){
	int i;
	int j;

	for(i=0; i<unknowns; i++) {
		for(j=0; j<unknowns; j++) {
			printf("%d. coefficient of row %d: \n", j+1, i+1);
			scanf("%f", &M[i][j]);
		}
	printf("\nYou entered: \n");
	printMatrix(M, 'M');
	}
}

void enterIndTerm(int unknowns){
	int i;

	for(i=0; i<unknowns; i++) {
			printf("Right-side term of row %d: \n", i+1);
			scanf("%f", &B[i]);
		}
	printf("You entered: \n");
	printMatrix(M, 'M');
}

float summation(int prim_counter, int sec_counter, int flag) {
	int s = 0;
	int k = prim_counter;

	float mult = 0;
	float sum = 0;

	if(flag == 0) {
		for(s=0;s<k;s++) {
				mult = L[k][s] * U[s][k];
				sum = sum + mult;
		}
	}else if(flag == 1) {
		for(s=0;s<k;s++) {
				mult = L[sec_counter][s] * U[s][k];
				sum = sum + mult;
		}
	} else if(flag == 2) {
		for(s=0;s<k;s++) {
				mult = L[k][s] * U[s][sec_counter];
				sum = sum + mult;
		}
	}
	return sum;
}

void printMatrix(float matrix[3][3], char name) {
	int m = 0;
	int n = 0;
	printf("Matrix %c\n", name);

	for(m=0; m<3; m++){
		for(n=0; n<3; n++){
			printf("%0.2f\t", matrix[m][n]);
		}
	printf("%0.2f\n", B[m]);
	}
}
