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

public class BoardReaplyUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardReplyDAO boardReplyDAO = new BoardReplyDAO();
		BoardReplyDTO boardReplyDTO = new BoardReplyDTO();
		HttpSession session = request.getSession();
		
		// json 응답
		Gson gson = new Gson();
		
		//Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		
		int userNum = (int)session.getAttribute("userNumber");
		
		int fbCommentNum = jsonObject.get("replyNum").getAsInt();
		String content = jsonObject.get("replyContent").getAsString();
		
		boardReplyDTO.setFbCommentNum(fbCommentNum);
		boardReplyDTO.setFbCommentContent(content);
		
		//DB저장
		boardReplyDAO.update(boardReplyDTO);
		System.out.println("댓글 수정완료" + boardReplyDTO);
		
		
		// JSON 응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 수정되었습니다")));

		
		return null;
	}

}
