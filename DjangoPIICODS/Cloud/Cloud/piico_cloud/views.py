import requests
from django.shortcuts import render



# Create your views here.
def dashboard(request):
    return render(request, "Dashboard.html")
def temperatura(request):
    url = "http://localhost:3500/sensor/findByDate"
    payload="{\r\n    \"date\": \"2020-12-03\",\r\n    \"escala\":\"max\",\r\n    \"variable\":\"Temperature\"\r\n}"
    headers = {
    'Content-Type': 'application/json'
    }
    response = requests.request("POST", url, headers=headers, data=payload)
    nodos = response.json()
    print("RESPUESTA: ->",nodos)
    return render(request, "Temperatura.html", {"nodos": nodos})
def inicio(request):
    return render(request, "Inicio.html")
def aspersor(request):
    return render(request, "Aspersor.html")
def broker_pub(request):
    return render(request, "BrokerPub.html")
def broker_sub(request):
    return render(request, "BrokerSub.html")
def gateway(request):
    return render(request, "Gateway.html")
def humedad(request):
    return render(request, "Humedad.html")
def pluviometro(request):
    return render(request, "Pluviometro.html")
def radiacion(request):
    return render(request, "Radiacion.html")
def anemometro(request):
    return render(request, "Anemometro.html")
def direccion_viento(request):
    return render(request, "DireccionViento.html")