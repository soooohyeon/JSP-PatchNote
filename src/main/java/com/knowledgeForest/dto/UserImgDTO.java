package com.knowledgeForest.dto;

public class UserImgDTO {
	private int userImgNum;
	private int studyNum;
	private int boardNum;
	private String userImgName;	// 실제 이미지명
	private String userImgUuid;	// 서버에 저장되는 이미지명
	public int getUserImgNum() {
		return userImgNum;
	}
	public void setUserImgNum(int userImgNum) {
		this.userImgNum = userImgNum;
	}
	public int getStudyNum() {
		return studyNum;
	}
	public void setStudyNum(int studyNum) {
		this.studyNum = studyNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserImgName() {
		return userImgName;
	}
	public void setUserImgName(String userImgName) {
		this.userImgName = userImgName;
	}
	public String getUserImgUuid() {
		return userImgUuid;
	}
	public void setUserImgUuid(String userImgUuid) {
		this.userImgUuid = userImgUuid;
	}
	
	@Override
	public String toString() {
		return "UserImgDTO [userImgNum=" + userImgNum + ", studyNum=" + studyNum + ", boardNum=" + boardNum
				+ ", userImgName=" + userImgName + ", userImgUuid=" + userImgUuid + "]";
	}
}