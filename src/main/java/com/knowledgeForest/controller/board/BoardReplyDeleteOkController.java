package com.knowledgeForest.controller.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardReplyDAO;

public class BoardReplyDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Result result = new Result();
		BoardReplyDAO boardReplyDAO = new BoardReplyDAO();
	    HttpSession session = request.getSession();

		// json 응답
		Gson gson = new Gson();
//	      Map<String, Object> responseMap = new HashMap<>();

		int userNum = (int)session.getAttribute("userNumber");
	      
		int fbCommentNum = Integer.parseInt(request.getParameter("fbCommentNum"));
		System.out.println("fbCommentNum : " + fbCommentNum);
		// 댓글 삭제 로직 추가
		boardReplyDAO.delete(fbCommentNum);

		// JSON 응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));

		return null;
	}

}