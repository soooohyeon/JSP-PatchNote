package com.knowledgeForest.controller.study;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dao.StudyImgDAO;
import com.knowledgeForest.dto.AdminImgDTO;
import com.knowledgeForest.dto.StudyDTO;
import com.knowledgeForest.dto.StudyImgDTO;
import com.knowledgeForest.dto.StudyUserDTO;
import com.knowledgeForest.dto.UserImgDTO;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class StudyUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudyDAO studyDAO = new StudyDAO();
		StudyImgDAO studyImgDAO = new StudyImgDAO();
		StudyDTO studyDTO = new StudyDTO();
		StudyImgDTO studyImgDTO = new StudyImgDTO();
		UserImgDTO userImgDTO = new UserImgDTO();
		
		
		Result result = new Result();
		
//		final String UPLOAD_PATH = "D:\\web_0900_oht\\Semi\\KnowledgeForest-Back\\src\\main\\webapp\\upload\\study";
		final String UPLOAD_PATH = "D:\\web_0900_oht\\kdt\\KnowledgeForest-Back\\src\\main\\webapp\\upload\\banner";
		final int FILE_SIZE = 1024 * 1024 * 5;

//      MultipartParser 실행
		MultipartParser parser = new MultipartParser(request, FILE_SIZE);
		parser.setEncoding("utf-8");
		
		int studyNum = 0;
		
//      파일, 텍스트 데이터 처리
		Part part;
		while((part = parser.readNextPart()) != null) {
			if(part.isParam()) {
//				텍스트 파라미터 처리
				ParamPart paramPart = (ParamPart) part;
				String paramName = paramPart.getName();
				String paramValue = paramPart.getStringValue();	

				HttpSession session = request.getSession();
				Integer userNumber = (Integer)session.getAttribute("userNumber");
				studyDTO.setUserNum(userNumber);
				
//				전달받은 파라미터 값 저장
				if ("studyNum".equals(paramName)) {
					studyNum = Integer.valueOf(paramValue);
					studyDTO.setStudyNum(studyNum);
				} else if ("studyTitle".equals(paramName)) {
					studyDTO.setStudyTitle(paramValue);
				} else if ("studyDescript".equals(paramName)) {
					studyDTO.setStudyDescript(paramValue);
				} else if ("studyStartDay".equals(paramName)) {
					studyDTO.setStudyStartDay(paramValue);
				} else if ("studyEndDay".equals(paramName)) {
					studyDTO.setStudyEndDay(paramValue);
				} else if ("studyStartTime".equals(paramName)) {
					studyDTO.setStudyStartTime(paramValue);
				} else if ("studyEndTime".equals(paramName)) {
					studyDTO.setStudyEndTime(paramValue);
				} else if ("studyLimit".equals(paramName)) {
					studyDTO.setStudyLimit(Integer.valueOf(paramValue));
				} else if ("studyDeadline".equals(paramName)) {
					studyDTO.setStudyDeadline(paramValue);
				} else if ("studyUploadDate".equals(paramName)) {
					studyDTO.setStudyUploadDate(paramValue);
				} else if ("studyEditDate".equals(paramName)) {
					studyDTO.setStudyEditDate(paramValue);
				}
			} else if (part.isFile()) {
				FilePart filePart = (FilePart) part;
				filePart.setRenamePolicy(new DefaultFileRenamePolicy());
				String fileOriginalName = filePart.getFileName();
				
//				기존 파일 삭제
				if (studyNum != 0) {
					userImgDTO = studyImgDAO.selectStudyImg(studyNum);
//					기존에 저장되었던 이미지명 저장
					if (userImgDTO != null) {
						String imgName = userImgDTO.getUserImgUuid();
//						이미지가 저장된 경로와 삭제할 파일명 전달
						HashMap<String, String> imgInfo = new HashMap<>();
						imgInfo.put("studyNum", String.valueOf(studyNum));
						imgInfo.put("UPLOAD_PATH", UPLOAD_PATH);
						imgInfo.put("imgName", imgName);
						
//						DB삭제 및 실제 폴더에서 이미지 삭제
						studyImgDAO.deleteNoticeImg(imgInfo);						
					}
				}
				
//				수정할 이미지가 있다면				
				if (fileOriginalName != null) {
					String fileSystemName = System.currentTimeMillis() + "_" + fileOriginalName;
					File newFile = new File(UPLOAD_PATH, fileSystemName);
					filePart.writeTo(newFile);
					
					if(newFile.exists()) {
						System.out.println("새로운 파일 저장 완료: " + newFile.getAbsolutePath());
					} else {
						System.out.println("새로운 파일 저장 실패: " + newFile.getAbsolutePath());
					}
					userImgDTO = new UserImgDTO();
					userImgDTO.setUserImgUuid(fileSystemName);
					userImgDTO.setUserImgName(fileOriginalName);
					userImgDTO.setStudyNum(studyNum);
//					DB 저장
					studyImgDAO.insert(userImgDTO);
				} else {
					System.out.println("업로드된 파일이 없습니다 (파일 선택하지 않음)");
				}
				
			}
		}
		
		System.out.println("업데이트 ok 컨트롤러");
		
		studyDAO.update(studyDTO);
		
		result.setPath(request.getContextPath() + "/study/studyList.st");
		result.setRedirect(true);
		return result;
	}

}
