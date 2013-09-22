//
//  prac1-15.c
//  pract1-15
//
//  Created by César Alberto Trejo Juárez & Magnus Henkel on 28/08/13.
//  Copyright (c) 2013 __Programación Avanzada y Métodos Numéricos__. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int n,i,j, a, num;
float sum, prom;

struct Alumno {
    char name[256];
    float calif;
};

int main (int argc, const char * argv[])
{
    printf("Bienvenidos al programa para evaluación.");
    printf("\n¿Cuántos alumnos ingresará?: \t");
    scanf("%d", &n);
    
    
    while (((n = scanf("%d%c", &num, &a)) != 2 && n != EOF) || a != '\n') {
        printf("Por favor ingrese un número: ");
        do {
            n = scanf("%c", &a);
        } while(n != EOF && a != '\n');
    }
    
    // Lectura de datos
    struct Alumno inge[n];
    struct Alumno temp[1];
    
    for (i=0; i<n; i++) {
        printf("\nAlumno %d: ",i+1);
        scanf("%s", inge[i].name);
        printf("Calificación: ");
        scanf("%f", &inge[i].calif);
        sum = sum + inge[i].calif;
    }
    
    
    //Calificación más alta
    for (i=0; i<n; i++) {
        for (j=i+1; j<n; j++) {
            temp[0] = inge[i];
            if (inge[i].calif>inge[j].calif) {
                temp [0] = inge[i];
                inge[i] = inge[j];
                inge [j] = temp[0];
            }
        }
    }
    
    //Impresión de alumnos con calificación más alta:
    i=n-1;
    do {
        printf("\nAlumno: %s", inge[i].name);
        printf("\nCalificación: %.2f", inge[i].calif);
        if (inge[i].calif!=inge[i-1].calif) {
            i=0;
        }
        i--;
    } while (i>=0);
    
    prom = sum / (float)n;
    printf("\nPromedio de alumnos: %.2f\n", prom);
    
    
}