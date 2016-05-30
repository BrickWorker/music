package music.recommd.service.inter;

import music.recommd.model.User;
import music.recommd.model.Validation;

public interface ValidationService {

	Boolean validate(String accessToken);
	
	//在每次登陆之后更新token，不支持多点登陆
	Validation createOrUpdateAccessToken(User user);
	
	
	//验证用户名和密码
	Boolean validatePassword(String phone, String password);
	
	
	//用token获得用户
	User getUserByAccessToken(String accessToken);
	
	//用token获得用户Id
	String getUserIdByAccessToken(String accessToken);
}
