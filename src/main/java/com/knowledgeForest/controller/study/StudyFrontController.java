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
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("study 서블릿 실행");
//		
//		// request.getContextPath() URL 루트경로를 의미
//		System.out.println(request.getContextPath());
//
//		// request.getRequestURI 현재 요청의 URI를 의미
//		System.out.println(request.getRequestURI());
//		
//		// 요청url이 뭔지 구분하기
//		// 우리가 필요한 것은 전체 URI에서 ContextPath를 제외시킨 부분이다
//		String target = request.getRequestURI().substring(request.getContextPath().length());
//		System.out.println(target);

//		Result result = null; //+++++

//		switch (target) {
//		case "/study
//		}
//		request.getRequestDispatcher("Study").forward(request, response);
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("스터디 게시판 컨트롤러 입장");
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;
		
		switch(target) {
		case "/study/studylist.st":
			request.getRequestDispatcher("/html/study/study/studylist.jsp").forward(request, response);
			break;
		case "/study/studyWrite.st":
			System.out.println("ddddd");
			request.getRequestDispatcher("/html/study/study/studylist-write.jsp").forward(request, response);
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
