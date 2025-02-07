package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;

public class BoardDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("삭제컨트롤러");
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		// 게시글 삭제 로직 추가
		boardDAO.deleteBoard(boardNum);  
		
		result.setPath(request.getContextPath() + "/board/board-list.bo");
		result.setRedirect(true);
		return result;

	   
		
	}
}
