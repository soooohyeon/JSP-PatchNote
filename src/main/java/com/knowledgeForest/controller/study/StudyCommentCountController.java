package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyCommentDAO;

public class StudyCommentCountController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		int studyNum = Integer.valueOf(request.getParameter("studyNum"));
		StudyCommentDAO studyCommentDAO = new StudyCommentDAO();
		System.out.println("studyNum >>>" + studyNum);
		int commentCount = studyCommentDAO.selectCommentCount(studyNum);
		request.setAttribute("commentCount", commentCount);
		System.out.println("commentCount >>>" + commentCount);
		/*
		 * result.setPath("/html/study/studylist-detail.jsp");
		 * result.setRedirect(false);
		 * 
		 */
		

	    // JSON 응답 설정
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(String.valueOf(commentCount)); // 숫자 데이터를 그대로 반환
		return null;
	}
	
}
