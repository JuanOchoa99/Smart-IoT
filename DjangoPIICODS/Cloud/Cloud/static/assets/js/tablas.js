$(document).ready(function(){
    console.log("Se esta ejecutando este scripts???????????")
        var estacion = $("#valorNodo").val()
        console.log("Estacion: "+estacion)
        var station = "";
        if(estacion == "01"){
            station = "estacion_1"
        }
        if(estacion == "02"){
            station = "estacion_2"
        }
        if(estacion == "03"){
            station = "estacion_3"
        }
        console.log("Estacion: "+station)
        var settings = {
            "url": "http://localhost:3500/sensor/findValue",
            "method": "POST",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify({"estacion":station,"variable":sensor}),
          };
          console.log("Estacion: "+station)
          $.ajax(settings).done(function (response) {
            console.log(response);
            data = JSON.parse(response)
            for(let valor of data){
                $("#valorActual").html('')
                $("#valorActual").append('<canvas id="valorActual" data-type="radial-gauge" data-value='+valor.valor+' data-width="300" data-height="300" data-bar-width="10" data-bar-shadow="5" data-units="°C" data-color-bar-progress="rgba(50,200,50,.75)"></canvas>')
                console.log(valor.valor+"  estacion: "+valor.estacion)
            }
          });
});