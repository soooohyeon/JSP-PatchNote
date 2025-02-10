package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dto.BannerImgDTO;

public class AdminBannerDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		
//		공지 번호 저장
		int bannerNum = Integer.parseInt(request.getParameter("bannerNum"));
//		공지 번호 전달 후 공지 정보 불러오기
		BannerImgDTO bannerImgDTO = adminDAO.selectOneBanner(bannerNum);
		
//		공지글이 존재하지 않을 경우 목록으로 되돌아가기
		if (bannerImgDTO == null) {
			System.out.println("존재하지 않는 게시글 임");
			
			result.setPath("/admin/admin-bannerlist.ad");	// 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			
			return result;
		}
		
		bannerImgDTO.setImages(adminImgDAO.selectBannerImg(bannerNum));
		
//		화면으로 전달
		request.setAttribute("banner", bannerImgDTO);
		
		result.setPath("/html/admin/admin-bannerdetail.jsp");
		result.setRedirect(false);
		
		return result;
	}
}
