package music.recommd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import music.recommd.dao.MusicReposity;
import music.recommd.model.Music;
import music.recommd.service.inter.MusicService;

@Component
@Transactional
public class MusicServiceImpl implements MusicService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MusicReposity musicReposity;

	@Override
	public List<Music> findAll(Integer page, Integer limit) {
		final PageRequest musicPage = new PageRequest(page, limit,
				Direction.DESC, "musicId");
		return this.musicReposity.findAll(musicPage).getContent();
	}

	@Override
	public List<Music> findByType(String type, Integer page, Integer limit) {//目前只考虑十万位和十位的素材
		final PageRequest musicPage = new PageRequest(page, limit,
				Direction.DESC, "musicId");
		String typeLike = null;
		switch (type.length()) {
		case 6:
			//语种
			typeLike = type.substring(0,1);
			return this.musicReposity.findByMusicTypeLeft(typeLike, musicPage).getContent();
		default:
			typeLike = type;
			return this.musicReposity.findByMusicTypeRight(typeLike, musicPage).getContent();
		}
	}

}
