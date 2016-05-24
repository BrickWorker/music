package music.recommd.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Music;
import music.recommd.model.Singer;

public interface MusicReposity extends CrudRepository<Music, Long>  {
	
	Page<Music> findAll(Pageable pageable);
	
	//按类型查找2
	@Query("select mu from Music mu where mu.musicType like ?1%")
	Page<Music> findByMusicTypeLeft(String musicType, Pageable pageable);
	
	@Query("select mu from Music mu where mu.musicType like %?1")
	Page<Music> findByMusicTypeRight(String musicType, Pageable pageable);
	
	//获取最新
	@Query("select mu from Music mu where mu.isNew = '1'")
	Page<Music> findByIsNew(Pageable pageable);
	
	//按歌手寻找歌单
	@Query("select mu from Music mu where mu.musicSinger =?1")
	List<Music> findAllBySinger(Singer singer);

}
