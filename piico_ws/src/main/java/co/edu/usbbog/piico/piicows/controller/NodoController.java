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
import co.edu.usbbog.piico.piicows.service.NodoService;
import co.edu.usbbog.piico.piicows.service.SensorService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/nodo")
public class NodoController {
	
	private static Logger logger = LoggerFactory.getLogger(ControlAreaController.class);
	
	@Autowired
	private NodoService nodoService;
	
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
	
	@GetMapping(value="/list")
	public @ResponseBody String listarSensor() {
	
		JSONObject respuesta = new JSONObject();
		respuesta.put("data", nodoService.findAll());
		return nodoService.findAll().toString();
	}
	@GetMapping(value="/find")
	public @ResponseBody String listarNodos() {
	
		return nodoService.find().toString();
	}


	
	
	 
}
