import sys
import json
import paho.mqtt.client as mqtt


def main():

    client = mqtt.Client('piicoPub')  # Creación del cliente?Ė
    client.connect(host='mqtt.eclipse.org', port=1883)
    topic = "sen_p"

    pruebaMongo = {
                        "id": "1231321",
                        "mensaje": "Prueba del mensaje"
                   }
    act_info = {
    "node-id": "estacion",
    
    "pass": "sgdfg456rt0fdmvñsfti3q5",
    "date": "(2016, 4, 8, 11, 43, 54, 920632)",
    "request": "info",
    "information": {
        "node": "true",
        "interfaces": "true",
        "actuators": "true",
        "sensors": "true",
        "mqtt": "true"
    }
}
    req_send = {
        "node-id": "estacion 1",
        "date": "2020-09-07-08-25-42",
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

    req_stop = {
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

    sen_p = {
                    "node_id": "estacion1",
                    "date": "2020-09-07-08-25-42",
                    "gps": {
                        "lon": 4.25,
                        "lat": 4.8
                        },
                    "sensors": [
                        {
                            "type": "tem",
                            "sensor_id": "Temperature",
                            "value": "0.0",
                            "magnitude": "Celsius"
                        },
                        {
                            "type": "hum",
                            "sensor_id": "Humidity",
                            "value": "0.0",
                            "magnitude": "percent"
                        },
                        {
                            "type": "vel",
                            "sensor_id": "Velocity",
                            "value": "0.0",
                            "magnitude": "Km/h"
                        },
                        {
                            "type": "dir",
                            "sensor_id": "Direction",
                            "value": "North",
                            "magnitude": "Cardinal_point"
                        },
                        {
                            "type": "plu",
                            "sensor_id": "Pluviometer",
                            "value": "0.0",
                            "magnitude": "mm3"
                        },
                        {
                            "type": "rad",
                            "sensor_id": "Radiation",
                            "value": "0.0",
                            "magnitude": "W/m2"
                        }
                    ]
                }
    conf_l = {"node-id": "PruebaCOndf", "date": "2020-08-30 21:57:36.608547", "sampling-frequency": 5, "send-frequency": 7, "broker": {"broker_address": "test.mosquitto.org", "port": "1883", "qos": "2", "user": "gateway", "pass": "123456"}, "interfaces": [{"type": "wifi", "ssid": "Piico", "psk": "thisismywirelesspassword"}, {"type": "blue", "alias": "Gateway_PIICO", "mac": "A3545ETR456D"}, {"type": "xbee", "state": "active", "pan-id": "154", "mac": "A3545ETR456D"}], "sensors": [{"type": "tem", "state": "active", "sensor-id": "AM2315-temperature"}, {"type": "hum", "state": "active", "sensor-id": "AM2315-humidity"}, {"type": "vel", "state": "active", "sensor-id": "Wind-speed"}, {"type": "dir", "state": "active", "sensor-id": "Wind-direction"}, {"type": "plu", "state": "active", "sensor-id": "Pluviometer"}, {"type": "rad", "state": "active", "sensor-id": "Solar-radiation"}], "actuators": [{"type": "asp", "state": "active", "actuator-id": "Lawn-sprinkler"}, {"type": "led", "state": "active", "actuator-id": "RGB"}]}
    string_message = json.dumps(sen_p)
    print(string_message)
    client.publish(topic, string_message)


if __name__ == '__main__':
    main()

sys.exit(0)
