package com.S1.Sone.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration @EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter  {
	@Autowired
	private InfoAuthService userDetailService;
	
	protected void configure(AuthenticationManagerBuilder authm)throws Exception {
		


		
		authm.userDetailsService(userDetailService).passwordEncoder(passwordencoder());
		
		
		authm.inMemoryAuthentication()
		.withUser("serveradmin")
		.password(passwordencoder().encode("3377"))
		.roles("ADMIN");
			
		

	}
	
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new Argon2PasswordEncoder(16,32,1,4096,3);
	}

	protected void configure(HttpSecurity http)throws Exception{
		
			http.csrf().disable();
			http.authorizeRequests()
				.antMatchers("/**")
				.hasRole("ADMIN")
				.antMatchers("/**")
				.hasRole("USER")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin();	
						
			
	}


}
