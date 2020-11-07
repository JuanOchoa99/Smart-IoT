import paho.mqtt.subscribe as subscribe
import sys
import json
import os
import time
from datetime import date, datetime, time, timedelta
import calendar
from gpiozero import MCP3008
from gpiozero import Button
import time
import board
import busio
import adafruit_am2320
import math
import traceback

#programa que interpreta el json recibido a través del topico req_l y activa los sensores segun el tipo de sensor y la variable.

hoy= datetime.today()
formatdate= "%x-%X"
now = hoy.strftime(formatdate)
#print str(now)
nodeid = 'nodo2'


def sensado(variable, protocolo):
    i2c = busio.I2C(board.SCL, board.SDA)
    sensor = adafruit_am2320.AM2320(i2c)
    if variable == "Temp":
        temperature = sensor.temperature
        env='python jsonPython.py -p'+ protocolo +' -n '+ nodeid +' -s Temperature -v '+ '{0}C'.format(temperature) +' -m Celsius -d '+ str(now) 
        os.system(env)

    if variable == "Hum":
        humidity = sensor.relative_humidity
        env='python jsonPython.py -p '+ protocolo +' -n '+ nodeid +' -s Humidity -v '+ '{0}%'.format(humidity) +' -m percent -d '+ str(now) 
        os.system(env)

while True:

    msg = subscribe.simple("req_l", hostname="192.168.4.1")
    data = msg.payload
    datos = data.decode('ASCII')

    datajson = json.loads(datos)

    for parametro in datajson['conf_l']:
        for sensor in parametro['sensor']:
            x = sensor['type']
            y = sensor['protocol']
            sensado(x,y)
