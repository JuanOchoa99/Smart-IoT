package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Puertadeenlace;
import co.edu.usbbog.piico.piicows.repository.mysql.IPuertaDeEnlaceRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class PuertaEnlaceService implements IPuertaEnlaceService{
	
	@Autowired
	private IPuertaDeEnlaceRepository gatewayRepo;
	@Override
	public List<Puertadeenlace> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Puertadeenlace findById(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Puertadeenlace usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Puertadeenlace usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
