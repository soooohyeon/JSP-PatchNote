package com.knowledgeForest.dto;

public class LoginDTO {
	//field
		private int userNum;
		private String userId;
		private String userPw;
		private String userNick;
		private String userBirth;
		private String userPH;
		private String userName;

		
		//getter setter
		
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
		public String getUserPw() {
			return userPw;
		}
		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}
		public String getUserNick() {
			return userNick;
		}
		public void setUserNick(String userNick) {
			this.userNick = userNick;
		}
		public String getUserBirth() {
			return userBirth;
		}
		public void setUserBirth(String userBirth) {
			this.userBirth = userBirth;
		}

		public String getUserPH() {
			return userPH;
		}
		public void setUserPH(String userPH) {
			this.userPH = userPH;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/*
		 * public String getUserJoinDate() { return userJoinDate; } public void
		 * setUserJoinDate(String userJoinDate) { this.userJoinDate = userJoinDate; }
		 */
		
		
		@Override
		public String toString() {
			return "UserDTO [userNum=" + userNum + ", userId=" + userId + ", userPw=" + userPw + ", userNick=" + userNick
					+ ", userBirth=" + userBirth + ", userPH=" + userPH + ", userName=" + userName + "]";
		}
		


		

	}