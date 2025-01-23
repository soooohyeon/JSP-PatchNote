package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardUserDTO;

public class BoardEditOkController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();

			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			String boardTitle = request.getParameter("boardTitle");
			String boardContents = request.getParameter("boardContents");
			String userNick = request.getParameter("userNick");
			
			BoardUserDTO boardDetail = boardDAO.editBoard(boardNum);
			
			request.setAttribute("boardDetail", boardDetail);
			result.setPath("/html/board/boardlist-detail.jsp");
					
			
			result.setRedirect(false);
			return result;
	}
}