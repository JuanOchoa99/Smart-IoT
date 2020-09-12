'''
Created on 27/02/2020

@author: Sebastian Enrique Villanueva Navarro
Juan Jose Ochoa Ortiz
'''
import argparse
import json
import sys
import paho.mqtt.client as mqtt
import datetime
import threading
import time

hostname = ""
puerto = 0            
class Archivo:
    
    def Leer_Archivo(self,nombre,ruta):
        with open(str(ruta)+str(nombre),"r+") as archivo_conf:
            self.archivo_string = str(archivo_conf.read())
            self.archivo_json = json.dumps(self.archivo_string)
            return json.loads(self.archivo_json)

parser = argparse.ArgumentParser(
    prog='Estacion PIICO USB',
    description='Comandos para el inicio de la estacion.',
    epilog="mas informacion en https://piico.ingusb.com",
    add_help=True
)
parser.add_argument(
    '-v','--version',
    dest='version',
    action='version',
    version='%(prog)s 1.0'
)
parser.add_argument(
    '-n','--name', '--nameid',
    dest='name',
    required=True,
    nargs=1,
    type=str,
    help='nombre identificador del nodo'
)
parser.add_argument(
    '-p','--pass', '--password',
    dest='password',
    required=True,
    nargs=1,
    type=str,
    help='Contraseña identificador del actuador a activar'
)
def json_decode(data):
    string_data = data.decode('ASCII')
    json_data = json.loads(string_data)
    return json_data

def on_connect(client, userdata, flags, rc):
    client.subscribe([("conf_l", 2),("req_l", 2),("act_l",2)])
def on_message(client, userdata, message):
    print('------------------------------')
    brokerPub = ConexionPub()
    brokerPubSta = ConexionSta()
    construir_json = EstadoAct()
    #print('topic: %s', message.topic)
    #print("%s %s" % (message.topic,message.payload))
    topico = message.topic
    json_resultado = json_decode(message.payload)
    print(json_resultado['node-id'])
    if topico == "conf_l":
        #print("----", json_resultado)
        with open("C:\\Envio Peticiones\\etc\\piico\\conf_l.json","r+") as archivo_conf:
                archivo_conf.seek(0)
                archivo_conf.truncate()
                archivo_conf.seek(0)
                archivo_conf.writelines(json_resultado)
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
            threadPublicador = threading.Thread(name="Publicador", target=brokerPub.publicadorMas, args=(topic, nuevo_json))
            threadPublicador.start()
            print(threadPublicador.isAlive())
            print("chao")
        elif data['request'] == "stop":
            threadPublicador.stop()
        elif data['request'] == "info":
            print("Comienzo")
            nuevo_json = construir_json.armar_json(data)
            topic = "sta_l"
            print("Chao", nuevo_json)
            print(hostname,puerto)
            threadPublicadorSta = threading.Thread(name="Publicador", target=brokerPubSta.publicador, args=( topic, nuevo_json))
            threadPublicadorSta.start()
    elif topico == "act_l":
        data = json_decode(message.payload)
        if data['request'] == "info":
            nuevo_json = construir_json.armar_json(data)
            topic = "sta_l"
            threadPublicadorSta = threading.Thread(name="Publicador", target=brokerPubSta.publicador, args=( topic, nuevo_json))
            threadPublicadorSta.start()
        elif data['request'] == "act":
            if data['actuators']['actuator-id'] == "Aspersor":
                aspersor = True #Reemplazar por rutina de aspersor
    
    
class EstadoAct:
    def armar_json(self,data):
        leer_archivo = Archivo()
        leer_conf = json.loads(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
        nuevo_json = {}
        nuevo_json['node-id']= data['node-id']
        nuevo_json['date'] = data['date']
        nuevo_json['broker'] ={}
        nuevo_json['broker']['publish'] = []
        nuevo_json['broker']['suscribe'] = []
        nuevo_json['interfaces'] = []
        nuevo_json['sensors'] =[]
        nuevo_json['actuators'] =[]
        print(nuevo_json)
        print(data['information']['mqtt'])
        print(data['information']['actuators'])
        print(data['information']['sensors'])
        print(data['information']['interfaces'])
        if data['information']['mqtt'] == "true":
            print("segundo if")
            nuevo_json['broker']['ip'] = leer_conf['broker']['broker_address']
            nuevo_json['broker']['port'] = leer_conf['broker']['port']
            nuevo_json['broker']['qos'] = leer_conf['broker']['qos']
            nuevo_json['broker']['user'] = leer_conf['broker']['user']
            nuevo_json['broker']['publish'].append({
                                "type": "sen_l"})
            nuevo_json['broker']['publish'].append({
                                "type": "sta_l"})
            nuevo_json['broker']['suscribe'].append({
                                "type": "conf_l"})
            nuevo_json['broker']['suscribe'].append({
                                "type": "req_l"})
            nuevo_json['broker']['suscribe'].append({
                                "type": "act_l"})
            print("---------",nuevo_json)
        if data['information']['interfaces'] == "true":
            print("tercer if")
            for interfaz in leer_conf['interfaces']:
                print(interfaz['type'])
                print(leer_conf['interfaces'])
                print()
                if interfaz['type'] == "wifi":
                    nuevo_json['interfaces'].append({
                                "type": "wifi",
                                "state": "active",
                                "dir": ""+leer_conf['broker']['broker_address']+"" })
                if interfaz['type'] == "blue":
                    print(nuevo_json)
                    nuevo_json['interfaces'].append({
                                "type": "blue",
                                "state": "active",
                                "mac": ""+interfaz['mac']+"",
                                "mode": "direct"})
                    print(nuevo_json)
                if interfaz['type'] == "xbee":
                    nuevo_json['interfaces'].append({
                                "type": "xbee",
                                "state": "active",
                                "pan-id": "1234",
                                "mac": ""+interfaz['mac']+""})
        print(data['information']['sensors'])
        if data['information']['sensors'] == "true":
            print("4 if")
            for sensor in leer_conf['sensors']:
                if sensor['type'] == "tem":
                    nuevo_json['sensors'].append({
                                "sensor-id": "Temperature",
                                "state": "active" })
                if sensor['type'] == "hum":
                    nuevo_json['sensors'].append({
                                "sensor-id": "Humidity",
                                "state": "active" })
                if sensor['type'] == "vel":
                    nuevo_json['sensors'].append({
                                "sensor-id": "Velocity",
                                "state": "active" })
                if sensor['type'] == "dir":
                    nuevo_json['sensors'].append({
                                "sensor-id": "Direction",
                                "state": "active" })
                if sensor['type'] == "plu":
                    nuevo_json['sensors'].append({
                                "sensor-id": "Pluviometer",
                                "state": "active" })
                if sensor['type'] == "rad":
                    nuevo_json['sensors'].append({
                                "sensor-id": "Radiation",
                                "state": "active" })
        if data['information']['actuators'] == "true":
            print("5 if")
            for actuador in leer_conf['actuators']:
                if actuador['type'] == "asp":
                    nuevo_json['actuators'].append({
                                "actuator-id": "Aspersor",
                                "state": "active"})
                if actuador['type'] == "led":
                    nuevo_json['actuators'].append({
                                "actuator-id": "RGB",
                                "state": "active"})
        return nuevo_json

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
    def publicadorMas(self, topicoPub, mensajePub):
        leer_archivo = Archivo()
        json_leer = json.loads(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
        hostPub = json_leer['broker']['broker_address']
        puertoPub = int(json_leer['broker']['port'])
        while True:
            service = mqtt.Client('piicoPub') # Creación del cliente?Ė
            service.connect(host= hostPub, port=puertoPub)
            topic = topicoPub
            mensaje = mensajePub
            service.publish(topic, json.dumps(mensaje))
            print(json_leer['send-frequency'])
            time.sleep(json_leer['send-frequency'])
class ConexionSta:
    def publicador(self, topicoPubSta, mensajePubSta):
        leer_archivo = Archivo()
        json_leer = json.loads(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
        hostPubSta = json_leer['broker']['broker_address']
        puertoPubSta = int(json_leer['broker']['port'])
        service = mqtt.Client('piicoPub') # Creación del cliente?Ė
        service.connect(host= hostPubSta, port=puertoPubSta)
        topic = topicoPubSta
        mensaje = mensajePubSta
        print(topic,mensaje,hostPubSta)
        service.publish(topic, json.dumps(mensaje))

    
def main():     
    args = parser.parse_args()
    estacion=args.name
    password = args.password
    print('La estacion es: ', estacion)
    print('La contraseña del actuador se registro')
    with open("C:\\Envio Peticiones\\etc\\piico\\station.pass","w") as archivo_pass:
        archivo_pass.seek(0)
        archivo_pass.truncate()
        password_act = "PASSWORD_ACT="
        password_act += str(password)
        archivo_pass.write(password_act)
        print("Se guardo la contraseña del actuador en el archivo",archivo_pass.name)
    leer_archivo = Archivo()
    json_leer = json.loads(leer_archivo.Leer_Archivo("conf_l.json","C:\\Envio Peticiones\\etc\\piico\\"))
    hostname = json_leer['broker']['broker_address']
    puerto = int(json_leer['broker']['port'])
    broker = ConexionMqtt()
    threadSuscriptor = threading.Thread(name="Suscriptor", target=broker.sucriptor, args=(hostname, puerto))
    threadSuscriptor.start()
if  __name__ ==  '__main__':
    main()