package com.S1.Sone.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration @EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter  {
	
	String token;
	String secretkey;
	protected void configure(HttpSecurity http)throws Exception{
		
			http.csrf().disable();
			http.authorizeRequests()
				.antMatchers("authenticate").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin();
	}
}

