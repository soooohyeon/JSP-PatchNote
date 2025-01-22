package com.knowledgeForest.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dao.NoticeDAO;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.NoticeDTO;

public class BoardListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		
		System.out.println("Dddddd : ");
		
		List<BoardUserDTO> boardList = boardDAO.getBoard();
		request.setAttribute("boardList", boardList);
		
		result.setPath("/html/board/board-list.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
