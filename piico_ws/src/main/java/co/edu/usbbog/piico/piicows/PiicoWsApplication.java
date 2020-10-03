package co.edu.usbbog.piico.piicows;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import co.edu.usbbog.piico.piicows.config.MongoConfig;
import co.edu.usbbog.piico.piicows.model.mongo.GPS;
import co.edu.usbbog.piico.piicows.model.mongo.Nodo;
import co.edu.usbbog.piico.piicows.model.mongo.Sensor;
import co.edu.usbbog.piico.piicows.repository.INodoMongoRepository;

@SpringBootApplication
public class PiicoWsApplication {
	String node_id = "";
	String date = "";
	GPS gps;
	Nodo nodo;
	float lat;
	float lon;
	ArrayList<Sensor> sensores;
	Sensor sensor;

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}

	public static void main(String[] args) {
		SpringApplication.run(PiicoWsApplication.class, args);
		PiicoWsApplication piico = new PiicoWsApplication();
		piico.prueba();
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
			clienteJava.setCallback(new MqttCallback() {
				@Override
				public void messageArrived(String topic, MqttMessage message) {
					String data = new String(message.getPayload());
					JSONObject jsonObject = new JSONObject(data);
					System.out.println("OBJETO JSON: " + jsonObject);
					String key;
					Iterator<String> iter = jsonObject.keys();
					while (iter.hasNext()) {
						key = iter.next();
						try {
							Object value = jsonObject.get(key);
							System.out.println("Entrando");
							System.out.println("." + key + ".");
							System.out.println(jsonObject);
							node_id = value.toString();
							System.out.println("GET: " + getNode_id());
							if (key.equals("node_id")) {
								System.out.println("AdentroNodeID");
								node_id = value.toString();
								System.out.println("Saliendo");
							} else if (key.equals("date")) {
								System.out.println("AdentroDate");
								date = value.toString();
								System.out.println("SaliendoDate");
							} else if (key.equals("sensors")) {
								System.out.println("ENTRANDO SENSOR");
								JSONArray array = new JSONArray(value.toString());
								System.out.println(array);
								sensores = new ArrayList<Sensor>();
								for (int i = 0; i < array.length(); i++) {
									sensor = new Sensor();
									JSONObject jsonObject1 = (JSONObject) array.get(i);

									System.out.println("DATOS DEL USUARIO: " + i);
									String type = jsonObject1.get("type").toString();
									System.out.println(type);
									sensor.setType(type);
									sensor.setSensor_id(jsonObject1.get("sensor_id").toString());
									sensor.setMagnitude(jsonObject1.get("magnitude").toString());
									sensor.setValue(jsonObject1.get("value").toString());
									sensores.add(sensor);

								}
								for (int i = 0; i < sensores.size(); i++) {
									System.out.println("Listado; " + sensores.get(i));
								}

							} else if (key.equals("gps")) {
								gps = new GPS();
								Iterator<String> iter2 = jsonObject.getJSONObject(key).keys();
								while (iter2.hasNext()) {
									String keyGps = iter2.next();
									Object value2 = jsonObject.getJSONObject(key).get(keyGps);
									System.out.println("key" + keyGps);
									System.out.println("values" + value2.toString());
									if (keyGps.equals("lat")) {
										lat = Float.parseFloat(value2.toString());
										System.out.println(lat);
										gps.setLat(lat);
									} else if (keyGps.equals("lon")) {
										lon = Float.parseFloat(value2.toString());
										System.out.println(lon);
										gps.setLon(lon);
									}

								}

							}
						} catch (JSONException e) {
							System.out.println("error: " + e);
						}
						/*Profe para revisar esta parte de alamcenamiento en la base de datos
						 * MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
						 MongoDatabase database = mongoClient.getDatabase("piico_db");
						MongoCollection<Nodo> collection = database.getCollection("sen_p", Nodo.class);
						nodo = new Nodo(node_id, date, gps, sensores);
						collection.insertOne(nodo);
						System.out.println("Se guardo");*/
					}

					// Nodo nodo = new Nodo();
					// nodo.toJson(jsonObject);

				}

				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
					// TODO Auto-generated method stub

				}

				@Override
				public void connectionLost(Throwable cause) {
					// TODO Auto-generated method stub
					System.out.println("Error: " + cause);
				}

			});
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

	public void ProbarJson() {
		String data = new String(
				"{\"node_id\":\"estacion 1\",\"date\":\"2016,4,8,11,43,54,920632\",\"gps\":{\"lon\":4.25,\"lat\":4.8},\"sensors\":[{\"type\":\"tem\",\"sensor_id\":\"Temperature\",\"value\":\"0.0\",\"magnitude\":\"Celsius\"},{\"type\":\"hum\",\"sensor_id\":\"Humidity\",\"value\":\"0.0\",\"magnitude\":\"percent\"},{\"type\":\"vel\",\"sensor_id\":\"Velocity\",\"value\":\"0.0\",\"magnitude\":\"Km/h\"},{\"type\":\"dir\",\"sensor_id\":\"Direction\",\"value\":\"North\",\"magnitude\":\"Cardinal_point\"},{\"type\":\"plu\",\"sensor_id\":\"Pluviometer\",\"value\":\"0.0\",\"magnitude\":\"mm3\"},{\"type\":\"rad\",\"sensor_id\":\"Radiation\",\"value\":\"0.0\",\"magnitude\":\"W/m2\"}]}");
		JSONObject jsonObject = new JSONObject(data);
		System.out.println("OBJETO JSON: " + jsonObject);
		String key;
		Iterator<String> iter = jsonObject.keys();
		while (iter.hasNext()) {
			key = iter.next();
			try {
				Object value = jsonObject.get(key);
				System.out.println("Entrando");
				System.out.println("." + key + ".");
				System.out.println(jsonObject);
				node_id = value.toString();
				System.out.println("GET: " + getNode_id());
				if (key.equals("node_id")) {
					System.out.println("AdentroNodeID");
					node_id = value.toString();
					System.out.println("Saliendo");
				} else if (key.equals("date")) {
					System.out.println("AdentroDate");
					date = value.toString();
					System.out.println("SaliendoDate");
				} else if (key.equals("sensors")) {
					System.out.println("ENTRANDO SENSOR");
					JSONArray array = new JSONArray(value.toString());
					System.out.println(array);
					sensores = new ArrayList<Sensor>();
					for (int i = 0; i < array.length(); i++) {
						sensor = new Sensor();
						JSONObject jsonObject1 = (JSONObject) array.get(i);

						System.out.println("DATOS DEL USUARIO: " + i);
						String type = jsonObject1.get("type").toString();
						System.out.println(type);
						sensor.setType(type);
						sensor.setSensor_id(jsonObject1.get("sensor_id").toString());
						sensor.setMagnitude(jsonObject1.get("magnitude").toString());
						sensor.setValue(jsonObject1.get("value").toString());
						sensores.add(sensor);

					}
					for (int i = 0; i < sensores.size(); i++) {
						System.out.println("Listado; " + sensores.get(i));
					}

				} else if (key.equals("gps")) {
					gps = new GPS();
					Iterator<String> iter2 = jsonObject.getJSONObject(key).keys();
					while (iter2.hasNext()) {
						String keyGps = iter2.next();
						Object value2 = jsonObject.getJSONObject(key).get(keyGps);
						System.out.println("key" + keyGps);
						System.out.println("values" + value2.toString());
						if (keyGps.equals("lat")) {
							lat = Float.parseFloat(value2.toString());
							System.out.println(lat);
							gps.setLat(lat);
						} else if (keyGps.equals("lon")) {
							lon = Float.parseFloat(value2.toString());
							System.out.println(lon);
							gps.setLon(lon);
						}

					}

				}
			} catch (JSONException e) {
				System.out.println("error: " + e);
			}
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			 MongoDatabase database = mongoClient.getDatabase("piico_db");
			MongoCollection<Nodo> collection = database.getCollection("sen_p", Nodo.class);
			nodo = new Nodo(node_id, date, gps, sensores);
			collection.insertOne(nodo);
			System.out.println("Se guardo");
		}
	}

}
