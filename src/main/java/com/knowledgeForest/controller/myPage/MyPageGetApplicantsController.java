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

public class MyPageGetApplicantsController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO myPageDAO = new MyPageDAO();
		Result result = new Result();

		int studyNum = Integer.parseInt(request.getParameter("studyNum"));

		List<StudyApplyUserDTO> applicants = myPageDAO.getApplicants(studyNum);
		System.out.println("applicants" + applicants);

		// JSON 형식 응답 설정
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		 // Gson을 사용하여 객체를 JSON으로 변환
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(applicants);

		// JSON 응답 작성
		try (PrintWriter out = response.getWriter()) {
			out.print("{\"applicants\": " + jsonResponse + "}");
			out.flush();
		}

		// Result 객체 반환 (JSON 응답 처리 후 페이지 이동 없음)
		result.setPath(null); // 페이지 이동이 없음을 명시
		result.setRedirect(false); // 리다이렉트 설정 (false로 유지)
		return null;

	}
}