package music.recommd.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import music.recommd.dao.MusicReposity;
import music.recommd.dao.UserReposity;
import music.recommd.model.Music;
import music.recommd.model.User;
import music.recommd.service.inter.UserService;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserReposity userReposity;
	
	@Autowired
	private MusicReposity musicReposity;

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

	//用户添加收藏
	@Override
	public User collect(Long musicId, String user_id) {
		User user = this.userReposity.findOne(user_id);
		Music music = this.musicReposity.findOne(musicId);
		Set<Music> userCollect = user.getuserCollect();
		userCollect.add(music);
		user.setuserCollect(userCollect);
		return this.userReposity.save(user);
	}

	@Override
	public Boolean isCollect(Long musicId, String userId) {
		 User user = this.userReposity.findOne(userId);
		 Music music = this.musicReposity.findOne(musicId);
		 for (Music currentMusic : user.getuserCollect()) {
			if(currentMusic == music){
				return true;
			}
		}
		return false;
	}

	@Override
	public User removeCollect(Long musicId, String userId) {
		User user = this.userReposity.findOne(userId);
		Music music = this.musicReposity.findOne(musicId);
		Set<Music> userCollect = user.getuserCollect();
		userCollect.remove(music);
		user.setuserCollect(userCollect);
		return this.userReposity.save(user);
	}

	@Override
	public List<User> getAll() {
		return this.userReposity.getAll();
	}

}
