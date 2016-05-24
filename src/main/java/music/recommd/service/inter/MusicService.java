package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.Music;
import music.recommd.model.Singer;

public interface MusicService {
	List<Music> findAll(Integer page, Integer limit);
	
	//获取最热音乐
	List<Music> findHot(Integer page, Integer limit);
	
	
	//按分类获取音乐
	List<Music> findByType(String type, Integer page, Integer limit);
	
	
	//获取最新
	List<Music> findByIsNew(Integer page, Integer limit);
	
	Music findOne(Long id);
	
	Music countPv(Music music);
	
	Music save(Music music);
	
	//按歌手寻找歌单
	List<Music> findBySinger(Singer singer);
	
	

}
