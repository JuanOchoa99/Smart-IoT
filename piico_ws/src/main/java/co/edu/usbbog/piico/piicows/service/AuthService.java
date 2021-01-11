package co.edu.usbbog.piico.piicows.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Auth;
import co.edu.usbbog.piico.piicows.repository.mysql.IAuthRepository;

@Service
public class AuthService implements IAuthService{
	
	@Autowired
	private IAuthRepository authRepo;

	@Override
	public List<Auth> findAll() {
		List<Auth> auths = authRepo.findAll();
		return auths;
	}

	@Override
	public Auth findById(String auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Auth auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alter(Auth auth) {
		// TODO Auto-generated method stub
		return null;
	}

}
