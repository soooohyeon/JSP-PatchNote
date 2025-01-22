package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardUserDTO;

public class BoardDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String boardTitle = request.getParameter("boarTitle");
		String boardContents = request.getParameter("boardContents");
		
		BoardUserDTO boardDetail = boardDAO.selectBoard(boardNum);
		
		request.setAttribute("boardDetail", boardDetail);
		result.setPath("/html/board/boardlist-detail.jsp");
		
		
//		HttpSession session = request.getSession();
//		boardNum = BoardDAO.Boarddetail(boardDAO);
//		session.setAttribute("boardNum", boardNum);
//		session.setAttribute("boardTitle", boardTitle);
//		session.setAttribute("boardContents",boardContents);
//		
		
		
		result.setRedirect(false);
		return result;
	}
}
