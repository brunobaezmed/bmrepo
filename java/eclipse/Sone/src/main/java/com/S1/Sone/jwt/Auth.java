package com.S1.Sone.jwt;

import com.S1.Sone.UserService.UserService;
import com.S1.Sone.models.Users;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ViewResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.net.MalformedURLException;
import java.util.List;

@Configuration @EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter  {
	private boolean a = false;
	final public UrlResource index=new UrlResource("http://localhost:2333/index.html",);
	final public UrlResource error= new UrlResource("http://localhost:2333/error");
	final public  UrlResource home = new UrlResource()
	@Autowired
	private UserService personservice;
	@Autowired
	private InfoAuthService userDetailService;

	public Auth() throws MalformedURLException {
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authm)throws Exception {

		//	authm.userDetailsService(userDetailService).passwordEncoder(passwordencoder());
		//authm.jdbcAuthentication().dataSource(datasource);
		authm.inMemoryAuthentication().withUser("serveradmin").password(passwordencoder().encode("3377")).roles("ADMIN");

	}
	
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new Argon2PasswordEncoder(16,32,1,4096,3);
	}


	protected void configure(HttpSecurity http)throws Exception {
		http.csrf().disable();
			


			/*http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/**")
			.hasAnyRole("USER");

			*/
				http.authorizeRequests()
				.antMatchers("/home.html")
						.hasAnyRole("ADMIN").and().formLogin();


		http.authorizeRequests().anyRequest().permitAll();
	}
	public UrlResource Info(Users cred) throws Exception {

		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		List<Users> u= personservice.getAll();

		for(int l=0;l<u.size();l++) {
			if(u.get(l).getEmail().equals(cred.getEmail())) {

				String passhashed=u.get(l).getPassword();
				boolean result=argon2.verify(passhashed, cred.getPassword().toCharArray());
				if(result) {

					return index;

					}
				}
			}
		return error;

	}


}
