package com.knowledgeForest.dto;

public class NoticeDTO {
//	CREATE TABLE TBL_NOTICE (
//			NOTICE_NUM NUMBER,
//			NOTICE_TITLE VARCHAR2(100) NOT NULL,
//			NOTICE_CONTENTS VARCHAR2(1000) NOT NULL,
//			NOTICE_UPLOAD_DATE DATE DEFAULT SYSDATE NOT NULL,
//			NOTICE_EDIT_DATE DATE DEFAULT SYSDATE NOT NULL,
//			CONSTRAINT PK_NOTICE PRIMARY KEY (NOTICE_NUM)
//		);
	private int noticeNum;
	private String noticeTitle;
	private String noticeContents;
	private String noticeUploadDate;
	private String noticeEditDate;
	
	
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public String getNoticeUploadDate() {
		return noticeUploadDate;
	}
	public void setNoticeUploadDate(String noticeUploadDate) {
		this.noticeUploadDate = noticeUploadDate;
	}
	public String getNoticeEditDate() {
		return noticeEditDate;
	}
	public void setNoticeEditDate(String noticeEditDate) {
		this.noticeEditDate = noticeEditDate;
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeContents="
				+ noticeContents + ", noticeUploadDate=" + noticeUploadDate + ", noticeEditDate=" + noticeEditDate
				+ "]";
	}
	
	
	
	
}
