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
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.StudyUserDTO;
import com.knowledgeForest.dto.UserDTO;

public class AdminMainListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

		List<UserDTO> userList = adminDAO.selectUserFive();
		List<StudyUserDTO> studyList = adminDAO.selectStudyFive();
		List<BoardUserDTO> boardList = adminDAO.selectBoardFive();
		List<NoticeDTO> noticeList = adminDAO.selectNoticeFive();
		
//		날짜 형식 변환해서 다시 저장
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd"); // DB 날짜 포맷
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // 변환 포맷
		
		for (UserDTO user : userList) {
			String originalDate = user.getUserJoinDate();
			try {
                Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
                String joinDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
                user.setUserJoinDate(joinDate); // DTO에 다시 설정
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		for (StudyUserDTO study : studyList) {
			String originalDate = study.getStudyUploadDate();
			try {
				Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
				String uploadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
				study.setStudyUploadDate(uploadDate); // DTO에 다시 설정
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (BoardUserDTO board : boardList) {
			String originalDate = board.getBoardUploadDate();
			try {
				Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
				String uploadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
				board.setBoardUploadDate(uploadDate); // DTO에 다시 설정
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (NoticeDTO notice : noticeList) {
			String originalDate = notice.getNoticeUploadDate();
			try {
				Date date = originalFormat.parse(originalDate); // 문자열 -> Date 변환
				String uploadDate = targetFormat.format(date); // 새로운 형식으로 변환 : yyyy-MM-dd
				notice.setNoticeUploadDate(uploadDate); // DTO에 다시 설정
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("userList", userList);
		request.setAttribute("studyList", studyList);
		request.setAttribute("boardList", boardList);
		request.setAttribute("noticeList", noticeList);
		result.setPath("/html/admin/admin-main.jsp");
		result.setRedirect(false);

		return result;
	}
}
