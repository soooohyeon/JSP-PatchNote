package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyApplyUserDTO;

public class StudyApplyInsertOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		StudyApplyUserDTO studyApplyUserDTO = new StudyApplyUserDTO();
		
		Result result = new Result();
		
		System.out.println("나와1!!!");
		
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		studyApplyUserDTO.setStudyNum(studyNum);
		studyApplyUserDTO.setUserNum(11);
		studyApplyUserDTO.setUserDeterMination(request.getParameter("studyDeterMination"));
		
		System.out.println(studyApplyUserDTO + "studyApplyUserDTO");
		
		
		studyDAO.insertStudyApply(studyApplyUserDTO);
		
		result.setPath(request.getContextPath() + "/study/studyWrite.st");
		result.setRedirect(true);

		return result;
	}

}
