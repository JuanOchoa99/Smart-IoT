package co.edu.usbbog.piico.piicows.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;

import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;

public interface ISensorService {
	public List<Sensor> sensores();
	public Sensor buscar(String sensor);
	public Boolean crear(Sensor sensor);
	public Boolean remover(String sensor);
	public Boolean modificar(Sensor sensor);
	public Boolean asignarNodo(Sensor sensor, Nodo nodo);
	public JSONObject history(Sensor sensor, Nodo nodo);
	public JSONObject comparativa(Sensor sensor, LocalDateTime inicio, LocalDateTime fin, String escala);
	public JSONObject estados(Sensor sensor, LocalDateTime fecha, String type);
	public JSONObject realTime(Sensor sensor, Nodo nodo);
}
