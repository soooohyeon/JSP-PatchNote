package com.knowledgeForest.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.StudyImgDTO;
import com.knowledgeForest.dto.UserImgDTO;

public class StudyImgDAO {
   SqlSession sqlSession;
   
   public StudyImgDAO() {
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
   public void insert(UserImgDTO userImgDTO) {
      System.out.println("이미지 DAO - userImgDTO : " + userImgDTO);
      
      try {
         sqlSession.insert("StudyMapper.insertImg", userImgDTO);
      } catch (Exception e) {
         System.out.println("파일 저장이 실패되었습니다. " + e.getMessage());
         e.printStackTrace();
      }
   }
   
//   public List<StudyImgDTO> select(int boardNumber){
//      return sqlSession.selectList("studyImg.select", boardNumber);
//   }

   // 이미지 조회
	public UserImgDTO selectStudyImg(int studyNumber) {
		UserImgDTO image = sqlSession.selectOne("StudyMapper.selectStudyImg", studyNumber);
		System.out.println("스터디 번호 : " + studyNumber);
		System.out.println("스터디 이미지DAO : " + image);
		return image;
	}

	// 이미지 삭제
	public void deleteNoticeImg(HashMap<String, String> imgInfo) {
		int studyNum = Integer.parseInt(imgInfo.get("studyNum"));
		sqlSession.delete("StudyMapper.deleteStudyImg", studyNum);
//		실제 폴더에서 이미지 삭제 메소드 실행
		removeAdminImg(imgInfo);		
	}
	
//	실제 폴더에서 이미지 삭제
	public void removeAdminImg(HashMap<String, String> imgInfo) {
		String imgSrc = imgInfo.get("UPLOAD_PATH");
		String imgName = imgInfo.get("imgName");
		
		File file = new File(imgSrc, imgName);
		
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("파일 삭제 성공");
			} else {
				System.out.println("파일 삭제 실패");
			}
		} else {
			System.out.println("이미지 존재 안함");
		}
	}

}
