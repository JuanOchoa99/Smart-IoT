'''
Created on 27/02/2020

@author: aasanchez
'''

import argparse
from logic.ConfigTools import Station

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
    required=True,
    nargs=1,
    type=str,
    help='nombre identificador del nodo'
)
parser.add_argument(
    '-p','--pass', '--password',
    dest='password',
    required=True,
    nargs=1,
    type=str,
    help='Contraseña identificador del actuador a activar'
)
    
def main():     
    args = parser.parse_args()
    estacion=args.name
    password = args.password
    print('la estacion es: ', estacion)
    print('La contraseña del actuador se registro')

if  __name__ ==  '__main__':
    main()
