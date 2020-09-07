import sys
import json
import paho.mqtt.client as mqtt


def main():


    client = mqtt.Client('piicoPub') # Creación del cliente?Ė
    client.connect(host='mqtt.eclipse.org', port=1883)
    topic = "req_l"
    mensaje = {
    "node-id": "estación 1",
    "date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)",
    "request": "send",
    "sensors": [
        {
            "sensor-id": "Temperature",
            "network": [
                "wifi",
                "blue",
                "xbee"
            ]
        },
        {
            "sensor-id": "Humidity",
            "network": [
                "wifi",
                "blue",
                "xbee"
            ]
        },
        {
            "sensor-id": "Velocity",
            "network": [
                "wifi",
                "blue",
                "xbee"
            ]
        },
        {
            "sensor-id": "Direction",
            "network": [
                "wifi",
                "blue",
                "xbee"
            ]
        },
        {
            "sensor-id": "Pluviometer",
            "network": [
                "wifi",
                "blue",
                "xbee"
            ]
        },
        {
            "sensor-id": "Radiation",
            "network": [
                "wifi",
                "blue",
                "xbee"
            ]
        }
    ]
}
    
    client.publish(topic, json.dumps(mensaje))
    print(mensaje)

 
if  __name__ ==  '__main__':
    main()
 
sys.exit(0)