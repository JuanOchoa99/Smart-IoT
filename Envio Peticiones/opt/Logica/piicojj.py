'''
Created on 27/02/2020

@author: Sebastian Enrique Villanueva Navarro
Juan Jose Ochoa Ortiz
'''
import argparse
import json
import sys
import paho.mqtt.client as mqtt
import threading


hostname = "mqtt.eclipse.org"
puerto = 1883            



def json_decode(data):
    string_data = data.decode('ASCII')
    json_data = json.loads(string_data)
    return json_data

class Archivo:
    
    def Leer_Archivo(self,nombre,ruta):
        with open(str(ruta)+str(nombre),"r+") as archivo_conf:
            self.archivo_string = str(archivo_conf.read())
            self.archivo_json = json.dumps(self.archivo_string)
            return json.loads(self.archivo_json)

def on_connect(client, userdata, flags, rc):
    client.subscribe([("conf_l", 2),("req_l", 2),("act_l",2)])
def on_message(client, userdata, message):
    topico = message.topic
    json_resultado = json_decode(message.payload)
    print(json_resultado['node-id'])
    if topico == "conf_l":
        mensaje_str = message.payload
        resultado = mensaje_str.decode('ASCII')
        print("----", resultado)
        with open("C:\\Envio Peticiones\\etc\\piico\\conf_l.json","r+") as archivo_conf:
                archivo_conf.seek(0)
                archivo_conf.truncate()
                archivo_conf.seek(0)
                archivo_conf.writelines(resultado)
        leer_archivo = Archivo()
        json_leer = json.loads(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
    elif topico == "req_l":
        print("hola")
        topic = "sen_l"
        #json_message = message.payload
        data = json_decode(message.payload)
        if data['request'] == "send":
            print("hola2")
            nuevo_json = {}
            nuevo_json['node-id']= data['node-id']
            nuevo_json['date'] = data['date']
            nuevo_json['sensors'] =[]
            posicion = 0
            #print(nuevo_json)
            for sensor in data['sensors']:
                    if sensor['sensor-id'] == "Temperature":
                        nuevo_json['sensors'].append({
                                    "type":"tem",
                                    "sensor-id":""+sensor['sensor-id']+"",
                                    "value":"0.0",
                                    "magnitude":"C" })
                    if sensor['sensor-id'] == "Humidity":
                        nuevo_json['sensors'].append({
                                    "type":"hum",
                                    "sensor-id":""+sensor['sensor-id']+"",
                                    "value":"0",
                                    "magnitude":"%" })
                    if sensor['sensor-id'] == "Velocity":
                        nuevo_json['sensors'].append({
                                    "type":"hum",
                                    "sensor-id":""+sensor['sensor-id']+"",
                                    "value":"0",
                                    "magnitude":"km/h" })
                    if sensor['sensor-id'] == "Direction":
                        nuevo_json['sensors'].append({
                                    "type":"hum",
                                    "sensor-id":""+sensor['sensor-id']+"",
                                    "value":"0",
                                    "magnitude":"grados" })
                    if sensor['sensor-id'] == "Pluviometer":
                        nuevo_json['sensors'].append({
                                    "type":"hum",
                                    "sensor-id":""+sensor['sensor-id']+"",
                                    "value":"0",
                                    "magnitude":"ml" })
                    if sensor['sensor-id'] == "Radiation":
                        nuevo_json['sensors'].append({
                                    "type":"hum",
                                    "sensor-id":""+sensor['sensor-id']+"",
                                    "value":"0",
                                    "magnitude":"w/m2" })
            #print("-------SEN_l---------\n",json.dumps(nuevo_json['sensors']))
            print("chao")
            topic = "sen_l"
            brokerPub = ConexionMqtt()
            
            brokerPub = ConexionPub
            threadPublicador = threading.Thread(name="Publicador", target=brokerPub.publicadorMas, args=(hostname, puerto, topic, nuevo_json))
            threadPublicador.start()
            print("chao")
        elif data['request'] == "stop":
            threadPublicador.stop()
    elif topico == "act_l":
        data = json_decode(message.payload)
        if data['request'] == "info":
            nuevo_json = {}
            nuevo_json['node-id']= data['node-id']
            nuevo_json['date'] = data['date']
            nuevo_json['actuators'] =[]
            for actuador in leer_conf['actuators']:
                    if actuador['type'] == "asp":
                        nuevo_json['actuators'].append({
                                    "actuator-id": "Aspersor",
                                    "state": "active"})
                    if actuador['type'] == "led":
                        nuevo_json['actuators'].append({
                                    "actuator-id": "RGB",
                                    "state": "active"})
            topic = "sta_l"
            brokerPub = ConexionPub
            threadPublicador = threading.Thread(name="Publicador", target=brokerPub.publicador, args=(hostname, puerto, topic, nuevo_json))
            threadPublicador.start()

        elif data['request'] == "act":
            if data['actuators']['actuator-id'] == "Aspersor":
                aspersor = True #Reemplazar por rutina de aspersor
                


            
        

class ConexionMqtt:
    def sucriptor(self, hostSub, puertoSub):
        client = mqtt.Client(client_id='Sevin', clean_session=False)
        client.on_connect = on_connect
        client.on_message = on_message
        print("hostname= ",hostSub,"puerto= ",puertoSub)
        client.connect(host=hostSub, port=puertoSub)
        #client.loop()
        client.loop_forever()

class ConexionPub:
    def publicadorMas(hostPub, puertoPub, topicoPub, mensajePub):
        while True:
            service = mqtt.Client('piicoPub') # Creación del cliente?Ė
            service.connect(host= hostPub, port=puertoPub)
            topic = topicoPub
            mensaje = mensajePub
            service.publish(topic, json.dumps(mensaje))
            time.sleep(2)
    def publicador(hostPub, puertoPub, topicoPub, mensajePub):
        service = mqtt.Client('piicoPub') # Creación del cliente?Ė
        service.connect(host= hostPub, port=puertoPub)
        topic = topicoPub
        mensaje = mensajePub
        service.publish(topic, json.dumps(mensaje))

    
def main():     
    #leer_archivo = Archivo()
    #print("----Archivo JSON-----------")
    #print(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
    #json_leer = json.loads(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
    #print('--------------------------------------Leer broker------------------------')
    #print(json_leer['broker']['broker_address'])
    broker = ConexionMqtt()
    threadSuscriptor = threading.Thread(name="Suscriptor", target=broker.sucriptor, args=(hostname, puerto))
    threadSuscriptor.start()


if  __name__ ==  '__main__':
    main()