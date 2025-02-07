package com.knowledgeForest.dto;

public class StudyCommentDTO {
	private int studyCommentNum;
	private int studyNum;
	private int userNum;
	private String studyComment;
	private String studyCommentUploadDate;
	private String studyCommentEditDate;
	
	public int getStudyCommentNum() {
		return studyCommentNum;
	}
	public void setStudyCommentNum(int studyCommentNum) {
		this.studyCommentNum = studyCommentNum;
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
	public String getStudyComment() {
		return studyComment;
	}
	public void setStudyComment(String studyComment) {
		this.studyComment = studyComment;
	}
	public String getStudyCommentUploadDate() {
		return studyCommentUploadDate;
	}
	public void setStudyCommentUploadDate(String studyCommentUploadDate) {
		this.studyCommentUploadDate = studyCommentUploadDate;
	}
	public String getStudyCommentEditDate() {
		return studyCommentEditDate;
	}
	public void setStudyCommentEditDate(String studyCommentEditDate) {
		this.studyCommentEditDate = studyCommentEditDate;
	}
	
	@Override
	public String toString() {
		return "StudyCommentDTO [studyCommentNum=" + studyCommentNum + ", studyNum=" + studyNum + ", userNum=" + userNum
				+ ", studyComment=" + studyComment + ", studyCommentUploadDate=" + studyCommentUploadDate
				+ ", studyCommentEditDate=" + studyCommentEditDate + "]";
	}
	
	
}
