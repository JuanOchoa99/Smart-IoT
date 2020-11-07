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

import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.service.PuertaEnlaceService;
import co.edu.usbbog.piico.piicows.service.SensorService;

@RestController
@CrossOrigin
@RequestMapping("/puertaEnlace")
public class PuertaEnlaceController {
	private static Logger logger = LoggerFactory.getLogger(ControlAreaController.class);
	
	@Autowired
	private PuertaEnlaceService puertaDeEnlaceService;
	
	@PostMapping(value="/save")
	public @ResponseBody String save(@RequestBody PuertaDeEnlace puertaDeEnlace) {
		String mg = "";
		return mg;
	}
	
	@PostMapping(value="/delete")
	public @ResponseBody String delete(@RequestBody String puertaDeEnlace) {
		String mg = "";
		return mg;
	}
	
	@PostMapping(value="/alter")
	public @ResponseBody String alter(@RequestBody PuertaDeEnlace puertaDeEnlace) {
		String mg = "";
		return mg;
	}
	
	@GetMapping(value="/count")
	public @ResponseBody String contarPuertaDeEnlace() {
		String mg = "";
		return mg;
	}
	
	@PostMapping(value="/find")
	public @ResponseBody String find(@RequestBody String puertaDeEnlace) {
		String mg = "";
		return mg;
	}
	
	@GetMapping(value="/list")
	public @ResponseBody String list() {
		String mg = "";
		return mg;
	}
}