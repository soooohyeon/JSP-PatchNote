package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;

public class StudyWriteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer userNum = (Integer)session.getAttribute("userNum");
		String path = null;
		
		if(userNum == null) {
			path = request.getContextPath() + "/main/main-login.html";
		}else {
			path = request.getContextPath() + "/study/studyWrite.st";
			request.setAttribute(path, session);
		}
		
		result.setPath(path);
		result.setRedirect(false);
		return null;
	}

}
