import json

mensaje = '''{
  "node-id": "estacion_1",
  "date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)",
  "sampling-frequency": "7",
  "send-frequency": "7",
  "broker": {
    "broker_address": "192.168.4.1",
    "port": "1883",
    "qos": "2",
    "user": "gateway",
    "pass": "123456"
  },
  "interfaces": [
    {
      "type": "wifi",
      "ssid": "David_IOT",
      "psk": "facil123*"
    },
    {
      "type": "blue",
      "alias": "Gateway_PIICO",
      "mac": "A3545ETR456D"
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
      "actuator-id": "prueba"
    }
  ]
}'''

network_names = ["Piico","piico",]
passwords = ["thisismywirelesspassword","nueva","facil123*"]

datajson = json.loads(mensaje)

def CreateWifiConfig(SSID, password):
    config_lines = [
    '\n',
    'network={',
    '\tssid="{}"'.format(SSID),
    '\tpsk="{}"'.format(password),
    '\tkey_mgmt=WPA-PSK',
    '}'
    ]

    config = '\n'.join(config_lines)
    print(config)

    with open("wpa_supplicant.conf", "a+") as wifi:
        wifi.write(config)

    print("Wifi config added")

for net in datajson['interfaces']:
    if net['type'] == 'wifi':
        SSID = net['ssid']
        PASS = net['psk']
        #print(SSID,PASS)

if SSID in network_names:
    if PASS not in passwords:
        CreateWifiConfig(SSID,PASS)
elif SSID not in network_names:
    CreateWifiConfig(SSID,PASS)
    passwords.append(PASS)
    network_names.append(SSID)
