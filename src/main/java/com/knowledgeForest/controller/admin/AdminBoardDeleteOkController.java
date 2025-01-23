package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;

public class AdminBoardDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		
		adminDAO.deleteBoard(boardNum);
		
		result.setPath(request.getContextPath() + "/admin/admin-boardlist.ad");
		result.setRedirect(false);
		return result;
	}
}