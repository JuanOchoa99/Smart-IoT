'''
Created on 30/08/2020

@author: jjochoa - sevillanueva
'''

import sys
import json
#import paho.mqtt.client as mqtt
import datetime


class Conf_l:
    def __init__(self):
        print("----------------Menu de envio de peticiones por MQTT------------------------------")
        print("Datos de la estación")
        self.nodeId = str(input("Digite id de la estación:"))
        self.samples = int(input("Digite frecuencía por minuto:"))

        print("--------------------------Datos de la broker-------------------------------")
        self.ip = str(input("Digite dirección del broker: "))
        self.port = int(input("Digite puerto: "))
        self.qos = int(input("Digite QoS: "))
        self.user = str(input("Digite usuario: "))
        self.password = str(input("Digite contraseña: "))

        self.brokerAttributes = {
                                    "broker_address" : "-",
                                    "port" : "-",
                                    "qos" : "-",
                                    "user" : "-",
                                    "pass" : "-"
                                }
        self.brokerAttributes["broker_address"] = self.ip
        self.brokerAttributes["port"]=self.port
        self.brokerAttributes["qos"]=self.qos
        self.brokerAttributes["user"]=self.user
        self.brokerAttributes["pass"]=self.password
        self.jsonBroker = json.dumps(self.brokerAttributes, indent=4,separators=(',',':'),sort_keys=False)
        
        print("--------------------Configurar la interfaces-------------------------------")
        opcionInterface = 1
        while opcionInterface != 2:
            self.type = str(input("Digite protocolo de comunicación(wifi - blue - xbee): "))

            if self.type == "wifi":
                self.typeWifi = True
                self.ssid = str(input("Digite nombre de la red: "))
                self.psk = str(input("Digite contraseña "))
            elif self.type == "blue":
                self.typeBlue = True
                self.alias = str(input("Digite nombre de la red: "))
                self.macBlue = str(input("Digite dirección MAC: "))
                self.puerto = str(input("Digite dirección Puerto: "))
            elif self.type == "xbee":
                self.typeXbee = True
                self.state = True
                self.panId = str(input("Digite pan-id: "))
                self.macXbee = str(input("Digite dirección MAC: "))
            
            if self.type != "wifi" and self.type != "blue" and self.type != "xbee":
                print("Protocolo inválido")
            else:
                print("1. Configurar otro protocolo.")
                print("2. Continuar.")
                opcionInterface = int(input("Digite una opción: "))

        self.wifiAttributes = {
                                "ssid" : "-",
                                "psk" : "-"
                            }
        self.wifiAttributes["ssid"]= self.ssid
        self.wifiAttributes["psk"]= self.psk
        self.jsonWifi = json.dumps(self.wifiAttributes, indent=2,separators=(',',':'),sort_keys=False)

        self.blueAttributes = {
                                "alias" : "-",
                                "mac" : "-",
                                "port": "-"
                            }
        self.blueAttributes["alias"]= self.alias
        self.blueAttributes["mac"]= self.macBlue
        self.blueAttributes["port"]= self.puerto
        self.jsonBlue = json.dumps(self.blueAttributes, indent=2,separators=(',',':'),sort_keys=False)

        self.xbeeAttributes = {
                                "state" : "-",
                                "pan-id" : "-",
                                "mac" : "-"
                            }
        self.xbeeAttributes["state"]= self.state
        self.xbeeAttributes["pan-id"]= self.panId
        self.xbeeAttributes["mac"]= self.macXbee
        self.jsonXbee = json.dumps(self.xbeeAttributes, indent=3,separators=(',',':'),sort_keys=False)

        self.interfaceAttributes = {
                                "wifi" : "-",
                                "blue" : "-",
                                "xbee" : "-"
                            }
        self.interfaceAttributes["wifi"] = json.loads(self.jsonWifi)
        self.interfaceAttributes["blue"] = json.loads(self.jsonBlue)
        self.interfaceAttributes["xbee"] = json.loads(self.jsonXbee)
        self.jsonInterfaces = json.dumps(self.interfaceAttributes, indent=3,separators=(',',':'),sort_keys=False)


        print("Configurar los sensores")

        self.listSenType = str(input("Digite tipo: "))
        self.listSenState = True
        self.listSenId = str(input("Digite id del sensor: "))

        self.sensorAttributes = {
                            "type" : "-",
                            "state" : "-",
                            "sensor-id" : "-"
                        }
        self.sensorAttributes["type"] = self.listSenType
        self.sensorAttributes["state"] = self.listSenState
        self.sensorAttributes["sensor-id"] = self.listSenId
        self.jsonSensores = json.dumps(self.sensorAttributes, indent=3,separators=(',',':'),sort_keys=False)


        print("Configurar los actuadores")

        self.listActType = str(input("Digite tipo: "))
        self.listActState = True
        self.listActId = str(input("Digite id del actuador: "))

        self.actuadorAttributes = {
                            "type" : "-",
                            "state" : "-",
                            "actuador-id" : "-"
                        }
        self.actuadorAttributes["type"] = self.listSenType
        self.actuadorAttributes["state"] = self.listSenState
        self.actuadorAttributes["actuador-id"] = self.listSenId
        self.jsonActuadores = json.dumps(self.actuadorAttributes, indent=3,separators=(',',':'),sort_keys=False)


        self.__attributes = {
                            "node-id" : "-",
                            "date" : "-",
                            "sampling-frequency" : "-", 
                            "Broker" : {}, 
                            "interfaces" : {}, 
                            "sensors" : {}, 
                            "actuators" : {} 
                        }
        self.date = datetime.datetime.now()
        self.dateString = str(self.date)
        self.__attributes["node-id"] = self.nodeId
        self.__attributes["date"]=self.dateString
        self.__attributes["sampling-frequency"]=self.samples
        self.__attributes["Broker"]=json.loads(self.jsonBroker)
        self.__attributes["interfaces"]=json.loads(self.jsonInterfaces)
        self.__attributes["sensors"]=json.loads(self.jsonSensores)
        self.__attributes["actuators"]=json.loads(self.jsonActuadores)
        self.__datajson = json.dumps(self.__attributes, indent=7,separators=(',',':'),sort_keys=False)

        #Observar Json
        print(self.__datajson)  

        
        #client = mqtt.Client('piicoPub')
        #client.connect(host='192.168.0.19', port=1883)
        #topic = "piico_usb"
        #mensaje = self.__datajson
def main():

    
    opcion = 0
    
    while opcion != 4:
        print("1. Configurar nodo")
        print("2. Configurar sensores")
        print("3. Configurar Actuadores")
        print("4. Salir")

        opcion = int(input("Ingrese una opción"))
        if opcion == 1:
            Conf_l()
            
        elif opcion != 1:
            break

 
if __name__ == '__main__':
    main()
 
sys.exit(0)