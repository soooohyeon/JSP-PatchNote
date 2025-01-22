package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.StudyApplyDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class AdminStudyApplyDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		int studyApplyNum = Integer.parseInt(request.getParameter("studyApplyNum"));
		StudyApplyDTO studyApply = adminDAO.selectStudyApplyOne(studyApplyNum);

//		날짜 형식 변환해서 다시 저장
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷

		String originalDeadline = studyApply.getStudyDeadline();
		String originalStudyStartDay = studyApply.getStudyStartDay();
		String originalStudyEndDay = studyApply.getStudyEndDay();

		try {
			Date date1 = originalFormat.parse(originalDeadline); // 문자열 -> Date 변환
			String deadline = targetFormat.format(date1); // 새로운 형식으로 변환 : yyyy-MM-dd
			studyApply.setStudyDeadline(deadline); // DTO에 다시 설정
			
			Date date2 = originalFormat.parse(originalStudyStartDay); // 문자열 -> Date 변환
			String studyStartDay = targetFormat.format(date2); // 새로운 형식으로 변환 : yyyy-MM-dd
			studyApply.setStudyStartDay(studyStartDay); // DTO에 다시 설정

			Date date3 = originalFormat.parse(originalStudyEndDay); // 문자열 -> Date 변환
			String studyEndDay = targetFormat.format(date3); // 새로운 형식으로 변환 : yyyy-MM-dd
			studyApply.setStudyEndDay(studyEndDay); // DTO에 다시 설정
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("studyApply", studyApply);

		result.setPath("/html/admin/admin-studyapplydetail.jsp");
		result.setRedirect(false);
		return result;
	}

}
