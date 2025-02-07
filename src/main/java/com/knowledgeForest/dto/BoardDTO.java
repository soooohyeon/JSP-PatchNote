package com.knowledgeForest.dto;

public class BoardDTO {

//   CREATE TABLE TBL_BOARD (
//         BOARD_NUM NUMBER,
//         USER_NUM NUMBER NOT NULL,
//         BOARD_TITLE VARCHAR2(100) NOT NULL,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
//         BOARD_CONTENTS VARCHAR2(1000) NOT NULL,
//         BOARD_UPLOAD_DATE DATE DEFAULT SYSDATE NOT NULL,
//         BOARD_EDIT_DATE DATE DEFAULT SYSDATE NOT NULL,
//         CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NUM),
//         CONSTRAINT FK_USER FOREIGN KEY (USER_NUM)
//               REFERENCES TBL_USER(USER_NUM) ON DELETE CASCADE
//      );


	private int boardNum;
	private int userNum;
	private String boardTitle;
	private String boardContents;
	private String boardAuthor;
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

	public String getBoardAuthor() {
		return boardAuthor;
	}

	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
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

	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	public void setContent(String content) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", userNum=" + userNum + ", boardTitle=" + boardTitle
				+ ", boardContents=" + boardContents + ", boardAuthor=" + boardAuthor + ", boardUploadDate="
				+ boardUploadDate + ", bordEditDate=" + boardEditDate + "]";
	}


	
	

}
