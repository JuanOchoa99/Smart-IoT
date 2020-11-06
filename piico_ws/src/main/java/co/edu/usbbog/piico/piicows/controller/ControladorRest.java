package co.edu.usbbog.piico.piicows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.NodoService;
import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.RolService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;


@RestController
@RequestMapping(path = "/ingusbbo_piico")
public class ControladorRest {
	@Autowired
	private UsuarioService usuarioService;
	private NodoService nodoService;
	@Autowired
	private RolService rolService;
	
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardarUsuario(@RequestBody Usuario usuario) {
		String mg = "";
		if (usuarioService.save(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro ya existe"+"\"}";		
		}
	}
	@RequestMapping(value = "/eliminarUsuario", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String eliminarUsuario(@RequestBody String usuario) {
		String mg = "";
		if (usuarioService.deleteById(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro eliminado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@RequestMapping(value = "/modificarUsuario", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarUsuario(@RequestBody Usuario usuario) {
		String mg = "";
		if (usuarioService.alter(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro modificado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@RequestMapping(value = "/contarUsuario", method = RequestMethod.GET)
	public @ResponseBody String contarUsuario() {
		String mg = "";
		mg = usuarioService.count().toString();
		return mg;
	}
	
	@RequestMapping(value = "/buscarUsuario", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String buscarUsuario(@RequestBody String usuario) {
		String mg = "";
		if (usuarioService.findById(usuario) != null){
			return mg = usuarioService.findById(usuario).toString();
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String listarUsuarios(@RequestBody String usuario) {
		String mg = "";
		mg = usuarioService.findAll().toString();
		return mg;
	}
	
	
	// CRUD Rol
	
	@RequestMapping(value = "/guardarRol", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardarRol(@RequestBody Rol rol) {
		String mg = "";
		if (rolService.save(rol)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro ya existe"+"\"}";
		
		}
	}
	
	@RequestMapping(value = "/eliminarRol", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String eliminarRol(@RequestBody String rol) {
		String mg = "";
		if (rolService.deleteById(rol)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro eliminado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@RequestMapping(value = "/modificarRol", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarRol(@RequestBody Rol rol) {
		String mg = "";
		if (rolService.alter(rol)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro modificado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@RequestMapping(value = "/contarRol", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String contarRol() {
		String mg = "";
		mg = rolService.count().toString();
		return mg;
	}
	
	@RequestMapping(value = "/buscarRol", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String buscarRol(@RequestBody String rol) {
		String mg = "";
		if (rolService.findById(rol) != null){
			return mg = rolService.findById(rol).toString();
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro no existe"+"\"}";
		}
	}
	
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String listarRol(@RequestBody String rol) {
		String mg = "";
		mg = rolService.findAll().toString();
		return mg;
	}
	

}
