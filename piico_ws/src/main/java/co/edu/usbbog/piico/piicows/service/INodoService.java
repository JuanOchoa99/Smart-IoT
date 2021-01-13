package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.json.JSONArray;

import co.edu.usbbog.piico.piicows.model.mysql.Nodo;

public interface INodoService {
	public JSONArray findAll();
	public Nodo findById(String nodo);
	public Boolean save(Nodo nodo);
	public Boolean deleteById(String nodo);
	public Long count();
	public Boolean alter(Nodo usuario);
}
