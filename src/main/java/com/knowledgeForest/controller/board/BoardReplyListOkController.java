package com.knowledgeForest.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardReplyDAO;

public class BoardReplyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("________________BoardReplyListOkController_________________");

		BoardReplyDAO boardReplyDAO = new BoardReplyDAO();
		Gson gson  = new Gson();
		// 댓글 목록 담을 객체
		JsonArray replies = new JsonArray();
		// 페이징 정보를 담을 객체
        JsonObject pageInfo = new JsonObject();
		// 최종 JSON 객체 (댓글 목록 + 페이징 정보)
		JsonObject result = new JsonObject();
		
		// 페이징
		String tempPage = request.getParameter("page");
		int page = (tempPage == null) ? 1 : Integer.valueOf(tempPage);
		
		System.out.println("+++++ tempPage : " + tempPage);
		
		int rowCount = 5;
		int pageCount = 5;
		// 페이징 처리
		int startRow = (page -1) * rowCount +1;
		int endRow = startRow + rowCount -1;
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		
		int boardNum = Integer.valueOf(request.getParameter("boardNum"));
		
		paramMap.put("boardNum", boardNum);
		
		boardReplyDAO.selectAll(paramMap).stream().map(gson::toJson).map(JsonParser::parseString).forEach(replies::add);
        
		// 결과 객체에 저장
		result.add("replies", replies);
        
		// 페이징 정보 설정
		int total = boardReplyDAO.getCommentTotal(boardNum);
		int realEndPage = (int) Math.ceil(total / (double)rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount -1);
		endPage = Math.min(endPage, realEndPage);
		
		// 페이지 양옆<>
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		// 페이지
        pageInfo.addProperty("page", page);
        pageInfo.addProperty("startPage", startPage);
        pageInfo.addProperty("endPage", endPage);
        pageInfo.addProperty("prev", prev);
        pageInfo.addProperty("next", next);
        pageInfo.addProperty("total", total);
		
		System.out.println("page : " + page);
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("prev : " + prev);
		System.out.println("next : " + next);

		// 결과 객체에 저장
        result.add("pageInfo", pageInfo);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
        out.print(result.toString());
		out.close();
		
		return null;
	}

}
