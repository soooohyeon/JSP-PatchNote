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
		System.out.println("스터디 게시판 컨트롤러 입장!!!!!");
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		Result result = new Result();
		
		switch(target) {
		case "/study/studyList.st":
			request.getRequestDispatcher("/html/study/studylist.jsp").forward(request, response);
			break;
		case "/study/studyWrite.st":
			System.out.println("ddddd");
			request.getRequestDispatcher("/html/study/studylist-write.jsp").forward(request, response);
			break;
		case "/study/studyWriteOk.st":
			System.out.println("studyWriteOk!");
			result = new StudyWriteOkController().execute(request, response);
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
