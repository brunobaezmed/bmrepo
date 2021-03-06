package com.S1.Sone.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.S1.Sone.UsersTimeRepository.MariadbCrud;
import com.S1.Sone.models.PersonInfo;
import com.S1.Sone.repository.URepository;

@Service
public class PersonInfoService {

	@Autowired
	private URepository basicinfo;
	@Autowired
	private MariadbCrud especificinfo;
	
 
	
	public PersonInfo getInfo(long id) {
		PersonInfo personinfo=new PersonInfo();
		String fullname=basicinfo.findById(id).get().getName()+" "+
			basicinfo.findById(id).get().getLastname();
		
		String ab=especificinfo.findById(id).get().getBirth()+" "+
		especificinfo.findById(id).get().getAdded();
		 personinfo.setId(id);
		 personinfo.setEmail(basicinfo.findById(id).get().getEmail());
	     personinfo.setFullname(fullname);
	     personinfo.setAddedBirth(ab);
	     personinfo.setNumberphone(basicinfo.findById(id).get().getNumberphone());
		 return personinfo;
	}



	
	
}
