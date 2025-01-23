package com.knowledgeForest.dto;

public class StudyApplyUserDTO {
//	STUDY_APPLY_NUM" NUMBER, 
//	STUDY_NUM" NUMBER, 
//	USER_NUM" NUMBER, 
//	USER_DETERMINATION" VARCHAR2(500) NOT NULL ENABLE, 
//	STUDY_APPLY_STATUS" NUMBER DEFAULT 0 NOT NULL ENABLE, 
//	STUDY_APPLY_DATE" DATE DEFAULT SYSDATE NOT NULL ENABLE, 

	private int studyApplyNum;
	private int studyNum;
	private int userNum;
	private String userDetermination;
	private int studyApplyStatus;
	private String studyApplyDate;
	private String userId;
	private String userNick;
	private int participants;
	private int limitParticipants;
	private String deadline;
	public int getStudyApplyNum() {
		return studyApplyNum;
	}
	public void setStudyApplyNum(int studyApplyNum) {
		this.studyApplyNum = studyApplyNum;
	}
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
	public String getUserDetermination() {
		return userDetermination;
	}
	public void setUserDetermination(String userDetermination) {
		this.userDetermination = userDetermination;
	}
	public int getStudyApplyStatus() {
		return studyApplyStatus;
	}
	public void setStudyApplyStatus(int studyApplyStatus) {
		this.studyApplyStatus = studyApplyStatus;
	}
	public String getStudyApplyDate() {
		return studyApplyDate;
	}
	public void setStudyApplyDate(String studyApplyDate) {
		this.studyApplyDate = studyApplyDate;
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
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public int getLimitParticipants() {
		return limitParticipants;
	}
	public void setLimitParticipants(int limitParticipants) {
		this.limitParticipants = limitParticipants;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "StudyApplyUserDTO [studyApplyNum=" + studyApplyNum + ", studyNum=" + studyNum + ", userNum=" + userNum
				+ ", userDetermination=" + userDetermination + ", studyApplyStatus=" + studyApplyStatus
				+ ", studyApplyDate=" + studyApplyDate + ", userId=" + userId + ", userNick=" + userNick
				+ ", participants=" + participants + ", limitParticipants=" + limitParticipants + ", deadline="
				+ deadline + "]";
	}

}
