package com.knowledgeForest.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.BoardDAO;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.UserImgDTO;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class BoardEditOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		BoardDTO boardDTO = new BoardDTO();
		UserImgDTO userImgDTO = new UserImgDTO();

		// 이미지 경로
		final String UPLOAD_PATH = "C:\\KDT\\web_0900_hjh\\중간 팀프로젝트\\back\\project\\src\\main\\webapp\\upload\\board";
		final int FILE_SIZE = 1024 * 1024 * 5;

		// MultipartParser실행
		MultipartParser parser = new MultipartParser(request, FILE_SIZE);
		parser.setEncoding("utf-8");

		int boardNum = 0;

		// 파일, 텍스트 처리
		Part part;
		while ((part = parser.readNextPart()) != null) {
			if (part.isParam()) {
				// 텍스트 파라미터 처리
				ParamPart paramPart = (ParamPart) part;
				String paramName = paramPart.getName();
				String paramValue = paramPart.getStringValue();

				// 전달받은 파라미터 값 저장
				if ("boardNum".equals(paramName)) {
					boardNum = Integer.parseInt(paramValue);
					boardDTO.setBoardNum(boardNum);
				} else if ("boardTitle".equals(paramName)) {
					boardDTO.setBoardTitle(paramValue);
				} else if ("boardContents".equals(paramName)) {
					boardDTO.setBoardContents(paramValue);
				}

			} else if (part.isFile()) {
				FilePart filePart = (FilePart) part;
				filePart.setRenamePolicy(new DefaultFileRenamePolicy());
				String fileOriginalName = filePart.getFileName();

				// 기존 파일 삭제
				if (boardNum != 0) {
					UserImgDTO existinFiles = boardDAO.selectBoardImg(boardNum);
					System.out.println("existinFiles : " + existinFiles);
					// 기존에 ㅇ저장되었던 이미지명 저장
					if (userImgDTO != null) {
						String imgName = existinFiles.getUserImgUuid();

						// 이미지가 저장된 경로와 삭제할 파일명 전달
						HashMap<String, String> imgInfo = new HashMap<>();
						imgInfo.put("boardNum", String.valueOf(boardNum));
						imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
						imgInfo.put("imgName", imgName);

						// DB삭제 및 실제 폴더에서 이미지 삭제
						boardDAO.deleteboardImg(imgInfo);
					}
				}

				// 수정할 이미지
				if (fileOriginalName != null) {
					String fileSystemName = System.currentTimeMillis() + "_" + fileOriginalName;
					File newFile = new File(UPLOAD_PATH, fileSystemName);
					filePart.writeTo(newFile);

					if (newFile.exists()) {

					} else {

					}
					userImgDTO = new UserImgDTO();

					userImgDTO.setUserImgUuid(fileSystemName);
					userImgDTO.setUserImgName(fileOriginalName);
					userImgDTO.setBoardNum(boardNum);
					// DB저장
					boardDAO.insertBoardImg(userImgDTO);
				} else {
					System.out.println("업로드된 파일이 없습니다");
				}
			}
		}

		// 값 DAO 메소드로 전달하여 DB에 값 저장
		boardDAO.editBoard(boardDTO);

		result.setPath(request.getContextPath() + "/board/boardlist.bo");
		result.setRedirect(true);

		return result;
	}
}