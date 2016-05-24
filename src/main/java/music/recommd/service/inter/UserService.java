package music.recommd.service.inter;

import music.recommd.model.User;

public interface UserService {
	
	User save(User user);
	
	//是否手机号被注册
	Boolean isRgister(String phone);
	
	
	User findByPhone(String phone);
	
	
	//login
	Boolean login(String phone, String password);
	
	
	//用户收藏
	User collect(Long musicId, String userId);
	
	

}
