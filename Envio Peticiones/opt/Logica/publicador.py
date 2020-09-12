import sys
import json
import paho.mqtt.client as mqtt


def main():

    client = mqtt.Client('piicoPub')  # Creación del cliente?Ė
    client.connect(host='mqtt.eclipse.org', port=1883)
    topic = "req_l"
    mensaje = {
                    "node-id": "estación 1",
                    "date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)",
                    "request": "info",
                    "information": {
                        "node": "true",
                        "interfaces": "true",
                        "actuators": "true",
                        "sensors": "true",
                        "mqtt": "true"
                    } 
                }
    string_message = json.dumps(mensaje)
    print(string_message)
    client.publish(topic, string_message)


if __name__ == '__main__':
    main()

sys.exit(0)
