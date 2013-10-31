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

category = {1: "zipcode", 4: "township", 5:"state"}


class Indexer():
    def __init__(self, textfile):
        self.fileToList = []
        self.filterStates = set() 
        self.i = 2 
        self.stateIndex = {}  # todavía no está en uso
        for line in textfile:
            listItems = line.split("|")
            self.fileToList.append(listItems)

    def filterFunc(self, index):
        while self.i < len(Ind.fileToList):
            self.filterStates.add(self.fileToList[self.i][index])
            self.i += 1

#    def createStateIndex(self):
#        self.i = 2
#        while self.i < len(Ind.fileToList):
#            for state in self.filterStates:
#                if state == Ind.fileToList[self.i][4]:
#                    self.stateIndex[self.i] = state
#                    break
#        self.i += 1
#        print(self.stateIndex)
                
                
    def search(self, index, criteria):
        if self.fileToList[index] == criteria:
            return criteria

    def show(self, filteredList):
        for item in sorted(filteredList):
            print(item)
'''
class SubCatSearch(Indexer):
    def __init__(self):
        Indexer(textfile).__init__(self)
        self.stateDict = {}
    def filterFunc(self, index, state):
        self.i = 2
        while self.i < len(self.fileToList):
            if state == self.filterStates[index][4]:
                self.stateDict = dict((state,self.filterStates[index][4]) for state in Ind.filterStates)
                break
            self.i += 1
        print(self.stateDict)
'''                   

Ind = Indexer(textfile)
Ind.filterFunc(4)
print("Displaying all {} states of México".format(len(Ind.filterStates)))
Ind.show(Ind.filterStates)

#Scs.filterFunc(4, "Tabasco")

stateList = list(sorted(Ind.filterStates))
print("Debugging: Ind.fileToList[0][4]:::: ", Ind.fileToList[0][4], "stateList[0]", stateList[0])

print(len(Ind.fileToList))

def indexStates():
    i = 0
    while i < len(Ind.fileToList):
        for subList in Ind.fileToList:
            if subList[4] == stateList[i]:
                print("State", subList[4], "found on line: ", i)
            i += 1

indexStates()
    