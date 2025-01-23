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

        int studyNum = Integer.parseInt(request.getParameter("studyNum"));

        // 스터디 상세 정보 조회
        StudyUserDTO detailStudy = studyDAO.selectStudy(studyNum); // 3에 해당하는 게시글 조회

        // 날짜 형식 변환
        String originalDate = detailStudy.getStudyDeadline();
        if (originalDate != null) {
            // 날짜 포맷 정의
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
            SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷

            try {
                // 문자열 -> Date 변환
                Date date = originalFormat.parse(originalDate);
                // Date -> 문자열 변환 (새로운 형식으로 변환)
                String deadLine = targetFormat.format(date);
                // DTO에 다시 설정
                detailStudy.setStudyDeadline(deadLine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 상세 정보 전달
        request.setAttribute("detailStudy", detailStudy);
        result.setPath("/html/study/studylist-detail.jsp");
        result.setRedirect(false);

        return result;
    }
}