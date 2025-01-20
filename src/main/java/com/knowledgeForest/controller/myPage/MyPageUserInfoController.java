package com.knowledgeForest.controller.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.UserDTO;

public class MyPageUserInfoController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserDTO user = new MyPageDAO().getUserInfo(userId);
		request.setAttribute("userId", userId);
		return new Result(false, "/html/mypage/mypage-accountedit.jsp");

		return null;
	}

}
