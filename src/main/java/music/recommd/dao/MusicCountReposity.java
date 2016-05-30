package music.recommd.dao;

import org.springframework.data.repository.CrudRepository;

import music.recommd.model.MusicCount;

public interface MusicCountReposity  extends CrudRepository<MusicCount, Long>{
	
	MusicCount findByUserIdAndMusicId(String userId, String musicId);

}
