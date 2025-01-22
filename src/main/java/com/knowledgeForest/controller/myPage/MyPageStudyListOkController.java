package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.StudyDTO;

public class MyPageStudyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO mypageDAO = new MyPageDAO();
		Result result = new Result();
		
		// userNum = (int) request.getSession().getAttribute("userNum");
		int userNum = 13;

		List<StudyDTO> studyList = null;
		
		studyList = mypageDAO.getStudyList(userNum);
		System.out.println("studyList : " + studyList);
		request.setAttribute("studyList", studyList);
		result.setPath("/html/mypage/mypage-writtenboard.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
