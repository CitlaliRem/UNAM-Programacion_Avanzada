/*
 * pract1-6.c
 *
 *  Created on: Aug 25, 2013
 *      Author: Henkel Magnus & Trejo Juárez César Alberto
 *
 *      Hacer el algoritmo y programa que llene automáticamente una matriz de
 *      20 x 20 con valores de cero, excepto en la diagonal principal, que
 *      deberán ser unos. Imprimir en pantalla.
 */

#include <stdio.h>

int main() {
	int i, j;
	int matriz[20][20];

	for(i=0; i<20; i++) {
		for(j=0; j<20; j++) {
			matriz[i][j] = 0;
			matriz[i][i] = 1;

		}
	}

	for(i=0; i<20; i++) {
		for(j=0; j<19; j++) {
			printf("%d ", matriz[i][j]);
		}
		printf("%d\n", matriz[i][j]);
	}
	return 0;
}
