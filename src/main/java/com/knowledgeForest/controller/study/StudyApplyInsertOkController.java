package com.knowledgeForest.controller.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyApplyUserDTO;

public class StudyApplyInsertOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession(false); // 현재 세션 가져오기
		StudyDAO studyDAO = new StudyDAO();
		StudyApplyUserDTO studyApplyUserDTO = new StudyApplyUserDTO();

		int userNum = (int) session.getAttribute("userNumber");
		System.out.println("userNum : " + userNum);

		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		studyApplyUserDTO.setStudyNum(studyNum);
		studyApplyUserDTO.setUserNum(userNum);
		System.out.println("각오  :  " + request.getParameter("userDetermination"));
		studyApplyUserDTO.setUserDetermination(request.getParameter("userDetermination"));

		System.out.println(studyApplyUserDTO + "studyApplyUserDTO");

		studyDAO.insertStudyApply(studyApplyUserDTO);

		result.setPath(request.getContextPath() + "/study/studyWrite.st");
		result.setRedirect(true);

		return result;
	}

}
