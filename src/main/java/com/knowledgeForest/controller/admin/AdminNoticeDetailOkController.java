package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.NoticeDTO;

public class AdminNoticeDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
//		공지 번호 저장
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
//		공지 번호 전달 후 공지 정보 불러오기
		NoticeDTO notice = adminDAO.selectOneNotice(noticeNum);
		
//		화면으로 전달
		request.setAttribute("notice", notice);
		
		result.setPath("/html/admin/admin-noticedetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
