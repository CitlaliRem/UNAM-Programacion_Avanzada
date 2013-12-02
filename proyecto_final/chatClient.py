#!/usr/bin/python
# -*- coding: utf-8 -*-
""" A client to use it for a chat.
	chatClient.py is a class wich let us
	connect to a Server, after it we can 
	send and receive messages.

	authors: 
		César Alberto Trejo Juárez  cesaralberto@yandex.com or cesaratj27@gmail.com
		Oscar Díaz
		Brenda
		Magnus Henkel
"""
#
#	Imports
#
import sys
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
			print 'Server offline',
			print 'Try later'
			self.socket.close()
			sys.exit(0)

		try:	
			readThreading =	threading.Thread(target = self.read)
			writeThreading = threading.Thread(target = self.write)
			
			readThreading.start()
			writeThreading.start()
		
		except KeyboardInterrupt:
			#print "Shutdown requested...(KeyboardInterrupt at 1o)"
			self.socket.close()
			sys.exit(0)
		except EOFError:
			#print "Shutdown requested...(EOFError at 1o)"
			self.socket.close()
			sys.exit(0)
		except:
			#print 'Shutdown requested...(Except at 1o)'
			self.socket.close()
			sys.exit(0)

	def read(self):
		try:
			while (True):
				fromServer = self.socket.recv(200000)
				if ('Server: Goodbye' in fromServer):
					print fromServer
					break
				print fromServer
		except KeyboardInterrupt:
			#print "Shutdown requested...(KeyboardInterrupt at 2o)"
			self.socket.close()
			sys.exit(0)
		except EOFError:
			#print "Shutdown requested...(EOFError at 2o)"
			self.socket.close()
			sys.exit(0)
		except:
			#print "Shutdown requested...(Except at read)"
			self.socket.close()
			sys.exit(0)
		finally:
			self.socket.close()
			sys.exit(0)

	def write(self):
		try:
			while (True):
				toServer = raw_input()
				self.socket.send(toServer + "\n")
		except KeyboardInterrupt:
			#print "Shutdown requested...(KeyboardInterrupt at 2o)"
			self.socket.send("I am logging out \n")
			self.socket.close()
			sys.exit(0)
		except EOFError:
			#print "Shutdown requested...(EOFError at 2o)"
			self.socket.send("\n")
			self.socket.close()
			sys.exit(0)
		except:
			#print 'Shutdown requested...(Except at 2o)'
			self.socket.send("\n")	
			self.socket.close()
			sys.exit(0)
		finally:
			#self.socket.send("\n")
			self.socket.close()
			sys.exit(0)
			

if __name__ == "__main__":
	try:
		client = chatClient()
	except socket.error:
		#print 'No Server Found at __main__'
		sys.exit(0)
	except EOFError:
		#print 'Ready to exit... at __main__'
		sys.exit(0)
	except:
		#print 'Shutdown at __main__'
		sys.exit(0)
	finally:
		sys.exit(0)
