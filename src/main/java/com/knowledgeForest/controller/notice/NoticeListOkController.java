package com.knowledgeForest.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.NoticeDAO;
import com.knowledgeForest.dto.NoticeDTO;

public class NoticeListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		NoticeDAO noticeDAO = new NoticeDAO();
		Result result = new Result();
		
		List<NoticeDTO> noticeList = noticeDAO.getNotice();
		request.setAttribute("noticeList", noticeList);
		noticeList.forEach(System.out::println);
		result.setPath("/html/notice/notice-list.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
