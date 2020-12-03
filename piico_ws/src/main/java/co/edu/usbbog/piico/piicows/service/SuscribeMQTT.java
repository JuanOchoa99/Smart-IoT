package co.edu.usbbog.piico.piicows.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Log;
import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;
import co.edu.usbbog.piico.piicows.repository.mysql.IPuertaDeEnlaceRepository;

@Service
public class SuscribeMQTT implements MqttCallback {

	@Autowired(required = true)
	private LogService logService;
	private PuertaEnlaceService puertaEnlaceService;
	public GatewayDAO gatewayDAO;
	private IPuertaDeEnlaceRepository repo;
	LocalDateTime fecha;

	public SuscribeMQTT() {
		gatewayDAO = new GatewayDAO();
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("desconectado " + cause.getMessage() + " " + cause.fillInStackTrace());

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String data = new String(message.getPayload());
		System.out.println("Topico: "+topic);
		JSONObject jsonObject = new JSONObject(data);
		if(topic.equals("sta_j")) {
			
		}else if(topic.equals("sen_j")) {
			Gateway n = new Gateway().fromJson(jsonObject);
			System.out.println("OBJETO Gateway: " + n.toString());
			gatewayDAO.create(n);
		}
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("completado");
	}
	public void prueba() {
		String topic = "sta_j";
		int qos = 2;
		String broker = "tcp://mqtt.eclipse.org:1883";
		String clientId = "AsyncPIICO";
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttAsyncClient sampleClient = new MqttAsyncClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			sampleClient.setCallback(this);
			System.out.println("Connecting to broker: " + broker);
			sampleClient.connect(connOpts);
			System.out.println("Connected");
			Thread.sleep(1000);
			String topic2 = "sen_j";
			sampleClient.subscribe(topic, qos);
			sampleClient.subscribe(topic2, qos);
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
}
