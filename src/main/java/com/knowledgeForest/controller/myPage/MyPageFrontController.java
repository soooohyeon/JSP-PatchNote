package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// 마이페이지 기본화면 - 개인정보 수정 화면 이동
		case "/mypage/mypage-accountedit.my":
			result = new MyPageUserInfoController().execute(request, response);
			break;

		// 개인정보 수정
		case "/mypage/mypage-accounteditOk.my":
			result = new MyPageUserInfoEditOkController().execute(request, response);
			break;

		case "/mypage/MypageCheckNicknameOk.my":
			System.out.println("마이페이지 닉네임 중복처리");
			result = new MyPageCheckNicknameOk().execute(request, response);
			break;

		case "/mypage/mypage-deleteaccount.my":
			System.out.println("유저 탈퇴 페이지 이동");

			request.getRequestDispatcher("/html/mypage/mypage-deleteaccount.jsp").forward(request, response);
			break;

		case "/mypage/MyPageDeleteOkController.my":
			System.out.println("유저 탈퇴 처리");
			result = new MyPageDeleteOkController().execute(request, response);
			break;

		case "/mypage/mypage-hostboard.my":
			System.out.println("만든 스터디 목록");
			result = new MyPageMyStudiesController().execute(request, response);
			break;
		case "/mypage/getApplicants.my":
			System.out.println("신청자 목록 출력");
			result = new MyPageGetApplicantsController().execute(request, response);
			break;

			case "/mypage/mypage-acceptApplicant.my":
			System.out.println("스터디 신청 수락");
			result = new MyPageStudyAcceptOkController().execute(request, response);
			break;

		case "/mypage/mypage-rejectApplicant.my":
			System.out.println("스터디 신청 거절");
			result = new MyPageStudyRejectOkController().execute(request, response);
			break;

		case "/mypage/mypage-applylist.my":
			System.out.println("신청한 스터디");
			result = new MyPageStudyListOkController().execute(request, response);
			break;

		case "/mypage/mypage-cancelStudy.my":
			System.out.println("스터디 신청 취소");
			result = new MyPageStudyCancelOkController().execute(request, response);
			break;

//		case "/mypage/mypage-jimlist.my":
//			request.getRequestDispatcher("/html/mypage/mypage-jimlist.jsp").forward(request, response);
//			break;

		case "/mypage/mypage-writtenboard.my":
			System.out.println("작성한 자유게시판");
			result = new MyPageBoardListOkController().execute(request, response);
			break;

		// 로그아웃 처리 추가

		case "/login/logout.me":
			System.out.println("로그아웃 처리 시작");
			HttpSession session = request.getSession(false); // 현재 세션 가져오기
			if (session != null) {
				session.invalidate(); // 세션 무효화
				System.out.println("세션 종료 완료");
			}
			response.sendRedirect(request.getContextPath() + "/knowledgeForest.main"); // 메인 페이지로 이동
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
