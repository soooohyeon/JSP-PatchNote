package com.knowledgeForest.controller.myPage;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPageFrontController
 */
//@WebServlet("/MyPageFrontController")
public class MyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPageFrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());

//		경로 분기처리
		switch (target) {
		case "/mypage/mypage-accountedit.my":
			request.getRequestDispatcher("/html/mypage/mypage-accountedit.jsp").forward(request, response);
			break;

		case "/mypage/mypage-applylist.my":
			request.getRequestDispatcher("/html/mypage/mypage-applylist.jsp").forward(request, response);
			break;
			
		case "/mypage/mypage-deleteaccount.my":
			request.getRequestDispatcher("/html/mypage/mypage-deleteaccount.jsp").forward(request, response);
			break;
			
		case "/mypage/mypage-hostboard.my":
			request.getRequestDispatcher("/html/mypage/mypage-hostboard.jsp").forward(request, response);
			break;
			
		case "/mypage/mypage-jimlist.my":
			request.getRequestDispatcher("/html/mypage/mypage-jimlist.jsp").forward(request, response);
			break;
			
		case "/mypage/mypage-writtenboard.my":
			request.getRequestDispatcher("/html/mypage/mypage-writtenboard.jsp").forward(request, response);
			break;
		}

	}

}
