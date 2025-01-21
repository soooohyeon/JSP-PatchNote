package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.UserDTO;

public class NoticeDAO {
	public SqlSession sqlSession;

	public NoticeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public List<NoticeDTO> getNotice() {
		List<NoticeDTO> list = sqlSession.selectList("NoticeMapper.getNotice");

		return list;
	}

//		해당 게시글 상세 조회
	public NoticeDTO selectNotice(int noticeNum) {
		return sqlSession.selectOne("NoticeMapper.selectNotice", noticeNum);
	}
	
}
