package com.knowledgeForest.dto;

public class BannerDTO {
//CREATE TABLE TBL_BANNER (
//	BANNER_NUM NUMBER, 
//	BANNER_NAME VARCHAR2(100) NOT NULL ENABLE, 
//	BANNER_UPLOAD_DATE DATE DEFAULT SYSDATE NOT NULL ENABLE, 
//	BANNER_EDIT_DATE DATE DEFAULT SYSDATE NOT NULL ENABLE, 
//	 CONSTRAINT PK_BANNER PRIMARY KEY (BANNER_NUM)
//};
	private int bannerNum;
	private String bannerName;
	private String bannerUploadDate;
	private String bannerEditDate;
	
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
	
	@Override
	public String toString() {
		return "BannerDTO [bannerNum=" + bannerNum + ", bannerName=" + bannerName + ", bannerUploadDate="
				+ bannerUploadDate + ", bannerEditDate=" + bannerEditDate + "]";
	}
}