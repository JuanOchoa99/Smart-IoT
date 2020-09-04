'''
Created on 28/02/2020

@author: jjochoa - sevillanueva
'''

import json
def main():
    wifi = {
        "ssid":"PIICO",
        "psk":"Password10"
    }
    blue = {
        "alias":"Sevin",
        "mac":"mau52s84a5d"
    }
    xbee = {
        "state":False,
        "pan_id":9182,
        "mac":"223i4hjb4nv"
    }
    interfaces = {
        "wifi": wifi,
        "blue": blue,
        "xbee": xbee
    }

    data_json = json.dumps(interfaces)

    for key in interfaces:
        if key == "wifi":
            SSID = interfaces[key].get("ssid")
            password = interfaces[key].get("psk")
            print("Configuracion wifi:  SSID: ",SSID," contraseña:",password)
        if key == "blue":
            alias = interfaces[key].get("alias")
            macBlue = interfaces[key].get("mac")
            print("Configuracion Bluetooth:  Alias: ",alias," Direccion MAC:",macBlue)
        if key == "xbee":
            state = interfaces[key].get("state")
            if state == False:
                estado = "Desactivado"
            else:
                estado = "Activado"
            panId = interfaces[key].get("pan_id")
            macXbee = interfaces[key].get("mac")
            print("Configuracion Estado: ",estado," Panel id:",panId," Direccion MAC: ",macXbee)
    print("---------------------Datos en Formato JSON--------------------\n",data_json)
    print("Tenemos")
    print("---------------------Datos en Formato String--------------------\n",interfaces)
    
    with open("D:\\Envio Peticiones\\etc\\piico\\conf_l.json","r+") as archivo_conf:
            mensaje_json = {
                "node-id": "estación 1",
                "date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)",
                "sampling-frequency": 7,
                "send-frequency": 7,
                "broker": {
                "broker_address": "192.168.10.1",
                    "port": "1883",
                    "qos": "2",
                    "user": "gateway",
                    "pass": "123456"
                },
                "interfaces": [ 
                    {
                        "type": "wifi",
                        "ssid": "Pony",
                        "psk": "thisismywirelesspassword"
                    },
                    {
                        "type": "blue",
                        "alias": "Gateway_PIICO",
                        "mac": "A3545ETR456D“"
                    },
                    {
                        "type": "xbee",
                        "state": "active",
                        "pan-id": "154",
                        "mac": "A3545ETR456D"
                    }
                ],
                "sensors": [
                    {
                        "type": "tem",
                        "state": "active",
                        "sensor-id": "AM2315-temperature"
                    },
                    {
                        "type": "hum",
                        "state": "active",
                        "sensor-id": "AM2315-humidity"
                    },
                    {
                        "type": "vel",
                        "state": "active",
                        "sensor-id": "Wind-speed"
                    },
                    {
                        "type": "dir",
                        "state": "active",
                        "sensor-id": "Wind-direction"
                    },
                    {
                        "type": "plu",
                        "state": "active",
                        "sensor-id": "Pluviometer"
                    },
                    {
                        "type": "rad",
                        "state": "active",
                        "sensor-id": "Solar-radiation"
                    }
                ],
                "actuators": [
                    {
                        "type": "asp",
                        "state": "active",
                        "actuator-id": "Lawn-sprinkler"
                    },
                    {
                        "type": "led",
                        "state": "active",
                        "actuator-id": "RGB"
                    }
                ]
            }
            mensaje_str = str(mensaje_json)
            print(mensaje_str)
            if mensaje_str == str(archivo_conf.read()):
                print("Archivo de configuración esta actualizado")
            else:
                json_conf = json.dumps(mensaje_json)
                archivo_conf.writelines(json_conf)
                print("El archivo de configuracion esta desactualizado.\n Actualizando...")
                print(json_conf)

if __name__ == '__main__':
    main()

        
