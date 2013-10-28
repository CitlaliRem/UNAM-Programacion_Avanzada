'''
Created on Oct 20, 2013
 
 pract9-3.py 

 Programa que recibe una matriz de 3 x 3, determina el valor maximo, asi
 como su posicion. Si existen valores iguales, obtiene todas las posiciones.

 Authors: 
     Cesar Alberto Trejo Juarez (cesaratj27 at gmail.com)
     Magnus Henkel (magnus.henkel at zoho.com)
  
'''

class matrix:
    '''Una simple clase para encontrar el numero maximo dentro de
    una matriz y mostrar la(s) posicion(es) donde se encuentra'''
    def __init__(self):
        self.matrix = [ [212,13,3], [3,212,16], [0,-23,312] ]
        self.maxim = 0
        self.pos = []
        print('Creating matrix')

    def findMax(self):
        for i in range(len(self.matrix)):
            for j in range(len(self.matrix)):
                if self.matrix[i][j] > self.maxim:
                    self.maxim = self.matrix[i][j]

    def posMax(self):
        for k in range(len(self.matrix)):
            for l in range(len(self.matrix)):
                if self.matrix[k][l] == self.maxim:
                    self.pos.append([k,l])


m1 = matrix()
for j in range(len(m1.matrix)):
    print(m1.matrix[j])
m1.findMax()
print('Maximum of matrix: ' + str(m1.maxim))
m1.posMax()
print('Position(s) of maximum value: ')
for i in range(len(m1.pos)):
    print(m1.pos[i])
