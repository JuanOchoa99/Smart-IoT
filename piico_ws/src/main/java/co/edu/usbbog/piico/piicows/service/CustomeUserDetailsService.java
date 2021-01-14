package co.edu.usbbog.piico.piicows.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsername(username);
		CustomUserDetails userDetails = null;
		if(user!=null) {
			userDetails = new CustomUserDetails();
			userDetails.setUsuario(user);
		}else {
			throw new UsernameNotFoundException("El usuario con username "+username+"no existe");
		}
		return userDetails;
	}

}
