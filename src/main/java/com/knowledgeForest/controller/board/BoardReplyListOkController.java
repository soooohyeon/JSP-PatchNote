package com.knowledgeForest.controller.board;

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
import com.knowledgeForest.dao.BoardReplyDAO;

public class BoardReplyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int boardNum = Integer.valueOf(request.getParameter("boardNum"));
		BoardReplyDAO boardReplyDAO = new BoardReplyDAO();
		Gson gson  = new Gson();
		JsonArray replies = new JsonArray();
		
		boardReplyDAO.selectAll(boardNum).stream().map(gson::toJson).map(JsonParser::parseString).forEach(replies::add);
		
		System.out.println(replies.toString());
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(replies.toString());
		out.close();
		
		return null;
		
	}

}
