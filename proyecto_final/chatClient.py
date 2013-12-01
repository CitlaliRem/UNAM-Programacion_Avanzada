#!/usr/bin/python
# -*- coding: utf-8 -*-
""" A client to use it for a chat.
	chatClient.py is a class wich let us
	connect to a Server, after it we can 
	send and receive messages.

	author: César Alberto Trejo Juárez
"""
#
#	Imports
#
import threading
import socket

#
#	Global variables
#
HOST = 'localhost'
PORT = 8888
SERVER = ((HOST, PORT))

class chatClient(threading.Thread):
	"""A simple class wich works like a client for a chat"""
	def __init__(self):
		self.PORT = PORT
		self.HOST = HOST
		self.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		try:
			print 'Connecting to Server...'
			self.socket.connect(SERVER)
		except socket.error:
			print 'Server offline'
			self.socket.close()
		while (True):
			readThreading =	threading.Thread(target = self.read)
			#readThreading.daemon = True 	# To die automatically
			readThreading.start()

			writeThreading = threading.Thread(target = self.write)
			#writeThreading.daemon = True	# To die automatically
			writeThreading.start()

		readThreading.close()
		writeThreading.close()
		self.socket.close()

	def read(self):
		while (True):
			fromServer = self.socket.recv(200000)
			if fromServer:
				print fromServer

	def write(self):
		while (True):
			toServer = raw_input('Your message: ')
			self.socket.send(toServer + "\n")
			#if toServer == '/LOGOUT':
			#	self.socket.close()
			#	sys.exit(0)



if __name__ == "__main__":
	client = chatClient()
