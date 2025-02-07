package com.knowledgeForest.dto;

public class StudyImgDTO {
    private int studyNum;
    private int userNum;
    private String userNick;
    private String studyTitle;
    private String studyDescript;
    private String studyLocation;
    private String studyStartDay;
    private String studyEndDay;
    private String studyStartTime;
    private String studyEndTime;
    private int studyLimit;
    private String studyDeadline;
    private int studyShowph;
    private int studyCategory;
    private String studyUploadDate;
    private String studyEditDate;
    private UserImgDTO images;
    
	public int getStudyNum() {
		return studyNum;
	}
	public void setStudyNum(int studyNum) {
		this.studyNum = studyNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getStudyTitle() {
		return studyTitle;
	}
	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}
	public String getStudyDescript() {
		return studyDescript;
	}
	public void setStudyDescript(String studyDescript) {
		this.studyDescript = studyDescript;
	}
	public String getStudyLocation() {
		return studyLocation;
	}
	public void setStudyLocation(String studyLocation) {
		this.studyLocation = studyLocation;
	}
	public String getStudyStartDay() {
		return studyStartDay;
	}
	public void setStudyStartDay(String studyStartDay) {
		this.studyStartDay = studyStartDay;
	}
	public String getStudyEndDay() {
		return studyEndDay;
	}
	public void setStudyEndDay(String studyEndDay) {
		this.studyEndDay = studyEndDay;
	}
	public String getStudyStartTime() {
		return studyStartTime;
	}
	public void setStudyStartTime(String studyStartTime) {
		this.studyStartTime = studyStartTime;
	}
	public String getStudyEndTime() {
		return studyEndTime;
	}
	public void setStudyEndTime(String studyEndTime) {
		this.studyEndTime = studyEndTime;
	}
	public int getStudyLimit() {
		return studyLimit;
	}
	public void setStudyLimit(int studyLimit) {
		this.studyLimit = studyLimit;
	}
	public String getStudyDeadline() {
		return studyDeadline;
	}
	public void setStudyDeadline(String studyDeadline) {
		this.studyDeadline = studyDeadline;
	}
	public int getStudyShowph() {
		return studyShowph;
	}
	public void setStudyShowph(int studyShowph) {
		this.studyShowph = studyShowph;
	}
	public int getStudyCategory() {
		return studyCategory;
	}
	public void setStudyCategory(int studyCategory) {
		this.studyCategory = studyCategory;
	}
	public String getStudyUploadDate() {
		return studyUploadDate;
	}
	public void setStudyUploadDate(String studyUploadDate) {
		this.studyUploadDate = studyUploadDate;
	}
	public String getStudyEditDate() {
		return studyEditDate;
	}
	public void setStudyEditDate(String studyEditDate) {
		this.studyEditDate = studyEditDate;
	}
	public UserImgDTO getImages() {
		return images;
	}
	public void setImages(UserImgDTO images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "StudyImgDTO [studyNum=" + studyNum + ", userNum=" + userNum + ", userNick=" + userNick + ", studyTitle="
				+ studyTitle + ", studyDescript=" + studyDescript + ", studyLocation=" + studyLocation
				+ ", studyStartDay=" + studyStartDay + ", studyEndDay=" + studyEndDay + ", studyStartTime="
				+ studyStartTime + ", studyEndTime=" + studyEndTime + ", studyLimit=" + studyLimit + ", studyDeadline="
				+ studyDeadline + ", studyShowph=" + studyShowph + ", studyCategory=" + studyCategory
				+ ", studyUploadDate=" + studyUploadDate + ", studyEditDate=" + studyEditDate + ", images=" + images
				+ "]";
	}
   
}
