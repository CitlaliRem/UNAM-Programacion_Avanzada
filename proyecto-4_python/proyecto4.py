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

file = open("CPdescarga.csv", "r", encoding="latin1")

#inicializamos una lista con cero contenido
fileToList = []

for line in file:
    listItems = line.split(",")
    #print(listItems)
    #agregamos en la lista general cada lista que nos devuelve .split(",")
    fileToList.append(listItems)

#Definimos una funcion que nos devuelva 1 o 0 si es o no el codigo postal
def search(items):
    if items[0] == "21379":
        return 1
    return 0

#Aplicamos un filtro usando nuestra funcion search en la lista general
list2 = list(filter(search, fileToList))

#mostramos las listas que aplican con el codigo postal 06600
#print(list2, sep='\n')

for item in list2:
    print(item)