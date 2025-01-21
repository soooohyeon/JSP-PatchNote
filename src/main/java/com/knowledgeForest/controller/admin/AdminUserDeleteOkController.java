package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;

// 유저 탈퇴
public class AdminUserDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

//		userNum 변수에 저장
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		
//		유저 데이터 삭제 메소드 실행 - userNum 전달
		adminDAO.deleteUser(userNum);

//		경로 설정
		result.setPath(request.getContextPath() + "/admin/admin-main.ad");
		result.setRedirect(true);
		
		return result;
	}

}
