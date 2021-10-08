package com.S1.Sone.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.S1.Sone.UserService.UserService;
@Service
public class InfoAuthService implements UserDetailsService {

	@Autowired
	private UserService uservice;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
				
			for(int z=0;z<uservice.getAll().size();z++) {
				if(username.equals(uservice.getAll().get(z).getEmail())) {
					return new InfoAuth(uservice.getAll().get(z));
				}
				
				
			}
				throw new UsernameNotFoundException("User Not Found");
			
			
			
			
			
	}

}
