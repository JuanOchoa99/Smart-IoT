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
        String mensaje = "{\"Gateway_id\":\"S-PIICO\",\"date\":\"2016,4,8,11,43,54,920632\",\"interfaces\":[{\"type\":\"wifi\",\"state\":\"active\",\"dir\":\"192.168.0.5\",\"mac\":\"A3545ETR456D\"},{\"type\":\"blue\",\"state\":\"active\",\"mac\":\"A3545ETR456D\"},{\"type\":\"xbee\",\"state\":\"active\",\"mac\":\"A3545ETR456D\"}],\"nodes\":[{\"node_id\":\"estación 1\",\"date\":\"datetime.datetime(2016, 4, 8, 11, 43, 54, 920632)\",\"state\":\"send\",\"broker\":{\"ip\":\"192.126.0.4\",\"port\":\"1883\",\"qos\":\"2\",\"user\":\"gateway\",\"publish\":[],\"sucribe\":[]},\"interfaces\":[{\"type\":\"wifi\",\"state\":\"active\",\"dir\":\"192.168.0.5\",\"mac\":\"A3545ETR456D\"},{\"type\":\"blue\",\"state\":\"active\",\"mac\":\"A3545ETR456D\",\"mode\":\"direct\"},{\"type\":\"xbee\",\"state\":\"active\",\"pan_id\":\"1234\",\"mac\":\"A3545ETR456D\"}],\"sensors\":[{\"sensor_id\":\"temperature\",\"state\":\"active\"},{\"sensor_id\":\"humidity\",\"state\":\"active\"},{\"sensor_id\":\"velocity\",\"state\":\"active\"},{\"sensor_id\":\"Direction\",\"state\":\"active\"},{\"sensor_id\":\"Pluviometer\",\"state\":\"active\"},{\"sensor_id\":\"Radiation\",\"state\":\"active\"}],\"actuators\":[{\"actuator_id\":\"Aspersor\",\"state\":\"active\"},{\"actuator_id\":\"RGB\",\"state\":\"active\"}]}]}";
        MqttMessage mqttMessage = new MqttMessage(mensaje.getBytes());
        mqttMessage.setQos(messagePublishModel.getQos());
        mqttMessage.setRetained(messagePublishModel.getRetained());

        Mqtt.getInstance().publish(messagePublishModel.getTopic(), mqttMessage);
    }

}
