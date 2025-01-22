package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;

public class StudyUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int studyNumber = Integer.valueOf(request.getParameter("studyNumber"));
		System.out.println(studyNumber);
		StudyDAO studyDAO = new StudyDAO();
		
		request.setAttribute("study", studyDAO.select(studyNumber));
		
		request.getRequestDispatcher("/html/study/studylist-edit.jsp").forward(request, response);
		
		return null;
	}

}
