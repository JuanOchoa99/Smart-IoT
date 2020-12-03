package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.OrdenActuador;
import co.edu.usbbog.piico.piicows.repository.mysql.IOrdenActuador;

@Service
public class OrdenActuadorService implements IOrdenActuadorService{
	
	@Autowired
	private IOrdenActuador ordenActRepo;
	@Override
	public List<OrdenActuador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String ordenAct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(OrdenActuador ordenAct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenActuador findById(String ordenAct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(OrdenActuador ordenAct) {
		// TODO Auto-generated method stub
		return null;
	}


}
