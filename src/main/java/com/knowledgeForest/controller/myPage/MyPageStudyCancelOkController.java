package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;


// 신청 취소
public class MyPageStudyCancelOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MyPageDAO mypageDAO = new MyPageDAO();
		Result result = new Result();

//		studyNum 변수에 저장
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
	
//		신청 취소 메소드 실행 - studyNum 전달
		mypageDAO.deleteStudyApply(studyNum);
		
//		경로 설정
		result.setPath(request.getContextPath() + "/mypage/mypage-applylist.my");
		result.setRedirect(true);
		
		return result;
	}

}
