package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.UserDTO;

public class MyPageUserInfoEditOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // 현재 세션 가져오기
		int userNum = (int) session.getAttribute("userNumber");

		MyPageDAO myPageDAO = new MyPageDAO();

		// 폼 데이터 가져오기
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userNick = request.getParameter("userNick");
		String userPw = request.getParameter("userPw");
		String userPH = request.getParameter("userPH");

		// userDTO 객체 생성 및 데이터 설정
		UserDTO userInfo = new UserDTO();
		userInfo.setUserId(userId);
		userInfo.setUserNum(userNum);
		userInfo.setUserName(userName);
		userInfo.setUserBirth(userBirth);
		userInfo.setUserPH(userPH);
		userInfo.setUserNick(userNick);
		userInfo.setUserPw(userPw);

		// DAO메소드 호출
		int updateResult = myPageDAO.updateUserInfo(userInfo);

		// 결과 처리
		if (updateResult > 0) {
			request.setAttribute("message", "회원정보가 수정되었습니다.");
		} else {
			request.setAttribute("message", "회원정보 수정에 실패했습니다.");
		}

		// JSP에서 사용할 데이터 저장
		request.setAttribute("userInfo", userInfo);
		Result result = new Result();
		
		result.setPath(request.getContextPath() + "/mypage/mypage-accountedit.my"); // 리다이렉션 경로 수정
		result.setRedirect(true); // 리다이렉션 설정
		return result;
	}

}
