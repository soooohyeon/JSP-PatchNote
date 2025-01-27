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
