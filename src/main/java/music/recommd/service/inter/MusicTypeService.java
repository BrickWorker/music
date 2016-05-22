package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.MusicType;

public interface MusicTypeService {
	
	
	List<MusicType> getAllType(Integer page, Integer limit);

}
