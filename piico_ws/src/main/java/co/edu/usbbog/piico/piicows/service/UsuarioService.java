package co.edu.usbbog.piico.piicows.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public List<Usuario> usuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscar(String usuario) {
		Usuario user;
		try {
			if(usuarioRepo.existsById(usuario)) {
				user = usuarioRepo.getOne(usuario);
			}else {
				user = null;
			}
			
		}catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	public Boolean registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean login(String username, String password) {
		Usuario user;
		Boolean respuesta;
		try {
			if(usuarioRepo.existsById(username)) {
				user = usuarioRepo.getOne(username);
				if (user.getPass().equals(password)){
					respuesta = true;
				}else {
					respuesta = false;
				}
			}else {
				respuesta = false;
			}
			
		}catch (Exception e) {
			respuesta = false;
		}
		return respuesta;
	}

	@Override
	public Boolean alter(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean logout(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean modificarRol(Usuario usuario, List<Rol> roles, String option) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByUsername(String username) {
		Usuario user = usuarioRepo.findByUsername(username);
		return user;
	}

	
}
