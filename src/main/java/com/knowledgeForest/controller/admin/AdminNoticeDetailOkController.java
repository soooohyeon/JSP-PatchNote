package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.NoticeImgDTO;

public class AdminNoticeDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		
//		공지 번호 저장
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
//		공지 번호 전달 후 공지 정보 불러오기
		NoticeImgDTO noticeImgDTO = adminDAO.selectOneNotice(noticeNum);
		
//		공지글이 존재하지 않을 경우 목록으로 되돌아가기
		if (noticeImgDTO == null) {
			System.out.println("존재하지 않는 게시글 임");
			
			result.setPath("/admin/admin-noticelist.ad");	// 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			
			return result;
		}
		
		noticeImgDTO.setImages(adminImgDAO.selectNoticeImg(noticeNum));
		
//		화면으로 전달
		request.setAttribute("notice", noticeImgDTO);
		
		result.setPath("/html/admin/admin-noticedetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
