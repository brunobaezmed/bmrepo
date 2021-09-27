package com.S1.Sone;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.S1.Sone.Services.PersonInfoService;
import com.S1.Sone.UserService.UserService;
import com.S1.Sone.models.PersonInfo;
import com.S1.Sone.models.Users;
import com.S1.Sone.models.Userstime;
@SpringBootTest
class SoneApplicationTests {
		
		@Autowired
		private UserService serv;
		@Autowired
		private PersonInfoService pinfoservice;
		@Test
		void testDataaccess() {	
			
			Userstime vm=new Userstime(1);
			Users s=new Users(1);
			s.setName("Bruno");
			s.setLastname("Baez Medina");
			s.setPassword("---");
			s.setNumberphone("0991742753");
			s.setEmail("brunomatias33@u.com");
			
			vm.setId(1);
			vm.setBirth("15/08/98");
			serv.save_update(vm);
			PersonInfo bruno=pinfoservice.getInfo(1);
			
			
			
		}
}
	
		

/*
SELECT USERSACCESS.name , USERSACCESS.Lastname , Userstime.birth,Userstime.added
FROM USERSACCESS,Userstime
WHERE USERSACCESS.id = Userstime.id;
*/



/* 
 
SELECT USERSACCESS.name,USERSACCESS.lastname,USERSACCESS.email,USERSACCESS.numberphone,Userstime.added FROM USERSACCESS,Userstime where USERSACCESS.id=Userstime.id

 */