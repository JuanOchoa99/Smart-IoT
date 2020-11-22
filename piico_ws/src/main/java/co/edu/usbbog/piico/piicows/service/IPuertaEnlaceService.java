package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;



public interface IPuertaEnlaceService {
	public List<PuertaDeEnlace> findAll();
	public PuertaDeEnlace findById(String usuario);
	public Boolean save(PuertaDeEnlace usuario);
	public Boolean deleteById(String usuario);
	public Long count();
	public Boolean alter(PuertaDeEnlace usuario);
<<<<<<< HEAD

=======
	
>>>>>>> master
}
