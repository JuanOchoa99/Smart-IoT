package com.usbbog.piico.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbbog.piico.service.*;
import com.usbbog.piico.model.Usuarios;

@RestController
@RequestMapping("/usuarios")
public class RestControlador {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping
	public List<Usuarios> lista(){
		return usuarioService.findAll();
	}
	@GetMapping(value = "/{usuario}")
	public Object Buscar(String usuario){
		return usuarioService.findById(usuario);
	}
	@PostMapping("/registrar")
	public String insertar(@RequestBody Usuarios u) {
		String mg = "";
		if (usuarioService.save(u)){
			return mg = "{\"causa\":\"true\",\"error\":\"Registro incertado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro incorrecto"+"\"}";
		}
	}
	@PutMapping
	public String modificar(@RequestBody Usuarios u) {
		String mg = "";
		if (usuarioService.save(u)) {
			return mg = "{\"causa\":\"true\",\"error\":\"Registro modificado"+"\"}";
		}else {
			return mg = "{\"causa\":\"false\",\"error\":\"Registro incorrecto"+"\"}";
		}
	}
	@DeleteMapping(value = "/{usuario}")
	public void eliminar(@PathVariable("usuario") String usuario) {
		usuarioService.deleteById(usuario);
	}
	
	@GetMapping
	@RequestMapping ("/count")
	public long Count(){
		return usuarioService.count();
	}
}
