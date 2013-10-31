'''
Created on Oct 30, 2013

@author: arytloc
'''
'''
   Projecto 4:
   Programa que efectúa una busqueda sobre un archivo de texto (.cvs) y muestra o ordena la lista por los siguientes criterios:
       * muestra la lista de estados (sin repetición)
       * muestra número de delegaciones, municipios, rancherías por estados
       * ordena los estados por la cantidad de códigos postales

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
        self.i = 2 
        for line in textfile:
            listItems = line.split("|")
            self.fileToList.append(listItems)

    def filterFunc(self, index):
        while self.i < len(Ind.fileToList):
            self.filterStates.add(self.fileToList[self.i][index])
            self.i += 1

    def show(self, filteredList):
        for item in sorted(filteredList):
            print(item)

class SubCatSearch(Indexer):
    def __init__(self):
        Indexer.__init__(self, textfile)
        self.stateDict = {}
        self.stateList = list(Ind.filterStates)
        self.townshipSet = set()
        self.townshipDict = {}

    def indexStates(self):
        i = 1
        k = 0
        while i < len(Ind.fileToList) and not k > 31:
            for subList in Ind.fileToList:
                if subList[4] == self.stateList[k]:
#                    print("State", subList[4], "found on line: ", i)
                    self.stateDict[i] = self.stateList[k]
                    k += 1
                    i = 1
                    break
                i += 1
    
    def printStateIndex(self):
        print(self.stateDict)
    
    def listSubCat(self):
        townshipNum = 0
        for index, state in self.stateDict.items():
            i = index
            while state == Ind.fileToList[i][4] and i < len(Ind.fileToList) - 1: 
                self.townshipSet.add(Ind.fileToList[i][3])
                townshipNum = len(self.townshipSet)
                i += 1
            print(townshipNum,"\t\t\t", state) 
            self.townshipSet = set()
            townshipNum = 0

                
    
Ind = Indexer(textfile)
Ind.filterFunc(4)
print("Displaying all {} states of México".format(len(Ind.filterStates)))
print("\n")
Ind.show(Ind.filterStates)
ssearch = SubCatSearch()
ssearch.indexStates()
print("\n")
print("# townships\t\tstate")
ssearch.listSubCat()
    