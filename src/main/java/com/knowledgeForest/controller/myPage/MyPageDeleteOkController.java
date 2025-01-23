package com.knowledgeForest.controller.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;

// 유저 탈퇴
public class MyPageDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MyPageDAO mypageDAO = new MyPageDAO();
		Result result = new Result();
		HttpSession session = request.getSession(false);

//		userNum 변수에 저장
		int userNum = (int) session.getAttribute("userNumber");

		System.out.println(userNum);
		
//		유저 데이터 삭제 메소드 실행 - userNum 전달
		mypageDAO.deleteUser(userNum);

//		세션 무효화
		session.invalidate();
//		경로 설정
		result.setPath(request.getContextPath() + "/knowledgeForest.main");
		result.setRedirect(true);
		
		return result;
	}

}
