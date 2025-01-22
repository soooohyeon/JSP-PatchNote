package com.knowledgeForest.dto;

public class StudyUserDTO {

    private int studyNum;          
    private int userNum;           
    private String studyTitle;     
    private String studyDescript;  
    private String studyLocation;  
    private String studyStartDay;  
    private String studyEndDay;    
    private String studyStartTime; 
    private String studyEndTime;   
    private int studyLimit;        
    private String studyDeadline;  
    private int studyShowPh;    
    private int studyCategory;  
    private String studyUploadDate;
    private String studyEditDate;  
    private String userId;         
    private String userNick;       
    private String userPh;      
    private int participants;		// 확정인원  
    private int likeCount;

//	getter(), setter() 
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

	public int getStudyShowPh() {
		return studyShowPh;
	}

	public void setStudyShowPh(int studyShowPh) {
		this.studyShowPh = studyShowPh;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserPh() {
		return userPh;
	}

	public void setUserPh(String userPh) {
		this.userPh = userPh;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
//	toString() 메소드 오버라이딩

	@Override
	public String toString() {
		return "StudyUserDTO [studyNum=" + studyNum + ", userNum=" + userNum + ", studyTitle=" + studyTitle
				+ ", studyDescript=" + studyDescript + ", studyLocation=" + studyLocation + ", studyStartDay="
				+ studyStartDay + ", studyEndDay=" + studyEndDay + ", studyStartTime=" + studyStartTime
				+ ", studyEndTime=" + studyEndTime + ", studyLimit=" + studyLimit + ", studyDeadline=" + studyDeadline
				+ ", studyShowPh=" + studyShowPh + ", studyCategory=" + studyCategory + ", studyUploadDate="
				+ studyUploadDate + ", studyEditDate=" + studyEditDate + ", userId=" + userId + ", userNick=" + userNick
				+ ", userPh=" + userPh + ", participants=" + participants + ", likeCount=" + likeCount
				+ ", getStudyNum()=" + getStudyNum() + ", getUserNum()=" + getUserNum() + ", getStudyTitle()="
				+ getStudyTitle() + ", getStudyDescript()=" + getStudyDescript() + ", getStudyLocation()="
				+ getStudyLocation() + ", getStudyStartDay()=" + getStudyStartDay() + ", getStudyEndDay()="
				+ getStudyEndDay() + ", getStudyStartTime()=" + getStudyStartTime() + ", getStudyEndTime()="
				+ getStudyEndTime() + ", getStudyLimit()=" + getStudyLimit() + ", getStudyDeadline()="
				+ getStudyDeadline() + ", getStudyShowPh()=" + getStudyShowPh() + ", getStudyCategory()="
				+ getStudyCategory() + ", getStudyUploadDate()=" + getStudyUploadDate() + ", getStudyEditDate()="
				+ getStudyEditDate() + ", getUserId()=" + getUserId() + ", getUserNick()=" + getUserNick()
				+ ", getUserPh()=" + getUserPh() + ", getParticipants()=" + getParticipants() + ", getLikeCount()="
				+ getLikeCount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
