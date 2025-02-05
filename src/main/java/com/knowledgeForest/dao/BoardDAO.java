package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardImgDTO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.UserImgDTO;

public class BoardDAO {

    public SqlSession sqlsession;

    public BoardDAO() {
        sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 게시글 목록 조회
    public List<BoardUserDTO> getBoard(Map<String, Object> paramMap) {
    	return sqlsession.selectList("BoardMapper.getBoardList", paramMap);
    }
    
    //게시글 총 개수 가져오기
    public int getTotal() {
    	return sqlsession.selectOne("BoardMapper.getTotal");
    }
    
	//	해당 게시글 상세 조회,  
	public BoardImgDTO selectBoard(int boardNum) {
		return sqlsession.selectOne("BoardMapper.selectBoard", boardNum);
	}
	
	// 등록
	public int insertBoard(BoardDTO boardDTO) {
		sqlsession.insert("BoardMapper.insertBoard", boardDTO);
		int boardNum = sqlsession.selectOne("BoardMapper.getCurrentBoard");
		System.out.println("보드 넘버 반환 : " + boardNum);
		return boardNum;
	}
	
	//이미지 등록
		public void insertBoardImg(UserImgDTO userImgDTO) {
			try {
				sqlsession.insert("BoardMapper.insertBoardImg", userImgDTO);
			} catch (Exception e) {
				System.out.println("파일 저장 실패" + e.getMessage());
				e.printStackTrace();
			}
		}
	
	public void editBoard(BoardDTO boardDTO){
		sqlsession.update("BoardMapper.editBoard",boardDTO);
	}
	
	// 삭제
		public void deleteBoard(int boardDTO) {
			sqlsession.delete("BoardMapper.deleteBoard", boardDTO);
		}
	// 이미지 조회
	public UserImgDTO selectBoardImg(int boardNumber) {
		return sqlsession.selectOne("BoardMapper.selectBoardImg", boardNumber);
	}
}