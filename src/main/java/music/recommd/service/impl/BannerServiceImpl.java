package music.recommd.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import music.recommd.dao.BannerReposity;
import music.recommd.model.Banner;
import music.recommd.service.inter.BannerService;

@Component
@Transactional
public class BannerServiceImpl implements BannerService {

	
	@Autowired
	private BannerReposity bannerReposity;
	
	@Override
	public Banner findByBannerId(Long bannerId) {
		return bannerReposity.findByBannerId(bannerId);
	}

	@Override
	public List<Banner> findAll(Integer page, Integer limit) {
		final PageRequest bannerPage = new PageRequest(page, limit,
				Direction.DESC, "bannerId");
		return this.bannerReposity.findAll(bannerPage).getContent();
	}

}
