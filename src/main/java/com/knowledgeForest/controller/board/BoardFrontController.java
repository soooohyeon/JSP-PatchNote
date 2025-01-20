package com.knowledgeForest.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardDTO;

public class BoardFrontController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		
		
		return null;
	}
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        // DAO 인스턴스 생성
//        BoardDAO boardDAO = new BoardDAO();
//
//        // 클라이언트에서 보낸 데이터를 GET 방식으로 받음
//        String title = request.getParameter("title");
//        String content = request.getParameter("content");
//
//        // 데이터베이스에 저장할 DTO 생성
//        BoardDTO board = new BoardDTO();
//        board.setTitle(title);
//        board.setContent(content);
//
//        // DAO를 통해 데이터베이스에 저장
//        boolean result = boardDAO.insertBoard(board);
//
//        // 저장 결과에 따라 응답 처리
//        if (result) {
//            // 성공 시 리스트 페이지로 이동
//            response.sendRedirect(request.getContextPath() + "/board/board-list.jsp");
//        } else {
//            // 실패 시 에러 메시지 출력
//            response.getWriter().println("<h1>게시글 저장 실패</h1>");
//        }
	
	
    }
}