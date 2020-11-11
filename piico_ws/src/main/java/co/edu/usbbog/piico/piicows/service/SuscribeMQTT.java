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
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;

@Service
public class SuscribeMQTT implements MqttCallback{
	
	
	public GatewayDAO gatewayDAO;


	public SuscribeMQTT() {
		gatewayDAO = new GatewayDAO();
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("desconectado " + cause.getMessage()+" "+cause.fillInStackTrace());
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String data = new String(message.getPayload());
		System.out.println("OBJETO Gateway: " + data);
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
		String topic = "sen_j";
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
	
	/**
	 * Utilizar dos cliente diferentes (No creo que sea una opcion)
	 * MqttClient clienteJava = null;
		MqttConnectOptions connectOptions;
		String topic = "sta_p";
		String broker = "tcp://test.mosquitto.org:1883";
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
	 */
	
	/**
	 * 
	 * Utilizar un cliente Asincrono para poder recibir de distintos topicos 
	 *String[] topicFilters = {"sen_p","sta_p"};
	        int[] qos = {2,2};
	        String broker = "tcp://test.mosquitto.org:1883";
	        String clientId = "Sevin";
	        MemoryPersistence persistence = new MemoryPersistence();

	        try {
	            MqttAsyncClient sampleClient = new MqttAsyncClient(broker, clientId, persistence);
	            MqttConnectOptions connOpts = new MqttConnectOptions();
	            connOpts.setCleanSession(true);
	            sampleClient.setCallback(this);
	            System.out.println("Connecting to broker: " + broker); 
	            sampleClient.connect(connOpts);
	            System.out.println("Connected");
	            sampleClient.subscribe(topicFilters, qos);
	            System.out.println("Subscribed");
	        } catch (Exception me) {
	            if (me instanceof MqttException) {
	                System.out.println("reason " + ((MqttException) me).getReasonCode());
	            }
	            System.out.println("msg " + me.getMessage());
	            System.out.println("loc " + me.getLocalizedMessage());
	            System.out.println("cause " + me.getCause());
	            System.out.println("excep " + me);
	            me.printStackTrace();
	        }
	}
	 */

}
