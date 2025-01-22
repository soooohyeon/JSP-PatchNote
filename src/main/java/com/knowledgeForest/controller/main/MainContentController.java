package com.knowledgeForest.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MainDAO;
import com.knowledgeForest.dto.StudyDTO;

public class MainContentController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		MainDAO mainDAO = new MainDAO();
		
//		신규 등록 스터디 조회한 결과를 newStudyList에 담음
		List<StudyDTO> newStudyList = mainDAO.getNewStudy();
		
		request.setAttribute("newStudyList", newStudyList);
		
		
		result.setPath("/main.jsp");
		result.setRedirect(false);
		return result;
	}

}