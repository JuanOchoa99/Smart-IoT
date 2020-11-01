package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.model.mysql.repository.IRol;
import co.edu.usbbog.piico.piicows.model.mysql.repository.IUsuario;


@Service
public class RolService implements IRolService{
	
	@Autowired
	private IRol rolRepo;
	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol findById(String rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

}
