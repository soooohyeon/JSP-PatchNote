package com.knowledgeForest.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;

public class PasswrdUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		LoginDAO loginDAO = new LoginDAO();

		HttpSession session = request.getSession(false); // 기존 세션 불러오기
		int userNum = (Integer) session.getAttribute("userNum");

//		비밀번호, ID MAP 타입으로 DAO에 전달
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("userNum", userNum);
		userInfo.put("userPw", request.getParameter("userPw"));
		
//		비밀번호 수정 메소드 호출
		loginDAO.updatePw(userInfo);

//		저장된 세션 삭제
		session.invalidate();
		result.setPath(request.getContextPath()+"/login/login.me");
		result.setRedirect(false);
		
		return result;
	}
}
