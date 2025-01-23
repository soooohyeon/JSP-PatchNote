package com.knowledgeForest.dto;

public class StudyApplyDTO {
	private int studyNum;
	private String studyTitle;
	private int studyLimit;
	private String userNick;
	private String participants;
	private String studyDeadline;
	private String studyStartDay;
	private String studyEndDay;
	private String studyStartTime;
	private String studyEndTime;
	private int studyCategory;
	private int studyApplyNum;
	private String studyApplyDate;
	private int studyApplyStatus;
	private String userDetermination;

	// getter, setter
	public int getStudyNum() {
		return studyNum;
	}

	public void setStudyNum(int studyNum) {
		this.studyNum = studyNum;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
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

	public int getStudyCategory() {
		return studyCategory;
	}

	public void setStudyCategory(int studyCategory) {
		this.studyCategory = studyCategory;
	}

	public int getStudyApplyNum() {
		return studyApplyNum;
	}

	public void setStudyApplyNum(int studyApplyNum) {
		this.studyApplyNum = studyApplyNum;
	}

	public String getStudyApplyDate() {
		return studyApplyDate;
	}

	public void setStudyApplyDate(String studyApplyDate) {
		this.studyApplyDate = studyApplyDate;
	}

	public int getStudyApplyStatus() {
		return studyApplyStatus;
	}

	public void setStudyApplyStatus(int studyApplyStatus) {
		this.studyApplyStatus = studyApplyStatus;
	}

	public String getUserDetermination() {
		return userDetermination;
	}

	public void setUserDetermination(String userDetermination) {
		this.userDetermination = userDetermination;
	}

//	toString() 메소드
	@Override
	public String toString() {
		return "StudyApplyDTO [studyNum=" + studyNum + ", studyTitle=" + studyTitle + ", studyLimit=" + studyLimit
				+ ", studyDeadline=" + studyDeadline + ", studyStartDay=" + studyStartDay + ", studyEndDay="
				+ studyEndDay + ", studyStartTime=" + studyStartTime + ", studyEndTime=" + studyEndTime
				+ ", studyCategory=" + studyCategory + ", studyApplyNum=" + studyApplyNum + ", studyApplyDate="
				+ studyApplyDate + ", studyApplyStatus=" + studyApplyStatus + ", userDetermination=" + userDetermination
				+ "]";
	}

}
