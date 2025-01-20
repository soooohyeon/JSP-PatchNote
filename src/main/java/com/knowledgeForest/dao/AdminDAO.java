package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.UserDTO;

public class AdminDAO {
	
	public SqlSession sqlSession;

	public AdminDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

//	모든 유저 목록 조회
	public List<UserDTO> selectUserAll() {
		return sqlSession.selectList("AdminMapper.selectUserAll");
	}

//	해당 유저 상세 조회
	public List<UserDTO> selectUserOne(int userNum) {
		return sqlSession.selectList("AdminMapper.selectUserOne", userNum);
	}
	
}
