package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.StudyUserDTO;

public class AdminStudyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				AdminDAO adminDAO = new AdminDAO();
				List<StudyUserDTO> studyList = new ArrayList<>();
				Result result = new Result();
				
//				검색어 저장
				String keyword = request.getParameter("keyword");
				
//				유저 목록 조회
				if (keyword != null) {
					keyword = '%' + keyword + '%';
					studyList = adminDAO.selectStudySearch(keyword);
				} else {
					studyList = adminDAO.selectStudyAll();
				}
				
//				날짜 형식 변환해서 다시 저장
		        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
		        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷
		        
		        for (StudyUserDTO study : studyList) {
		            String originalDate = study.getStudyUploadDate();
		            if (originalDate != null) {
		                try {
		                    Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
		                    String uploadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
		                    study.setStudyUploadDate(uploadDate); // DTO에 다시 설정
		                    
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        }

//		        현재 시스템 DATE 전달
				request.setAttribute("today", LocalDate.now());
//		        스터디 정보 전달
				request.setAttribute("studyList", studyList);
				result.setPath("/html/admin/admin-studylist.jsp");
				result.setRedirect(false);

				return result;
	}
}
