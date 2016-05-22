package music.recommd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Banner;

public interface BannerReposity extends CrudRepository<Banner, Long> {

	Banner findByBannerId(Long bannerId);
	
	
	Page<Banner> findAll(Pageable pageable);
}
