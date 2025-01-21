package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardDTO;

public class BoardDAO {

    public SqlSession sqlsession;

    public BoardDAO() {
        sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 게시글 목록 조회
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = sqlsession.selectList("BoardMapper.getBoardList");
        return boardList;
    }

   public boolean insertBoard(BoardDTO board) {
      // TODO Auto-generated method stub
      return false;
   }
}