package com.knowledgeForest.controller.study;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyDTO;

public class StudyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudyDAO studyDAO = new StudyDAO();
		Result result = new Result();
		
		List<StudyDTO> studyList = studyDAO.getStudy();
		
		System.out.println(studyList);
		
		request.setAttribute("studyList", studyList);
		
		result.setPath("/html/study/studylist.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
