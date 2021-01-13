package co.edu.usbbog.piico.piicows.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.Estacion;
import co.edu.usbbog.piico.piicows.model.EstacionDashboard;
import co.edu.usbbog.piico.piicows.model.mongo.Data;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;
import co.edu.usbbog.piico.piicows.repository.mysql.INodoRepository;

@Service
public class NodoService implements INodoService{
	
	@Autowired
	private INodoRepository nodoRepo;
	private GatewayDAO gatewayDAO = new GatewayDAO();
	
	@Override
	public JSONArray findAll() {
		List<Gateway> gateways = gatewayDAO.find();
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					System.out.println(dato.getSensor_id());
					JSONObject json = new JSONObject();
					LocalDateTime date = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
					System.out.println(date);
					json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
					String numero = dato.getValue();
					json.put("price",numero);
					json.put("estacion",station.getNode_id());
					json.put("sensor", dato.getSensor_id());
					array.put(json);	
					
				}
			}
		}
		//System.out.println(array.toString());
		array = organizarData(array);
		return array;
	}
	private JSONArray organizarData(JSONArray valores) {
		System.out.println("Valores: " + valores.toString());
		List<EstacionDashboard> datos1 = convertJsonArrayEstacion(valores);
		datos1.sort(Comparator.comparing(EstacionDashboard::getDate));
		List<EstacionDashboard> datos = datos1;
		datos.sort(Comparator.comparing(EstacionDashboard::getNode_id));
		System.out.println("Datos: " + datos.toString());
		JSONArray resultado = new JSONArray();
		LocalDate dia = datos.get(0).getDate();
		String estacion = datos.get(0).getNode_id();
		System.out.println("Fecha: " + dia);
		System.out.println("Estacion: " + estacion);
		String valorTem = null, valorHum = null, valorVel = null, valorDir = null, valorPlu = null, valorSol = null;
		JSONObject json = new JSONObject();
		for (EstacionDashboard hd : datos) {
			if ((hd.getNode_id().equals(estacion))) {
				if (hd.getDate().isAfter(dia)) {
					if(hd.getSensor_id().equals("Temperature")){
						valorTem = hd.getPrice();
						System.out.println(valorTem);
					}else if(hd.getSensor_id().equals("Humidity")) {
						valorHum = hd.getPrice();
						System.out.println(valorHum);
					}else if(hd.getSensor_id().equals("wind_speed")) {
						valorVel = hd.getPrice();
					}else if(hd.getSensor_id().equals("Wind_direction")) {
						valorDir = hd.getPrice();
					}else if(hd.getSensor_id().equals("Pluviometer")) {
						valorPlu = hd.getPrice();
					}else if(hd.getSensor_id().equals("Solar_radiation")) {
						valorSol = hd.getPrice();
					}
				}
			}else{
				
				json.put("estacion", estacion);
				json.put("Temperature", valorTem);
				json.put("Humidity", valorHum);
				json.put("wind_speed", valorVel);
				json.put("Wind_direction", valorDir);
				json.put("Pluviometer", valorPlu);
				json.put("Solar_radiation", valorSol);
				
				dia = hd.getDate();
				estacion = hd.getNode_id();
				if(hd.getSensor_id().equals("Temperature")){
					valorTem = hd.getPrice();
				}else if(hd.getSensor_id().equals("Humidity")) {
					valorHum = hd.getPrice();
				}else if(hd.getSensor_id().equals("wind_speed")) {
					valorVel = hd.getPrice();
				}else if(hd.getSensor_id().equals("Wind_direction")) {
					valorDir = hd.getPrice();
				}else if(hd.getSensor_id().equals("Pluviometer")) {
					valorPlu = hd.getPrice();
				}else if(hd.getSensor_id().equals("Solar_radiation")) {
					valorSol = hd.getPrice();
				}
				System.out.println("Json Resultado: " + json);
				resultado.put(json);
				json = new JSONObject();

			}
		}
		json.put("estacion", estacion);
		json.put("Temperature", valorTem);
		json.put("Humidity", valorHum);
		json.put("wind_speed", valorVel);
		json.put("Wind_direction", valorDir);
		json.put("Pluviometer", valorPlu);
		json.put("Solar_radiation", valorSol);
		System.out.println("Json Resultado: " + json);
		resultado.put(json);
		json = new JSONObject();
		return resultado;
	}

	@Override
	public Nodo findById(String nodo) {
		try {
			System.out.println(nodoRepo.findById(nodo).get());
			return nodoRepo.findById(nodo).get();
		}catch(java.util.NoSuchElementException e) {
			return null;
		}
	}
	
	private List<EstacionDashboard> convertJsonArrayEstacion(JSONArray valores) {
		List<EstacionDashboard> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new EstacionDashboard().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}

	@Override
	public Boolean save(Nodo nodo) {
		if (findById(nodo.getId()) == null){
			nodoRepo.save(nodo);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean deleteById(String nodo) {
		if (findById(nodo) != null){
			nodoRepo.deleteById(nodo);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Long count() {
		return nodoRepo.count();
	}

	@Override
	public Boolean alter(Nodo nodo) {
		if (findById(nodo.getId()) != null){
			nodoRepo.save(nodo);
			return true;
		}else {
			return false;
		}
	}

}
