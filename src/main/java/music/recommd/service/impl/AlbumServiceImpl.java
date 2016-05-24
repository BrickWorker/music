package music.recommd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import music.recommd.dao.AlbumReposity;
import music.recommd.model.Album;
import music.recommd.service.inter.AlbumService;

@Component
@Transactional
public class AlbumServiceImpl implements AlbumService{
	
	@Autowired
	private AlbumReposity albumReposity;

	@Override
	public List<Album> findHot(Integer page, Integer limit) {
		final PageRequest albumPage = new PageRequest(page, limit,
				Direction.DESC, "albumPv");
		return this.albumReposity.findAll(albumPage).getContent();
	}

	@Override
	public List<Album> findNew(Integer page, Integer limit) {
		final PageRequest albumPage = new PageRequest(page, limit,
				Direction.DESC, "albumId");
		return this.albumReposity.findByIsNew(albumPage).getContent();
	}

	@Override
	public Album findOne(Long id) {
		return this.albumReposity.findOne(id);
	}

}
