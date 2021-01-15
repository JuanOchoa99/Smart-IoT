package co.edu.usbbog.piico.piicows.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.service.NodoService;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController {
	
	private static Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private NodoService nodoService;
	
	@GetMapping(value="/getPointToMap")
	public String getPointToMap() {
		return "";
	}
	
	@GetMapping(value="/getStations")
	public String getStations() {
		return "";
	}
	
	@GetMapping(value="/getPublishres")
	public String getPublishers() {
		return "";
	}
	
	@GetMapping(value="/getSuscribers")
	public String getSuscribers() {
		return "";
	}
	

}