package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.AdminImgDTO;

public class AdminImgDAO {
	SqlSession sqlSession;

	public AdminImgDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	공지 이미지 등록
	public void insertNoticeImg(AdminImgDTO adminImgDTO) {
		sqlSession.insert("AdminImgMapper.insertNoticeImg", adminImgDTO);
	}
	
}
