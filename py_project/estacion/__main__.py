'''
Created on 27/02/2020

@author: aasanchez
'''

import argparse
parser = argparse.ArgumentParser(
    prog='Estacion PIICO USB',
    description='Comandos para el inicio de la estacion.',
    epilog="mas informacion en https://piico.ingusb.com",
    add_help=True
)
parser.add_argument(
    '-v','--version',
    dest='version',
    action='version',
    version='%(prog)s 1.0'
)
parser.add_argument(
    '-n','--name', '--nameid',
    dest='name',
    metavar='N',
    required=True,
    nargs=1,
    type=str,
    help='nombre identificador del nodo'
)
parser.add_argument(
    '-u','--ubi', '--ubiety',
    dest='ubiety',
    metavar='U',
    required=True,
    nargs=2,
    type=float,
    help='ubicacion gps Lat=xx.xxxxxx & Long=xx.xxxxxx'
)
parser.add_argument(
    '-p','--prot', '--protocols',
    dest='protocols',
    metavar='P',
    required=True,
    nargs='+',
    type=str,
    choices=['wifi', 'blue', 'xbee'],
    default=['wifi'],
    help='[wifi blue xbee]'
)
parser.add_argument(
    '-s','--sen', '--sensors',
    dest='sensors',
    metavar='S',
    required=False,
    nargs='*',
    type=str,
    choices=['all', 'tem', 'hum', 'vel', 'dir', 'plu', 'rad'],
    default=['all'],
    help='[all | tem hum vel dir plu rad]'
)
parser.add_argument(
    '-a','--act', '--actuators',
    dest='actuators',
    metavar='A',
    required=False,
    nargs='*',
    type=str,
    choices=['all', 'asp', 'led'],
    default=['all'],
    help='[all | asp led]'
)
parser.add_argument(
    '-g','--gw', '--gateway',
    dest='gateway',
    metavar='G',
    required=False,
    nargs='*',
    type=str,
    default=['IP=192.168.1.2'],
    help='direccion IP del gateway [IP=], direccion Zigbee del gateway [XB=], dirreccion bluetooth del gateway [BT=]'
)
parser.add_argument(
    '-b','--bk', '--broker',
    dest='broker',
    metavar='B',
    required=False,
    nargs='*',
    type=str,
    default=['IP=192.168.1.2'],
    help='direccion IP del broker [IP=], direccion Zigbee del broker [XB=], dirreccion bluetooth del broker [BT=]'
)
class Estacion():
    def __init__(self,IPGateway):
        self.__IPGateway=IPGateway
    def getIPGateway(self):
        return self.__IPGateway
    
def main():     
    args = parser.parse_args()
    print(args.name)
    print(args.ubiety)
    print(args.protocols)    
    print(args.sensors)
    print(args.actuators)
    print(args.gateway)
    print(args.broker)
    estacion=Estacion(str(args.gateway))
    print('la estacion es: ', estacion.getIPGateway())

if  __name__ ==  '__main__':
    main()
