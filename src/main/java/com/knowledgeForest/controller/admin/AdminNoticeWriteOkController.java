package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.NoticeDTO;

public class AdminNoticeWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
		NoticeDTO notice = new NoticeDTO();
//		작성된 제목, 내용 객체에 담기
		notice.setNoticeTitle(request.getParameter("noticeTitle"));
		notice.setNoticeContents(request.getParameter("noticeCotent"));

//		값 DAO 메소드로 전달하여 DB에 값 저장
		adminDAO.insertNotice(notice);
		
		result.setPath(request.getContextPath() + "/admin/admin-noticelist.ad");
		result.setRedirect(true);
		
		return result;
	}
	
}
