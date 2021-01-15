package co.edu.usbbog.piico.piicows.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.TablaBuscaValor;
import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Protocolo;
import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mysql.IPuertaDeEnlaceRepository;

@Service
public class PuertaEnlaceService implements IPuertaEnlaceService{
	
	@Autowired
	private IPuertaDeEnlaceRepository gatewayRepo;

	@Override
	public List<PuertaDeEnlace> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuertaDeEnlace findById(String idPuerta) {
		return  gatewayRepo.findById(idPuerta).get();
	}

	@Override
	public Boolean save(PuertaDeEnlace puerta) {
		if (findById(puerta.getId()) == null){
			gatewayRepo.save(puerta);
			return true;
		}else {
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
		
		JSONObject jsonConf = new JSONObject();
		JSONArray inters = config.getJSONArray("interfaces");
		List<Protocolo> protocolos = convertJsonArrayProtocolo(inters);
		System.out.println("Protocolos: "+ protocolos.toString());
		JSONArray sensores = config.getJSONArray("sensors");
		List<Sensor> sensors = convertJsonArraySensor(sensores);
		System.out.println("Sensores: "+sensors.toString());
		JSONArray actuadors = config.getJSONArray("actuators");
		List<Actuador> actuadores = convertJsonArrayActuador(actuadors);
		System.out.println("Actuadores: "+actuadores.toString());
		
		
		return null;
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
