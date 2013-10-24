'''
Created on Oct 20, 2013
 
  productComplex.py

  Authors: 
          César Alberto Trejo Juárez (cesaratj27 at gmail.com)
          Magnus Henkel (magnus.henkel at zoho.com)
  
  Programa que recibe dos numeros complejos, y obtiene la multiplicacion.
  
'''

# importamos la libreria que permite trabajar con numeros complejos.
import cmath

c1 = input('Write a complex number (a+bj): ')
c2 = input('Write another complex number (c+dj): ')
print 'The product is: ' + str(c1 * c2)
