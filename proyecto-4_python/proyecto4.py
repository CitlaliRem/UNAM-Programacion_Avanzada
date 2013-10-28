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

 Nota:
 El archivo CPdescarga.csv tiene errores, al filtrar los estados salen
 resultados que no pertencen al grupo de estados
 Ejemplo: 98087,J. Jesús González Ortega 1,2,3,4 y 5ta. Sección,Colonia,Zacatecas,Zacatecas,Zacatecas,98001,.....
 En esta línea se ve que en el lugar 5 no aparece el estado, para corregir el
 filtrado se compara con el contenido del archivo estados.txt
'''
import time

textfile = open("CPdescarga.csv", "r", encoding="latin1")
estados = open("estados.txt", "r", encoding="UTF-8")

category = {1: "zipcode", 4: "township", 5:"state"}


class Indexer():
    def __init__(self, textfile):
        self.fileToList = []
        self.filterStatesErr = set() # este set contiene el filtrado de estados del archivo cvs
        self.filterStates = [] # este set contiene la lista de estados corregida
        self.stateList = set() # este set contiene la información correcta sobre los estados
        self.i = 2 
        self.stateIndex = {} 
        for line in textfile:
            listItems = line.split(",")
            self.fileToList.append(listItems)
        for line in estados:
            self.stateList.add(line.strip())

    def filterFunc(self, index):
        while self.i < len(Ind.fileToList):
            self.filterStatesErr.add(self.fileToList[self.i][index])
            self.i += 1

    def cleanList(self):
        for item in self.filterStatesErr:
            if item in self.stateList:
                self.filterStates.append(item)

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
print("Filtering states of México")
Ind.show(Ind.filterStatesErr)
time.sleep(4)

print("\n"*80)
print("Archive faulty. Cleaning up..\n\n")
time.sleep(4)

Ind.cleanList()
print("Displaying all {} states of México".format(len(Ind.filterStates)))
Ind.show(Ind.filterStates)

#Scs.filterFunc(4, "Tabasco")
