package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardUserDTO;

public class BoardUploadOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		Result result = new Result();
		
		
		boardDTO.setUserNum(0);
		boardDTO.setBoardTitle(request.getParameter("boardTitle"));
		boardDTO.setBoardContents(request.getParameter("boardContents"));
		
		boardDAO.insertBoard(boardDTO);
		
		result.setPath(request.getContextPath() + "/board/board-list.bo");
		result.setRedirect(true);
		
		return result;
		
	}
}

