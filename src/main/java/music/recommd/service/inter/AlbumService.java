package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.Album;

public interface AlbumService {

	//获取最新专辑
	List<Album> findNew(Integer page, Integer limit);
	
	
	List<Album> findHot(Integer page, Integer limit);
	
	Album findOne(Long id);
	
	
}
