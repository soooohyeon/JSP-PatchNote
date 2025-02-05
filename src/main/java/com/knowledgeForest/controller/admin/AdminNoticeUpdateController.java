package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dao.AdminImgDAO;
import com.knowledgeForest.dto.NoticeImgDTO;

public class AdminNoticeUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO amdinImgDAO = new AdminImgDAO();
		
//		이미지 경로 설정
//		final String UPLOAD_PATH = "D:\\web_0900_psh\\jsp_6\\workspace\\final_jsp\\src\\main\\webapp\\upload";
		final String UPLOAD_PATH = "D:\\kdt_0900_psh\\jsp_6\\project\\back\\forest\\src\\main\\webapp\\upload\\notice";
//		배포시 지정할 경로
//		.metadata/.plugins/.../wtpwebapps/ 내부 경로가 반환되는 이유는 Eclipse의 WTP (Web Tools Platform) 서버 설정 때문
//		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("upload/notice/");
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		NoticeImgDTO noticeImgDTO = adminDAO.selectOneNotice(noticeNum);
		noticeImgDTO.setImages(amdinImgDAO.selectNoticeImg(noticeNum));
		System.out.println("===============공지 수정 컨트롤러 ============");
		System.out.println("공지 수정 컨트롤러 imgName : " + noticeImgDTO);
		String imgName = noticeImgDTO.getImages().getAdminImgUuid();
		
//		이미지가 저장된 경로와 삭제할 파일명 전달
		HashMap<String, String> imgInfo = new HashMap<>();
		imgInfo.put("noticeNum", String.valueOf(noticeNum));
		imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
		imgInfo.put("imgName", imgName);
		
//		DB삭제 및 실제 폴더에서 이미지 삭제
		amdinImgDAO.deleteNoticeImg(imgInfo);
		
		request.setAttribute("notice", noticeImgDTO);
		
		result.setPath("/html/admin/admin-noticeupdate.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
