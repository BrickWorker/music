package music.recommd.service.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import music.recommd.dao.UserReposity;
import music.recommd.model.User;
import music.recommd.service.inter.UserService;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserReposity userReposity;

	@Override
	public User save(User user) {
		User saveUser = this.userReposity.save(user);
		return saveUser;
	}

	@Override
	public Boolean isRgister(String phone) {
		if(StringUtils.isNotEmpty(phone)){
			User user = this.userReposity.findByPhone(phone);
			if(user != null){
				return true;
			}
		}
		return false;
	}

	@Override
	public User findByPhone(String phone) {
		return this.userReposity.findByPhone(phone);
	}

	@Override
	public Boolean login(String phone, String password) {
		User user = this.userReposity.findByPhone(phone);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
