package com.knowledgeForest.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;
import com.knowledgeForest.controller.notice.NoticeDetailOkController;
import com.knowledgeForest.controller.notice.NoticeListOkController;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardDTO;

public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      this.doProcess(request, response);
	   }

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      this.doProcess(request, response);
	   }
	   
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("자유게시판 컨트롤러 들어옴");
	      String target = request.getRequestURI().substring(request.getContextPath().length());
	      Result result = null;
	
	      switch(target) {
	      case "/board/boarddetail.bo":
	    	  result = new BoardDetailOkController().execute(request, response);
	    	  break;
	    	  
	      case "/board/boardlist.bo" :
	    	  System.out.println("자유게시판 목록!!!!!!!!!!!!!!!!!!!!!!!!!!!들어옴");
	    	  result = new BoardListOkController().execute(request, response);
	    	  break;
	      
		case "/board/boardDeleteOk.bo" :
			System.out.println("자유게시판 목록!!!!!!!!!!!!!!!!!!!!!!!!!!!들어옴");
			result = new BoardDeleteOkController().execute(request, response);
			break;
	      }

	      if (result != null) {
	         if (result.isRedirect()) {
	            response.sendRedirect(result.getPath());
	         } else {
	            request.getRequestDispatcher(result.getPath()).forward(request, response);
	         }
	      }
	}
}
