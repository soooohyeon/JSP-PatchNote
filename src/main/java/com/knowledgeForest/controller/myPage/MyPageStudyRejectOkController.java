package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.StudyApplyUserDTO;

public class MyPageStudyRejectOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO myPageDAO = new MyPageDAO();
		Result result = new Result();

		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		myPageDAO.rejectApplicant(studyNum);

		return null;
	}
}