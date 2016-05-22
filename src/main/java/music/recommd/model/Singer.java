package music.recommd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Singer {
	
	private Long singerId;
	private String singerName;
	private Integer singerSex;
	private String singerPic;
	private Long singerBith;
	private String singerDescription;
	
	@Id
	@GeneratedValue
	public Long getSingerId() {
		return singerId;
	}
	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}
	public Integer getSingerSex() {
		return singerSex;
	}
	public void setSingerSex(Integer singerSex) {
		this.singerSex = singerSex;
	}
	public String getSingerPic() {
		return singerPic;
	}
	public void setSingerPic(String singerPic) {
		this.singerPic = singerPic;
	}
	public Long getSingerBith() {
		return singerBith;
	}
	public void setSingerBith(Long singerBith) {
		this.singerBith = singerBith;
	}
	public String getSingerDescription() {
		return singerDescription;
	}
	public void setSingerDescription(String singerDescription) {
		this.singerDescription = singerDescription;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

}
