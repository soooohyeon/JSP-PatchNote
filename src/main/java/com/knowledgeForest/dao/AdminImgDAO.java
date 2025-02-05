package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.AdminImgDTO;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.NoticeImgDTO;

public class AdminImgDAO {
	SqlSession sqlSession;

	public AdminImgDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

//	공지 이미지 등록
	public void insertNoticeImg(AdminImgDTO adminImgDTO) {
		try {
			sqlSession.insert("AdminImgMapper.insertNoticeImg", adminImgDTO);
		} catch (Exception e) {
			System.out.println("파일 저장이 실패되었습니다. " + e.getMessage());
			e.printStackTrace();
		}
	}

//	공지 이미지 조회
	public AdminImgDTO selectNoticeImg(int noticeNumber) {
		return sqlSession.selectOne("AdminImgMapper.selectNoticeImg", noticeNumber);
	}

}
