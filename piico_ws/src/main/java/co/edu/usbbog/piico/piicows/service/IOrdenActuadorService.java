package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.OrdenActuador;

public interface IOrdenActuadorService {
	public List<OrdenActuador> findAll();
	public OrdenActuador findById(String ordenAct);
	public Boolean save(OrdenActuador ordenAct);
	public Boolean deleteById(String ordenAct);
	public Long count();
	public Boolean alter(OrdenActuador ordenAct);
}
