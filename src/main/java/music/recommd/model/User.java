package music.recommd.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2812940724943633241L;
	private String userId;
	private String name;
	private String phone;
	private String sex;
	private String password;
	private String email;
	private String pic;
	private String brief;
	private Set<Music> userCollect;
	
	 @Id
	 @GeneratedValue(generator = "uuid")
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @Column(length = 36, unique = true)
	 @JSONField(ordinal = 1)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}

	@ElementCollection
	@CollectionTable(name = "userCollects", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "userCollect")
	public Set<Music> getuserCollect() {
		return userCollect;
	}


	@ElementCollection
	@CollectionTable(name = "musicCount", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "musicCount")
	public void setuserCollect(Set<Music> userCollect) {
		this.userCollect = userCollect;
	}

}
