import json
import os
import sys
import time
import paho.mqtt.publish as publish



config_string = '''
{   
  "conf_l":[
    {
    "init_date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)",
    "end_date": "datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)",
    "sensor":[
            {    
                "type":"Temp",
                "sensor-id":"Temperatura",
                "protocol":"wifi",
                "value":"1",
                "number_of_samples":"12"
            },
            {
                "type":"Hum",
                "sensor-id":"Humedad",
                "protocol":"wifi",
                "value":"0",
                "number_of_samples":"8"
            }
        ]
    }
  ]
}
'''
data = json.loads(config_string)
new_string = json.dumps(data, indent=2, sort_keys=False)


print(data)
publish.single("config_l",new_string, hostname="192.168.4.1")
