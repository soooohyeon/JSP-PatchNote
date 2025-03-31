package com.knowledgeForest.controller.board;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.UserImgDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		UserImgDTO userImgDTO = new UserImgDTO();
		Result result = new Result();
		HttpSession session = request.getSession(false); // 현재 세션 가져오기

		int userNum = (int) session.getAttribute("userNumber");
		final String UPLOAD_PATH = "C:\\KDT\\web_0900_hjh\\web\\중간 팀프로젝트\\back\\project\\src\\main\\webapp\\upload\\board";
		final int FILE_SIZE = 1024 * 1024 * 5; // 5mb;
		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);

		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());

		boardDTO.setUserNum(userNum);
		boardDTO.setBoardTitle(multipartRequest.getParameter("boardTitle"));
		boardDTO.setBoardContents(multipartRequest.getParameter("boardContents"));

		int boardNum = boardDAO.insertBoard(boardDTO);

		// 파일 업로드 처리
		// Enumeration : java.util 패키지에 포함된 인터페이스 , Iterator 비슷한 역할함

		Enumeration<String> fileNames = multipartRequest.getFileNames();
		System.out.println("fileNames : " + fileNames);
		while (fileNames.hasMoreElements()) {
			String name = (String) fileNames.nextElement();
			String fileSystemName = multipartRequest.getFilesystemName(name);

			String fileOriginalName = multipartRequest.getOriginalFileName(name);

			if (fileSystemName == null) {
				continue;
			}
			userImgDTO.setUserImgUuid(fileSystemName);
			userImgDTO.setUserImgName(fileOriginalName);
			userImgDTO.setBoardNum(boardNum);

			boardDAO.insertBoardImg(userImgDTO);
		}

		result.setPath(request.getContextPath() + "/board/boardlist.bo");
		result.setRedirect(true);

		return result;
	}
}
