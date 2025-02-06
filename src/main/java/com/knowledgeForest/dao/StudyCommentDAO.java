package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.StudyCommentDTO;

public class StudyCommentDAO {
	public SqlSession sqlSession;
	
	public StudyCommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//스터디 댓글 목록
	public List<StudyCommentDTO> selectAll(int studyNum){
		return sqlSession.selectList("studyComment.selectAll", studyNum);
	}
}
