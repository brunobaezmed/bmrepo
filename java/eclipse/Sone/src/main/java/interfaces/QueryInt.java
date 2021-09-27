package interfaces;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.S1.Sone.models.Users;
@NoRepositoryBean
public interface QueryInt {
	
	public List<Users> getinnerjoin();
	public List<Users> getbyLastname(String Lastname);
	public int deletebyName(String name) ;
	
}
