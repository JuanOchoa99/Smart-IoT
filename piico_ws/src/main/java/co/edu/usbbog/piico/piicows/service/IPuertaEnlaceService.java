package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Puertadeenlace;



public interface IPuertaEnlaceService {
	public List<Puertadeenlace> findAll();
	public Puertadeenlace findById(String usuario);
	public Boolean save(Puertadeenlace usuario);
	public Boolean deleteById(String usuario);
	public Long count();
	public Boolean alter(Puertadeenlace usuario);

}
