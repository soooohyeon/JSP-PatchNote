package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Result;

/**
 * Servlet implementation class LoginFrontController
 */
//@WebServlet("/LoginFrontController")
public class LoginFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginFrontController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = request.getRequestURI().substring(request.getContextPath().length());

		Result result = null;
//		System.out.println(target); // 이동되는 경로 확인
//      경로 분기처리
		switch (target) {

//		로그인 페이지 진입
		case "/login/login.me":
			request.getRequestDispatcher("/html/login/login.jsp").forward(request, response);
			break;

//		로그인 처리
		case "/login/loginOk.me":
			System.out.println("loginFrontController test");
			result = new LoginOkController().execute(request, response);
			break;

//		로그아웃 처리
		case "/login/logout.me":
			HttpSession session = request.getSession(false); // 현재 세션 가져오기
			if (session != null) {
				session.invalidate(); // 세션 무효화
			}
			response.sendRedirect(request.getContextPath() + "/knowledgeForest.main"); // 메인 페이지로 이동
			break;

//		회원가입 페이지 이동
		case "/login/join.me":
			request.getRequestDispatcher("/html/login/join.jsp").forward(request, response);
			break;
		
//		아이디 중복 검사
		case "/login/checkIdOk.me":
			result = new CheckIdOkController().execute(request, response);
			break;
			
//		닉네임 중복 검사
		case "/login/checkNickOk.me":
			result = new CheckNickOkController().execute(request, response);
			break;	
			
//		이미 가입된 전화번호인지 확인
		case "/login/phoneCheck.me" :
			 result = new CheckPhoneOkController().execute(request,response);
			break;
			
//		핸드폰 인증번호 발송
		case "/login/sendSMS.me" :
			result = new JoinSMSController().execute(request,response);
			break;
			
//		인증번호 확인
		case "/login/verifyCode.me":
			result = new VerifyCodeController().execute(request, response);
			break;	
			
//		회원 가입 완료
		case "/login/joinOk.me":
			result = new JoinOkController().execute(request, response); // 404 에러 공존
			break;

//		비밀번호 찾기
		case "/login/passwordSelect.me":
			request.getRequestDispatcher("/html/login/passwordSelect.jsp").forward(request, response);
			break;
			
//		아이디와 휴대폰 번호로 유저 조회
		case "/login/checkUserOk.me":
			result = new CheckUserOkController().execute(request, response);
			break;

//		비밀번호 찾기 후 비밀번호 수정페이지로 이동
		case "/login/passwrdUpdate.me":
			request.getRequestDispatcher("/html/login/passwordSelect-detail.jsp").forward(request, response);
			break;
			
//		비밀번호 찾기 후 비밀번호 수정 완료
		case "/login/passwordUpdateOk.me":
			result = new PasswrdUpdateOkController().execute(request, response);
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