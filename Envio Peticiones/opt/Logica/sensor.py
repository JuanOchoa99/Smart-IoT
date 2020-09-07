import json
import paho.mqtt.client as mqtt
data = {
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

nuevo_json = {}
nuevo_json['node-id']="estacion 1"
nuevo_json['date'] = "2020-01-20"
nuevo_json['sensors'] =[]
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
print("-------SEN_l---------\n",json.dumps(nuevo_json['sensors']))
client = mqtt.Client('piicoPub') # Creación del cliente?Ė
client.connect(host='mqtt.eclipse.org', port=1883)
topic = "sen_l"
print(json.dumps(nuevo_json))
client.publish(topic, json.dumps(nuevo_json))

