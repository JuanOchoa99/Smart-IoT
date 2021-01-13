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
	public List<Auth> findAll(String tipo) {
		List<Auth> auths = authRepo.findAll();
		for (int i = 0; i < auths.size(); i++) {
			if(tipo.equals("pub")) {
				if(auths.get(i).getTopic().equals("sen_p") || auths.get(i).getTopic().equals("sta_p")){
					auths.remove(i);
				}
			}if(tipo.equals("sub")) {
				if(auths.get(i).getTopic().equals("req_p") || auths.get(i).getTopic().equals("act_p") || auths.get(i).getTopic().equals("conf_p")){
					auths.remove(i);
				}
			}
		}
		System.out.println("Lista: "+auths);
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
