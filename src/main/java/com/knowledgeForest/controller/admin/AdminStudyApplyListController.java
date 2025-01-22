package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.StudyApplyUserDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class AdminStudyApplyListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		List<StudyApplyUserDTO> studyApplyList = null;

		String keyword = request.getParameter("keyword");
		
	//	스터디 신청 유저 목록 조회
		if (keyword != null) {
			keyword = '%' + keyword + '%';
			studyApplyList = adminDAO.selectStudyApplySearch(keyword);
		} else {
			studyApplyList = adminDAO.selectStudyApplyAll();
		}
		
//		날짜 형식 변환해서 다시 저장
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷
        
        for (StudyApplyUserDTO studyApply : studyApplyList) {
            String originalDate = studyApply.getDeadline();
            if (originalDate != null) {
                try {
                    Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
                    String limitDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
                    studyApply.setDeadline(limitDate); // DTO에 다시 설정
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        현재 시스템 DATE 전달
		request.setAttribute("today", LocalDate.now());
		request.setAttribute("studyApplyList", studyApplyList);
		result.setPath("/html/admin/admin-studyapplylist.jsp");
		result.setRedirect(false);
		return result;
	}

}
