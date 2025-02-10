package com.knowledgeForest.dto;

public class BannerImgDTO {
	private int bannerNum;
	private String bannerName;
	private String bannerUploadDate;
	private String bannerEditDate;
	private AdminImgDTO images;	// 필드 추가, getter, setter 추가
	
	public int getBannerNum() {
		return bannerNum;
	}
	public void setBannerNum(int bannerNum) {
		this.bannerNum = bannerNum;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	public String getBannerUploadDate() {
		return bannerUploadDate;
	}
	public void setBannerUploadDate(String bannerUploadDate) {
		this.bannerUploadDate = bannerUploadDate;
	}
	public String getBannerEditDate() {
		return bannerEditDate;
	}
	public void setBannerEditDate(String bannerEditDate) {
		this.bannerEditDate = bannerEditDate;
	}
	public AdminImgDTO getImages() {
		return images;
	}
	public void setImages(AdminImgDTO images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "BannerImgDTO [bannerNum=" + bannerNum + ", bannerName=" + bannerName + ", bannerUploadDate="
				+ bannerUploadDate + ", bannerEditDate=" + bannerEditDate + ", images=" + images + "]";
	}
}
