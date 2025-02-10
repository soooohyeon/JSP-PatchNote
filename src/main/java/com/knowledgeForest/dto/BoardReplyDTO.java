package com.knowledgeForest.dto;

public class BoardReplyDTO {

	private int fbCommentNum;
	private String fbCommentContent;
	private String fbCommentDate;
	private int boardNum;
	private int userNum;
	
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
	public String getFbCommentDate() {
		return fbCommentDate;
	}
	public void setFbCommentDate(String fbCommentDate) {
		this.fbCommentDate = fbCommentDate;
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
	
	@Override
	public String toString() {
		return "BoardReplyDTO [fbCommentNum=" + fbCommentNum + ", fbCommentContent=" + fbCommentContent
				+ ", fbCommentDate=" + fbCommentDate + ", boardNum=" + boardNum + ", userNum=" + userNum + "]";
	}
}
