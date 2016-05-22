package music.recommd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.MusicType;

public interface MusicTypeReposity extends CrudRepository<MusicType, Long>   {
	
	Page<MusicType> findAll(Pageable pageable);

}
