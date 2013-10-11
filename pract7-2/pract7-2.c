/*
 * 	pract7-2.c
 * 	Programa que calcule el polinomio de interpolación de Lagrange de primer y
 * 	segundo orden, para aproximar en x=2.
 *
 * 	Authors:
 *	Magnus Henkel (magnus.henkel at zoho.com)
 *	César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *
 *	Universidad Nacional Autónoma de México
 *	Programación Avanzada y Métodos Numéricos
 *
 *  Created on: Oct 10, 2013
 *
 */


#include<stdio.h>
#include<stdlib.h>
#include<string.h>

float partDiv(size_t rows, size_t columns, float matrix[rows][columns], int orden, float num_eval);

float table[4][2] = {{0,2},{1,3},{4,18},{6,38}};
float num_eval = 0.2;
float f1, f2;

int main(int argc, char **argv) {

	int i, j;

	printf("\nYour table is: \n");
	printf("f\tf(x)\n");
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 2; ++j) {
				printf("%0.2f\t", table[i][j]);
			}
			printf("\n");
		}

	//partDiv(4, 2, table, 1, num_eval);
	printf("\npolynomial first order: f_1(x) = %0.2fx\n", partDiv(4,2,table,1,num_eval));
	printf("polynomial second order: f_2(x) = %0.2fx^2 + %0.2fx\n", partDiv(4,2,table,1,num_eval), partDiv(4,2,table,2,num_eval));
	//partDiv(4, 2, table, 2, num_eval);

	return 0;
}

float partDiv(size_t rows, size_t columns, float matrix[rows][columns], int orden, float num_eval) {

	float x = num_eval;
	int i;
	int sub1, sub2;
	float pol1 = 0;
	float pol2 = 0;
	float polynomial = 0;

	if(orden == 1) {
		for (i = 0; i < orden + 1; ++i) {

				switch (i) {
					case 0:
						sub1 = 1;
						break;
					case 1:
						sub1 = 0;
						break;
					default:
						break;
				}

				pol1 = pol1 + ((x - matrix[sub1][0]) / (matrix[i][0] - matrix[sub1][0])) * matrix[i][1];

		}
		polynomial = pol1;

	} else if(orden == 2) {

		for (i = 0; i < orden + 1; ++i) {

			switch (i) {
				case 0:
					sub1 = 1;
					sub2 = 2;
					break;
				case 1:
					sub1 = 0;
					sub2 = 2;
					break;
				case 2:
					sub1 = 0;
					sub2 = 1;
					break;
				default:
					break;
			}

			pol2 = pol2 + (((x - matrix[sub1][0]) * (x - matrix[sub2][0])) / ((matrix[i][0] - matrix[sub1][0]) * (matrix[i][0] - matrix[sub2][0]))) * matrix[i][1];
			polynomial = pol2;

		}

	} // end if
	return polynomial;
}
