package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.model.mysql.repository.ISensor;
import co.edu.usbbog.piico.piicows.model.mysql.repository.IUsuario;

@Service
public class SensorService implements ISensorService{
	
	@Autowired
	private ISensor sensorRepo;

	@Override
	public List<Sensor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor findById(String sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

}
