package com.knowledgeForest.dto;

public class FbCommentDTO {
//CREATE TABLE TBL_FB_COMMENT (
//	FB_COMMENT_NUM NUMBER, 
//	BOARD_NUM NUMBER, 
//	USER_NUM NUMBER, 
//	FB_COMMENT_CONTENT VARCHAR2(200) NOT NULL, 
//	FB_COMMENT_UPLOAD_DATE DATE DEFAULT SYSDATE NOT NULL, 
//	FB_COMMENT_EDIT_DATE DATE DEFAULT SYSDATE NOT NULL,
//	CONSTRAINT PK_FB_COMMENT PRIMARY KEY (FB_COMMENT_NUM)
//)
	private int fbCommentNum;
	private int boardNum;
	private int userNum;
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
		return "FbCommentDTO [fbCommentNum=" + fbCommentNum + ", boardNum=" + boardNum + ", userNum=" + userNum
				+ ", fbCommentContent=" + fbCommentContent + ", fbCommentUploadDate=" + fbCommentUploadDate
				+ ", fbCommentEditDate=" + fbCommentEditDate + "]";
	}
}
