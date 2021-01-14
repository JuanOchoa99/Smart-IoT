package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Auth;
import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;
import co.edu.usbbog.piico.piicows.repository.mysql.IPuertaDeEnlaceRepository;

@Service
public class PuertaEnlaceService implements IPuertaEnlaceService{
	
	@Autowired
	private IPuertaDeEnlaceRepository gatewayRepo;

	@Override
	public List<PuertaDeEnlace> findAll() {
		List<PuertaDeEnlace> puertaDeEnlace = gatewayRepo.findAll();
		return puertaDeEnlace;
	}

	@Override
	public PuertaDeEnlace findById(String idPuerta) {
		return  gatewayRepo.findById(idPuerta).get();
	}

	@Override
	public Boolean save(PuertaDeEnlace puerta) {
		if (findById(puerta.getId()) == null){
			gatewayRepo.save(puerta);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean deleteById(String idPuerta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(PuertaDeEnlace puerta) {
		// TODO Auto-generated method stub
		return null;
	}
}
