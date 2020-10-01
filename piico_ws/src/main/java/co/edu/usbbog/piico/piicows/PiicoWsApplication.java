package co.edu.usbbog.piico.piicows;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.gson.Gson;

import co.edu.usbbog.piico.piicows.model.mongo.Nodo;
import co.edu.usbbog.piico.piicows.repository.INodoMongoRepository;

@SpringBootApplication
public class PiicoWsApplication {


	public static void main(String[] args) {
		SpringApplication.run(PiicoWsApplication.class, args);
		prueba();
	}

	public static void prueba() {  
		MqttClient clienteJava;
		MqttConnectOptions connectOptions;
		String topic = "sen_p";
		String broker = "tcp://mqtt.eclipse.org:1883";
		String clientID = MqttClient.generateClientId();
		Boolean pub = true;
		Boolean subs = true;
		connectOptions = new MqttConnectOptions();        
		connectOptions.setCleanSession(true);
		connectOptions.setKeepAliveInterval(50);
		try{
			clienteJava = new MqttClient(broker, clientID);
			clienteJava.setCallback(new MqttCallback() {

				@Override
				public void connectionLost(Throwable cause) {
					// TODO Auto-generated method stub

				}

				@Override
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					String data = new String(message.getPayload());
					JSONObject jsonObject = new JSONObject(data);
					System.out.println("imp: " + jsonObject);
					//Nodo nodo = new Gson().toJson(jsonObject.stringToValue(data),Nodo.class);

				}

				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
					// TODO Auto-generated method stub

				}

			});
			clienteJava.connect(connectOptions);
			int subQoS = 2;
			clienteJava.subscribe(topic,subQoS);
			
		}catch(MqttException e){
			e.printStackTrace();
			System.exit(-1);
		}    
	}

}
