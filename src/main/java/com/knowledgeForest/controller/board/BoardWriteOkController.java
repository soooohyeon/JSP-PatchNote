package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardDTO;

public class BoardWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		Result result = new Result();
		HttpSession session = request.getSession(false); // 현재 세션 가져오기
		
		int userNum = (int) session.getAttribute("userNumber");
		System.out.println("userNum : " + userNum);
		boardDTO.setUserNum(userNum);
		boardDTO.setBoardTitle(request.getParameter("boardTitle"));
		boardDTO.setBoardContents(request.getParameter("boardContents"));
		
		boardDAO.insertBoard(boardDTO);

		result.setPath(request.getContextPath() + "/board/boardlist.bo");
		result.setRedirect(true);
		
		return result;
	}
}
