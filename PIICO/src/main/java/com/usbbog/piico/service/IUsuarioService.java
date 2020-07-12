package com.usbbog.piico.service;

import java.util.List;
import com.usbbog.piico.model.Usuarios;

public interface IUsuarioService {

	public List<Usuarios> findAll();
	public Usuarios findById(String usuario);
	public Boolean save(Usuarios usuario);
	public Boolean deleteById(String usuario);
	public Long count();
	public Boolean alter(Usuarios usuario);
}
