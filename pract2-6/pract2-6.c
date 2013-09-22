/*
 * pract2-6.c
 *
 *  Created on: Sep 5, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel
 *
 *      Utilizando 2 apuntadores, intercambiar los valores de 2 arreglos de una
 *      dimensión con el mismo número de elementos.
 */

#include<stdio.h>

void main() {

	int i;
	int arr1[7] = { 1, 3, 5, 7, 9, 11, 13 };
	int arr2[7] = { 101, 103, 105, 107, 109, 111, 113 };

	int *p2arr1;
	int *p2arr2;

	p2arr1 = arr1;
	p2arr2 = arr2;


	int swapVar = 0;

	printf("Array 1: ");
	for(i=0; i<sizeof(arr1)/sizeof(arr1[0]); i++) {
		printf("%i ", *(arr1 + i));
	}

	printf("\nArray 2: ");
	for(i=0; i<sizeof(arr1)/sizeof(arr1[0]); i++) {
		printf("%i ", *(arr2 + i));
	}

	for(i=0; i<sizeof(arr1)/sizeof(arr1[0]); i++) {
		swapVar = *(arr1 + i);
		*(arr1 + i) = *(arr2 + i);
		*(arr2 + i) = swapVar;
	}

	printf("\nSwapping values:\n");
	printf("Array 1: ");
	for(i=0; i<sizeof(arr1)/sizeof(arr1[0]); i++) {
		printf("%i ", *(arr1 + i));
	}

	printf("\nArray 2: ");
	for(i=0; i<sizeof(arr1)/sizeof(arr1[0]); i++) {
		printf("%i ", *(arr2 + i));
	}
}
