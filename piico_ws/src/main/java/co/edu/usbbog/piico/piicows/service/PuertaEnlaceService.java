package co.edu.usbbog.piico.piicows.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Auth;
import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mysql.IActuadorRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.INodoRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IProtocoloRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IPuertaDeEnlaceRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.ISensorRepository;

@Service
public class PuertaEnlaceService implements IPuertaEnlaceService {

	@Autowired
	private IPuertaDeEnlaceRepository gatewayRepo;
	@Autowired
	private IProtocoloRepository protocoloRepo;
	@Autowired
	private INodoRepository nodoRepo;
	@Autowired
	private ISensorRepository sensorRepo;
	@Autowired
	private IActuadorRepository actuadorRepo;

	@Override
	public List<PuertaDeEnlace> findAll() {
		List<PuertaDeEnlace> puertaDeEnlace = gatewayRepo.findAll();
		return puertaDeEnlace;
	}

	@Override
	public PuertaDeEnlace findById(String idPuerta) {
		return gatewayRepo.findById(idPuerta).get();
	}

	@Override
	public Boolean save(PuertaDeEnlace puerta) {
		if (findById(puerta.getId()) == null) {
			gatewayRepo.save(puerta);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean deleteById(String idPuerta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(PuertaDeEnlace puerta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject crearConfiguracion(JSONObject config) {
		
		PuertaDeEnlace puertaDeEnlace = gatewayRepo.getOne("Gateway_1");
		System.out.println(puertaDeEnlace.toString());
		Nodo nodo  = new Nodo();
		nodo.setId(config.getString("node_id"));
		nodo.setDescripcion(config.getString("descripcion"));
		nodo.setEstado((byte)config.getInt("estado"));
		nodo.setProtocoloComunicacion("protocolo");
		nodo.setPuertaDeEnlaceBean(puertaDeEnlace);
		JSONArray inters = config.getJSONArray("interfaces");
		List<Protocolo> protocolos = convertJsonArrayProtocolo(inters);
		JSONArray sensores = config.getJSONArray("sensors");
		List<Sensor> sensors = convertJsonArraySensor(sensores);
		JSONArray actuadors = config.getJSONArray("actuators");
		List<Actuador> actuadores = convertJsonArrayActuador(actuadors);
		for (Protocolo protocolo : protocolos) {
			for (Sensor sensor : sensors) {
				for (Actuador actuador : actuadores) {
					actuador.setNodoBean(nodo);
					nodo.setActuadors(actuadores);
					actuadorRepo.save(actuador);
					System.out.println("Se almaceno en base de datos: "+actuador.toString());
				}
				sensor.setNodoBean(nodo);
				nodo.setSensors(sensors);
				sensorRepo.save(sensor);
				System.out.println("Se almaceno en base de datos: "+sensor.toString());
			}
			nodo.setProtocolos(protocolos);
			protocoloRepo.save(protocolo);
			System.out.println("Se almaceno en base de datos: "+protocolo.toString());
		}
		nodoRepo.save(nodo);
		
		JSONObject jsonConf = new JSONObject();
		jsonConf.put("Gateway_id","Gateway_1");
		jsonConf.put("node_id", config.getString("node_id"));
		jsonConf.put("date",config.getString("date"));
		jsonConf.put("sampling_frequency", config.getInt("sampling_frequency"));
		jsonConf.put("send_frequency", config.getInt("send_frequency"));
		JSONObject broker = new JSONObject();
		broker.put("broker_address","broker.hivemq.com");
		broker.put("port","1883");
		broker.put("qos", "2");
		broker.put("user", "gateway");
		broker.put("pass", "123456");
		jsonConf.put("broker", broker);
		JSONArray interfaces = new JSONArray();
		for (int i = 0; i < inters.length(); i++) {
			JSONObject json = inters.getJSONObject(i);
			JSONObject json1 = new JSONObject();
			if(json.getString("tipo").equals("wifi")) {
				json1.put("type", json.getString("tipo"));
				json1.put("ssid", json.getString("ssid"));
				json1.put("psk", json.getString("psk"));
				interfaces.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("tipo").equals("blue")){
				json1.put("type", json.getString("tipo"));
				json1.put("alias", json.getString("alias"));
				json1.put("mac", json.getString("mac"));
				interfaces.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("tipo").equals("xbee")) {
				json1.put("type", json.getString("tipo"));
				json1.put("state", json.getString("state"));
				json1.put("pan_id", json.getString("pan_id"));
				json1.put("mac", json.getString("mac"));
				interfaces.put(json1);
				json1 = new JSONObject();
			}
		}
		System.out.println(interfaces);
		jsonConf.put("interfaces", interfaces);
		JSONArray sens = new JSONArray();
		for (int i = 0; i < sensores.length(); i++) {
			JSONObject json = sensores.getJSONObject(i);
			JSONObject json1 = new JSONObject();
			if(json.getString("sensor_id").equals("Temperature")) {
				json1.put("type", json.getString("tipo"));
				if(json.getInt("estado") == 1) {
					json1.put("state", "active");
				}else {
					json1.put("state", "disable");
				}
				
				json1.put("sensor_id", json.getString("sensor_id"));
				sens.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("sensor_id").equals("Humidity")) {
				json1.put("type", json.getString("tipo"));
				if(json.getInt("estado") == 1) {
					json1.put("state", "active");
				}else {
					json1.put("state", "disable");
				}
				json1.put("sensor_id", json.getString("sensor_id"));
				sens.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("sensor_id").equals("Pluviometer")) {
				json1.put("type", json.getString("tipo"));
				if(json.getInt("estado") == 1) {
					json1.put("state", "active");
				}else {
					json1.put("state", "disable");
				}
				json1.put("sensor_id", json.getString("sensor_id"));
				sens.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("sensor_id").equals("Solar_radiation")) {
				json1.put("type", json.getString("tipo"));
				if(json.getInt("estado") == 1) {
					json1.put("state", "active");
				}else {
					json1.put("state", "disable");
				}
				json1.put("sensor_id", json.getString("sensor_id"));
				sens.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("sensor_id").equals("Wind_direction")) {
				json1.put("type", json.getString("tipo"));
				if(json.getInt("estado") == 1) {
					json1.put("state", "active");
				}else {
					json1.put("state", "disable");
				}
				json1.put("sensor_id", json.getString("sensor_id"));
				sens.put(json1);
				json1 = new JSONObject();
			}
			if(json.getString("sensor_id").equals("wind_speed")) {
				json1.put("type", json.getString("tipo"));
				if(json.getInt("estado") == 1) {
					json1.put("state", "active");
				}else {
					json1.put("state", "disable");
				}
				json1.put("sensor_id", json.getString("sensor_id"));
				sens.put(json1);
				json1 = new JSONObject();
			}
		}
		jsonConf.put("sensors",sens);
		JSONArray act = new JSONArray();
		for (int i = 0; i < actuadors.length(); i++) {
			JSONObject json = actuadors.getJSONObject(i);
			JSONObject json1 = new JSONObject();
				if(json.getString("actuator_id").equals("actuador_1")) {
					json1.put("type", json.getString("tipo"));
					if(json.getInt("estado") == 1) {
						json1.put("state", "active");
					}else {
						json1.put("state", "disable");
					}
					act.put(json1);
					json1 = new JSONObject();
				}
				if(json.getString("actuator_id").equals("actuador_2")) {
					json1.put("type", json.getString("tipo"));
					if(json.getInt("estado") == 1) {
						json1.put("state", "active");
					}else {
						json1.put("state", "disable");
					}
					act.put(json1);
					json1 = new JSONObject();
				}
		}
		jsonConf.put("actuators", act);
		System.out.println("CONF_P: "+jsonConf.toString());
		return jsonConf;
	}


	private List<Protocolo> convertJsonArrayProtocolo(JSONArray valores) {
		List<Protocolo> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new Protocolo().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}

	private List<Sensor> convertJsonArraySensor(JSONArray valores) {
		List<Sensor> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new Sensor().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}

	private List<Actuador> convertJsonArrayActuador(JSONArray valores) {
		List<Actuador> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new Actuador().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}
}
