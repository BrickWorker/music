package music.recommd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.User;

public interface UserReposity  extends CrudRepository<User, String>{
	
	User findByPhone(String phone);
	
	@Query("select us from User us")
	List<User> getAll();

}
