package co.edu.usbbog.piico.piicows.controller;


import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.config.Mqtt;
import co.edu.usbbog.piico.piicows.config.exceptions.ExceptionMessages;
import co.edu.usbbog.piico.piicows.config.exceptions.MqttException;
import co.edu.usbbog.piico.piicows.model.mqtt.Req_p;

@RestController
@RequestMapping(value = "/api/mqtt")
public class Controlador {
	
	@PostMapping("publish")
    public void publishMessage(@RequestBody @Validated Req_p messagePublishModel,
                               BindingResult bindingResult) throws org.eclipse.paho.client.mqttv3.MqttException {
        if (bindingResult.hasErrors()) {
            throw new MqttException(ExceptionMessages.SOME_PARAMETERS_INVALID);
        }
        String mensaje = "{\"node_id\": \"Prueba de confifuracion 5454\", \"date\": \"2020-08-30 21:57:36.608547\", \"sampling_frequency\": 5, \"send_frequency\": 7, \"broker\": {\"broker_address\": \"mqtt.eclipse.org\", \"port\": \"1883\", \"qos\": \"2\", \"user\": \"gateway\", \"pass\": \"123456\"}, \"interfaces\": [{\"type\": \"wifi\", \"ssid\": \"Piico\", \"psk\": \"thisismywirelesspassword\"}, {\"type\": \"blue\", \"alias\": \"Gateway_PIICO\", \"mac\": \"A3545ETR456D\"}, {\"type\": \"xbee\", \"state\": \"active\", \"pan_id\": \"154\", \"mac\": \"A3545ETR456D\"}], \"sensors\": [{\"type\": \"tem\", \"state\": \"active\", \"sensor_id\": \"AM2315-temperature\"}, {\"type\": \"hum\", \"state\": \"active\", \"sensor_id\": \"AM2315-humidity\"}, {\"type\": \"vel\", \"state\": \"active\", \"sensor_id\": \"Wind-speed\"}, {\"type\": \"dir\", \"state\": \"active\", \"sensor_id\": \"Wind-direction\"}, {\"type\": \"plu\", \"state\": \"active\", \"sensor_id\": \"Pluviometer\"}, {\"type\": \"rad\", \"state\": \"active\", \"sensor_id\": \"Solar-radiation\"}], \"actuators\": [{\"type\": \"asp\", \"state\": \"active\", \"actuator_id\": \"Lawn-sprinkler\"}, {\"type\": \"led\", \"state\": \"active\", \"actuator_id\": \"RGB\"}]}";
        MqttMessage mqttMessage = new MqttMessage(mensaje.getBytes());
        mqttMessage.setQos(messagePublishModel.getQos());
        mqttMessage.setRetained(messagePublishModel.getRetained());

        Mqtt.getInstance().publish(messagePublishModel.getTopic(), mqttMessage);
    }
}
