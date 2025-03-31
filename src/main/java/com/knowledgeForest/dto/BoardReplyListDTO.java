package com.knowledgeForest.dto;

public class BoardReplyListDTO {

	private int fbCommentNum;
	private String fbCommentContent;
	private String fbCommentUploadDate;
	private int boardNum;
	private int userNum;
	private String userId;
	private String userNick;
	
	public int getFbCommentNum() {
		return fbCommentNum;
	}
	public void setFbCommentNum(int fbCommentNum) {
		this.fbCommentNum = fbCommentNum;
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
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BoardReplyListDTO [fbCommentNum=" + fbCommentNum + ", fbCommentContent=" + fbCommentContent
				+ ", fbCommentUploadDate=" + fbCommentUploadDate + ", boardNum=" + boardNum + ", userNum=" + userNum
				+ ", userNick=" + userNick + ", userId=" + userId + "]";
	}
	
}
