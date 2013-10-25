'''
Created on Oct 20, 2013

 MatrixZeroOddEven.py 

 Programa que recibe una matriz de 4 x 4 y determina cuántos números
 son positivos, cuántos ceros, y cuántos negativos.

 Authors: 
     César Alberto Trejo Juárez (cesaratj27 at gmail.com)
     Magnus Henkel (magnus.henkel at zoho.com)

'''
#table= [ [ 0 for i in range(6) ] for j in range(6) ]
#print(table)
#for d1 in range(6):
#    for d2 in range(6):
#        table[d1][d2]= d1+d2+2
#print(table)

#m1 = [ [1, 2, 3, 0], [4, 5, 6, 0], [7, 8, 9, 0] ]
#m2 = [ [2, 4, 6, 0], [1, 3, 5, 0], [0, -1, -2, 0] ]
#m3= [ 4*[0] for i in range(3) ]

#for i in range(3):
#    for j in range(4):
#        m3[i][j]= m1[i][j]+m2[i][j]

#print("matix 1: ", m1)
#print("matrix 2: ", m2)
#print("matrix 3", m3)



#s = input()
#m1 = list(map(float, s.split()))

            #print("Enter first row of 4x4 matrix:")
matrix = [[float(input("Enter [{}][{}]: ".format(j+1, i+1))) for i in range(4)] for j in range(4)]
            #col[] = matrix.append(input(("Enter {}. value of row {}: ".format(i+1, row+1))))


print("You entered the following matrix:")
#for row in range(len(matrix)):
    #print(matrix[row], sep="")

for row in matrix:
    for item in row: 
        print(item, sep=''),
#for row in matrix:
    #print(matrix[row])
#for row in range(4):
#    for col in range(4):
#        print(matrix[row][col], end="   ")
