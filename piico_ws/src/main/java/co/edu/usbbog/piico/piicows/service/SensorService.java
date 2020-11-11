package co.edu.usbbog.piico.piicows.service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import co.edu.usbbog.piico.piicows.model.mongo.Data;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;
import co.edu.usbbog.piico.piicows.repository.mysql.ISensorRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class SensorService implements ISensorService{
	
	@Autowired
	private ISensorRepository sensorRepo;
	
	
	private GatewayDAO gatewayDAO = new GatewayDAO();

	@Override
	public List<Sensor> sensores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor buscar(String sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean crear(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remover(String sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean modificar(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean asignarNodo(Sensor sensor, Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray history(String stationIn, String variable) {
		List<Gateway> gateways = gatewayDAO.findByNodo(stationIn);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals(variable)) {
						JSONObject json = new JSONObject();
						LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						LocalDate date = dateTime.toLocalDate();
						System.out.println(date);
						json.put("date", date);
						json.put("price",dato.getValue());
						array.put(json);		
						
					}
				}
			}
		}
		System.out.println(array.toString());
		return array;

	}

	@Override
	public JSONObject comparativa(Sensor sensor, LocalDateTime inicio, LocalDateTime fin, String escala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject estados(Sensor sensor, LocalDateTime fecha, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject realTime(Sensor sensor, Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
