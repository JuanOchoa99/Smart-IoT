package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.repository.mysql.INodo;

@Service
public class NodoService implements INodoService{
	
	@Autowired
	private INodo nodoRepo;

	@Override
	public List<Nodo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nodo findById(String nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Nodo usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
