package co.edu.usbbog.piico.piicows.controller;

import java.time.LocalDate;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.model.mongo.Data;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;
import co.edu.usbbog.piico.piicows.service.SensorService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/sensor")
public class SensorsController {
	
	private static Logger logger = LoggerFactory.getLogger(ControlAreaController.class);
	
	@Autowired
	private SensorService sensorService;
	
	@PostMapping(value="/save")
	public @ResponseBody String save(@RequestBody Data data) {
		return null;
	}
	
	@PostMapping(value="/delete")
	public @ResponseBody String delete(@RequestBody String sensor) {
		return null;
	}
	
	@PostMapping(value="/alter")
	public @ResponseBody String alter(@RequestBody Data data) {
		return null;
	}
	
	@GetMapping(value="/count")
	public @ResponseBody String count() {
		return null;
	}
	
	@PostMapping(value="/find")
	public @ResponseBody String find(@RequestBody String sensor) {
		return null;
	}
	
	@PostMapping(value="/list")
	public @ResponseBody String listarSensor(@RequestBody String filtro) {
		
		JSONObject jsonObject = new JSONObject(filtro);
		
		String station = jsonObject.getString("station");
		String variable = jsonObject.getString("variable");
		String escala = jsonObject.getString("escala");
		System.out.println("1"+variable);
		System.out.println("2"+station);
		JSONObject respuesta = new JSONObject();
		respuesta.put("data", sensorService.history(station, variable, escala));
		return sensorService.history(station, variable, escala).toString();
	}
	
	@PostMapping(value="/findByDate")
	public @ResponseBody String findByDate(@RequestBody String filtro) {
		
		JSONObject jsonObject = new JSONObject(filtro);
		
		String fecha = jsonObject.getString("date");
		String escala = jsonObject.getString("escala");
		JSONObject respuesta = new JSONObject();
		//respuesta.put("data", sensorService.history(station, variable, escala));
		//return sensorService.history(station, variable, escala).toString();
		return null;
	}
	
	@PostMapping(value="/balance")
	public @ResponseBody String balance(@RequestBody String filtro) {
		
		JSONObject jsonObject = new JSONObject(filtro);
		
		String escala = jsonObject.getString("escala");
		String sensor = jsonObject.getString("sensor");
		String variable = jsonObject.getString("variable");
		LocalDate fechaIni = LocalDate.parse(jsonObject.getString("fechaIni"));
		LocalDate fechaFin = LocalDate.parse(jsonObject.getString("fechaFin"));
		
		System.out.println("Escala"+escala);
		System.out.println("Sensor"+sensor);
		System.out.println("variable"+variable);
		JSONObject respuesta = new JSONObject();
		return sensorService.comparativa(sensor, escala, variable, fechaIni, fechaFin).toString();
	}
	
	@GetMapping(value="/map")
	public @ResponseBody String map() {
		
		return sensorService.mapa().toString();
	}
	
	/**
	 * 
	 * 	@PostMapping(value="/findLast")
		public @ResponseBody String findLast(@RequestBody String filtro) {
			
			JSONObject jsonObject = new JSONObject(filtro);
			
			String station = jsonObject.getString("station");
			String variable = jsonObject.getString("variable");
			
			System.out.println("1"+variable);
			System.out.println("2"+station);
			JSONObject respuesta = new JSONObject();
			respuesta.put("data", sensorService.history(station, variable, escala));
			return sensorService.history(station, variable, escala).toString();
		}
	 * @param filtro
	 * @return
	 */

	
	
	 
}
