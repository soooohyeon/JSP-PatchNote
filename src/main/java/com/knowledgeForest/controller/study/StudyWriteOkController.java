package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyDTO;

public class StudyWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		StudyDTO studyDTO = new StudyDTO();
		
		Result result = new Result();
		
		System.out.println("나와랏3");
		
//		studyDTO.setUserNum(request.getParameter("userNum"));
		studyDTO.setUserNum(11);
		
		studyDTO.setStudyTitle(request.getParameter("studyTitle"));
		studyDTO.setStudyDescript(request.getParameter("studyDescript"));
		studyDTO.setStudyLocation(request.getParameter("studyLocation"));
		studyDTO.setStudyStartDay(request.getParameter("studyStartDay"));
		studyDTO.setStudyEndDay(request.getParameter("studyEndDay"));
		studyDTO.setStudyStartTime(request.getParameter("studyStartTime"));
		studyDTO.setStudyEndTime(request.getParameter("studyEndTime"));
//		studyDTO.setStudyLimit(Integer.parseInt(request.getParameter("studyLimit")));
		studyDTO.setStudyDeadline(request.getParameter("studyDeadline"));
//		studyDTO.setStudyShowph(Integer.parseInt(request.getParameter("studyShowph")));
//		studyDTO.setStudyCategory(Integer.parseInt(request.getParameter("studyCategory")));
		studyDTO.setStudyUploadDate(request.getParameter("studyUploadDate"));
		studyDTO.setStudyEditDate(request.getParameter("studyEditDate"));
		
		System.out.println(studyDTO.getStudyDescript());
		
		//게시글 추가
		int studyNumber = studyDAO.insertStudy(studyDTO);
		System.out.println("생성된 게시글 번호 : " + studyNumber);
		System.out.println(studyDTO);
//		studyDAO.insertStudy(studyDTO);

		// ++++++++++++++++++++++
//		result.setPath("/study/studyList.st");
//		result.setRedirect(false);
		result.setPath(request.getContextPath() + "/study/studyList.st");
		result.setRedirect(true);

		return result;
	}

}
