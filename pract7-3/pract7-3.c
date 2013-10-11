/*
 * 	pract7-3.c
 *
 * 	Programa que implemente el algoritmo para el método de Newton de Diferencias
 * 	Divididas para N puntos.
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

#include <stdio.h>

int main(int argc, char const *argv[])
{
	float C[8][8],  X[8], M[8], x, f, pe, mul, pol, rf, ft;
	int n, i, j;

	printf("Enter grade of polynomial to evaluate: ");
	scanf("%d", &n);

	printf("\nEnter values for x_0, x_1, x_2...,x_n\n");
	for(i = 0; i <= n; i++)
	{
		printf("\nValue for x_%d: ",i);
	    scanf("%f", &x);
		X[i] = x;
	}

	printf("\nValues for f...\n");
	for(i = 0; i <= n; i++) {
		printf("\nEnter value for f_%d: ", i);
		scanf("%f", &f);
		C[i][0] = f;
	}

	printf("\nEnter value of point to evaluate: ");
	scanf("%f", &pe);

	for(i = 1; i <= n; i++) {
		for(j = 1; j <= i; j++) {
			C[i][j] = (C[i][j-1] - C[i-1][j-1]) / (X[i] - X[i-j]);
		}
	}

	mul = 1;
	for(i = 1; i <= n; i++) {
		for(j = 0; j <= (i-1); j++) {
			mul = (pe - X[j]) * mul;
			M[i] = mul;
		}
	}

	pol = 0;
	rf = 0;
	for(i = 1; i <= n; i++) {
		pol = C[i][i] * M[i];
		rf = rf + pol;
	}

	ft = C[0][0] + rf;

	printf("\nApproximation of point %.4f: %.4f\n\n", pe, ft);

	return 0;
}
