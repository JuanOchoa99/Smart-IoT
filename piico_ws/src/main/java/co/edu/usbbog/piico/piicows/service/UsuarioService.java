package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.usbbog.piico.piicows.modelo.mysql.Usuario;
import co.edu.usbbog.piico.piicows.model.mysql.repository.IUsuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuario usuarioRepo;
	@Override
	public List<Usuario> findAll() {
		List<Usuario> listUsers= usuarioRepo.findAll();
		return listUsers;
	}

	@Override
	public Usuario findById(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Usuario usuario) {
		if (findById(usuario.getId()) == null){
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
	public Boolean alter(Usuario usuario) {
		if (findById(usuario.getId()) != null){
			usuarioRepo.save(usuario);
			return true;
		}else {
			return false;
		}
	}

}
