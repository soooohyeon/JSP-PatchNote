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
import com.knowledgeForest.dto.BoardReplyDTO;

public class BoardReplyWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {//Map을 인포트받으니 왜 빨간줄??
		
		BoardReplyDTO boardreplyDTO = new BoardReplyDTO();
		BoardReplyDAO boardreplyDAO = new BoardReplyDAO();
		HttpSession session = request.getSession(false);
		
		int userNum = (int) session.getAttribute("userNumber");
		request.setCharacterEncoding("utf-8");
		
		//json 응답
		Gson gson = new Gson();
		
		//Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		//필수 파라미터 확인
		if(!jsonObject.has("boardNum") || !jsonObject.has("fbCommentContent")) {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
			}
		
		//DTO설정
		boardreplyDTO.setBoardNum(jsonObject.get("boardNum").getAsInt());
		boardreplyDTO.setUserNum(userNum);
		boardreplyDTO.setFbCommentContent(jsonObject.get("fbCommentContent").getAsString());
		
		System.out.println("boardreplyDTO확인" + boardreplyDTO);
		
		//DB저장
		boardreplyDAO.insert(boardreplyDTO);
		System.out.println("댓글 작성완료" + boardreplyDTO);
		
		//Json응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));
	
		return null;
	}

}
