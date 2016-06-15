package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.MusicCount;

public interface MusicCountService {
	
	//用户听了某首歌
	MusicCount save(MusicCount musicCount);
	
	
	//判断用户是否有听过某首歌
	MusicCount isHeard(String userId, String musicId);
	
	//获取所有听过的歌
	List<MusicCount> getMusicCountAll(String userId);

}
