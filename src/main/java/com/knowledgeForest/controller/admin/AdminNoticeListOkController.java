package com.knowledgeForest.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.AdminDAO;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class AdminNoticeListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		String keyword = request.getParameter("keyword");
		List<NoticeDTO> noticeList = null;
		
//		유저 목록 조회
		if (keyword != null) {
			keyword = '%' + keyword + '%';
			noticeList = adminDAO.selectNoticeSearch(keyword);
		} else {
			noticeList = adminDAO.selectNoticeAll();
		}
		
//		날짜 형식 변환해서 다시 저장
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷
        
        for (NoticeDTO notice : noticeList) {
            String originalDate = notice.getNoticeUploadDate();
            if (originalDate != null) {
                try {
                    Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
                    String uploadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
                    notice.setNoticeUploadDate(uploadDate); // DTO에 다시 설정
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
		
		request.setAttribute("noticeList", noticeList);
		result.setPath("/html/admin/admin-noticelist.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
