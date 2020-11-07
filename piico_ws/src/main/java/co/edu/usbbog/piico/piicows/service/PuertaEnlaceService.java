package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.repository.mysql.IPuertaDeEnlaceRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class PuertaEnlaceService implements IPuertaEnlaceService{
	
	@Autowired
	private IPuertaDeEnlaceRepository gatewayRepo;
	@Override
	public List<PuertaDeEnlace> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuertaDeEnlace findById(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(PuertaDeEnlace usuario) {
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
	public Boolean alter(PuertaDeEnlace usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
