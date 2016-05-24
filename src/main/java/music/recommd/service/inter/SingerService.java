package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.Singer;

public interface SingerService {
	List<Singer> findAll(Integer page, Integer limit);
	
	Singer findOne(Long id);

}
