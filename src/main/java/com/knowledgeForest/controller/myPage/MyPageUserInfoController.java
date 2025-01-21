package com.knowledgeForest.controller.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.UserDTO;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyPageUserInfoController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		  // 요청과 응답의 인코딩 설정
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		//POST 요청일 경우
		if (request.getMethod().equalsIgnoreCase("POST")) {
	        // 사용자가 입력한 값 가져오기
			response.setContentType("text/html; charset=UTF-8");

			System.out.println("post 요청됨");
			
	        String userId = request.getParameter("userId");
	        String userName = request.getParameter("userName");
	        String userBirth = request.getParameter("userBirth");
	        String userNick = request.getParameter("userNick");
	        String userPH = request.getParameter("userPH");
            String userPw = request.getParameter("userPw");


	        // DTO에 값 설정
	        UserDTO user = new UserDTO();
	        user.setUserId(userId);
	        user.setUserName(userName);
	        user.setUserBirth(userBirth);
	        user.setUserNick(userNick);
	        user.setUserPH(userPH);
	        user.setUserPw(userPw);
	        
	        System.out.println("수정된 user 값 : " +user);

	        // DAO를 통해 업데이트 수행
	        MyPageDAO myPageDAO = new MyPageDAO();
	        int updateResult = myPageDAO.updateUserInfo(user);

	        if (updateResult > 0) {
	            request.setAttribute("message", "회원정보가 성공적으로 수정되었습니다.");
	        } else {
	            request.setAttribute("message", "회원정보 수정에 실패했습니다.");
	        }

	        Result result = new Result();
			result.setPath("/html/mypage/mypage-accountedit.jsp");
			result.setRedirect(false);

			return result;
	    }
		
		
	
	    // GET 요청 시 사용자 정보 조회
		//String userId = request.getParameter("userId");
		String userId = "eunji69";
		MyPageDAO myPageDAO = new MyPageDAO();
		UserDTO userInfo = myPageDAO.getUserInfo(userId);

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
		result.setPath("/html/mypage/mypage-accountedit.jsp");
		result.setRedirect(false);

		return result;
	}

}
