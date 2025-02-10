package com.knowledgeForest.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dao.NoticeDAO;
import com.knowledgeForest.dto.NoticeImgDTO;

public class NoticeDetailOkController {

	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		NoticeDAO noticeDAO = new NoticeDAO();
		Result result = new Result();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		NoticeImgDTO noticeImgDTO = noticeDAO.selectNotice(noticeNum);
		noticeImgDTO.setImages(adminImgDAO.selectNoticeImg(noticeNum));
		request.setAttribute("noticedetail", noticeImgDTO);
		result.setPath("/html/notice/notice-detail.jsp");
		result.setRedirect(false);
		return result;
	}
}
