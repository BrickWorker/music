package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.Album;
import music.recommd.model.Singer;

public interface AlbumService {

	//获取最新专辑
	List<Album> findNew(Integer page, Integer limit);
	
	
	List<Album> findHot(Integer page, Integer limit);
	
	Album findOne(Long id);
	
	//按歌手获得专辑
	List<Album> findAlbumBySinger(Singer singer);
	
	//获取最新专辑长度
	Long getNewLength();
}
