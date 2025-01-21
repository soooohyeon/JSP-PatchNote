package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;
import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.LikeDTO;
import com.knowledgeForest.dto.StudyDTO;

import java.util.List;

public class MainDAO {

	private SqlSession sqlsession;

	public MainDAO() {
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 위시리스트 조회
	public List<String> getWishList(int userNum) {
		System.out.println("사용자 번호로 위시리스트 조회: " + userNum);
		List<String> wishList = sqlsession.selectList("MainMapper.getWishList", userNum);
		return wishList;

	}

	// 신규 등록 스터디
	public List<StudyDTO> getNewStudy() {
		System.out.println("신규 등록 스터디 조회");
		List<StudyDTO> newStudyList = sqlsession.selectList("MainMapper.newStudy");
		return newStudyList;
	}

	// 마감 임박 스터디
	public List<StudyDTO> getEndStudy() {
		System.out.println("마감 임박 스터디 조회");
		List<StudyDTO> endStudyList = sqlsession.selectList("MainMapper.endStudy");
		return endStudyList;
	}

}