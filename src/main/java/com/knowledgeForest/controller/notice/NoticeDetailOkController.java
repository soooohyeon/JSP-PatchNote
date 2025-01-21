package com.knowledgeForest.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;
import com.knowledgeForest.dao.NoticeDAO;
import com.knowledgeForest.dto.NoticeDTO;

public class NoticeDetailOkController {

	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		NoticeDAO noticeDAO = new NoticeDAO();
		Result result = new Result();
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		NoticeDTO noticedetail = noticeDAO.selectNotice(noticeNum);
		
		request.setAttribute("noticedetail", noticedetail);
		result.setPath("/html/notice/notice-detail.jsp");
		result.setRedirect(false);
		return result;
	}
}
