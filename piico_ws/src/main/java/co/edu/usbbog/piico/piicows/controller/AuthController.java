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

import co.edu.usbbog.piico.piicows.model.mysql.Auth;
import co.edu.usbbog.piico.piicows.service.AuthService;
import co.edu.usbbog.piico.piicows.service.PuertaEnlaceService;

@RestController
@CrossOrigin
@RequestMapping("/piico/auth")
public class AuthController {
private static Logger logger = LoggerFactory.getLogger(ControlAreaController.class);
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value="/save")
	public @ResponseBody String save(@RequestBody Auth auth) {
		String mg = "";
		return mg;
	}
	
	@PostMapping(value="/delete")
	public @ResponseBody String delete(@RequestBody String auth) {
		String mg = "";
		return mg;
	}
	
	@PostMapping(value="/alter")
	public @ResponseBody String modificarRol(@RequestBody Auth auth) {
		String mg = "";
		return mg;
	}
	
	@GetMapping(value="/count")
	public @ResponseBody String contarAuth() {
		String mg = "";
		return mg;
	}
	
	@PostMapping(value="/find")
	public @ResponseBody String find(@RequestBody String auth) {
		String mg = "";
		return mg;
	}
	
	@GetMapping(value="/list")
	public @ResponseBody String list() {
		String mg = "";
		return mg;
	}
}
