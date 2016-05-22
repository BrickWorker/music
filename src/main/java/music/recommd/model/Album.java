package music.recommd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Album {
	
	private Long albumId;
	private String albumName;
	private String albumPic;
	private Singer singer;
	private String albumDescription;
	private Integer albumPv;
	
	@Id
	@GeneratedValue
	public Long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	
	@NotNull
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	@NotNull
	public String getAlbumPic() {
		return albumPic;
	}
	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}
	
	@ManyToOne
	@NotNull
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	public String getAlbumDescription() {
		return albumDescription;
	}
	public void setAlbumDescription(String albumDescription) {
		this.albumDescription = albumDescription;
	}
	public Integer getAlbumPv() {
		return albumPv;
	}
	public void setAlbumPv(Integer albumPv) {
		this.albumPv = albumPv;
	}

}
