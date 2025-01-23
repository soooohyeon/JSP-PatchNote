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
		UserDTO userInfo = myPageDAO.getUserInfo(userNum);

		// 날짜 변환 처리 (1986-02-14 00:00:00 -> 19860214)
		try {
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");

			Date birthDate = inputFormat.parse(userInfo.getUserBirth());
			String formattedBirthDate = outputFormat.format(birthDate);
			userInfo.setUserBirth(formattedBirthDate); // 변환된 값 설정
		} catch (Exception e) {
			e.printStackTrace();
		}

		// JSP에서 사용할 데이터 저장
		request.setAttribute("userInfo", userInfo);
		Result result = new Result();
		result.setPath(request.getContextPath() + "/html/mypage/mypage-accountedit.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
