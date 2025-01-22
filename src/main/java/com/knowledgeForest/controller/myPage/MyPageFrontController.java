package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;

/**
 * Servlet implementation class MyPageFrontController
 */
// @WebServlet("/MyPageFrontController")
public class MyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("doGet");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				System.out.println("doPost");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());
		
		  // 요청과 응답의 인코딩 설정
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		  
		  System.out.println("doProcess");
		  System.out.println(request.getRequestURI());
		  Result result = null;

		// 경로 분기처리
		switch (target) {
		case "/mypage/mypage-accountedit.my":
			result = new MyPageUserInfoController().execute(request, response);
			break;
			
		case "/mypage/MypageCheckNicknameOk.my":
			System.out.println("마이페이지 닉네임 중복처리");
			result = new MyPageCheckNicknameOk().execute(request, response);
			break;
			
		case "/mypage/MyPageDeleteOkController.my":
			System.out.println("유저 탈퇴 처리");
			result = new MyPageDeleteOkController().execute(request, response);
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
			System.out.println("작성한 자유게시판");
			result = new MyPageBoardListOkController().execute(request, response);
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
