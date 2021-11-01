package com.S1.Sone.UserService;

import com.S1.Sone.UsersTimeRepository.MariadbCrud;
import com.S1.Sone.models.Users;
import com.S1.Sone.models.Userstime;
import com.S1.Sone.repository.URepository;
import com.mysql.cj.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserService{
	@PersistenceContext
	private EntityManager entityManagerFactoryBuilder;


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
	@Query
	public Users getUserByEmail(String email) {
		javax.persistence.Query query =  entityManagerFactoryBuilder
				.createNativeQuery(" select * from USERSACCESS WHERE Email = '"+email+"'",Users.class);

	  return (Users) query.getResultList().get(0);
	}


	public void save_update(Users user) {
		PasswordEncoder encoder=new Argon2PasswordEncoder(16,32,1,4096,3);
	
		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);
		if(user.getRole() == null) {
			user.setRole("USER");
		}
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

	public boolean getSemail(String email){

			List<Users> u=getAll();
			for(int l=0; l<u.size(); l++){
				if(u.get(l).getEmail().equals(email)){

					return true;
					}
			}
			return false;


	}

	public Users getGemail(String email){

		List<Users> u=getAll();
		for(int l=0; l<u.size(); l++){
			if(u.get(l).getEmail().equals(email)){

				return u.get(l);
			}
		}

		return null;


	}


	public List<Users> getAllList() {
		List<Users>u = getAll();
		for(int z = 0; z<u.size();z++){
			u.get(z).setPassword("null");
			if(u.get(z).getRole().startsWith("A"))u.remove(z);
		}
		return u;
	}
}