package com.knowledgeForest.dto;

public class FbCommemtUserDTO {
	private int fbCommentNum;
	private int boardNum;
	private int userNum;
	private String userId;
	private String userNick;
	private String fbCommentContent;
	private String fbCommentUploadDate;
	private String fbCommentEditDate;
	
	public int getFbCommentNum() {
		return fbCommentNum;
	}
	public void setFbCommentNum(int fbCommentNum) {
		this.fbCommentNum = fbCommentNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
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
	public String getFbCommentContent() {
		return fbCommentContent;
	}
	public void setFbCommentContent(String fbCommentContent) {
		this.fbCommentContent = fbCommentContent;
	}
	public String getFbCommentUploadDate() {
		return fbCommentUploadDate;
	}
	public void setFbCommentUploadDate(String fbCommentUploadDate) {
		this.fbCommentUploadDate = fbCommentUploadDate;
	}
	public String getFbCommentEditDate() {
		return fbCommentEditDate;
	}
	public void setFbCommentEditDate(String fbCommentEditDate) {
		this.fbCommentEditDate = fbCommentEditDate;
	}
	
	@Override
	public String toString() {
		return "FbCommemtUserDTO [fbCommentNum=" + fbCommentNum + ", boardNum=" + boardNum + ", userNum=" + userNum
				+ ", userId=" + userId + ", userNick=" + userNick + ", fbCommentContent=" + fbCommentContent
				+ ", fbCommentUploadDate=" + fbCommentUploadDate + ", fbCommentEditDate=" + fbCommentEditDate + "]";
	}
}
