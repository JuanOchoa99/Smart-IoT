'''
Created on 27/02/2020

@author: Sebastian Enrique Villanueva Navarro
'''
import argparse
import json

class Archivo:
    def __init__(self):
        with open("D:\\Envio Peticiones\\etc\\piico\\conf_l.json","r+") as archivo_conf:
            self.archivo_string = str(archivo_conf.read())
            self.archivo_json = json.dumps(self.archivo_string)

   # def escribir_archivo(self):
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
    
def main():     
    args = parser.parse_args()
    estacion=args.name
    password = args.password
    print('La estacion es: ', estacion)
    print('La contraseña del actuador se registro')

    with open("D:\\Envio Peticiones\\etc\\piico\\station.pass","w") as archivo_pass:
        archivo_pass.seek(0)
        archivo_pass.truncate()
        password_act = "PASSWORD_ACT="
        password_act += str(password)
        archivo_pass.write(password_act)
        print("Se guardo la contraseña del actuador en el archivo",archivo_pass.name)

    read_file = Archivo()
    print(json.loads(read_file.archivo_json))
    with open("D:\\Envio Peticiones\\etc\\piico\\conf_l.json","r+") as archivo_conf:
        mensaje_json = {"node-id": "estacion 1", "date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)", "sampling-frequency": 7, "send-frequency": 7, "broker": {"broker_address": "192.168.10.1", "port": "1883", "qos": "2", "user": "gateway", "pass": "123456"}, "interfaces": [{"type": "wifi", "ssid": "Piico", "psk": "thisismywirelesspassword"}, {"type": "blue", "alias": "Gateway_PIICO", "mac": "A3545ETR456D"}, {"type": "xbee", "state": "active", "pan-id": "154", "mac": "A3545ETR456D"}], "sensors": [{"type": "tem", "state": "active", "sensor-id": "AM2315-temperature"}, {"type": "hum", "state": "active", "sensor-id": "AM2315-humidity"}, {"type": "vel", "state": "active", "sensor-id": "Wind-speed"}, {"type": "dir", "state": "active", "sensor-id": "Wind-direction"}, {"type": "plu", "state": "active", "sensor-id": "Pluviometer"}, {"type": "rad", "state": "active", "sensor-id": "Solar-radiation"}], "actuators": [{"type": "asp", "state": "active", "actuator-id": "Lawn-sprinkler"}, {"type": "led", "state": "active", "actuator-id": "RGB"}]}
        json_m = json.dumps(Archivo().archivo_json)
        json_conf = json.dumps(mensaje_json)
        print("----LEYENDO ARCHIVO--------------------\n",archivo_conf.read())
        #print("Archivo de configuración esta actualizado\n",json.loads(json_m))
        if archivo_conf.read() == json.loads(json_m):
            print("Archivo de configuración esta actualizado\n",json.dumps(json_m))
        else:
            archivo_conf.seek(0)
            archivo_conf.truncate()
            archivo_conf.seek(0)
            archivo_conf.writelines(json_conf)
            print("El archivo de configuracion esta desactualizado.\n Actualizando...")
            print(json_conf)
   
if  __name__ ==  '__main__':
    main()