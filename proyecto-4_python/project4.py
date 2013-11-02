'''
Created on Oct 30, 2013

@author: arytloc
'''
import operator
'''
   Projecto 4:
   Programa que efectúa una busqueda sobre un archivo de texto (.cvs) y muestra o ordena la lista por los siguientes criterios:
       * muestra la lista de estados (sin repetición)
       * muestra número de delegaciones, municipios, rancherías por estados
       * ordena los estados por la cantidad de códigos postales
       
       Dato para corroborar (computados con Excel): 
       Cantidad de códigos postales
       DF 1444
       Aguascalientes 420

    Authors: 
    César Alberto Trejo Juárez (cesaratj27 at gmail.com)
    Magnus Henkel (magnus.henkel at zoho.com)
 
Created on Oct 27, 2013

'''

textfile = open("CPdescarga.txt", "r", encoding="latin1")

class Indexer():
    def __init__(self, textfile):
        self.fileToList = []
        self.filterStates = set() 
        #self.listLength = 0

        for line in textfile:
            listItems = line.split("|")
            self.fileToList.append(listItems)

    def filterFunc(self, index): # filtra una columna especificada por index
        i = 2
        while i < len(Ind.fileToList):
            self.filterStates.add(self.fileToList[i][index])
            i += 1

    def show(self, filteredList):
        for item in sorted(filteredList):
            print(item)
    
    def countLines(self, textFile):
        return len(textFile)

class SubCatSearch(Indexer):
    def __init__(self):
        Indexer.__init__(self, textfile)
        self.stateDict = {}
        self.stateList = list(Ind.filterStates)
        self.setItemCount = 0
        self.townshipSet = set()
        #self.townshipDict = {}
        self.zipcodeSet = set()
        self.zipcodeList = [] 
        self.zipcodeDict = {}
    
    def createDict(self, dictName, keyParam, dictItem):
        dictEntry = dictName[keyParam] = dictItem
        return dictEntry

    def indexStates(self, column, linecount):
        i = 0 # i representa las indices de las sublistas a recorrer (o visto de otra forma las lineas del archivo)
        k = 0 # k representa cada estado en la lista de estados 
        while i <= linecount and not k > 31:
            for subList in Ind.fileToList:
                if subList[column] == self.stateList[k]:
                    self.createDict(self.stateDict, i, self.stateList[k])
                    k += 1
                    i = 0
                    break
                i += 1
    
    def printStateIndex(self):
        print(self.stateDict)

    def  countSetItems(self, setName):
        numSetItems = len(setName)
        return numSetItems
    
    def listSubCat(self, columnToCompare, columnToAdd, setName, rootFile, linecount, ordered):
        #setItemCount = 0
        for index, state in self.stateDict.items():
            while state == rootFile[index][columnToCompare] and index < (linecount - 1): 
                setName.add(rootFile[index][columnToAdd])
                self.setItemCount = self.countSetItems(setName)
                index += 1
            self.printListSubCat(self.setItemCount, state, ordered)
            #print(self.setItemCount,"\t\t\t", state) 
            setName = set()
            self.setItemCount = 0

    def printListSubCat(self, itemCount, state, ordered=0):
        if ordered == 1:
            self.createDict(self.zipcodeDict, itemCount, state)
            if len(self.zipcodeDict) == len(self.stateList):
                sortedDict = sorted(self.zipcodeDict.items(), key=operator.itemgetter(0))
                #sortedDict = sorted(self.zipcodeDict.items(), key=lambda (k,v): v[1])
                for key, value in sortedDict:
                    print(key,"\t\t\t", value)
        else:
            print(itemCount, "\t\t\t", state)

    
    
Ind = Indexer(textfile)
Ind.filterFunc(4)
print("Displaying all {} states of México".format(len(Ind.filterStates)))
print("_"*40)
Ind.show(Ind.filterStates)
ssearch = SubCatSearch()
ssearch.indexStates(4, Ind.countLines(Ind.fileToList)) # entrega como argumentos el indice de la columa y el número de lineas de la lista (archivo)
print("\n")
print("Displaying townships (municipios/delegaciones/rancherías):")
print("_"*40)
print("# townships\t\tstate")
ssearch.listSubCat(4, 3, ssearch.townshipSet, Ind.fileToList, Ind.countLines(Ind.fileToList), 0) # compara con columna 4 (estados) y agrega contenido de columna 3 (municipios,delegaciones, rancherías)
print("\n")
print("Displaying zipcodes, ascending order")
print("_"*40)
print("# zipcode\t\tstate")
ssearch.listSubCat(4, 0, ssearch.zipcodeSet, Ind.fileToList, Ind.countLines(Ind.fileToList), 1) # compara con columna 4 (estados) y agrega contenido de columna 3 (municipios,delegaciones, rancherías)
    