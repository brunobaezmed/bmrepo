package com.S1.Sone.jwt;

import com.S1.Sone.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.S1.Sone.UserService.UserService;

import java.util.List;

@Service
public class InfoAuthService implements UserDetailsService {

	@Autowired
	private UserService uservice;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			
			Users authorizated= uservice.getUserByEmail(email);

					return new InfoAuth(authorizated);

			}
			
			
			
	}


