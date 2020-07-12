package com.usbbog.piico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usbbog.piico.repo.IUsuarios;
import com.usbbog.piico.model.Usuarios;


@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarios usuarioRepo;

	@Override
	public List<Usuarios> findAll() {
		List<Usuarios> listUsers= usuarioRepo.findAll();
		return listUsers;
	}

	@Override
	public Usuarios findById(String usuario) {
		try {
			return (Usuarios) usuarioRepo.findById(usuario).get();
		}catch(java.util.NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Boolean save(Usuarios usuario) {

		if (findById(usuario.getUsuario()) == null){
			usuarioRepo.save(usuario);
			return true;
		}else {
			return false;
		}
			
		
		
	}

	@Override
	public Boolean deleteById(String usuario) {
		
		if (findById(usuario) != null){
			usuarioRepo.deleteById(usuario);
			return true;
		}else {
			return false;
		}
			
	}

	@Override
	public Long count() {
		return usuarioRepo.count();
	}

	@Override
	public Boolean alter(Usuarios usuario) {
		if (findById(usuario.getUsuario()) != null){
			usuarioRepo.save(usuario);
			return true;
		}else {
			return false;
		}
		
	}

}
