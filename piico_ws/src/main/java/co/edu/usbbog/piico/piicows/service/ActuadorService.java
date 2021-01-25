package co.edu.usbbog.piico.piicows.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.jsr310.LocalDateTimeCodec;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.Estacion;
import co.edu.usbbog.piico.piicows.model.mongo.ActuadorAct_p;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.NodoAct_p;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;
import co.edu.usbbog.piico.piicows.repository.mysql.ISensorRepository;

@Service
public class ActuadorService implements IActuadorService {
	@Autowired
	private ISensorRepository sensorRepo;
	private GatewayDAO gatewayDAO = new GatewayDAO();

	@Override
	public List<Actuador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actuador findById(String actuador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Actuador actuador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String actuador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Actuador actuador) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject construirAct_p(JSONArray nodos) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Gateway_id", "Gateway_1");
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDate date = dateTime.toLocalDate();
		System.out.println("Fecha: " + date);
		jsonObject.put("date", date);
		List<NodoAct_p> lista = new ArrayList<NodoAct_p>();
		for (int i = 0; i < nodos.length(); i++) {
			NodoAct_p nodo = new NodoAct_p();
			nodo.setNode_id(nodos.getJSONObject(i).getString("node_id"));
			nodo.setDate(date);
			nodo.setRequest("send");
			ActuadorAct_p aspersor = new ActuadorAct_p();
			ActuadorAct_p rgb = new ActuadorAct_p();
			if(nodos.getJSONObject(i).getBoolean("activate")) {
				aspersor.setActuadorId("aspersor");
				aspersor.setOrder("active");
				rgb.setActuadorId("RGB");
				rgb.setOrder("active");
			}else {
				aspersor.setActuadorId("aspersor");
				aspersor.setOrder("disable");
				rgb.setActuadorId("RGB");
				rgb.setOrder("disable");
			}
			List<ActuadorAct_p> actuadores = new ArrayList<ActuadorAct_p>();
			actuadores.add(aspersor);
			actuadores.add(rgb);
			nodo.setActuadores(actuadores);
			lista.add(nodo);
		}
		jsonObject.put("nodos", lista);
		return jsonObject;
	}

	private List<NodoAct_p> convertJsonArrayEstacion(JSONArray valores) {
		List<NodoAct_p> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new NodoAct_p().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}

}
