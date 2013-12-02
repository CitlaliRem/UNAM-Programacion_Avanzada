#!/usr/bin/python
# -*- coding: utf-8 -*-
""" A client to use it for a chat.
        chatClient.py is a class wich let us
        connect to a Server, after it we can 
        send and receive messages.

        author: César Alberto Trejo Juárez
"""
#
#        Imports
#
import sys
import threading
import socket

#
#        Global variables
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
                        readThreading =        threading.Thread(target = self.read)
                        writeThreading = threading.Thread(target = self.write)
                        
                        readThreading.start()
                        writeThreading.start()
                
                except KeyboardInterrupt:
                        print "Shutdown requested...(KeyboardInterrupt at 1o)"
                        self.socket.close()
                except EOFError:
                        print "Shutdown requested...(EOFError at 1o)"
                        self.socket.close()

        def read(self):
                while (True):
                        fromServer = self.socket.recv(200000)
                        if ('Server: Goodbye' in fromServer):
                                print fromServer
                                break
                        print fromServer

        def write(self):
                try:
                        while (True):
                                toServer = raw_input()
                                self.socket.send(toServer + "\n")
                                if toServer == "/exit":
                                        self.socket.close()
                                        sys.exit(0)
                                        break;
                except KeyboardInterrupt:
                        print "Shutdown requested...(KeyboardInterrupt at 2o)"
                        self.socket.close()
                        sys.exit(0)
                except EOFError:
                        print "Shutdown requested...(EOFError at 2o)"
                        self.socket.close()
                        sys.exit(0)
                        

if __name__ == "__main__":
        try:
                client = chatClient()
        except socket.error:
                print 'No Server Found at __main__'
                sys.exit(0)
        except EOFError:
                print 'Ready to exit... at __main__'
                sys.exit(0)
        except:
                print 'Shutdown at __main__'
                sys.exit(0)

