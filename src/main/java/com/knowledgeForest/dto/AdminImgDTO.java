package com.knowledgeForest.dto;

public class AdminImgDTO {
	private int adminImgNum;
	private int bannerNum;
	private int noticeNum;
	private String adminImgName;	// 실제 이미지명
	private String adminImgUuid;	// 서버에 저장되는 이미지명
	
	public int getAdminImgNum() {
		return adminImgNum;
	}
	public void setAdminImgNum(int adminImgNum) {
		this.adminImgNum = adminImgNum;
	}
	public int getBannerNum() {
		return bannerNum;
	}
	public void setBannerNum(int bannerNum) {
		this.bannerNum = bannerNum;
	}
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getAdminImgName() {
		return adminImgName;
	}
	public void setAdminImgName(String adminImgName) {
		this.adminImgName = adminImgName;
	}
	public String getAdminImgUuid() {
		return adminImgUuid;
	}
	public void setAdminImgUuid(String adminImgUuid) {
		this.adminImgUuid = adminImgUuid;
	}
	
	@Override
	public String toString() {
		return "AdminImgDTO [adminImgNum=" + adminImgNum + ", bannerNum=" + bannerNum + ", noticeNum=" + noticeNum
				+ ", adminImgName=" + adminImgName + ", adminImgUuid=" + adminImgUuid + "]";
	}
}
