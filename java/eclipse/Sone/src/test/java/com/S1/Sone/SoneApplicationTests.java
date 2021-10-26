package com.S1.Sone;


import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//@SpringBootTest
class SoneApplicationTests {
		
	
		@Test
		void testDataaccess() {

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