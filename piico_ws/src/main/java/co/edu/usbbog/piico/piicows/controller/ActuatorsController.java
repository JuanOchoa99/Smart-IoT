package co.edu.usbbog.piico.piicows.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.service.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/piico/actuators")
public class ActuatorsController {
	
	@Autowired
	private AuthService autService;
	
	@PostMapping(value="/listBroker")
	public @ResponseBody String listarBroker(@RequestBody String tipo) {
		JSONObject json = new JSONObject(tipo);
		String broker = json.getString("tipo");
		System.out.println(autService.findAll(broker).toString());
		return autService.findAll(broker).toString();
	}

}
