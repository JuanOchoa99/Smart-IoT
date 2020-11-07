package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Orden;
import co.edu.usbbog.piico.piicows.repository.mysql.IOrdenRepository;

@Service
public class OrdenService implements IOrdenService{
	
	@Autowired
	private IOrdenRepository ordenRepo;
	@Override
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden findById(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

}
