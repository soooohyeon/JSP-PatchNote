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

public class AdminBannerUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		
		int bannerNum = Integer.parseInt(request.getParameter("bannerNum"));
		BannerImgDTO bannerImgDTO = adminDAO.selectOneBanner(bannerNum);
		
		request.setAttribute("banner", bannerImgDTO);
		
		result.setPath("/html/admin/admin-bannerupdate.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
