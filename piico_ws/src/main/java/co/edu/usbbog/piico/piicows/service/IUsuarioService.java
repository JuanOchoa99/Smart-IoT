package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.modelo.mysql.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(String usuario);
	public Boolean save(Usuario usuario);
	public Boolean deleteById(String usuario);
	public Long count();
	public Boolean alter(Usuario usuario);
}
