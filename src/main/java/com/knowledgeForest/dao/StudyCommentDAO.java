package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.StudyCommentDTO;

public class StudyCommentDAO {
	public SqlSession sqlSession;
	
	public StudyCommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	
	//스터디 댓글 목록
	public List<StudyCommentDTO> selectAll(Map paramMap){
		return sqlSession.selectList("studyComment.selectAll", paramMap);
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
	
	// 하나의 스터디 게시글의 댓글 개수 조회
	public int selectCommentCount(int studyNum) {
		int result = sqlSession.selectOne("studyComment.commnetCount", studyNum);
		System.out.println("댓글 개수 조회 DAO");
		System.out.println("result : " + result);
		return result;
//		return sqlSession.selectOne("studyComment.commnetCount", studyNum);
	}
	
	//스터디 댓글 수정
	public void update(StudyCommentDTO studyCommentDTO) {
		System.out.println("댓글DAO - studyCommentDTO : " + studyCommentDTO);
		
		try {
			sqlSession.update("studyComment.update", studyCommentDTO);
		} catch (Exception e) {
			System.out.println("댓글 수정이 실패되었습니다. " + e.getMessage());
			e.printStackTrace();
		}			
	}
	
	//스터디 댓글 삭제
	public void delete(int studyCommentNum) {
		System.out.println("DAO studycommentNum: "  + studyCommentNum);
		sqlSession.delete("studyComment.deleteStudyComment", studyCommentNum);
	}
	
}
