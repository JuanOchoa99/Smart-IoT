package co.edu.usbbog.piico.piicows.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.PuertaEnlaceService;
import co.edu.usbbog.piico.piicows.service.RolService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;
@RestController
@CrossOrigin
@RequestMapping("/piico/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value="/save")
	public @ResponseBody String save(@RequestBody Usuario usuario) {
		String mg = "";
		if (usuarioService.registrar(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro ya existe"+"\"}";		
		}
	}
	
	@PostMapping(value="/delete")
	public @ResponseBody String delete(@RequestBody String usuario) {
		String mg = "";
		if (usuarioService.deleteById(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro eliminado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@PostMapping(value="/alter")
	public @ResponseBody String alter(@RequestBody Usuario usuario) {
		String mg = "";
		if (usuarioService.alter(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro modificado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}

	
	@PostMapping(value="/find")
	public @ResponseBody String find(@RequestBody String usuario) {
		String mg = "";
		if (usuarioService.buscar(usuario) != null){
			return mg = usuarioService.buscar(usuario).toString();
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@GetMapping(value="/list")
	public @ResponseBody String list() {
		String mg = "";
		mg = usuarioService.usuarios().toString();
		return mg;
	}
}
