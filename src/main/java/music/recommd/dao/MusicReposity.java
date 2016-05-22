package music.recommd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Music;

public interface MusicReposity extends CrudRepository<Music, Long>  {
	
	Page<Music> findAll(Pageable pageable);
	
	//按类型查找2
	@Query("select mu from Music mu where mu.musicType like ?1%")
	Page<Music> findByMusicTypeLeft(String musicType, Pageable pageable);
	
	@Query("select mu from Music mu where mu.musicType like %?1")
	Page<Music> findByMusicTypeRight(String musicType, Pageable pageable);

}
