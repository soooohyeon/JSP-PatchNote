package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.StudyApplyUserDTO;
import com.knowledgeForest.dto.StudyDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class StudyDAO {
   public SqlSession sqlSession;
   
   public StudyDAO() {
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
   
//   스터디 목록 조회

   public List<StudyUserDTO> selectStudyAll() {
      return sqlSession.selectList("StudyMapper.selectStudyAll");
   }
   
   
//   스터디 목록 조회 - 검색
   public List<StudyUserDTO> selectStudySearch(Map<String, Object> paramMap) {
      return sqlSession.selectList("StudyMapper.selectStudySearch", paramMap);
   }
   
//   총 스터디 게시글 수
   public int getStudyTotal(String keyword) {
      System.out.println("keyword : " + keyword);
      return sqlSession.selectOne("StudyMapper.getStudyTotal", keyword);
   }
   
   public int insertStudy(StudyDTO studyDTO) {
	  System.out.println("================== 스터디 DAO ==================");
      sqlSession.insert("StudyMapper.insert", studyDTO);
      System.out.println(studyDTO);
      return sqlSession.selectOne("StudyMapper.getCurrentStudyNumber");
      
//      int studyNumber = sqlSession.selectOne("study.getCurrentStudyNumber");
//      studyDTO.setStudyNum(studyNumber);
//      System.out.println("마지막 생성된 값 : " + studyNumber);
//      return studyNumber;
      
   }
   
   public void insertStudyApply(StudyApplyUserDTO studyApplyUserDTO) {
      sqlSession.insert("StudyMapper.insertStudyApply", studyApplyUserDTO);
   }
   
   public StudyDTO select(int studyNumber) {
      return sqlSession.selectOne("study.select", studyNumber);
   }
   
   //해당 게시글 상세 조회
   public StudyUserDTO selectStudy(int studyNum) {
      return sqlSession.selectOne("StudyMapper.selectDetail", studyNum);
   }
   
   //게시글 수정
   public void update(StudyDTO studyDTO) {
      System.out.println(studyDTO);
      sqlSession.update("StudyMapper.editStudy", studyDTO);
   }

   public void delete(int studyNumber) {
      sqlSession.delete("StudyMapper.deleteStudy", studyNumber);
      
   }
}
