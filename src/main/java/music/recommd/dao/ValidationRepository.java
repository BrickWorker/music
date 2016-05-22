package music.recommd.dao;

import org.springframework.data.repository.CrudRepository;

import music.recommd.model.Validation;

public interface ValidationRepository extends CrudRepository<Validation, Long>{
	
	Validation findByAccessToken(String accessToken);

}
