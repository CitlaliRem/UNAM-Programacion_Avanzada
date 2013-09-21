/*
 * pract1-13.c
 *
 *  Created on: Aug 25, 2013
 *      Author: Henkel Magnus & Trejo Juárez César Alberto
 *
 *      Hacer el algoritmo y programa que almacene en un arreglo de estructuras,
 *      dos números complejos, y que obtenga la multiplicación.
 */

#include <stdio.h>
#include <complex.h>

int main(void) {

	double pr1, pc1, pr2, pc2;

	struct complexNumbers {
		double complex cx;
		double complex cy;
	};

	printf("\nParte real, primer número: ");
	scanf("%lf",&pr1);

	printf("Parte compleja, primer número: ");
	scanf("%lf",&pc1);

	printf("Parte real, segundo número: ");
	scanf("%lf",&pr2);

	printf("Parte compleja, segundo número: ");
	scanf("%lf",&pc2);

	struct complexNumbers cmplx;
	cmplx.cx = pr1 + pc1*I;
	cmplx.cy = pr2 + pc2*I;

	double complex product = cmplx.cx * cmplx.cy;
	printf("\nEl producto de los números complejos es: %.2f%+.2fi", creal(product), cimag(product));

	return 0;
}
