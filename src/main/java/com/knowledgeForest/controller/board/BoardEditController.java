package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardUserDTO;

public class BoardEditController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		BoardDAO boardDAO = new BoardDAO();

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardUserDTO boardDetail = boardDAO.selectBoard(boardNum);
		
		request.setAttribute("boardDetail", boardDetail);
		result.setPath("/html/board/boardlist-edit.jsp");
		result.setRedirect(false);
		return result;
	}

}
