package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardReplyDTO;
import com.knowledgeForest.dto.BoardReplyListDTO;

public class BoardReplyDAO {

	public SqlSession sqlSession;
	
	public BoardReplyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//댓글 작성
	public void insert(BoardReplyDTO boardReplyDTO) {
		sqlSession.insert("BoardMapper.insertReply",boardReplyDTO);
	}
	
	//댓글 목록
	public List<BoardReplyListDTO> selectAll(int boardNum){
		return sqlSession.selectList("BoardMapper.selectAllReply", boardNum);
	}
	
	//댓글 삭제
	public void delete(int boardreplyNum) {
		sqlSession.delete("BoardMapper.deleteReply", boardreplyNum);
	}
	
	//댓글 수정
	public void update(BoardReplyDTO boardReplyDTO) {
		sqlSession.update("BoardMapper.editReply", boardReplyDTO);
	}
}
