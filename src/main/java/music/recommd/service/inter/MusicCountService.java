package music.recommd.service.inter;

import music.recommd.model.MusicCount;

public interface MusicCountService {
	
	//用户听了某首歌
	MusicCount save(MusicCount musicCount);
	
	
	//判断用户是否有听过某首歌
	MusicCount isHeard(String userId, String musicId);

}
