package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.StudyApplyDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class MyPageMyStudiesController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyPageDAO myPageDAO = new MyPageDAO();
        Result result = new Result();
        HttpSession session = request.getSession(false);

        int userNum = (int) session.getAttribute("userNumber");
        List<StudyUserDTO> myStudyList = myPageDAO.getMyStudies(userNum);
        
        
        
//		날짜 형식 변환해서 다시 저장
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷

		for (StudyUserDTO study : myStudyList) {
			String originalDeadLineDate = study.getStudyDeadline();
			
			if (originalDeadLineDate != null) {
				try {
					Date date = originalFormat.parse(originalDeadLineDate); // 문자열 -> Date 변환
					String newDeadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy.MM.dd
					study.setStudyDeadline(newDeadDate); // DTO에 다시 설정

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
        
        
        System.out.println("userNum" + userNum);
        
        System.out.println("만든 스터디 목록 : " + myStudyList);
//      현재 시스템 DATE 전달
		request.setAttribute("today", LocalDate.now());

        request.setAttribute("myStudyList", myStudyList);
        result.setPath("/html/mypage/mypage-hostboard.jsp");
        result.setRedirect(false);

        return result;
    }
}