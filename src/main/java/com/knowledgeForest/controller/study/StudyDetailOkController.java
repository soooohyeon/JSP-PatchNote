package com.knowledgeForest.controller.study;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dto.StudyUserDTO;

public class StudyDetailOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudyDAO studyDAO = new StudyDAO();
        Result result = new Result();

        // 파라미터에서 studyNum 추출
        int studyNum = Integer.parseInt(request.getParameter("studyNum"));

        // 스터디 상세 정보 조회
        StudyUserDTO detailStudy = studyDAO.selectStudy(studyNum);

        // 날짜 필드 변환 및 설정
        String deadline = convertDateFormat(detailStudy.getStudyDeadline());
        String startDay = convertDateFormat(detailStudy.getStudyStartDay());
        String endDay = convertDateFormat(detailStudy.getStudyEndDay());
        String uploadDate = convertDateFormat(detailStudy.getStudyUploadDate());

        detailStudy.setStudyDeadline(deadline);
        detailStudy.setStudyStartDay(startDay);
        detailStudy.setStudyEndDay(endDay);
        detailStudy.setStudyUploadDate(uploadDate);

        // 변환된 스터디 상세 정보를 request에 설정
        request.setAttribute("detailStudy", detailStudy);

        // 결과 경로 설정
        result.setPath("/html/study/studylist-detail.jsp");
        result.setRedirect(false);

        return result;
    }

    /**
     * 날짜 형식 변환 메서드
     * 
     * @param dateString 변환할 날짜 문자열
     * @return 변환된 날짜 문자열
     */
    private String convertDateFormat(String dateString) {
        if (dateString == null) {
            return null;
        }

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");   // 변환 포맷

        try {
            Date date = originalFormat.parse(dateString);   // 문자열 -> Date 변환
            return targetFormat.format(date);               // Date -> 문자열 변환
        } catch (Exception e) {
            e.printStackTrace();
            return dateString;  // 변환 실패 시 원래 값을 반환
        }
    }
}