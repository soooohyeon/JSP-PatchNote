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
import com.knowledgeForest.dto.UserImgDTO;

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
			
			//이미지 경로 
			final String UPLOAD_PATH = "C:\\KDT\\web_0900_hjh\\중간 팀프로젝트\\back\\project\\src\\main\\webapp\\upload\\board";
			final int FILE_SIZE = 1024 * 1024 * 5;
			
			//MultipartParser실행
			MultipartParser parser = new MultipartParser(request, FILE-SIZE)
//			boardDAO.deleteBoard(boardNum);
			
			//기존 파일 삭제
			if(boardNum !=0) {
				UserImgDTO existinFiles = boardDAO.select(boardNum);
			}
			
			
			
			result.setPath(request.getContextPath() + "/board/boardlist.bo");
			result.setRedirect(true);
			return result;
	}
}