package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class StudyUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		StudyDTO studyDTO = new StudyDTO();
		
		Result result = new Result();
		
		System.out.println("업데이트 ok 컨트롤러");

		studyDTO.setUserNum(11);
		
		studyDTO.setStudyNum(Integer.parseInt(request.getParameter("studyNum")));
		studyDTO.setStudyTitle(request.getParameter("studyTitle"));
		studyDTO.setStudyDescript(request.getParameter("studyDescript"));
		studyDTO.setStudyLocation(request.getParameter("studyLocation"));
		studyDTO.setStudyStartDay(request.getParameter("studyStartDay"));
		studyDTO.setStudyEndDay(request.getParameter("studyEndDay"));
		studyDTO.setStudyStartTime(request.getParameter("studyStartTime"));
		studyDTO.setStudyEndTime(request.getParameter("studyEndTime"));
		studyDTO.setStudyLimit(Integer.parseInt(request.getParameter("studyLimit")));
		studyDTO.setStudyDeadline(request.getParameter("studyDeadline"));
		studyDTO.setStudyUploadDate(request.getParameter("studyUploadDate"));
		studyDTO.setStudyEditDate(request.getParameter("studyEditDate"));

		System.out.println("55555 : " + studyDTO.getStudyTitle());
		
		studyDAO.update(studyDTO);
		
		result.setPath(request.getContextPath() + "/study/studyList.st");
		result.setRedirect(true);
		return result;
	}

}
