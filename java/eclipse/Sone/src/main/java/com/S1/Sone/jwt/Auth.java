package com.S1.Sone.jwt;

import com.S1.Sone.UserService.UserService;
import com.S1.Sone.models.Users;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.HeaderWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.Console;
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
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	public Auth() throws MalformedURLException {
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authm)throws Exception {



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

		UsernamePasswordAuthenticationFilter usernamefilter =new UsernamePasswordAuthenticationFilter();
		/*http.authorizeRequests()
				.antMatchers("/home.html")
						.hasAnyRole("ADMIN","USER").and().formLogin();*/
		http.authorizeRequests().antMatchers("/user/cred","/login.html","/js/**","/css/**","/")
				.permitAll();
		http.authorizeRequests().anyRequest().authenticated();

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


	public Boolean getJWT(Users u) throws Exception {

		Authentication token= new UsernamePasswordAuthenticationToken(u.getEmail(),u.getPassword());

		 Authentication auth =authenticationManager().authenticate(token);

			if(auth.isAuthenticated()){
			new org.springframework.security.core.userdetails.User(u.getEmail(),u.getPassword(),userDetailService.loadUserByUsername(u.getEmail()).getAuthorities());



				return true;}
			else return false;
	}



	}

