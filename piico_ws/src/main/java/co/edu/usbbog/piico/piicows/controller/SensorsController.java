package co.edu.usbbog.piico.piicows.controller;

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

import co.edu.usbbog.piico.piicows.model.mongo.Sensor;
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
	public @ResponseBody String save(@RequestBody Sensor sensor) {
		return null;
	}
	
	@PostMapping(value="/delete")
	public @ResponseBody String delete(@RequestBody String sensor) {
		return null;
	}
	
	@PostMapping(value="/alter")
	public @ResponseBody String alter(@RequestBody Sensor sensor) {
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
	public @ResponseBody String listarSensor() {
		return null;
	}
}
