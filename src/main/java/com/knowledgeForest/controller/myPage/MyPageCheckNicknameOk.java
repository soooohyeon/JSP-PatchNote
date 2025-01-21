package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;

public class MyPageCheckNicknameOk implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MyPageDAO myPageDAO = new MyPageDAO();
		Result result = new Result();
		String userNick = request.getParameter("userNick");
		System.out.println("userNick : " + userNick);
	
		boolean isExist = myPageDAO.checkNickname(userNick);
		System.out.println("isExist" + isExist);
		request.setAttribute(userNick, isExist);
		// result.setPath("/html/mypage/mypage-accountedit.jsp");
		// result.setRedirect(true);
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().write(isExist ? "1" : "0");
		// return result;
		return null;
	}

}
