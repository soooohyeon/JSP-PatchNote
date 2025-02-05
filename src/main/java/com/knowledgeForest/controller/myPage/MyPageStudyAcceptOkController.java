package com.knowledgeForest.controller.myPage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;

public class MyPageStudyAcceptOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO myPageDAO = new MyPageDAO();

		System.out.println("??????");
		int studyApplyNum = Integer.parseInt(request.getParameter("studyApplyNum"));
		System.out.println("studyNum" + studyApplyNum);

		int isAccepted = myPageDAO.acceptApplicant(studyApplyNum);
		
		System.out.println(isAccepted);

		// JSON 형식 응답 설정
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Gson을 사용하여 객체를 JSON으로 변환
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(isAccepted);

		// JSON 응답 작성
		try (PrintWriter out = response.getWriter()) {
			out.print("{\"applicants\": " + jsonResponse + "}");
			out.flush();
		}

		
		return null;
	}
}