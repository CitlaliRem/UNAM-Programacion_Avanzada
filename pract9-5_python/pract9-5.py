'''
Created on Oct 20, 2013

 MatrixZeroOddEven.py 

 Programa que recibe una matriz de 4 x 4 y determina cuántos números
 son positivos, cuántos ceros, y cuántos negativos.

 Authors: 
     César Alberto Trejo Juárez (cesaratj27 at gmail.com)
     Magnus Henkel (magnus.henkel at zoho.com)

'''
import sys
inp_err = 3
matrix = []
rows =  []

#try:
matrix = [[float(input("Enter [{}][{}]: ".format(j+1, i+1))) for i in range(4)] for j in range(4)]

#    for i in range(4):
#        for j in range(4):
#            rows = float(input("Enter [{}][{}]: ".format(i, j)))
#            matrix.append(rows)
#except ValueError:
#    if inp_err == 0:
#        print("Too many tries. Exiting...")
#        sys.exit()
#    print("Please enter any positive, negative or zero number")
#    inp_err -= 1

# Matriz estática para pruebas:
#matrix = [[1,-6,4,3],
#     [0,-13,67,2],
#     [8,-23,0,-35],
#     [2,3,-0,5]]

for row in range(4):
    for val in matrix[row]:
        print(val, end="\t")
    print("\n")

positiveList = []
negativeList = []
zeroList = [] 

for row in range(4):
        for val in matrix[row]:
            if val > 0:
                print("Found positive: ", val )
                positiveList.append(val)
            elif val < 0:
                print("Found negative: ", val)
                negativeList.append(val) 
            elif val == 0:
                print("Found zero: ", val)
                zeroList.append(val)
            
print("_" * 30)
print("Found ", len(positiveList), "positive numbers")
print("Found ", len(negativeList), "negative nubmers")
print("Found ", len(zeroList), "zeros")
                

