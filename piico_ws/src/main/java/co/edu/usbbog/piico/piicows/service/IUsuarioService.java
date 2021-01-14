package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.model.mysql.Usuario;

public interface IUsuarioService {
	public List<Usuario> usuarios();
	public Usuario buscar(String usuario);
	public Boolean registrar(Usuario usuario);
	public Boolean deleteById(String usuario);
	public Boolean alter(Usuario usuario);
	public Boolean login(String username, String password);
	public Boolean logout(String username);
	public Boolean modificarRol(Usuario usuario, List<Rol> roles, String option);
	public Usuario findByUsername(String username);
}
