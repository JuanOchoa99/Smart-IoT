package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Historial;
import co.edu.usbbog.piico.piicows.model.mysql.Log;

public interface IHistorialService {
	public List<Historial> findAll();
	public Historial findById(String historial);
	public Boolean save(Historial historial);
	public Boolean deleteById(String historial);
	public Long count();
	public Boolean alter(Historial historial);
}
