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

		String nickname = request.getParameter("nickname");
		String id = request.getParameter("id");
		System.out.println("nickname : " + nickname);
		System.out.println("id : " + id);
	
		boolean isExist = myPageDAO.checkNickname(nickname);
//		result.setData(isExist);
		
		request.setAttribute(id, isExist);
		result.setPath("/html/mypage/mypage-accountedit.jsp");
		result.setRedirect(false);

		return result;
	}

}
