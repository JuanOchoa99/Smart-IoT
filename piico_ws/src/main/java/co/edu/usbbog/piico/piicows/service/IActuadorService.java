package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Actuador;

public interface IActuadorService {
	public List<Actuador> findAll();
	public Actuador findById(String actuador);
	public Boolean save(Actuador actuador);
	public Boolean deleteById(String actuador);
	public Long count();
	public Boolean alter(Actuador actuador);
}
