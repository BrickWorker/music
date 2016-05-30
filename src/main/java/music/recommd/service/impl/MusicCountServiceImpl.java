package music.recommd.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import music.recommd.dao.MusicCountReposity;
import music.recommd.model.MusicCount;
import music.recommd.service.inter.MusicCountService;

@Component
@Transactional
public class MusicCountServiceImpl implements MusicCountService{

	@Autowired
	private MusicCountReposity musicCountReposity;
	
	@Override
	public MusicCount save(MusicCount musicCount) {
		return musicCountReposity.save(musicCount);
	}

	@Override
	public MusicCount isHeard(String userId, String musicId) {
		return this.musicCountReposity.findByUserIdAndMusicId(userId, musicId);
	}

}
