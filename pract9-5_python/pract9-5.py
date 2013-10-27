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

buffer = 1 

class InitMatrix(object):
    def __init__(self):
        self.matrix = matrix = []
        self.rows = rows = []
        self.dimension = dimension = 0
    def printMatrix(self):
        for row in self.matrix:
            for item in row:
                print(item, end="\t")
            print("\n")
    def printRow(self):
        for item in self.rows:
            print(item, end="\t")
        print("\n")

class FillMatrix(InitMatrix):
    def __init__(self):
        InitMatrix.__init__(self)
        self.rowbuffer = rowbuffer = []
        self.rowcount = 1
        self.valcount = 1 
        self.i = 0
    def resetCount(self):
       self.i = 0
       self.rowcount += 1
       self.valcount = 1

class ErrorHandling():
    def __init__(self):
        self.err_num = err_num = 3
    def errorcheck(self, dimension):
        if self.err_num == 0:
            print("Stop tampering with me! Exiting...")
            sys.exit()
        if len(M.matrix) >= M.dimension:
            print('Please enter any numberic value or "q" to quit entering the first row')
        else:
            print("Please enter numeric values only:")
        self.err_num -= 1

class EvalMatrix():
    def __init__(self):
        self.positiveList = positiveList = []
        self.negativeList = negativeList = []
        self.zeroList = zeroList = [] 
    def evaluate(self):
        for row in range(len(M.rows)):
            for val in M.matrix[row]:
                if val > 0:
                    print("Found positive: \t", val )
                    Eval.positiveList.append(val)
                elif val < 0:
                    print("Found negative: \t", val)
                    Eval.negativeList.append(val) 
                elif val == 0:
                    print("Found zero: \t", val)
                    Eval.zeroList.append(val)
    def resume(self):
        print("_" * 30)
        print("Found ", len(self.positiveList), "positive number(s)")
        print("Found ", len(self.negativeList), "negative nubmer(s)")
        print("Found ", len(self.zeroList), "zero(s)")

        
M = InitMatrix()
Err = ErrorHandling()
F = FillMatrix()
        
print('\nEnter numeric values of an arbitrarily-sized matrix, followed by "Enter": '.format(len(M.matrix) + 1))
print('Press "q" when finished entering the first row')

while buffer is not 'q':
    try:
#3matrix = [[float(input("Enter [{}][{}]: ".format(j+1, i+1))) for i in range(4)] for j in range(4)]
        while buffer: 
            buffer = input()
            if buffer == 'q':
                print("Finished entering first row of matrix")
                M.dimension = len(M.rows)
                print("Matrix dimension determined: ", M.dimension, "x", M.dimension) 
                break
            M.rows.append(float(buffer))
            M.printRow()
    except ValueError:
        Err.errorcheck(M.dimension)

M.matrix.append(M.rows)

while F.rowcount < M.dimension:
    while F.i < M.dimension:
        try:
            buffer = input('\nEnter {}. value of {} row'.format(F.valcount, F.rowcount))
            F.rowbuffer.append(float(buffer))
            #print("DEBUGGING: M.matrix", M.matrix,"M.rowbuffer: ", F.rowbuffer, "i: ", F.i," F.valcount", F.valcount, "F.rowcount", F.rowcount, "Dimension: ", dimension)
            F.i += 1
            F.valcount += 1
        except:
            Err.errorcheck(M.dimension)
    F.resetCount()
    #print("DEBUGGING: F.rowcount", F.rowcount, "F.valcount", F.valcount)
    M.matrix.append(F.rowbuffer)
    M.printMatrix()
    F.rowbuffer = []

Eval = EvalMatrix()
Eval.evaluate()
Eval.resume()
