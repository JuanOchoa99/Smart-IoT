package co.edu.usbbog.piico.piicows.controller;


import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.config.Mqtt;
import co.edu.usbbog.piico.piicows.config.exceptions.ExceptionMessages;
import co.edu.usbbog.piico.piicows.config.exceptions.MqttException;
import co.edu.usbbog.piico.piicows.model.mqtt.Act_p;
import co.edu.usbbog.piico.piicows.service.ActuadorService;

@RestController
@CrossOrigin
@RequestMapping(value = "/piico/api/mqtt/publish")
public class Controlador {
	@Autowired
	private ActuadorService actuadorService;
	@PostMapping("act_p")
    public void publishMessage(@RequestBody @Validated String filtro,
                               BindingResult bindingResult) throws org.eclipse.paho.client.mqttv3.MqttException {
        if (bindingResult.hasErrors()) {
            throw new MqttException(ExceptionMessages.SOME_PARAMETERS_INVALID);
        }
        JSONArray nodos = new JSONArray(filtro);
        JSONObject act_p = actuadorService.construirAct_p(nodos); 
        String mensaje = act_p.toString();
        MqttMessage mqttMessage = new MqttMessage(mensaje.getBytes());
        mqttMessage.setQos(2);
        mqttMessage.setRetained(false);
        Mqtt.getInstance().publish("act_p", mqttMessage);
    }
}
