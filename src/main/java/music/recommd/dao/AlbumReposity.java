package music.recommd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Album; 
public interface AlbumReposity extends CrudRepository<Album, Long>{
	
	Page<Album> findAll(Pageable pageable);
	
	//获取最新
	@Query("select ab from Album ab where ab.isNew = '1'")
	Page<Album> findByIsNew(Pageable pageable);

}
