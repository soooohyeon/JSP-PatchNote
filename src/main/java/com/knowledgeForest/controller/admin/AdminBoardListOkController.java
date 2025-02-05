package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class AdminBoardListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();

//		검색 결과 데이터를 담을 리스트 선언
		List<BoardUserDTO> boardList = new ArrayList<>();
//		검색어 저장
		String keyword = request.getParameter("keyword");
		
//		페이지 번호 파라미터로 받기
		String tempPage = request.getParameter("page");
//		넘겨받은 파라미터가 없다면 기본값 1 설정
		int page = (tempPage == null) ? 1 : Integer.valueOf(tempPage);
		
		int rowCount = 10;	// 한 페이지당 출력될 데이터 수
		int pageCount = 5;	// 5 단위로 페이지 버튼 출력
		int startRow = (page - 1) * rowCount + 1;	// 1페이지라면 rownum 1부터, 2페이지라면 rownum 11부터
		int endRow = startRow + rowCount - 1;		// 1페이지라면 rownum 10까지, 2페이지라면 rownum 20까지
		int total = 0;	// 총 유저 수
		
//		map에 계산한 결과 담기
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
//		키워드 여부로 유저 목록 조회
		paramMap.put("keyword", keyword);
//		자유게시판 목록 조회
		boardList = adminDAO.selectBoardAll(paramMap);
		
//		총 자유게시판 게시글 수
		total = adminDAO.getBoardTotal(keyword);
		
//		페이징 정보 설정
		int realEndPage = (int) Math.ceil(total / (double)rowCount);	// 실제 마지막 페이지 버튼
		int endPage = (int)(Math.ceil (page / (double)pageCount) * pageCount);	// 1차 - 시작 페이지 버튼 설정을 위한 마지막 페이지 계산
		int startPage = endPage - (pageCount - 1);	// 시작 페이지 버튼 설정
		endPage = Math.min(endPage, realEndPage);	// 2차 - 마지막 페이지 재설정 (둘 중 더 작은 값 리턴)
	
//		페이지 양옆 <>을 위한 설정
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

//		페이지 설정
	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);
		
//		날짜 형식 변환해서 다시 저장
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷
        
        for (BoardUserDTO board : boardList) {
            String originalDate = board.getBoardUploadDate();
            if (originalDate != null) {
                try {
                    Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
                    String uploadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
                    board.setBoardUploadDate(uploadDate); // DTO에 다시 설정
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        자유게시판 정보 전달
		request.setAttribute("boardList", boardList);
		
		result.setPath("/html/admin/admin-boardlist.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
