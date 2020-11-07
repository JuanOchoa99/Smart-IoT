package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Orden;

public interface IOrdenService {
	public List<Orden> findAll();
	public Orden findById(String orden);
	public Boolean save(Orden orden);
	public Boolean deleteById(String orden);
	public Long count();
	public Boolean alter(Orden orden);
}
