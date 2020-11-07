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

<<<<<<< HEAD
import co.edu.usbbog.piico.piicows.model.mysql.Actuador;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Orden;
import co.edu.usbbog.piico.piicows.model.mysql.Ordenactuador;
import co.edu.usbbog.piico.piicows.model.mysql.Protocolo;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.NodoService;
import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
=======


import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Puertadeenlace;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.NodoService;
import co.edu.usbbog.piico.piicows.service.PuertaEnlaceService;
import co.edu.usbbog.piico.piicows.model.mysql.Rol;
>>>>>>> master
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.RolService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;


@RestController
@RequestMapping(path = "/ingusbbo_piico")
public class ControladorRest {
	@Autowired
	private UsuarioService usuarioService;
<<<<<<< HEAD
	private NodoService nodoService;
	@Autowired
	private RolService rolService;
=======
	private RolService rolService;
	private PuertaEnlaceService puertaEnlaceService;
>>>>>>> master
	
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
<<<<<<< HEAD
	@RequestMapping(value = "/eliminarUsuario", method = RequestMethod.DELETE, 
=======
	@RequestMapping(value = "/eliminarUsuario", method = RequestMethod.POST, 
>>>>>>> master
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
	
<<<<<<< HEAD
	@RequestMapping(value = "/modificarUsuario", method = RequestMethod.PUT, 
=======
	@RequestMapping(value = "/modificarUsuario", method = RequestMethod.POST, 
>>>>>>> master
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
	
<<<<<<< HEAD
	@RequestMapping(value = "/buscarUsuario", method = RequestMethod.GET, 
=======
	@RequestMapping(value = "/buscarUsuario", method = RequestMethod.POST, 
>>>>>>> master
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
<<<<<<< HEAD
	public @ResponseBody String listarUsuarios(@RequestBody String usuario) {
=======
	public @ResponseBody String listarUsuarios() {
>>>>>>> master
		String mg = "";
		mg = usuarioService.findAll().toString();
		return mg;
	}
	
	
	// CRUD Rol
	
	@RequestMapping(value = "/guardarRol", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardarRol(@RequestBody Rol rol) {
<<<<<<< HEAD
		return null;
	}
	
	@RequestMapping(value = "/eliminarRol", method = RequestMethod.DELETE, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String eliminarRol(@RequestBody String rol) {
		return null;
	}
	
	@RequestMapping(value = "/modificarRol", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarRol(@RequestBody Rol rol) {
		return null;
=======
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
>>>>>>> master
	}
	
	@RequestMapping(value = "/contarRol", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String contarRol() {
<<<<<<< HEAD
		return null;
	}
	
	@RequestMapping(value = "/buscarRol", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String buscarRol(@RequestBody String rol) {
		return null;
	}
	
	@RequestMapping(value = "/listarRoles", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String listarRoles(@RequestBody String rol) {
		return null;
	}
	
	/**
	 * CRUD Protocolo
	 */
	@RequestMapping(value = "/guardarProtocolo", method = RequestMethod.POST)
	public @ResponseBody String guardarProtocolo(@RequestBody Protocolo protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarProtocolo", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarProtocolo(@RequestBody String protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/modificarProtocolo", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarProtocolo(@RequestBody Protocolo protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/contarProtocolo", method = RequestMethod.GET)
	public @ResponseBody String contarProtocolo() {
		return null;
	}
	
	@RequestMapping(value = "/buscarProtocolo", method = RequestMethod.GET)
	public @ResponseBody String buscarProtocolo(@RequestBody String protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/listarProtocolos", method = RequestMethod.GET)
	public @ResponseBody String listarProtocolo() {
		return null;
	}
	/**
	 * CRUD Nodo
	 */
	@RequestMapping(value = "/guardarNodo", method = RequestMethod.POST)
	public @ResponseBody String guardarNodo(@RequestBody Nodo protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarNodo", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarNodo(@RequestBody String nodo) {
		return null;
	}
	
	@RequestMapping(value = "/modificarNodo", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarNodo(@RequestBody Nodo nodo) {
		return null;
	}
	
	@RequestMapping(value = "/contarNodo", method = RequestMethod.GET)
	public @ResponseBody String contarNodo() {
		return null;
	}
	
	@RequestMapping(value = "/buscarNodo", method = RequestMethod.GET)
	public @ResponseBody String buscarNodo(@RequestBody String nodo) {
		return null;
	}
	
	@RequestMapping(value = "/listaNodos", method = RequestMethod.GET)
	public @ResponseBody String listarNodo() {
		return null;
	}
	/**
	 * CRUD Sensor
	 */
	@RequestMapping(value = "/guardarSensor", method = RequestMethod.POST)
	public @ResponseBody String guardarSensor(@RequestBody Sensor sensor) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarSensor", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarSensor(@RequestBody String sensor) {
		return null;
	}
	
	@RequestMapping(value = "/modificarSensor", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarSensor(@RequestBody Sensor sensor) {
		return null;
	}
	
	@RequestMapping(value = "/contarSensor", method = RequestMethod.GET)
	public @ResponseBody String contarSensor() {
		return null;
	}
	
	@RequestMapping(value = "/buscarSensor", method = RequestMethod.GET)
	public @ResponseBody String buscarSensor(@RequestBody String sensor) {
		return null;
	}
	
	@RequestMapping(value = "/listaSensores", method = RequestMethod.GET)
	public @ResponseBody String listarSensor() {
		return null;
	}
	
	/**
	 * CRUD Actuador
	 */
	@RequestMapping(value = "/guardarActuador", method = RequestMethod.POST)
	public @ResponseBody String guardarActuador(@RequestBody Actuador actuador) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarActuador", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarActuador(@RequestBody String actuador) {
		return null;
	}
	
	@RequestMapping(value = "/modificarActuador", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarActuador(@RequestBody Actuador actuador) {
		return null;
	}
	
	@RequestMapping(value = "/contarActuador", method = RequestMethod.GET)
	public @ResponseBody String contarActuador() {
		return null;
	}
	
	@RequestMapping(value = "/buscarActuador", method = RequestMethod.GET)
	public @ResponseBody String buscarActuador(@RequestBody String actuador) {
		return null;
	}
	
	@RequestMapping(value = "/listaActuadores", method = RequestMethod.GET)
	public @ResponseBody String listarActuador() {
		return null;
	}
	
	/**
	 * CRUD Orden
	 */
	@RequestMapping(value = "/guardarOrden", method = RequestMethod.POST)
	public @ResponseBody String guardarOrden(@RequestBody Orden orden) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarOrden", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarOrden(@RequestBody String orden) {
		return null;
	}
	
	@RequestMapping(value = "/modificarOrden", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarOrden(@RequestBody Orden orden) {
		return null;
	}
	
	@RequestMapping(value = "/contarOrden", method = RequestMethod.GET)
	public @ResponseBody String contarOrden() {
		return null;
	}
	
	@RequestMapping(value = "/buscarOrden", method = RequestMethod.GET)
	public @ResponseBody String buscarOrden(@RequestBody String orden) {
		return null;
	}
	
	@RequestMapping(value = "/listaOrdenes", method = RequestMethod.GET)
	public @ResponseBody String listarOrden() {
		return null;
	}
	
	/**
	 * CRUD Ordenactuador
	 */
	@RequestMapping(value = "/guardarOrdenactuador", method = RequestMethod.POST)
	public @ResponseBody String guardarOrdenactuador(@RequestBody Ordenactuador ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarOrdenactuador", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarOrdenactuador(@RequestBody String ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/modificarOrdenactuador", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarOrdenactuador(@RequestBody Ordenactuador ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/contarOrdenactuador", method = RequestMethod.GET)
	public @ResponseBody String contarOrdenactuador() {
		return null;
	}
	
	@RequestMapping(value = "/buscarOrdenactuador", method = RequestMethod.GET)
	public @ResponseBody String buscarOrdenactuador(@RequestBody String ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/listaOrdenactuador", method = RequestMethod.GET)
	public @ResponseBody String listarOrdenactuador() {
		return null;
	}
	
=======
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
	public @ResponseBody String listarRol() {
		String mg = "";
		mg = rolService.findAll().toString();
		return mg;
	}
	
	

>>>>>>> master
}
