package com.knowledgeForest.controller.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyCommentDAO;
import com.knowledgeForest.dto.StudyCommentDTO;

public class StudyCommentUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		StudyCommentDTO studyCommentDTO = new StudyCommentDTO();
		StudyCommentDAO studyCommentDAO = new StudyCommentDAO();
		int userNum = (int) session.getAttribute("userNumber");
		
		request.setCharacterEncoding("utf-8");
		
		//json 응답
		Gson gson = new Gson();
		
		//Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("commentNum : " + jsonObject.get("commentNum"));
		System.out.println("commentContent : " + jsonObject.get("commentContent"));
		
		//필수 파라미터 확인
		if(!jsonObject.has("commentNum") || !jsonObject.has("commentContent")) {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			System.out.println("if문 확인");
			return null;
		}
		
		//DTO 설정
		studyCommentDTO.setStudyCommentNum(jsonObject.get("commentNum").getAsInt());
		studyCommentDTO.setStudyComment(jsonObject.get("commentContent").getAsString());
		
		System.out.println("studyCommentDTO 확인 : " + studyCommentDTO);
		
		//DB 저장
		studyCommentDAO.update(studyCommentDTO);
		System.out.println("댓글 작성완료 : " + studyCommentDTO);
		
		//JSON 응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));
				
		return null;
	}

}
