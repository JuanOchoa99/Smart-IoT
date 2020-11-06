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

import com.usbbog.piico.model.Usuarios;

import co.edu.usbbog.piico.piicows.modelo.mysql.Nodo;
import co.edu.usbbog.piico.piicows.modelo.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.NodoService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;


@RestController
@RequestMapping(path = "/ingusbbo_piico")
public class ControladorRest {
	@Autowired
	private UsuarioService usuarioService;
	private NodoService nodoService;
	
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardarUsuario (@RequestBody Usuario usuario) {
		String mg = "";
		if (usuarioService.save(usuario)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro ya existe"+"\"}";
		}
	}
	@RequestMapping(value = "/listarNodos", method = RequestMethod.GET)
	public  List<Nodo> lista(){
		return nodoService.findAll();
	}
	
	@GetMapping(value = "/buscar/{nodo}")
	public @ResponseBody Nodo BuscarNodo (@RequestBody @PathVariable("nodo") String nodo){
		return nodoService.findById(nodo);
		
	}
	@RequestMapping(value = "/guardarNodo", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardarNodo (@RequestBody Nodo nodo) {
		String mg = "";
		if (nodoService.save(nodo)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro ya existe"+"\"}";
		}
	}
	@PutMapping(value = "/modificar")
	public String modificar(@RequestBody Nodo nodo) {
		String mg = "";
		if (nodoService.alter(nodo)) {
			return mg = "{\"causa\":\"true\",\"error\":\"Registro modificado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro incorrecto"+"\"}";
		}
	}
	@DeleteMapping(value = "/{usuario}")
	public void eliminarNodo(@PathVariable("usuario") String usuario) {
		usuarioService.deleteById(usuario);
	}
	
	@GetMapping
	@RequestMapping ("/count")
	public long Count(){
		return usuarioService.count();
	}
}
