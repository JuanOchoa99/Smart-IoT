package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.model.mysql.Auth;
public interface IAuthService {
	public List<Auth> findAll(String tipo);
	public Auth findById(String auth);
	public Boolean save(Auth auth);
	public Boolean deleteById(String auth);
	public Long count();
	public Boolean alter(Auth auth);
}
