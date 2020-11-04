package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.modelo.mysql.Rol;

public interface IRolService {
	
	public List<Rol> findAll();
	public Rol findById(String rol);
	public Boolean save(Rol rol);
	public Boolean deleteById(String rol);
	public Long count();
	public Boolean alter(Rol rol);

}
