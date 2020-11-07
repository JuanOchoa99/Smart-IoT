package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Rol;
import co.edu.usbbog.piico.piicows.repository.mysql.IRolRepository;


@Service
public class RolService implements IRolService{
	
	@Autowired
	private IRolRepository rolRepo;
	@Override
	public List<Rol> findAll() {
		List<Rol> listRol= rolRepo.findAll();
		return listRol;
	}

	@Override
	public Rol findById(String rol) {
		try {
			return (Rol) rolRepo.findById(rol).get();
		}catch(java.util.NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Boolean save(Rol rol) {
		if (findById(rol.getNombre()) == null){
			rolRepo.save(rol);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean deleteById(String rol) {
		if (findById(rol) != null){
			rolRepo.deleteById(rol);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Long count() {
		return rolRepo.count();
	}

	@Override
	public Boolean alter(Rol rol) {
		if (findById(rol.getNombre()) != null){
			rolRepo.save(rol);
			return true;
		}else {
			return false;
		}
	}

}
