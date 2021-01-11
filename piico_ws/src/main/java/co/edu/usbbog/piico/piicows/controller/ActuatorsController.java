package co.edu.usbbog.piico.piicows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.service.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/actuators")
public class ActuatorsController {
	
	@Autowired
	private AuthService autService;
	
	@GetMapping(value="/listBroker")
	public @ResponseBody String listarBroker() {
		return autService.findAll().toString();
	}

}
