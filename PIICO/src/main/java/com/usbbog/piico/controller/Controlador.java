package com.usbbog.piico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usbbog.piico.model.Usuarios;
import com.usbbog.piico.repo.IUsuarios;

@Controller
public class Controlador {
	@Autowired
	private IUsuarios user;
	@GetMapping("/saludo")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		Usuarios u = new Usuarios();
		u.setUsuario("Webservices");
		u.setApellidos("PIICO");
		u.setContrasenia("juhsyasa");
		u.setCorreo("piico@usbbog.com");
		u.setInstitucion("USB");
		u.setNombres("S-piico");
		u.setTelefono(3021245);
		u.setApellidos("2020");
		user.save(u);
		model.addAttribute("name", name);
		return "vista";
	}
	@GetMapping("/lista")
	public String greeting(Model model) {
		
		model.addAttribute("usuarios", user.findAll());
		return "vista";
	}
}
