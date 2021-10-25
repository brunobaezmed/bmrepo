package com.S1.Sone.controller;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

import com.S1.Sone.jwt.Auth;
import com.S1.Sone.jwt.InfoAuthService;
import javassist.URLClassPath;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import com.S1.Sone.Services.PersonInfoService;
import com.S1.Sone.UserService.UserService;
import com.S1.Sone.models.PersonInfo;
import com.S1.Sone.models.Users;
import com.S1.Sone.models.Userstime;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Control1  {
	@Autowired
	private InfoAuthService userDetailService;
	@Autowired
	private UserService personservice;
	@Autowired
	private PersonInfoService pinfoservice;


	@RequestMapping("/")
		private UrlResource homepage() throws MalformedURLException {
		UrlResource	 A= new UrlResource("http://localhost:2333/login.html");

		return A;

	}










    @GetMapping(value="get/users/user/{id}")
    	private Users user(@PathVariable("id") long id) {
    			return personservice.getById(id);
    	}
    @GetMapping(value="get/users")
    	private List<Users> all() {
    			return personservice.getAll();
    			}
    @GetMapping(value="get/usertime/{id}")
		private Userstime ins_userTime(@PathVariable long id) {

    			return personservice.getbyId(id);
    			}
    @GetMapping(value="get/basicinfo/{id}")
		private PersonInfo basicEspecifInfo(@PathVariable long id) {
    	
			return pinfoservice.getInfo(id);
			}
    


    
    
    
    
	@DeleteMapping(value="user/delete/{id}")
		private void del(@PathVariable("id") long id) {
	
				personservice.delete(id);
	
			}
	
	
   
	@PostMapping(value="user/post")
		private	long ins_userID(@RequestBody Users user) {
			
				personservice.save_update(user);
				return user.getId();
			}
	
	@PostMapping(value="users/post")
		private void ins_usersID(@RequestBody List<Users> users ) {
				personservice.save_update(users);
				
			}
	@PostMapping(value="usertime/post")
		private long ins_userTime(@RequestBody Userstime utime) {
				personservice.save_update(utime);
				return utime.getId();
	}
	
	@PostMapping(value="user/cred")
	private String credential(@RequestBody Users user) {
		return "http://localhost:2333/index.html";
	
}

	
	
	@PostMapping(value="authenticate")
	 private String auth(@RequestBody Users user) {
		return "index.html";
	}
	
	@PostMapping(value="/login")
	 private String auth2(@RequestBody Users user) {
		 	return "login.html";
	}
	
	
	

	
}