package co.edu.usbbog.piico.piicows.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Nodo;
import co.edu.usbbog.piico.piicows.repository.GatewayDAO;
import co.edu.usbbog.piico.piicows.repository.NodoDAO;

@Service
public class SuscribeMQTT implements MqttCallback{
	
	public NodoDAO nodoDao;
	public GatewayDAO gatewayDAO;


	public SuscribeMQTT() {
		gatewayDAO = new GatewayDAO();
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("desconectado " + cause.getMessage());
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String data = new String(message.getPayload());
		JSONObject jsonObject = new JSONObject(data);
		Gateway n = new Gateway().fromJson(jsonObject);
		System.out.println("OBJETO Gateway: " + n.toString());
		gatewayDAO.create(n);
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("completado");
		
	}

	public void prueba() {
		MqttClient clienteJava = null;
		MqttConnectOptions connectOptions;
		String topic = "sen_p";
		String broker = "tcp://mqtt.eclipse.org:1883";
		String clientID = MqttClient.generateClientId();
		Boolean pub = true;
		Boolean subs = true;
		connectOptions = new MqttConnectOptions();
		connectOptions.setCleanSession(true);
		connectOptions.setKeepAliveInterval(50);
		try {
			clienteJava = new MqttClient(broker, clientID);
			clienteJava.setCallback(this);
			clienteJava.connect(connectOptions);

		} catch (MqttException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("Ha sido conectado al broker " + broker);

		// Preparando un tópico
		// MqttTopic Topico = clienteJava.getTopic(Topico);

		try {
			int subQoS = 2;
			clienteJava.subscribe(topic, subQoS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
