package com.knowledgeForest.dao;

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
   
   public List<StudyImgDTO> select(int boardNumber){
      return sqlSession.selectList("studyImg.select", boardNumber);
   }

}
