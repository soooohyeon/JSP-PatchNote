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

// 관리자 전체 유저 목록 조회
public class AdminUserListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		String keyword = request.getParameter("keyWord");
		System.out.println("keyWord : " + keyword);
		List<UserDTO> userList = null;
		
//		유저 목록 조회
		if (keyword != null) {
			keyword = '%' + keyword + '%';
			userList = adminDAO.selectUserSearch(keyword);
		} else {
			userList = adminDAO.selectUserAll();
		}
		
		request.setAttribute("userList", userList);
		result.setPath("/html/admin/admin-userlist.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
