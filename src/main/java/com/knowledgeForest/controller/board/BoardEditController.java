package com.knowledgeForest.controller.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardImgDTO;

public class BoardEditController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		BoardDAO boardDAO = new BoardDAO();

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
//		해당 게시판에 대한 데이터 저장
		BoardImgDTO boardDetail = boardDAO.selectBoard(boardNum);
//		해당 게시판에 대한 이미지 데이터 저장
		boardDetail.setImages(boardDAO.selectBoardImg(boardNum));

		request.setAttribute("boardDetail", boardDetail);
		result.setPath("/html/board/boardlist-edit.jsp");
		result.setRedirect(false);
		return result;
	}

}
