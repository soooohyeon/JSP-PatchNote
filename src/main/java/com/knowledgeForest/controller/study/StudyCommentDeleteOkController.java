package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyCommentDAO;

public class StudyCommentDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyCommentDAO studyCommentDAO = new StudyCommentDAO();
		Result result = new Result();
		int studyCommentNumber = Integer.valueOf(request.getParameter("studyCommentNum"));
		
		//DB에 저장된 데이터 삭제
		studyCommentDAO.delete(studyCommentNumber);
		/*
		 * result.setRedirect(false); result.setPath(null);
		 */
		result.setPath(request.getContextPath() + "/study/studylist.st");
		result.setRedirect(true);
		
		return result;
	}

}
