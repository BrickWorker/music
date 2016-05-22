package music.recommd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import music.recommd.dao.MusicTypeReposity;
import music.recommd.model.MusicType;
import music.recommd.service.inter.MusicTypeService;

@Component
@Transactional
public class MusicTypeServiceImpl implements MusicTypeService{
	
	@Autowired
	private MusicTypeReposity musicTypeReposity;

	@Override
	public List<MusicType> getAllType(Integer page, Integer limit) {
		final PageRequest musicTypePage = new PageRequest(page, limit,
				Direction.DESC, "id");
		return this.musicTypeReposity.findAll(musicTypePage).getContent();
	}

}
