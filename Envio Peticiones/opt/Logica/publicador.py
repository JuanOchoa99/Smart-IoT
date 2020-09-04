import sys
import json
import paho.mqtt.client as mqtt


def main():


    client = mqtt.Client('piicoPub') # Creación del cliente?Ė
    client.connect(host='test.mosquitto.org', port=1883)
    topic = "conf_l"
    mensaje = {"node-id": "1", "date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)", "sampling-frequency": 7, "send-frequency": 7, "broker": {"broker_address": "192.168.10.1", "port": "1883", "qos": "2", "user": "gateway", "pass": "123456"}, "interfaces": [{"type": "wifi", "ssid": "Piico", "psk": "thisismywirelesspassword"}, {"type": "blue", "alias": "Gateway_PIICO", "mac": "A3545ETR456D"}, {"type": "xbee", "state": "active", "pan-id": "154", "mac": "A3545ETR456D"}], "sensors": [{"type": "tem", "state": "active", "sensor-id": "AM2315-temperature"}, {"type": "hum", "state": "active", "sensor-id": "AM2315-humidity"}, {"type": "vel", "state": "active", "sensor-id": "Wind-speed"}, {"type": "dir", "state": "active", "sensor-id": "Wind-direction"}, {"type": "plu", "state": "active", "sensor-id": "Pluviometer"}, {"type": "rad", "state": "active", "sensor-id": "Solar-radiation"}], "actuators": [{"type": "asp", "state": "active", "actuator-id": "Lawn-sprinkler"}, {"type": "led", "state": "active", "actuator-id": "RGB"}]}



    client.publish(topic, json.dumps(mensaje))
    print(mensaje)

 
if  __name__ ==  '__main__':
    main()
 
sys.exit(0)