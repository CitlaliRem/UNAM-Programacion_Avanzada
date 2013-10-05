/*
 * pract6-3.c
 *
 *  Created on: Sep 28, 2013
 *      Authors: Magnus Henkel, César Alberto Trejo Juárez
 *
 *      Elaborar un programa que implemente el método de Gauss-Seidel, para
 *      resolver sistemas de 3 incógnitas. TIP: Sólo es implementar en
 *      funciones, las ecuaciones resultantes del despeje de las ecuaciones del
 *      sistema.
 *
 */

#include<stdio.h>
#include<math.h>

void enterCoefficients(int unknowns);
void enterIndTerm(int unknowns);
void printMatrix(float matrix[3][3], char name);

float M[3][3];
float B[3];

float x[3] = {0,0,0};
float prev_x[3] = {0,0,0};

int main () {

	int i = 0;
	float threshold = 1;

	enterCoefficients(3);
	enterIndTerm(3);

	do {
		prev_x[0] = x[0];
		prev_x[1] = x[1];
		prev_x[2] = x[2];

		x[0] = (B[0] - (M[0][1] * x[1]) - (M[0][2] * x[2])) / M[0][0];
		printf("x[0]: %0.2f\t", x[0]);
		x[1] = (B[1] - (M[1][0] * x[0]) - (M[1][2] * x[2])) / M[1][1];
		printf("x[1]: %0.2f\t", x[1]);
		x[2] = (B[2] - (M[2][0] * x[0]) - (M[2][1] * x[1])) / M[2][2];
		printf("x[2]: %0.2f\n", x[2]);

		threshold = fabsf(x[0] - prev_x[0]);
		for(i=1; i<3; i++) {
			threshold = threshold > (fabsf(x[i] - prev_x[i])) ? threshold : fabsf((x[i] - prev_x[i]));
		}

	printf("x_1, x_2, x_3: %0.5f, %0.5f, %0.5f\n", x[0], x[1], x[2]);
	} while(threshold > 0.000001);

	printf("x_1, x_2, x_3: %0.5f, %0.5f, %0.5f\n", x[0], x[1], x[2]);
	return 0;
}

void enterCoefficients(int unknowns){
	int i;
	int j;

	for(i=0; i<unknowns; i++) {
		for(j=0; j<unknowns; j++) {
			printf("*************************************************************\n");
			printf("Notice that the mayor coefficient has to be in the diagonal,\n");
			printf("otherwise the system cannot be resolved by this method.\n");
			printf("*************************************************************\n");
			printf("%d. coefficient of row %d: \n", j+1, i+1);
			scanf("%f", &M[i][j]);
		}
	printf("You entered: \n");
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
