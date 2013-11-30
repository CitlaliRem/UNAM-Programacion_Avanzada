#!/usr/bin/python
# -*- coding: utf-8 -*-

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
		while True:
			self.message = raw_input(':')
			self.ownSocket.send(self.message)
		self.ownSocket.close()

class read(threading.Thread):
	"""A class wich lets read messages from Server"""
	def __init__(self, socket):
		threading.Thread.__init__(self)
		self.message = ''
		self.ownSocket = socket

	def run(self):
		while True:
			self.message = self.ownSocket.recv(1024)
			print self.message
		self.ownSocket.close()

if __name__ == "__main__":
	mysocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	mysocket.connect((HOST, PORT))

	hilos = [write(mysocket), read(mysocket)]

	for h in hilos:
		h.start()
