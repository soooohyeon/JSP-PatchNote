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
//		String userId = request.getParameter("userId");
		String userId = "eunji69";
		System.out.println(userId);
		UserDTO user = new MyPageDAO().getUserInfo(userId);
		System.out.println(user);
		request.setAttribute("userId", userId);
		Result result = new Result();
		result.setPath("/html/mypage/mypage-accountedit.jsp");
		result.setRedirect(false);

		return result;
	}

}
