package com.knowledgeForest.controller.admin;

import com.knowledgeForest.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;

		switch (target) {
//    	관리자 메인 화면
		case "/admin/admin-main.ad":
			result = new AdminMainListOkController().execute(request, response);
			break;

//    	모든 유저 목록 조회
		case "/admin/admin-userlist.ad":
			result = new AdminUserListOkController().execute(request, response);
			break;

//    	해당 유저 상세 조회
		case "/admin/admin-userdetail.ad":
			result = new AdminUserDetailOkController().execute(request, response);
			break;

//    	유저 삭제(탈퇴)
		case "/admin/userDeleteOk.ad":
			result = new AdminUserDeleteOkController().execute(request, response);
			break;

//    	모든 스터디 목록 조회
		case "/admin/admin-studylist.ad":
			result = new AdminStudyListOkController().execute(request, response);
			break;

//    	스터디 삭제
		case "/admin/studyDeleteOk.ad":
			result = new AdminStudyDeleteOkController().execute(request, response);
			break;
			
//		스터디 댓글 목록 조회
		case "/admin/admin-studycommentlist.ad":
			result = new AdminStudyReplyListOkController().execute(request, response);
			break;
			
//		스터디 댓글 목록 조회
		case "/admin/admin-studycommentDeleteOk.ad":
			result = new AdminStudyReplyDeleteOkController().execute(request, response);
			break;

//		스터디 신청 관리
		case "/admin/admin-studyapplylist.ad":
			result = new AdminStudyApplyListOkController().execute(request, response);
			break;
			
//		스터디 신청 취소
		case "/admin/admin-studyapplyDeleteOk.ad":
			result = new AdminStudyApplyDeleteOkController().execute(request, response);
			break;
			
//		스터디 신청 상세
		case "/admin/admin-studyapplydetail.ad":
			result = new AdminStudyApplyDetailOkController().execute(request, response);
			break;
			
//    	공지 목록 조회
		case "/admin/admin-noticelist.ad":
			result = new AdminNoticeListOkController().execute(request, response);
			break;

//    	공지 상세
		case "/admin/admin-noticedetail.ad":
			result = new AdminNoticeDetailOkController().execute(request, response);
			break;

//    	공지 등록
		case "/admin/admin-noticewrite.ad":
			request.getRequestDispatcher("/html/admin/admin-noticewrite.jsp").forward(request, response);
			break;

//    	공지 등록 완료
		case "/admin/admin-noticewriteOk.ad":
			result = new AdminNoticeWriteOkController().execute(request, response);
			break;
			
//    	공지 수정
		case "/admin/admin-noticeupdate.ad":
			result = new AdminNoticeUpdateController().execute(request, response);
			break;
			
//    	공지 수정 완료
		case "/admin/admin-noticeupdateOk.ad":
			result = new AdminNoticeUpdateOkController().execute(request, response);
			break;

//		공지 삭제
		case "/admin/admin-noticeDeleteOk.ad":
			result = new AdminNoticeDeleteOkController().execute(request, response);
			break;
			
//		자유게시판 목록 조회
		case "/admin/admin-boardlist.ad":
			result = new AdminBoardListOkController().execute(request, response);
			break;
			
//		자유게시판 글 삭제
		case "/admin/admin-boardDeleteOk.ad":
			result = new AdminBoardDeleteOkController().execute(request, response);
			break;
			
//		자유게시판 댓글 목록 조회
		case "/admin/admin-boardcommentlist.ad":
			result = new AdminBoardReplyListOkController().execute(request, response);
			break;
			
//		자유게시판 댓글 삭제
		case "/admin/admin-boardcommentDeleteOk.ad":
			result = new AdminBoardReplyDeleteOkController().execute(request, response);
			break;
			
//		배너 목록 조회
		case "/admin/admin-bannerlist.ad":
			result = new AdminBannerListOkController().execute(request, response);
			break;
			
//		배너 등록
		case "/admin/admin-bannerwrite.ad":
			request.getRequestDispatcher("/html/admin/admin-bannerwrite.jsp").forward(request, response);
			break;
			
//		배너 등록 완료
		case "/admin/admin-bannerwriteOk.ad":
			result = new AdminBannerWriteOkController().execute(request, response);
			break;
			
//		배너 상세 정보 조회
		case "/admin/admin-bannerdetail.ad":
			result = new AdminBannerDetailOkController().execute(request, response);
			break;
			
//		배너 글 삭제
		case "/admin/admin-bannerDeleteOk.ad":
			result = new AdminBannerDeleteOkController().execute(request, response);
			break;
			
//		배너 글 수정
		case "/admin/admin-bannerupdate.ad":
			result = new AdminBannerUpdateController().execute(request, response);
			break;
			
//		배너 글 수정 완료
		case "/admin/admin-bannerupdateOk.ad":
			result = new AdminBannerUpdateOkController().execute(request, response);
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