package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.StudyDTO;

public class StudyDAO {
	public SqlSession sqlSession;
	
	public StudyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	public void showList(StudyDTO studyDTO) {
//		sqlSession.select(null, null);
//	}
	
	public List<StudyDTO> getStudy() {
		List<StudyDTO> list = sqlSession.selectList("StudyMapper.select");
		
		return list;
	}
	
	public int insertStudy(StudyDTO studyDTO) {
		
		System.out.println("123123123"+studyDTO);
		sqlSession.insert("StudyMapper.insert", studyDTO);
		System.out.println("333333"+studyDTO);
		
		int studyNumber = sqlSession.selectOne("study.getCurrentStudyNumber");
		studyDTO.setStudyNum(studyNumber);
		System.out.println("마지막 생성된 값 : " + studyNumber);
		return studyNumber;
	}
}
