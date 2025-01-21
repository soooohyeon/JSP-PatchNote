package com.knowledgeForest.dto;

public class LikeDTO {
	
	// 위시 리스트 		
	private int likeNum; // LIKE_NUM
	private int userNum; // USER_NUM
	private int studyNum; // STUDY_NUM
	private String likeDate; // LIKE_DATE

	// TBL_STUDY 테이블의 컬럼
	private String studyTitle; // STUDY_TITLE

	// Getters and Setters
	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getStudyNum() {
		return studyNum;
	}

	public void setStudyNum(int studyNum) {
		this.studyNum = studyNum;
	}

	public String getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}

	public String getStudyTitle() {
		return studyTitle;
	}

	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}

	@Override
	public String toString() {
		return "LikeDTO{" + "likeNum=" + likeNum + ", userNum=" + userNum + ", studyNum=" + studyNum + ", likeDate='"
				+ likeDate + '\'' + ", studyTitle='" + studyTitle + '\'' + '}';
	}
}
