package co.edu.usbbog.piico.piicows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Log;
import co.edu.usbbog.piico.piicows.model.mysql.repository.ILogs;

@Service
public class LogService implements ILogService{
	
	@Autowired
	private ILogs usuarioRepo;

	@Override
	public List<Log> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log findById(String log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Log log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Log log) {
		// TODO Auto-generated method stub
		return null;
	}

}
