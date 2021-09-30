package com.S1.Sone.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
	
		String hash = 	argon2.hash(2, 1024, 2, user.getPassword().toCharArray());
		user.setPassword(hash);
		mariadbcrud.save(user);
	}
	public void save_update(List<Users> users) {
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

	



	
}