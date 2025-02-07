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

public class BoardEditOkController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();

			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			String boardTitle = request.getParameter("boardTitle");
			String boardContents = request.getParameter("boardContents");
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoardNum(boardNum);
			boardDTO.setBoardTitle(boardTitle);
			boardDTO.setBoardContents(boardContents);
			System.out.println(boardDTO);
			boardDAO.editBoard(boardDTO);
			
//			boardDAO.deleteBoard(boardNum);
			
			//기존 파일 삭제
			if(boardNum !=0) {
				
			}
			
			
			
			result.setPath(request.getContextPath() + "/board/boardlist.bo");
			result.setRedirect(true);
			return result;
	}
}