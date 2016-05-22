package music.recommd.service.inter;

import java.util.List;

import music.recommd.model.Banner;


public interface BannerService {

	Banner findByBannerId(Long bannerId);
	
	
	List<Banner> findAll(Integer page, Integer limit);
	
}
