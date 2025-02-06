package com.knowledgeForest.controller.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyCommentDAO;

public class StudyCommentListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studyNum = Integer.valueOf(request.getParameter("studyNum"));
		StudyCommentDAO studyCommentDAO = new StudyCommentDAO();
		Gson gson = new Gson();
		JsonArray comments = new JsonArray();
		
		System.out.println(studyNum);
		
		studyCommentDAO.selectAll(studyNum).stream().map(gson::toJson).map(JsonParser::parseString).forEach(comments::add);
		
		System.out.println(comments.toString());
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(comments.toString());
		out.close();
		
		return null;
	}

}
