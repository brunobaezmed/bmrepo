package com.S1.Sone.UserService;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.S1.Sone.UsersTimeRepository.MariadbCrud;
import com.S1.Sone.models.Users;
import com.S1.Sone.models.Userstime;
import com.S1.Sone.repository.URepository;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


@Service
public class UserService{
	

	@Autowired
	private URepository mariadbcrud;

	@Autowired
	private MariadbCrud m;
	
	public Users getById(long id) {
		
		return mariadbcrud.findById(id).get();
	}
	public List<Users> getAll() {
		List <Users> u=new ArrayList<Users>();

		mariadbcrud.findAll().forEach(Users->u.add(Users));
		return u;
	}
	
	public void save_update(Users user) {
		PasswordEncoder encoder=new Argon2PasswordEncoder(16,32,1,4096,3);
	
		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);
		user.setRole("USER");
		mariadbcrud.save(user);
	}
	public void save_update(List<Users> users) {
		PasswordEncoder encoder=new Argon2PasswordEncoder(16,32,1,4096,3);

	
		String hash="";
		for(int z=0;z<users.size();z++) {
			hash=users.get(z).getPassword();
			hash=encoder.encode(hash);
			users.get(z).setPassword(hash);
			users.get(z).setRole("USER");
		}
		mariadbcrud.saveAll(users);
	}
	public void delete(long id) {
		mariadbcrud.deleteById(id);;

	}
	


	
	public Userstime getbyId(long id) {
		
		return m.findById(id).get();
	}

	public void save_update(Userstime userstime) {
		Date time=new Date();
		String b="";
		b=time.toString();
		userstime.setAdded(b);
		m.save(userstime);
	}

	
	public String Info(Users cred) {

			Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			List<Users> u=getAll();
	
		    for(int l=0;l<u.size();l++) {
		    	if(u.get(l).getEmail().equals(cred.getEmail())) {
		    		
		    	String passhashed=u.get(l).getPassword();
		    		boolean result=argon2.verify(passhashed, cred.getPassword().toCharArray());
		    		if(result)
					return URLEncoder.encode("index.html", Charset.defaultCharset());
		    		
		    	}
		    	
		    }
		
			return "/error";
	}


	
	

	



	
}