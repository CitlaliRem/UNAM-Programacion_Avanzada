'''
Created on Oct 20, 2013
 
  pract9-1.py

  Authors: 
          
          Magnus Henkel (magnus.henkel at zoho.com)
          Cesar Alberto Trejo Juarez (cesaratj27 at gmail.com)
  
  Programa que recibe dos numeros complejos, y obtiene la multiplicacion.
  
'''

class complex:
	"""Para el producto de dos numeros complejos"""
	def __init__(self, r, i):
		self.real = r
		self.img = i

	def mostrar(self):
		print(self.real, '+', self.img,'i')

	def producto(self,z):
		return complex( self.real * z.real - self.img * z.img, self.real * z.img + self.img * z.real)


c1 = complex(2,-4)
c2 = complex(-1,0)
c3 = c1.producto(c2)
c3.mostrar()
