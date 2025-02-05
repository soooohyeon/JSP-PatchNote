 package com.knowledgeForest.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		List<BoardUserDTO> boardList = null;
		
		//페이징
		String tempPage = request.getParameter("page");
		int page = (tempPage == null) ? 1 : Integer.valueOf(tempPage);
		
		int rowCount = 10;
		int pageCount = 5;
		//페이징 처리
		int startRow = (page -1) * rowCount +1;
		int endRow = startRow + rowCount -1;
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		
		String keyword = request.getParameter("keyword");
		paramMap.put("keyword", keyword);

		boardList = boardDAO.getBoard(paramMap);
		
		request.setAttribute("boardList", boardList);
		
//		검색어 저장
		
		result.setPath("/html/board/board-list.jsp");
		result.setRedirect(false);
		
		//페이징 정보 설정
		int total = boardDAO.getTotal();
		int realEndPage = (int) Math.ceil(total / (double)rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount -1);
		endPage = Math.min(endPage, realEndPage);
		
		//페이지 양옆<>
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		//페이지
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		result.setPath("/html/board/board-list.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
	
	
}
