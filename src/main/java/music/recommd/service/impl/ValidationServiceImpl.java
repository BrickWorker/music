package music.recommd.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import music.recommd.dao.UserReposity;
import music.recommd.dao.ValidationRepository;
import music.recommd.model.User;
import music.recommd.model.Validation;
import music.recommd.service.inter.ValidationService;

@Component
@Transactional
public class ValidationServiceImpl implements ValidationService{
	
	@Autowired
	private ValidationRepository validationRepository;
	
	@Autowired
	private UserReposity userReposity;

	
	@Override
	public Boolean validate(String accessToken) {
		return validationRepository.findByAccessToken(accessToken) != null;
	}


	@Override
	public Validation createOrUpdateAccessToken(User user) {
		String Token = UUID.randomUUID().toString();
		Validation validation = this.validationRepository.findByUid(user.getUserId());
		if(validation == null){
			validation = new Validation(user.getUserId(), user.getName(), Token);
			return this.validationRepository.save(validation);
		}else{
			return validation;
		}
		
	}


	@Override
	public Boolean validatePassword(String phone, String password) {
		User user = this.userReposity.findByPhone(phone);
		if(user.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
