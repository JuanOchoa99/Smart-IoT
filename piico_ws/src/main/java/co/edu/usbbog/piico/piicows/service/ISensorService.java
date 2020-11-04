package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.modelo.mysql.Sensor;

public interface ISensorService {
	public List<Sensor> findAll();
	public Sensor findById(String sensor);
	public Boolean save(Sensor sensor);
	public Boolean deleteById(String sensor);
	public Long count();
	public Boolean alter(Sensor sensor);
}
