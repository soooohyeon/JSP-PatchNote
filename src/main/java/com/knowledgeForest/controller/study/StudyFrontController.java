package com.knowledgeForest.controller.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;

/**
 * Servlet implementation class StudyFrontController
 */
//@WebServlet("/StudyFrontController")
public class StudyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // 요청과 응답의 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;
		
		switch(target) {
		case "/study/studyList.st":
			System.out.println("ㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ");
//			request.getRequestDispatcher("/html/study/studylist.jsp").forward(request, response);
			result = new StudyListOkController().execute(request, response);
			break;
		case "/study/studyWrite.st":
			request.getRequestDispatcher("/html/study/studylist-write.jsp").forward(request, response);
			break;
		case "/study/studyWriteOk.st":
			result = new StudyWriteOkController().execute(request, response);
			break;
		case "/study/studyDetailOk.st":
			System.out.println("studyDetailOk!");
			result = new StudyDetailOkController().execute(request, response);
			break;
		case "/study/studyUpdate.st":
			System.out.println("studyUpdate!");
			result = new StudyUpdateController().execute(request, response);
			break;
		case "/study/studyUpdateOk.st":
			System.out.println("studyUpdateOk!");
			result = new StudyUpdateOkController().execute(request, response);
			break;
		case "/study/studyDeleteOk.st":
			System.out.println("studyDeleteOk!");
			result = new StudyDeleteOkController().execute(request, response);
			break;
		case "/study/studyApplyInsertOk.st":
			System.out.println("studyApplyInsertOk!");
			result = new StudyApplyInsertOkController().execute(request, response);
			break;
		case "/study/studyCommentListOk.st":
			System.out.println("studyCommentListOk!");
			result = new StudyCommentListOkController().execute(request, response);
			break;
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
		
	}

}
