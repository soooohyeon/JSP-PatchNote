package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;

public class AdminStudyReplyDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDAO adminDAO = new AdminDAO();
		int studyCommentNum = Integer.parseInt(request.getParameter("studyCommentNum"));
		
		adminDAO.deleteStudyReply(studyCommentNum);
		
		return null;
	}
}
