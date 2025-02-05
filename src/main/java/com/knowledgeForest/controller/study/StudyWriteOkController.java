package com.knowledgeForest.controller.study;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.StudyDAO;
import com.knowledgeForest.dao.StudyImgDAO;
import com.knowledgeForest.dto.StudyDTO;
import com.knowledgeForest.dto.UserImgDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class StudyWriteOkController implements Execute {

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      StudyDAO studyDAO = new StudyDAO();
      StudyDTO studyDTO = new StudyDTO();
      StudyImgDAO studyImgDAO = new StudyImgDAO();
      UserImgDTO userImgDTO = new UserImgDTO();
      
      Result result = new Result();
      
      HttpSession session = request.getSession(false); // 현재 세션 가져오기
      
      int userNum = (int) session.getAttribute("userNumber");
      
//      배포시 사용해야할 주소
//      final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("upload/");
      final String UPLOAD_PATH = "D:\\kdtpj\\project\\src\\main\\webapp\\upload\\study";
      final int FILE_SIZE = 1024 * 1024 * 50; // 5mb;

      MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
            new DefaultFileRenamePolicy());
      
//      studyDTO.setUserNum(request.getParameter("userNum"));
      studyDTO.setUserNum(userNum);
      
      studyDTO.setStudyTitle(multipartRequest.getParameter("studyTitle"));
      studyDTO.setStudyDescript(multipartRequest.getParameter("studyDescript"));
      studyDTO.setStudyLocation(multipartRequest.getParameter("studyLocation"));
      studyDTO.setStudyStartDay(multipartRequest.getParameter("studyStartDay"));
      studyDTO.setStudyEndDay(multipartRequest.getParameter("studyEndDay"));
      studyDTO.setStudyStartTime(multipartRequest.getParameter("studyStartTime"));
      studyDTO.setStudyEndTime(multipartRequest.getParameter("studyEndTime"));
//      studyDTO.setStudyLimit(Integer.parseInt(request.getParameter("studyLimit")));
      studyDTO.setStudyDeadline(multipartRequest.getParameter("studyDeadline"));
//      studyDTO.setStudyShowph(Integer.parseInt(request.getParameter("studyShowph")));
//      studyDTO.setStudyCategory(Integer.parseInt(request.getParameter("studyCategory")));
      studyDTO.setStudyUploadDate(multipartRequest.getParameter("studyUploadDate"));
      studyDTO.setStudyEditDate(multipartRequest.getParameter("studyEditDate"));
      
      
      //게시글 추가
      int studyNum = studyDAO.insertStudy(studyDTO);
      System.out.println(studyDTO);
      
      
      // 파일 업로드 처리
      // Enumeration : java.util 패키지에 포함된 인터페이스 , Iterator 비슷한 역할함
      Enumeration<String> fileNames = multipartRequest.getFileNames();
      System.out.println("파일명 : " + fileNames);

      while (fileNames.hasMoreElements()) {
         String name = fileNames.nextElement();
         String fileSystemName = multipartRequest.getFilesystemName(name);
         String fileOriginalName = multipartRequest.getOriginalFileName(name);
         System.out.println("fileSystemName : " + fileSystemName);

         if (fileSystemName == null) {
            continue;
         }
         
         userImgDTO.setStudyNum(studyNum);
         userImgDTO.setUserImgName(fileOriginalName);
         userImgDTO.setUserImgUuid(fileSystemName);
         
         System.out.println("업로드된 파일 정보 :" + userImgDTO);
         studyImgDAO.insert(userImgDTO);
      }      

      result.setPath(request.getContextPath() + "/study/studyList.st");
      result.setRedirect(true);

      return result;
   }

}
