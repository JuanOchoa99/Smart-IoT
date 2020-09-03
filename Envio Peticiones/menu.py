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

if __name__ == '__main__':
    main()

        
