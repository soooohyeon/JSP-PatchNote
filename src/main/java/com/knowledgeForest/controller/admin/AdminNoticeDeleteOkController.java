package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;

public class AdminNoticeDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

//		noticeNum 변수에 저장
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
//		공지 데이터 삭제 메소드 실행 - noticeNum 전달
		adminDAO.deleteNotice(noticeNum);

//		경로 설정
		result.setPath(request.getContextPath() + "/admin/admin-noticelist.ad");
		result.setRedirect(false);
		
		return result;
	}
	
}
