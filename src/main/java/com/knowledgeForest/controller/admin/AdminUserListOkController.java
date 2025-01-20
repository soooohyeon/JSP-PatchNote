package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.UserDTO;

public class AdminUserListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("유저 목록 들어옴");
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
//		유저 목록 조회
		List<UserDTO> userList = adminDAO.selectUserAll();
		request.setAttribute("userList", userList);
		
		result.setPath("/html/admin/admin-userlist.jsp");
		result.setRedirect(false);

		System.out.println("유저 목록 종료");
		return result;
	}
	
}
