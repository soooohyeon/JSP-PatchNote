package com.knowledgeForest.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dto.AdminImgDTO;
import com.knowledgeForest.dto.BannerDTO;
import com.knowledgeForest.dto.BannerImgDTO;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class AdminBannerUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		BannerDTO bannerDTO = new BannerDTO();
		AdminImgDTO adminImgDTO = new AdminImgDTO();
		BannerImgDTO bannerImgDTO = new BannerImgDTO();
		
//		=== 이미지 경로 설정 ===
//		final String UPLOAD_PATH = "D:\\web_0900_psh\\jsp_6\\workspace\\final_jsp\\src\\main\\webapp\\upload";
		final String UPLOAD_PATH = "D:\\kdt_0900_psh\\jsp_6\\project\\back\\forest\\src\\main\\webapp\\upload\\Banner";
//		배포시 지정할 경로
//		.metadata/.plugins/.../wtpwebapps/ 내부 경로가 반환되는 이유는 Eclipse의 WTP (Web Tools Platform) 서버 설정 때문
//		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/Banner/";
		final int FILE_SIZE = 1024 * 1024 * 5;
		
//      MultipartParser 실행
		MultipartParser parser = new MultipartParser(request, FILE_SIZE);
		parser.setEncoding("utf-8");
		
		int bannerNum = 0;
		
//      파일, 텍스트 데이터 처리
		Part part;
		while ((part = parser.readNextPart()) != null) {
			if (part.isParam()) {
//              텍스트 파라미터 처리
				ParamPart paramPart = (ParamPart) part;
				String paramName = paramPart.getName();
				String paramValue = paramPart.getStringValue();

//				전달받은 파라미터 값 저장
				if ("bannerNum".equals(paramName)) {
					bannerNum = Integer.parseInt(paramValue);
					bannerDTO.setBannerNum(bannerNum);
				} else if ("bannerName".equals(paramName)) {
					bannerDTO.setBannerName(paramValue);
				}
			} else if (part.isFile()) {
				FilePart filePart = (FilePart) part;
				filePart.setRenamePolicy(new DefaultFileRenamePolicy());
				String fileOriginalName = filePart.getFileName();

//              기존 파일 삭제
				adminImgDTO = adminImgDAO.selectBannerImg(bannerNum);
//				기존에 저장되었던 이미지명 저장
				String imgName = adminImgDTO.getAdminImgUuid();
//				이미지가 저장된 경로와 삭제할 파일명 전달
				HashMap<String, String> imgInfo = new HashMap<>();
				imgInfo.put("bannerNum", String.valueOf(bannerNum));
				imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
				imgInfo.put("imgName", imgName);
				
//				DB삭제 및 실제 폴더에서 이미지 삭제
				adminImgDAO.deleteBannerImg(imgInfo);

//				수정할 이미지가 있다면
				String fileSystemName = System.currentTimeMillis() + "_" + fileOriginalName;
				File newFile = new File(UPLOAD_PATH, fileSystemName);
				filePart.writeTo(newFile);
	
				if (newFile.exists()) {
					System.out.println("새로운 파일 저장 완료: " + newFile.getAbsolutePath());
				} else {
					System.out.println("새로운 파일 저장 실패: " + newFile.getAbsolutePath());
				}
				adminImgDTO = new AdminImgDTO();
				adminImgDTO.setAdminImgUuid(fileSystemName);
				adminImgDTO.setAdminImgName(fileOriginalName);
				adminImgDTO.setBannerNum(bannerNum);
//              DB 저장
				adminImgDAO.insertBannerImg(adminImgDTO);
			}
		}
		
//		값 DAO 메소드로 전달하여 DB에 값 저장
		adminDAO.updateBanner(bannerDTO);
		
		result.setPath(request.getContextPath() + "/admin/admin-bannerlist.ad");
		result.setRedirect(true);
		
		return result;
	}
	
}
