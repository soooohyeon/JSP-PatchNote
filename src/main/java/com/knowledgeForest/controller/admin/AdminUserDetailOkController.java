package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.UserDTO;

// 관리자 해당 유저 정보 상세페이지 조회
public class AdminUserDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		
//		유저 상세 조회한 결과 담기
		UserDTO user = adminDAO.selectUserOne(userNum);
		
//		해당 유저가 존재하지 않을 경우 목록으로 되돌아가기
		if (user == null) {
			System.out.println("존재하지 않는 게시글 임");
			
			result.setPath("/admin/admin-userlist.ad");	// 유저 목록 페이지로 리다이렉트
			result.setRedirect(true);
			
			return result;
		}
		
//		유저 생년월일 형식 날짜만 나오게 자르기
		user.setUserBirth(user.getUserBirth().substring(0, 11));
		
//		유저 정보
		request.setAttribute("user", user);
//		유저가 작성한 스터디
		request.setAttribute("studyCount", adminDAO.countStudy(userNum));
//		유저가 신청한 스터디
		request.setAttribute("applyCount", adminDAO.countApply(userNum));
//		유저가 작성한 스터디 댓글
		request.setAttribute("studyCommentCount", adminDAO.countStudyComment(userNum));
//		유저가 작성한 스터디
		request.setAttribute("boardCount", adminDAO.countBoard(userNum));
//		유저가 작성한 스터디
		request.setAttribute("boardCommentCount", adminDAO.countBoardComment(userNum));
		
//		경로 설정
		result.setPath("/html/admin/admin-userdetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
