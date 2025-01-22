package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyUserDTO;

public class StudyDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		Result result =new Result();
		
//		int studyUserNum = Integer.parseInt(request.getParameter("studyNum"));
		
//		StudyUserDTO detailStudy = studyDAO.selectStudy(studyUserNum);
		StudyUserDTO detailStudy = studyDAO.selectStudy(3);	//3에 해당하는 게시글 조회
		
		request.setAttribute("detailStudy", detailStudy);
		result.setPath("/html/study/studylist-detail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
