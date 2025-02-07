package com.knowledgeForest.controller.myPage;

import java.io.BufferedReader;
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
 // JSON 파싱용 내부 클래스
 private class AcceptRequest {
	private int studyApplyNum;

	public int getStudyApplyNum() {
			return studyApplyNum;
	}

	public void setStudyApplyNum(int studyApplyNum) {
			this.studyApplyNum = studyApplyNum;
	}
}
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO myPageDAO = new MyPageDAO();
		Result result = new Result();

		 // 요청 body에서 JSON 문자열을 읽어 객체로 변환
		 BufferedReader reader = request.getReader();
		 AcceptRequest acceptRequest = new Gson().fromJson(reader, AcceptRequest.class);
		 int studyApplyNum = acceptRequest.getStudyApplyNum();
		 System.out.println("studyApplyNum: " + studyApplyNum);

		 myPageDAO.rejectApplicant(studyApplyNum);

		 // JSON 응답 전송
		 response.setContentType("application/json; charset=UTF-8");
		 try(PrintWriter out = response.getWriter()){
				 out.print("{\"success\": true}");
				 out.flush();
		 }
		 return null;
	}
}