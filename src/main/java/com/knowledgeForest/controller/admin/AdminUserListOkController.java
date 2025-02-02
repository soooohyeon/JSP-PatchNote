package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.UserDTO;

// 관리자 전체 유저 목록 조회
public class AdminUserListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

//		검색 결과 데이터를 담을 리스트 선언
		List<UserDTO> userList = null;
//		검색어 파라미터로 받기
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
		userList = adminDAO.selectUserAll(paramMap);
		
//		총 유저의 수
		total = adminDAO.getUserTotal(keyword);
		
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
	    
//	    목록 설정
		request.setAttribute("userList", userList);
		
		result.setPath("/html/admin/admin-userlist.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
