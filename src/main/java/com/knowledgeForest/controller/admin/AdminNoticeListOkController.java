package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.NoticeDTO;

public class AdminNoticeListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		String keyword = request.getParameter("keyWord");
		System.out.println("keyWord : " + keyword);
		List<NoticeDTO> noticeList = null;
		
//		유저 목록 조회
		if (keyword != null) {
			keyword = '%' + keyword + '%';
//			noticeList = adminDAO.selectNoticeSearch(keyword);
		} else {
//			noticeList = adminDAO.selectNoticeAll();
		}
		
//		request.setAttribute("noticeList", noticeList);
		result.setPath("/html/admin/admin-noticeList.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
