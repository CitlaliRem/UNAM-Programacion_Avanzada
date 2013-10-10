/*
 * 	pract7-1.c
 * 	Programa que calcule el polinomio de primer orden de Lagrange
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

float table[2][2];
float num_eval = 0;
float f1;

int main(int argc, char **argv) {

int i, j;
char * count;
count = (char *)malloc(8 * sizeof(char));

	for (i = 0; i < 2; ++i) {
		if (i == 0) {
			strcpy(count, "first");
		} else if( i == 1) {
			strcpy(count, "second");
		}
		printf("Enter %s x value : ", count);
		scanf("%f", &table[i][0]);
	}

	for (i = 0; i < 2; ++i) {
		if (i == 0) {
			strcpy(count, "first");
		} else if( i == 1) {
			strcpy(count, "second");
		}
		printf("Enter %s f(x) value: ", count);
		scanf("%f", &table[i][1]);
	}

	printf("\nYou entered: \n");
	printf("f\tf(x)\n");
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 2; ++j) {
				printf("%0.2f\t", table[i][j]);
			}
			printf("\n");
		}

	printf("\nEnter the x value to be interpolated:");
	scanf("%f", &num_eval);


	f1 = (((num_eval - table[1][0]) / (table[0][0] - table[1][0])) * table[0][1]) + ((num_eval - table[0][0]) / (table[1][0] - table[0][0])) * table[1][1];
	printf("Interpolated f(x) value: %f", f1);

	return 0;
}
