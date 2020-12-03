package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.repository.mysql.INodoRepository;

@Service
public class NodoService implements INodoService{
	
	@Autowired
	private INodoRepository nodoRepo;

	@Override
	public List<Nodo> findAll() {
		List<Nodo> listNodo = nodoRepo.findAll();
		System.out.println(""+listNodo.toString());
		System.out.println(""+listNodo);
		return listNodo;
	}

	@Override
	public Nodo findById(String nodo) {
		try {
			System.out.println(nodoRepo.findById(nodo).get());
			return nodoRepo.findById(nodo).get();
		}catch(java.util.NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Boolean save(Nodo nodo) {
		if (findById(nodo.getId()) == null){
			nodoRepo.save(nodo);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean deleteById(String nodo) {
		if (findById(nodo) != null){
			nodoRepo.deleteById(nodo);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Long count() {
		return nodoRepo.count();
	}

	@Override
	public Boolean alter(Nodo nodo) {
		if (findById(nodo.getId()) != null){
			nodoRepo.save(nodo);
			return true;
		}else {
			return false;
		}
	}

}
