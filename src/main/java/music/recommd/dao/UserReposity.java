package music.recommd.dao;

import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Banner;
import music.recommd.model.User;

public interface UserReposity  extends CrudRepository<User, String>{
	
	User findByPhone(String phone);

}
