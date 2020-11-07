'''
Created on 28/02/2020

@author: jjochoa - sevillanueva
'''

import sys
import json
import paho.mqtt.client as mqtt
import datetime


class Conf_l:
    def __init__(self):
        self.nodeId = ""
        self.date = datetime.datetime.now()
        self.samples = 0

        #Broker
        self.ip = ""
        self.port = 0
        self.qos = 0
        self.user = ""
        self.pass = ""

        #Interfaces
        self.type = ""
        #Wi-fi
        self.typeWifi = False
        self.ssid = ""
        self.psk = ""
        #Blue
        self.typeBlue = False
        self.alias = ""
        self.macBlue = ""
        #Xbee
        self.typeXbee = False
        self.state = False
        self.panId = ""
        self.macXbee = ""

        #Blue
        self.typeBlue = False
        self.alias = ""
        self.macBlue = ""
        

        #Sensores
        






    def solicitar():
        print("Digite id del nodo: ")
        opcion = int(input("Ingrese una opción"))



def main():

    
    opcion = 0
    
    while opcion != 4
        print("1. Configurar nodo")
        print("2. Configurar sensores")
        print("3. Configurar Actuadores")
        print("4. Salir")

        opcion = int(input("Ingrese una opción"))
        if opcion == 1:







    client = mqtt.Client('piicoPub') # Creación del cliente?Ė
    client.connect(host='192.168.0.19', port=1883)
    topic = "piico_usb"
    mensaje = {"temp" : 92}

    
    while True:
        client.publish(topic, json.dumps(mensaje))
        print(mensaje)

 
if __name__ == '__main__':
    main()
 
sys.exit(0)