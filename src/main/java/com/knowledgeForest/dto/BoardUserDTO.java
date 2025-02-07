package com.knowledgeForest.dto;

public class BoardUserDTO {

	private int boardNum;
	private int userNum;
	private String userNick;
	private String boardTitle;
	private String boardContents;
	private String boardUploadDate;
	private String boardEditDate;
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
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getBoardUploadDate() {
		return boardUploadDate;
	}
	public void setBoardUploadDate(String boardUploadDate) {
		this.boardUploadDate = boardUploadDate;
	}
	public String getBordEditDate() {
		return boardEditDate;
	}
	public void setBordEditDate(String bordEditDate) {
		this.boardEditDate = bordEditDate;
	}
	@Override
	public String toString() {
		return "BoardUserDTO [boardNum=" + boardNum + ", userNum=" + userNum + ", userNick=" + userNick
				+ ", boardTitle=" + boardTitle + ", boardContents=" + boardContents + ", boardUploadDate="
				+ boardUploadDate + ", bordEditDate=" + boardEditDate + "]";
	}
	
}
