package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
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
				Result result = new Result();
				
				String keyword = request.getParameter("keyWord");
				List<StudyUserDTO> studyList = new ArrayList<>();
				
//				유저 목록 조회
				if (keyword != null) {
					keyword = '%' + keyword + '%';
//					studyList = adminDAO.selectUserSearch(keyword);
				} else {
					studyList = adminDAO.selectStudyAll();
					studyList.forEach(System.out::println);
				}
				
				request.setAttribute("studyList", studyList);
				result.setPath("/html/admin/admin-studylist.jsp");
				result.setRedirect(false);

				return result;
	}
}
