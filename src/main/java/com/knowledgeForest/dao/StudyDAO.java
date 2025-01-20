package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.StudyDTO;

public class StudyDAO {
	public SqlSession sqlSession;
	
	public StudyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void showList(StudyDTO studyDTO) {
//		sqlSession.select(null, null);
	}
	
	public void add(StudyDTO studyDTO) {
		sqlSession.insert("study.list", studyDTO);
	}
}
