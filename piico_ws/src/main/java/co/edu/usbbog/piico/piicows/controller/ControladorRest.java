package co.edu.usbbog.piico.piicows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.piico.piicows.modelo.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.UsuarioService;


@RestController
@RequestMapping(path = "/ingusbbo_piico")
public class ControladorRest {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardar(@RequestBody Usuario usuario) {
		String mg = "";
		if (usuarioService.save(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro ya existe"+"\"}";
		}
	}
}
