package co.edu.usbbog.piico.piicows.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mysql.ISensorRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class SensorService implements ISensorService{
	
	@Autowired
	private ISensorRepository sensorRepo;

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
	public JSONObject history(Sensor sensor, Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public JSONObject realTime(Sensor sensor, Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

}
