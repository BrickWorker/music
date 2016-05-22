package music.recommd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Banner {

	private Long bannerId;
	private String bannerType;
	private String bannerUrl;
	private Long itemId;
	private String bannerPic;
	
	
	@Id
	@GeneratedValue
	public Long getBannerId() {
		return bannerId;
	}
	public void setBannerId(Long bannerId) {
		this.bannerId = bannerId;
	}
	public String getBannerType() {
		return bannerType;
	}
	public void setBannerType(String bannerType) {
		this.bannerType = bannerType;
	}
	public String getBannerUrl() {
		return bannerUrl;
	}
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getBannerPic() {
		return bannerPic;
	}
	public void setBannerPic(String bannerPic) {
		this.bannerPic = bannerPic;
	}
	
}
