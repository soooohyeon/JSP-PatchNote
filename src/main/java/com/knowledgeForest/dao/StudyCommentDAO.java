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
	
	//스터디 댓글 등록
	public void insert(StudyCommentDTO studyCommentDTO) {
		System.out.println("댓글DAO - studyCommentDTO : " + studyCommentDTO);
		
		try {
			sqlSession.insert("studyComment.insert", studyCommentDTO);
		} catch (Exception e) {
			System.out.println("댓글 저장이 실패되었습니다. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//스터디 댓글 개수 조회
	public int selectCommentCount(int studyNum) {
		return sqlSession.selectOne("studyComment.commnetCount", studyNum);
	}
	
}
