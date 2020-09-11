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
            topic = "sen_l"
            print("chao")
            client.publish(topic, json.dumps(nuevo_json))
        elif data['request'] == "stop":
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
            topic = "sen_l"
            print("chao")
            client.publish(topic, json.dumps(nuevo_json))

    
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
    client = mqtt.Client(client_id='Sevin', clean_session=False)
    client.on_connect = on_connect
    client.on_message = on_message
    print("hostname= ",hostname,"puerto= ",puerto)
    client.connect(host=hostname, port=puerto)
    #client.loop()
    client.loop_forever()
if  __name__ ==  '__main__':
    main()