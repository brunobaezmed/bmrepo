package com.S1.Sone.jwt;

import com.S1.Sone.UserService.UserService;
import com.S1.Sone.models.Users;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.MalformedURLException;
import java.util.List;

@Configuration @EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter  {
	final public UrlResource index=new UrlResource("http://localhost:2333/index.html");
	final public UrlResource error= new UrlResource("http://localhost:2333/error");

	@Autowired
	private UserService personservice;
	@Autowired
	private InfoAuthService userDetailService;

	public Auth() throws MalformedURLException {
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authm)throws Exception {
		index.createRelative("/index.html");

		authm.userDetailsService(userDetailService).passwordEncoder(passwordencoder());
		authm.inMemoryAuthentication().withUser("serveradmin").password(passwordencoder()
				.encode("3377")).roles("ADMIN","USER");

	}
	
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new Argon2PasswordEncoder(16,32,1,4096,3);
	}


	protected void configure(HttpSecurity http)throws Exception {
		http.csrf().disable();
			

				http.authorizeRequests()
				.antMatchers("/home.html")
						.hasAnyRole("ADMIN","USER").and().formLogin();


		http.authorizeRequests().anyRequest().permitAll();
	}
	public UrlResource Info(Users cred)  {

		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		List<Users> u= personservice.getAll();
		String passhashed = "";
		for(int l=0;l<u.size();l++) {
			if(u.get(l).getEmail().equals(cred.getEmail())) {

				passhashed=u.get(l).getPassword();
				boolean result=argon2.verify(passhashed, cred.getPassword().toCharArray());
				if(result) {
					return index;
						}
				}
			}
		return error;

	}


}
