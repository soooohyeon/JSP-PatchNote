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
		
////		이미지를 저장한 실제 경로
//		final String UPLOAD_PATH = "C:\\KDT\\web_0900_hjh\\중간 팀프로젝트\\back\\project\\src\\main\\webapp\\upload\\board";
//		String imgName = boardDetail.getImages().getUserImgUuid();

////		이미지가 저장된 경로와 삭제할 파일명 전달
//		HashMap<String, String> imgInfo = new HashMap<>();
//		imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
//		imgInfo.put("imgName", imgName);
//		imgInfo.put("boardNum", String.valueOf(boardNum));

////		DB삭제 및 실제 폴더에서 이미지 삭제
//		boardDAO.deleteboardImg(imgInfo);
		
		request.setAttribute("boardDetail", boardDetail);
		result.setPath("/html/board/boardlist-edit.jsp");
		result.setRedirect(false);
		return result;
	}

}
