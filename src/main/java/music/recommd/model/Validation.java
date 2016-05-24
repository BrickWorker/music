package music.recommd.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author jaron
 *
 */
@Entity
public class Validation  {

	private Long id;
	private String uid;
	private String name;
	private String accessToken;

	public Validation() {
	}

	/**
	 * @param uid
	 * @param accessToken
	 * @param isAdmin
	 */
	public Validation(String uid, String name, String accessToken) {
		this.uid = uid;
		this.name = name;
		this.accessToken = accessToken;
	}

	@Id
	@GeneratedValue
	@JSONField(ordinal = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@NotNull
	@Column(unique=true, length = 64)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
