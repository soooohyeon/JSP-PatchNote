package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

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
	public List<BoardReplyListDTO> selectAll(Map paramMap){
		return sqlSession.selectList("BoardMapper.selectAllReply", paramMap);
	}
	
	//해당 게시글 댓글 개수
	public int getCommentTotal(int boardNum){
		return sqlSession.selectOne("BoardMapper.getCommentTotal", boardNum);
	}
	
	//댓글 삭제
	public void delete(int boardreplyNum) {
		sqlSession.delete("BoardMapper.deleteReply", boardreplyNum);
	}
	
	//댓글 수정
	public void update(BoardReplyDTO boardReplyDTO) {
		sqlSession.update("BoardMapper.updateReply", boardReplyDTO);
	}
}
