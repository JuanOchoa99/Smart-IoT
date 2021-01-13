package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.PuertaDeEnlace;



public interface IPuertaEnlaceService {
	public List<PuertaDeEnlace> findAll();
	public PuertaDeEnlace findById(String idPuerta);
	public Boolean save(PuertaDeEnlace puerta);
	public Boolean deleteById(String idPuerta);
	public Long count();
	public Boolean alter(PuertaDeEnlace puerta);
}
