package co.edu.usbbog.piico.piicows.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.model.mysql.Auth;

@RestController
@CrossOrigin
@RequestMapping("/charts")
public class ChartsController {
	private static Logger logger = LoggerFactory.getLogger(ControlAreaController.class);
	
	@PostMapping(value="/history")
	public @ResponseBody String history(@RequestBody String nodo) {
		String mg = "";
		return mg;
	}
	
	@GetMapping(value="/find")
	public @ResponseBody String find(@RequestBody LocalDateTime date) {
		String mg = "";
		return mg;
	}
	
	@GetMapping(value="/state")
	public @ResponseBody String state(@RequestBody String nodo) {
		String mg = "";
		return mg;
	}
}
