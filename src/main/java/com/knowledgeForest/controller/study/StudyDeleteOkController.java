package com.knowledgeForest.controller.study;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dao.StudyImgDAO;
import com.knowledgeForest.dto.UserImgDTO;

public class StudyDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		StudyImgDAO  studyImgDAO = new StudyImgDAO();
		Result result = new Result();
		int studyNumber = Integer.valueOf(request.getParameter("studyNum"));
		
		HashMap <String, String> imgInfo = new HashMap<>();
		
		final String UPLOAD_PATH = "D:\\KdtPj\\Semi\\src\\main\\webapp\\upload\\study";
		UserImgDTO userImgDTO = studyImgDAO.selectStudyImg(studyNumber);
		
		if (userImgDTO != null) {
			String imgName = userImgDTO.getUserImgUuid();
			
			imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
			imgInfo.put("imgName", imgName);
//			실제 폴더에 저장된 이미지 삭제
			studyImgDAO.removeAdminImg(imgInfo);
		}
		
//		DB에 저장된 데이터 삭제
		studyDAO.delete(studyNumber);
		
//		response.sendRedirect("/board/boardListOk.bo");
		result.setPath(request.getContextPath() + "/study/studyList.st");
		result.setRedirect(true);
		return result;
	}

}
