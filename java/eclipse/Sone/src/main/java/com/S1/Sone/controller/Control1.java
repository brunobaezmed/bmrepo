package com.S1.Sone.controller;

import com.S1.Sone.Services.PersonInfoService;
import com.S1.Sone.UserService.UserService;
import com.S1.Sone.jwt.Auth;
import com.S1.Sone.jwt.InfoAuthService;
import com.S1.Sone.models.PersonInfo;
import com.S1.Sone.models.Users;
import com.S1.Sone.models.Userstime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.net.MalformedURLException;
import java.util.List;

@RestController
public class Control1 {
	@Autowired
	public Auth authorization;
	@Autowired
	private UserService personservice;
	@Autowired
	private PersonInfoService pinfoservice;
	@Autowired
	private InfoAuthService userDetailService;

	@RequestMapping(value="/")
		private UrlResource homepage() throws MalformedURLException {
			return new UrlResource("http://localhost:2333/login.html");

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
		private boolean credential(@RequestBody Users user) throws Exception {

		return authorization.getJWT(user);

   }
   @PostMapping(value="user/recpass")
		private boolean recuperar_con(@RequestBody String user){

			return personservice.getSemail(user);


		}
}