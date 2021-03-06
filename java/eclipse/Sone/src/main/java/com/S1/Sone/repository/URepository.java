package com.S1.Sone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.S1.Sone.models.Users;


@Transactional
public interface URepository extends CrudRepository<Users,Long> {
	

	@Query(value="SELECT * FROM USERSACCESS u,Userstime ut where u.id=ut.id;"
			+ "",nativeQuery=true)
	List<Users> getNameAddbirth();
	
	
	
	
	@Query(value="SELECT u FROM USERSACCESS u,Userstime ut where u.id=ut.id;"
			+ "",nativeQuery=true)
	List<Users> getNameAddbirth1();









}