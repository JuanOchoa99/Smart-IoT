package co.edu.usbbog.piico.piicows.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/controlarea")
public class ControlAreaController {

	private static Logger logger = LoggerFactory.getLogger(ControlAreaController.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping(value="/getNotifications")
	public String getNotifications() {
		return "";
	}
	
	@GetMapping(value="/getActivities")
	public String getActivities() {
		return "";
	}
	
	@PostMapping(value="/config")
	public String config(@RequestBody String config) {
		return "";
	}
	
	
	@PostMapping(value="/login")
	public Boolean login(@RequestBody String userAndPass) {
		
		
		return null;
	}
	
	@PostMapping(value="/logout")
	public String logout() {
		return "";
	}
	
	@GetMapping(value="/getUserInfo")
	public String getUserInfo() {
		return "";
	}
	
	
}
