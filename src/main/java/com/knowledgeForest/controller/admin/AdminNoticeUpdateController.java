package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dto.NoticeImgDTO;

public class AdminNoticeUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		NoticeImgDTO noticeImgDTO = adminDAO.selectOneNotice(noticeNum);
		
		request.setAttribute("notice", noticeImgDTO);
		
		result.setPath("/html/admin/admin-noticeupdate.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
