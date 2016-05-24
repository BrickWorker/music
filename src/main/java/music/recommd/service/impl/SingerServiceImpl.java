package music.recommd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import music.recommd.dao.SingerReposity;
import music.recommd.model.Singer;
import music.recommd.service.inter.SingerService;

@Component
@Transactional
public class SingerServiceImpl implements SingerService{
	
	@Autowired
	private SingerReposity singerReposity;

	@Override
	public List<Singer> findAll(Integer page, Integer limit) {
		final PageRequest singerPage = new PageRequest(page, limit,
				Direction.DESC, "singerId");
		return this.singerReposity.findAll(singerPage).getContent();
	}

	@Override
	public Singer findOne(Long id) {
		return this.singerReposity.findOne(id);
	}

}
