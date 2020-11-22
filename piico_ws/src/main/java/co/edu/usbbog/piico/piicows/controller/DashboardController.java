package co.edu.usbbog.piico.piicows.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController {
	
	private static Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
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