package interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.S1.Sone.models.Users;

@Service
public interface IUserService {
	
	public List<Users>getAll();
	public Users getById(long id) ;
	public void save_update(Users user);
	public void delete(long id);

}