package com.knowledgeForest.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;

public class AdminStudyDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

//		studyNum 변수에 저장
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
//		스터디 데이터 삭제 메소드 실행 - boardNum 전달
		adminDAO.deleteStudy(studyNum);

//		경로 설정
		result.setPath(request.getContextPath() + "/admin/admin-studylist.ad");
		result.setRedirect(true);
		
		return result;
	}
	
}
