package com.S1.Sone.jwt;

import com.S1.Sone.UserService.UserService;
import com.S1.Sone.models.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
	private final String principal="ADMIN";
	public Auth() throws MalformedURLException {
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authm)throws Exception {


		authm.userDetailsService(userDetailService).passwordEncoder(passwordencoder());

	}


	@Bean
	public PasswordEncoder passwordencoder() {
		return new Argon2PasswordEncoder(16,32,1,4096,3);
	}


	protected void configure(HttpSecurity http)throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/user/delete/**").hasAuthority(principal);
		http.authorizeRequests()
				.antMatchers("/home.html")
				.hasAuthority(principal);
		http.authorizeRequests().antMatchers("/user/cred"
						,"/login.html","/js/**","/css/**","/","/error/*","/password.html"
						,"/register.html","/user/recpass","/user/post"
					,"/assets/**","/users/post")
						.permitAll();

		http.authorizeRequests().anyRequest().hasAnyAuthority("USER",principal).and().formLogin().disable();
		http.addFilterBefore(new AuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);


	}


	public boolean getJWT(Users u) throws Exception {

		Authentication token= new UsernamePasswordAuthenticationToken(u.getEmail(),u.getPassword());

		 Authentication auth =authenticationManager().authenticate(token);

		 	if(auth.isAuthenticated()){
				Users uauth=personservice.getGemail(u.getEmail());
				Collection<SimpleGrantedAuthority> grantedAuthorityCollection = new ArrayList<>();
				grantedAuthorityCollection.add(new SimpleGrantedAuthority(uauth.getRole()));

				new org.springframework.security.core.userdetails.User(u.getEmail(),u.getPassword(),grantedAuthorityCollection);

				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));

				String access_token = JWT.create()
						.withSubject(uauth.getEmail())
						.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("ROLE",uauth.getRole())
						.sign(algorithm);
				String refresh_token = JWT.create()
						.withSubject(uauth.getEmail())
						.withExpiresAt(new Date(System.currentTimeMillis()+30*60*1000))
						.withIssuer(request.getRequestURL().toString())
						.sign(algorithm);
				response.setHeader("access_token",access_token);
				response.setHeader("refresh_token",refresh_token);


			return true;

			}

		return false;
	}

	}

