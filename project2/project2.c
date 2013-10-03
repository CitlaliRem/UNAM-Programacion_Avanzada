 /*	Project #2
  *	Gauss-Jordan
  *
  *	Authors:
  *	 *	Magnus Henkel (magnus.henkel@zoho.com)
  *	 *	César Alberto Trejo Juárez (cesaratj27@gmail.com)
  *
  *	Universidad Nacional Autónoma de México
  *	Programación Avanzada y Métodos Numéricos
  *	Created on: Monday 30 September 2013
  */


#include <stdio.h>
#include <math.h>

void gaussJordan();
void gaussSeidel();
void printMatrix(float matrix[5][5], char name);
/*void enterCoefficients(int unknowns); */
/*void enterIndTerm(int unknowns); */

float M[5][5] = {{12,1,8,3,-10},{-9,7,-6,1,4},{-1,0,5,13,-17},{1,2,3,24,9},{3,4,5,7,19}};
float B[5] = {56.0,70.0,12.0,-30.0,45.0};


/*********************/
/*   function main   */
/*********************/
int main(int argc, char const *argv[]) {
	int answer;

/*	enterCoefficients(5); */
/*	enterIndTerm(5);      */

	printf("Resolve with Gauss-Jordan (1) or Gauss-Seidel (2)?\n");
	printf("Answer (1/2): \n");
	scanf("%d", &answer);

	if(answer == 1) { 			/* Primera opción: algoritmo de Gauss-Jordan */
		gaussJordan();
	} else if(answer == 2){ 	/* Segunda opción: algoritmo de Gauss-Seidel */
		gaussSeidel();
	}
	return 0;
}

/*****************************/
/* function printMatrix      */
/*****************************/
void printMatrix(float matrix[5][5], char name) {
    int m = 0;
    int n = 0;
    printf("Matrix %c\n", name);

    for(m=0; m<5; m++){
        for(n=0; n<5; n++){
            printf("%0.2f\t", matrix[m][n]);
        }
    printf("%0.5f\n", B[m]);
    }
}

/****************************/
/*   function gaussJordan   */
/****************************/
void gaussJordan() {

	int i = 0;
	int j = 0;
	int k = 0;
	float cte = 0.0;

	printf("Original ");
	printMatrix(M, 'M');
	printf("\n");

	for(i = 0; i < 5; i++){
		/* Normalizamos el renglón pivote */
		cte = M[i][i];

		for (j = 0; j < 5; j++) {
			M[i][j] = M[i][j] / cte;
		}

		B[i] = B[i] / cte;
		/*Fin normalizar */

		/* Eliminación gaussiana */
		for (j = i+1; j < 5; j++) {
			cte = M[j][i] / M[i][i];

			for (k = 0; k < 5; k++) {
				M[j][k] = M[j][k] - cte * M[i][k];
			}

			B[j] = B[j] - cte * B[i];
		}
	}

	/* Eliminacion inversa */
	for ( i = 4; i >= 0; i--)
	{
		for (j = i -1; j >= 0; j--)
		{
			cte = M[j][i];
			M[j][i] = M[j][i] - cte * M[i][i];
			B[j] = B[j] - cte * B[i];
		}
	}

	printf("Solution ");
	printMatrix(M, 'M');
}

/****************************/
/*   function gaussSeidel   */
/****************************/
void gaussSeidel() {

	    int i = 0;
		float x[5] = {0,0,0,0,0};
		float prev_x[5] = {0,0,0,0,0};
	    float threshold = 1;

	    do {
	        prev_x[0] = x[0];
	        prev_x[1] = x[1];
	        prev_x[2] = x[2];
	        prev_x[3] = x[3];
	        prev_x[4] = x[4];

	        x[0] = (B[0] - (M[0][1] * x[1]) - (M[0][2] * x[2]) - (M[0][3] * x[3]) - (M[0][4] * x[4])) / M[0][0];
	        x[1] = (B[1] - (M[1][0] * x[0]) - (M[1][2] * x[2]) - (M[1][3] * x[3]) - (M[1][4] * x[4])) / M[1][1];
	        x[2] = (B[2] - (M[2][0] * x[0]) - (M[2][1] * x[1]) - (M[2][3] * x[3]) - (M[2][4] * x[4])) / M[2][2];
	        x[3] = (B[3] - (M[3][0] * x[0]) - (M[3][1] * x[1]) - (M[3][2] * x[2]) - (M[3][4] * x[4])) / M[3][3];
	        x[4] = (B[4] - (M[4][0] * x[0]) - (M[4][1] * x[1]) - (M[4][2] * x[2]) - (M[4][3] * x[3])) / M[4][4];

	        threshold = fabsf(x[0] - prev_x[0]);
	        for(i=1; i<5; i++) {
	            threshold = threshold > (fabsf(x[i] - prev_x[i])) ? threshold : fabsf((x[i] - prev_x[i]));
	        }

	    } while(threshold > 0.000001);  /* preción */

	    printf("Solution:\n");
	    printf("x_1: %0.5f\t\n", x[0]);
	    printf("x_2: %0.5f\t\n", x[1]);
	    printf("x_3: %0.5f\t\n", x[2]);
	    printf("x_4: %0.5f\t\n", x[3]);
	    printf("x_5: %0.5f\t\n", x[4]);
}

/****** Estas funciones podrían usarse para ingesar la matriz manualmente.
 ****** Cómo el sistema tiene que converger para el método Gauss-Seidel, no toda matriz
 ****** puede ser resuelta. Por eso y por cuestiones de usuabilidad quitamos
 ****** estas funciones y la matriz para resolver se codificó estáticamente.
 ******/
/**********************************/
/*   function enterCoefficients   */
/**********************************/
/*
void enterCoefficients(int unknowns){
    int i;
    int j;

    for(i=0; i<unknowns; i++) {
        for(j=0; j<unknowns; j++) {
            printf("%d. coefficient of row %d: \n", j+1, i+1);
            scanf("%f", &M[i][j]);
        }
    printf("You entered: \n");
    printMatrix(M, 'M');
    }
}
*/
/**********************************/
/*   function enterIndTerm        */
/**********************************/
/*
void enterIndTerm(int unknowns){
    int i;

    for(i=0; i<unknowns; i++) {
            printf("Right-side term of row %d: \n", i+1);
            scanf("%f", &B[i]);
        }
    printf("You entered: \n");
    printMatrix(M, 'M');
}
*/
