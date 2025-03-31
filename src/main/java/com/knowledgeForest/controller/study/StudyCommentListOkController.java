package com.knowledgeForest.controller.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyCommentDAO;
import com.knowledgeForest.dto.StudyCommentDTO;

public class StudyCommentListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudyCommentDAO studyCommentDAO = new StudyCommentDAO();
		Gson gson = new Gson();
		// 댓글 목록 담을 객체
		JsonArray comments = new JsonArray();
		// 페이징 정보를 담을 객체
        JsonObject pageInfo = new JsonObject();
		// 최종 JSON 객체 (댓글 목록 + 페이징 정보)
		JsonObject result = new JsonObject();

		int studyNum = Integer.valueOf(request.getParameter("studyNum"));
		System.out.println("스터디 번호 : " + studyNum);
		
		// 페이지네이션
//		페이지 번호 파라미터로 받기
		String tempPage = request.getParameter("page");
//		넘겨받은 파라미터가 없다면 기본값 1 설정
		int page = (tempPage == null) ? 1 : Integer.valueOf(tempPage);

		int rowCount = 10; // 한 페이지당 출력될 데이터 수
		int pageCount = 5; // 5 단위로 페이지 버튼 출력
		int startRow = (page - 1) * rowCount + 1; // 1페이지라면 rownum 1부터, 2페이지라면 rownum 11부터
		int endRow = startRow + rowCount - 1; // 1페이지라면 rownum 10까지, 2페이지라면 rownum 20까지
		int total = 0; // 총 유저 수

//		map에 계산한 결과 담기
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("studyNum", studyNum);
		
//		해당 게시글에 대한 댓글 개수
		total = studyCommentDAO.selectCommentCount(studyNum);

//		페이징 정보 설정
		int realEndPage = (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지 버튼
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 1차 - 시작 페이지 버튼 설정을 위한 마지막 페이지 계산
		int startPage = endPage - (pageCount - 1); // 시작 페이지 버튼 설정
		endPage = Math.min(endPage, realEndPage); // 2차 - 마지막 페이지 재설정 (둘 중 더 작은 값 리턴)

//		페이지 양옆 <>을 위한 설정
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		// 댓글 리스트 JSON 형식으로 변환
		studyCommentDAO.selectAll(paramMap).stream().map(gson::toJson).map(JsonParser::parseString).forEach(comments::add);
		// JSON 형식으로 변환 결과 객체에 저장
		result.add("comments", comments);
		
//		페이지 설정
		pageInfo.addProperty("page", page);
		pageInfo.addProperty("startPage", startPage);
		pageInfo.addProperty("endPage", endPage);
		pageInfo.addProperty("prev", prev);
		pageInfo.addProperty("next", next);
//		해당 게시글에대한 댓글 개수 JSON 형식으로 변환해서 같이 전달
        pageInfo.addProperty("total", total);

		// 결과 객체에 저장
        result.add("pageInfo", pageInfo);
        
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result.toString());
		out.close();
		
		return null;
	}

}
