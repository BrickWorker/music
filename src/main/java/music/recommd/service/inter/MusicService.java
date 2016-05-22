package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.Music;

public interface MusicService {
	List<Music> findAll(Integer page, Integer limit);
	
	
	//按分类获取音乐
	List<Music> findByType(String type, Integer page, Integer limit);

}
