package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Ordenactuador;

public interface IOrdenActuadorService {
	public List<Ordenactuador> findAll();
	public Ordenactuador findById(String ordenAct);
	public Boolean save(Ordenactuador ordenAct);
	public Boolean deleteById(String ordenAct);
	public Long count();
	public Boolean alter(Ordenactuador ordenAct);
}
