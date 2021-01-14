package co.edu.usbbog.piico.piicows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;
import co.edu.usbbog.piico.piicows.service.NodoService;
import co.edu.usbbog.piico.piicows.service.PuertaEnlaceService;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.service.RolService;
import co.edu.usbbog.piico.piicows.service.UsuarioService;


@RestController
@RequestMapping("/seguridad")
public class ControladorRest {
	@Autowired
	private IUsuarioRepository userRepo;
	private RolService rolService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody Usuario user) {
		String pass = user.getPass();
		String encryptPassword = passwordEncoder.encode(pass);
		user.setPass(encryptPassword);
		userRepo.save(user);
		return "Se ha agregado el usuario admin";
	}
	
}
