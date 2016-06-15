package music.recommd.service.inter;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import music.recommd.model.Album;
import music.recommd.model.Music;
import music.recommd.model.Singer;
import music.recommd.model.User;

public interface MusicService {
	List<Music> findAll(Integer page, Integer limit);
	
	List<Music> findAllByAccessToken(Integer page, Integer limit, User user);
	
	//获取最热音乐
	List<Music> findHot(Integer page, Integer limit);
	
	
	//按分类获取音乐
	List<Music> findByType(String type, Integer page, Integer limit);
	
	//分类时获取到音乐长度
	Long getLength(String type);
	
	//获取最新
	List<Music> findByIsNew(Integer page, Integer limit);
	
	Music findOne(Long id);
	
	Music countPv(Music music);
	
	Music save(Music music);
	
	//按歌手寻找歌单
	List<Music> findBySinger(Singer singer);
	
	//按专辑获取音乐
	List<Music> findByAlbum(Album album);
	
	//查询所有音乐长度
	JSONObject findLength();
	
	

}
