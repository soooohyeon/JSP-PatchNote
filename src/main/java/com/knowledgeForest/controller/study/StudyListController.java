package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyDTO;

public class StudyListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		StudyDTO studyDTO = new StudyDTO();
		Result result = new Result();
		
		System.out.println(studyDTO);
		studyDTO.setStudyNum(Integer.valueOf(request.getParameter("studyNum")));
		studyDTO.setUserNum(Integer.valueOf(request.getParameter("userNum")));
		studyDTO.setStudyTitle(request.getParameter("studyTitle"));
		studyDTO.setStudyDescript(request.getParameter("studyDescript"));
		studyDTO.setStudyLocation(request.getParameter("studyLocation"));
		studyDTO.setStudyStartDay(request.getParameter("studyStartDay"));
		studyDTO.setStudyEndDay(request.getParameter("studyEndDay"));
		studyDTO.setStudyStartTime(request.getParameter("studyStartTime"));
		studyDTO.setStudyEndTime(request.getParameter("studyEndTime"));
		studyDTO.setStudyLimit(Integer.valueOf(request.getParameter("studyLimit")));
		studyDTO.setStudyDeadline(request.getParameter("studyDeadline"));
		studyDTO.setStudyShowph(Integer.valueOf(request.getParameter("studyShowph")));
		studyDTO.setStudyCategory(Integer.valueOf(request.getParameter("studyCategory")));
		studyDTO.setStudyUploadDate(request.getParameter("studyUploadDate"));
		studyDTO.setStudyEditDate(request.getParameter("studyEditDate"));
		
		
		
		return null;
	}

}
