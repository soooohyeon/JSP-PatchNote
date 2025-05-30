package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dto.AdminImgDTO;
import com.knowledgeForest.dto.BannerDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminBannerWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		BannerDTO bannerDTO = new BannerDTO();
//		이미지 첨부에 필요한 객체
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		AdminImgDTO adminImgDTO = new AdminImgDTO();
		
//		----------------------------------------------------------------------------
//		이미지 경로 설정
//		final String UPLOAD_PATH = "D:\\web_0900_psh\\jsp_6\\workspace\\final_jsp\\src\\main\\webapp\\upload";
		final String UPLOAD_PATH = "D:\\kdt_0900_psh\\jsp_6\\project\\back\\forest\\src\\main\\webapp\\upload\\banner";

//		배포시 지정할 경로
//		.metadata/.plugins/.../wtpwebapps/ 내부 경로가 반환되는 이유는 Eclipse의 WTP (Web Tools Platform) 서버 설정 때문
//		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("upload/banner/");
//		최대 이미지 파일 크기 제한 5MB
		final int FILE_SIZE = 1024 * 1024 * 5;
		
//		해당 객체를 사용하기 위해 cos.jar 파일을 빌드패스 해주어야함
//		MultipartRequest 객체 생성시 옵션 설정 필요 - req객체, 업로드 경로, 최대 크기, 인코딩 방식, 이름 정책(중복되는 파일명이 있을경우 이름을 바꾸는 규칙)
		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());
//		----------------------------------------------------------------------------
		
		bannerDTO.setBannerName(multipartRequest.getParameter("bannerName"));
		
		int bannerNum = adminDAO.insertBanner(bannerDTO);
		
//		----------------------------------------------------------------------------
//		getFileNames()는 input태그의 name 속성을 의미 / 반환타입이 Enumeration (Iterator 이전에 사용된 객체)\
		Enumeration<String> fileName = multipartRequest.getFileNames();
		
//		Iterator의 hasNext()
		while (fileName.hasMoreElements()) {
//			Iterator의 hasNext() / name : 태그의 이름을 의미
			String name = fileName.nextElement();
//			이미지가 저장될 때의 이름
			String fileSystemName = multipartRequest.getFilesystemName(name);
//			이미지의 원본 이름
			String fileOriginalName = multipartRequest.getOriginalFileName(name);
			
//			첨부된 이미지가 없을 때 처리 X
			if (fileSystemName == null) {
				continue;
			}
			adminImgDTO.setAdminImgUuid(fileSystemName);
			adminImgDTO.setAdminImgName(fileOriginalName);
			adminImgDTO.setBannerNum(bannerNum);
//			이미지 저장
			adminImgDAO.insertBannerImg(adminImgDTO);
		}
//		----------------------------------------------------------------------------
		
		result.setPath(request.getContextPath() + "/admin/admin-bannerlist.ad");
		result.setRedirect(true);
		
		return result;
	}
	
}
