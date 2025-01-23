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
		System.out.println("업데이트 컨트롤러");
		
		int studyNum = Integer.valueOf(request.getParameter("studyNum"));
		System.out.println(studyNum);
		StudyDAO studyDAO = new StudyDAO();
		
		request.setAttribute("study", studyDAO.selectStudy(studyNum));
		
		request.getRequestDispatcher("/html/study/studylist-edit.jsp").forward(request, response);
		
		return null;
	}

}
/*
 * studyStartDay studyEndDay studyDeadline
 */