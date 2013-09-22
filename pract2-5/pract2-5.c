/*
 * pract2-5.c
 *
 *  Created on: Sep 6, 2013
 *      Author: César Alberto Trejo Juárez, Magnus Henkel
 *
 *      Utilizando la aritmética de apuntadores, implemente una función que
 *      transponga una matriz cuadrada utilizando únicamente un apuntador.
 */


#include<stdio.h>
#include<stdlib.h>
#include<time.h>

main() {

	int i,j, k;
	int matrix[4][4];
	int temp;
	int *ptr;
	int cycle = 0;

	ptr = matrix;

	for (i=0; i<16; i++) {
			*(ptr + i) = rand() % 100;
	}

	for (i=0; i<4; i++) {
		for(j=0+cycle; j<4+cycle; j++) {
			printf("%i ", *(ptr + j));
		}
		printf("\n");
		cycle += 4;
	}

	for(k=0; k<7;k++) {
		temp = *(ptr + 1);
		*(ptr + 1) = *(ptr + 4);
		*(ptr + 4) = temp;

		temp = *(ptr + 2);
		*(ptr + 2) = *(ptr + 8);
		*(ptr + 8) = temp;

		temp = *(ptr + 3);
		*(ptr + 3) = *(ptr + 12);
		*(ptr + 12) = temp;

		temp = *(ptr + 6);
		*(ptr + 6) = *(ptr + 9);
		*(ptr + 9) = temp;

		temp = *(ptr + 7);
		*(ptr + 7) = *(ptr + 10);
		*(ptr + 10) = temp;

		temp = *(ptr + 11);
		*(ptr + 11) = *(ptr + 14);
		*(ptr + 14) = temp;
	}

	printf("\nTranspose of the matrix:\n\n");

	cycle = 0;

	for (i=0; i<4; i++) {
		for(j=0+cycle; j<4+cycle; j++) {
			printf("%i ", *(ptr + j));
		}
		printf("\n");
		cycle += 4;
	}
}


