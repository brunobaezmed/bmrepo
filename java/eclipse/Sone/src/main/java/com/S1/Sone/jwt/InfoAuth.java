package com.S1.Sone.jwt;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.S1.Sone.models.Users;

public class InfoAuth implements UserDetails {

	
	private final Users user ;
	private static final long serialVersionUID = 3359446991546793630L;
	
	public InfoAuth(Users user) {
		this.user=user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public String getPassword() {
							
			
		return user.getPassword();
	}

	public String getUsername() {
		return user.getEmail();

		

	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {

		return true;
	}

	public boolean isCredentialsNonExpired() {

		return true;
	}

	public boolean isEnabled() {
	
		return true;
	}
	public Users getuser() {
		return user;
	}

}
	