package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.StudyUserDTO;

public class BoardDAO {

    public SqlSession sqlsession;

    public BoardDAO() {
        sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 게시글 목록 조회
    public List<BoardUserDTO> getBoard() {
    	return sqlsession.selectList("BoardMapper.getBoardList");
    }
    
//	자유게시판 목록 조회 - 검색
	public List<BoardUserDTO> selectBoardSearch(String keyword) {
		return sqlsession.selectList("BoardMapper.selectBoardSearch", keyword);
	}

	//	해당 게시글 상세 조회,  
	public BoardUserDTO selectBoard(int boardNum) {
		return sqlsession.selectOne("BoardMapper.selectBoard", boardNum);
	}
	
	// 등록
	public void insertBoard(BoardDTO boardDTO) {
		sqlsession.insert("BoardMapper.insertBoard", boardDTO);
	}
	
	public void editBoard(BoardDTO boardDTO){
		sqlsession.update("BoardMapper.editBoard",boardDTO);
	}
	
	// 삭제
		public void deleteBoard(int boardDTO) {
			sqlsession.delete("BoardMapper.deleteBoard", boardDTO);
		}
}