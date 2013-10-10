'''
Created on Oct 4, 2013

@authors: Magnus Henkel (magnus.henkel at zoho.com)
          César Alberto Trejo Juárez (cesaratj27 at gmail.com)
'''

import sys

M1 = [[212,13,3],
     [3,7,16],
     [0,23,1]]

M2 = [[1,3,6,4,3],
     [7,13,24,67,2],
     [8,23,16,1,35],
     [2,3,0,11,5],
     [9,23,1,31,25]]

dimension = 0
inp_err = 2

print("Choose matrix 3x3 or 5x5 (3/5) ")
while inp_err > -1:
    try:
        selection = int(input())
        if selection == 3 or selection == 5:
            break
        raise ValueError()
    except ValueError:
        if inp_err == 0:
            print("Too many tries. Exiting...")
            sys.exit()
        print("Please enter one of the following integers (3/5))")
        inp_err -= 1

if selection == 3:
    print("You chose a matrix of {0}x{0}\n".format(selection))
    dimension = len(M1)
    print(dimension)
    M = M1
elif selection == 5:
    print("You choose a matrix of {0}x{0}\n".format(selection))
    dimension = len(M2)
    M = M2

def CheckDiagonal():
    """ Function which checks the diagonal of the matrix"""
    print("Diagonal")
    row = 0
    col = 0
    print("Row  Column  Number")
    while row < dimension:
        if M[row][col] % 2 == 0:
            print("[",row,"][",col,"]:  even")
        else:
            print("[",row,"][",col,"]:  odd")
    
        col += 1
        row += 1

def CheckMatrix():
    """ Function which checks every entry of the matrix"""
    print("\nWhole Matrix")
    row = 0
    col = 0
    print("Row  Column  Number")
    for row in range(dimension):
        for col in range(dimension):
            if M[row][col] % 2 == 0:
                print("[",row,"][",col,"]:  even")
            else:
                print("[",row,"][",col,"]:  odd")
    

CheckDiagonal()
CheckMatrix()

