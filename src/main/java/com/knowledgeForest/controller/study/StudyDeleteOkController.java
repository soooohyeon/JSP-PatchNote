package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dao.StudyDAO;

public class StudyDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		Result result = new Result();
		int studyNumber = Integer.valueOf(request.getParameter("studyNum"));
		
		studyDAO.delete(studyNumber);
		
//		response.sendRedirect("/board/boardListOk.bo");
		result.setPath(request.getContextPath() + "/study/studyList.st");
		result.setRedirect(true);
		return result;
	}

}
