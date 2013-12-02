#!/usr/bin/python
# -*- coding: utf-8 -*-

"""	Created on: Friday 29 november 2013
	Equipo:	César Alberto Trejo Juárez     cesaralberto@yandex.com
		Magnus Henkel
		Oscar Díaz
		Brenda
"""

import threading
import socket

HOST = 'localhost'
PORT = 8888
class write(threading.Thread):
	"""A class wich lets write messages to Server"""
	def __init__(self, socket):
		threading.Thread.__init__(self)
		self.message = ''
		self.ownSocket = socket

	def run(self):
		try:
			while True:
				self.message = raw_input()
				self.ownSocket.send(self.message + "\n")
		except KeyboardInterrupt:
			#print 'KeyboardInterrupt: Exit request at write class'
			self.ownSocket.send("/None \n")
			self.ownSocket.close()
		except EOFError:
			#print 'EOFError: Exite request at write class'
			self.ownSocket.send("/None \n")
			self.ownSocket.close()
		finally:
			self.ownSocket.close()

class read(threading.Thread):
	"""A class wich lets read messages from Server"""
	def __init__(self, socket):
		threading.Thread.__init__(self)
		self.message = ''
		self.ownSocket = socket

	def run(self):
		try:
			while True:
				self.message = self.ownSocket.recv(1024)
				print self.message
		except EOFError:
			#print 'EOFError: Exit request at class read'
			self.ownSocket.close()
		except:
			#print 'Except: Exit request at class read'
			self.ownSocket.close()
		finally:
			self.ownSocket.close()


if __name__ == "__main__":
	mysocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	mysocket.connect((HOST, PORT))

	hilos = [write(mysocket), read(mysocket)]
	try:
		for h in hilos:
			h.start()
	except EOFError:
		mysocket.send("/LOGOUT \n")
		mysocket.close()
		sys.exit(0)
