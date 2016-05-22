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
	private Singer singer;
	private Album album;
	private String musicType;
	private Integer musicPv;
	private String musicDload;
	private String musicAddress;
	
	
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
		return singer;
	}
	public void setMusicSinger(Singer singer) {
		this.singer = singer;
	}
	
	@ManyToOne
	@NotNull
	public Album getMusicAlbum() {
		return album;
	}
	public void setMusicAlbum(Album album) {
		this.album = album;
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
}
