package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import co.edu.usbbog.piico.piicows.modelo.mysql.Log;

public interface ILogService {

	public List<Log> findAll();
	public Log findById(String log);
	public Boolean save(Log log);
	public Boolean deleteById(String log);
	public Long count();
	public Boolean alter(Log log);
}
