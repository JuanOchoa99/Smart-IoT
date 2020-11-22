package co.edu.usbbog.piico.piicows.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean registrar(Usuario usuario) {
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
	public Boolean deleteById(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
