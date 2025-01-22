package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.NoticeDTO;

public class AdminNoticeUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		NoticeDTO notice = adminDAO.selectOneNotice(noticeNum);
		
		request.setAttribute("notice", notice);
		
		result.setPath("/html/admin/admin-noticeupdate.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
