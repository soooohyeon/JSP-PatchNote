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

public class AdminNoticeDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		AdminImgDAO adminImgDAO = new AdminImgDAO();
		NoticeImgDTO noticeImgDTO = new NoticeImgDTO();
		Result result = new Result();

//		noticeNum 변수에 저장
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
//		이미지 경로 설정
		final String UPLOAD_PATH = "D:\\kdt_0900_psh\\jsp_6\\project\\back\\forest\\src\\main\\webapp\\upload\\notice";
//		배포시 지정할 경로
//		.metadata/.plugins/.../wtpwebapps/ 내부 경로가 반환되는 이유는 Eclipse의 WTP (Web Tools Platform) 서버 설정 때문
//		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("upload/notice/");

//		폴더에 저장된 이미지 시스템명 불러오기
		noticeImgDTO.setImages(adminImgDAO.selectNoticeImg(noticeNum));
//		만약 저장된 이미지가 없다면
		if (noticeImgDTO.getImages() != null) {
			String imgName = noticeImgDTO.getImages().getAdminImgUuid();
		
//			이미지가 저장된 경로와 삭제할 파일명 전달
			HashMap<String, String> imgInfo = new HashMap<>();
			imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
			imgInfo.put("imgName", imgName);
//			실제 폴더에 저장된 이미지를 삭제할 메소드 사용 - 저장경로 및 파일명 전달
			adminImgDAO.removeAdminImg(imgInfo);
		}
		
//		공지 데이터 삭제 메소드 실행 - noticeNum 전달
		adminDAO.deleteNotice(noticeNum);
		
//		경로 설정
		result.setPath(request.getContextPath() + "/admin/admin-noticelist.ad");
		result.setRedirect(false);
		
		return result;
	}
	
}
