import json
class Archivo:
    
    def Leer_Archivo(self,nombre,ruta):
        with open(str(ruta)+str(nombre),"r+") as archivo_conf:
            self.archivo_string = str(archivo_conf.read())
            self.archivo_json = json.dumps(self.archivo_string)
            return json.loads(self.archivo_json)

def main():
    print("hola mundo")
    with open( "C:\\Envio Peticiones\\etc\\piico\\wpa_supplicant.conf","r+") as archivo_conf:
            ssid = "Nueva red"
            psk = "nuevacontraseña"
            mensaje = str(archivo_conf.readlines())
            mensaje.find("network")
            print("------ posicion ssid",mensaje.find("ssid"))
            if mensaje.find("ssid") != -1:
                archivo_conf.seek(122)
                
                archivo_conf.readline()
                archivo_conf.truncate()
                archivo_conf.write('network={ssid="David_IOT"psk="Nueva123*"key_mgmt=WPA-PSK}')
                archivo_conf.seek(0)
                print("-------------------\n",archivo_conf.read())
                print(archivo_conf.read(100))
            

if __name__ == "__main__":
    main()