package co.edu.usbbog.piico.piicows.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.edu.usbbog.piico.piicows.model.mysql.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7356488824107444561L;
	
	private Usuario user;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		user.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
		return null;
	}

	

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	@Override
	public String getPassword() {
		System.out.println("Usuario: "+ user.getPass());
		return user.getPass();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setUsuario(Usuario user2) {
		this.user =user;
		
	}

}
