package com.knowledgeForest.dto;


public class NoticeImgDTO {
	private int noticeNum;
	private String noticeTitle;
	private String noticeContents;
	private String noticeUploadDate;
	private String noticeEditDate;
	private AdminImgDTO images;	// 필드 추가, getter, setter 추가
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public String getNoticeUploadDate() {
		return noticeUploadDate;
	}
	public void setNoticeUploadDate(String noticeUploadDate) {
		this.noticeUploadDate = noticeUploadDate;
	}
	public String getNoticeEditDate() {
		return noticeEditDate;
	}
	public void setNoticeEditDate(String noticeEditDate) {
		this.noticeEditDate = noticeEditDate;
	}
	public AdminImgDTO getImages() {
		return images;
	}
	public void setImages(AdminImgDTO images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "NoticeImgDTO [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeContents="
				+ noticeContents + ", noticeUploadDate=" + noticeUploadDate + ", noticeEditDate=" + noticeEditDate
				+ ", images=" + images + "]";
	}
}
