import sys
import json
import paho.mqtt.client as mqtt


def main():

    client = mqtt.Client('piicoPub')  # Creación del cliente?Ė
    client.connect(host='mqtt.eclipse.org', port=1883)
    topic = "req_l"
    mensaje = {
        "node-id": "estacion 1",
        "date": "2020-09-07-08-25-42",
        "request": "stop",
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
    string_message = json.dumps(mensaje)
    print(string_message)
    client.publish(topic, string_message)


if __name__ == '__main__':
    main()

sys.exit(0)
