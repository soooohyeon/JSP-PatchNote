package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardImgDTO;
import com.knowledgeForest.dto.BoardUserDTO;

public class BoardDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

//		해당 게시판 데이터 저장
		BoardImgDTO boardImgDTO = boardDAO.selectBoard(boardNum);
//		해당 게시판 이미지 정보 저장
		boardImgDTO.setImages(boardDAO.selectBoardImg(boardNum));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(boardImgDTO);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

//		jsp 파일로 전달
		request.setAttribute("boardDetail", boardImgDTO);
		
		result.setPath("/html/board/boardlist-detail.jsp");
		result.setRedirect(false);

		return result;
	}
}
