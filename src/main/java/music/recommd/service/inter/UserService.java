package music.recommd.service.inter;

import java.util.List;

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
	
	//查询用户是否收藏
	Boolean isCollect(Long musicId, String userId);
	
	
	//移除收藏
	User removeCollect(Long musicId, String userId);
	
	List<User> getAll();
	
	

}
