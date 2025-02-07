package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.StudyApplyDTO;

public class MyPageStudyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO mypageDAO = new MyPageDAO();
		Result result = new Result();

		HttpSession session = request.getSession(false); // 현재 세션 가져오기
		
		int userNum = (int) session.getAttribute("userNumber");

		List<StudyApplyDTO> studyList = mypageDAO.getStudyList(userNum);
		System.out.println("studyList : " + studyList);

		int total = mypageDAO.getMyStudyTotal(userNum);

        String tempPage = request.getParameter("page");

		int page = (tempPage == null) ? 1 : Integer.valueOf(tempPage);

		int rowCount = 10; // 한 페이지당 출력될 데이터 수
		int pageCount = 5; // 5 단위로 페이지 버튼 출력
		int startRow = (page - 1) * rowCount + 1; // 1페이지라면 rownum 1부터, 2페이지라면 rownum 11부터
		int endRow = startRow + rowCount - 1; // 1페이지라면 rownum 10까지, 2페이지라면 rownum 20까지

		// map에 계산한 결과 담기
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("userNum", userNum);
		
		// 페이징 정보 설정
		int realEndPage = (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지 버튼
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 1차 - 시작 페이지 버튼 설정을 위한 마지막 페이지 계산
		int startPage = endPage - (pageCount - 1); // 시작 페이지 버튼 설정
		endPage = Math.min(endPage, realEndPage); // 2차 - 마지막 페이지 재설정 (둘 중 더 작은 값 리턴)

		// 페이지 양옆 <>을 위한 설정
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		// 페이지 설정
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
        
//		날짜 형식 변환해서 다시 저장
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷

		for (StudyApplyDTO study : studyList) {
			String originalApplyDate = study.getStudyApplyDate();
			String originalDeadLineDate = study.getStudyDeadline();
			if (originalApplyDate != null) {
				try {
					Date date = originalFormat.parse(originalApplyDate); // 문자열 -> Date 변환
					String newAppDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy.MM.dd
					study.setStudyApplyDate(newAppDate); // DTO에 다시 설정

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (originalDeadLineDate != null) {
				try {
					Date date = originalFormat.parse(originalDeadLineDate); // 문자열 -> Date 변환
					String newDeadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy.MM.dd
					study.setStudyApplyDate(newDeadDate); // DTO에 다시 설정

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

//        현재 시스템 DATE 전달
		request.setAttribute("today", LocalDate.now());

		request.setAttribute("studyList", studyList);
		result.setPath("/html/mypage/mypage-applylist.jsp");
		result.setRedirect(false);

		return result;
	}

}
