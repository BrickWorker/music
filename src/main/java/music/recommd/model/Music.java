package music.recommd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Music implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4993687468854744078L;
	private Long musicId;
	private String musicName;
	private Singer musicSinger;
	private Album musicAlbum;
	private String musicType;
	private Integer musicPv;
	private Integer isNew;
	private String musicDload;
	private String musicAddress;
	private Long isCollect; //当用户登录时获取是否收藏该音乐
	
	
	@Id
	@GeneratedValue
	public Long getMusicId() {
		return musicId;
	}
	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}
	
	@ManyToOne
	@NotNull
	public Singer getMusicSinger() {
		return musicSinger;
	}
	public void setMusicSinger(Singer musicSinger) {
		this.musicSinger = musicSinger;
	}
	
	
	@ManyToOne
	@NotNull
	public Album getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(Album album) {
		this.musicAlbum = album;
	}
	
	@NotNull
	public String getMusicType() {
		return musicType;
	}
	public void setMusicType(String musicType) {
		this.musicType = musicType;
	}
	
	public Integer getMusicPv() {
		return musicPv;
	}
	public void setMusicPv(Integer musicPv) {
		this.musicPv = musicPv;
	}
	
	public String getMusicDload() {
		return musicDload;
	}
	public void setMusicDload(String musicDload) {
		this.musicDload = musicDload;
	}
	public String getMusicAddress() {
		return musicAddress;
	}
	public void setMusicAddress(String musicAddress) {
		this.musicAddress = musicAddress;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	
	@NotNull
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	
	@NotNull
	public Long getIsCollect() {
		return isCollect;
	}
	public void setIsCollect(Long isCollect) {
		this.isCollect = isCollect;
	}
}
