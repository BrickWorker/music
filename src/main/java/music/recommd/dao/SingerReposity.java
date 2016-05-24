package music.recommd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Singer;

public interface SingerReposity  extends CrudRepository<Singer, Long>{
	
	Page<Singer> findAll(Pageable pageable);

}
