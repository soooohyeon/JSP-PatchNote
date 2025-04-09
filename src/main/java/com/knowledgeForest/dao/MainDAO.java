package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.StudyDTO;


public class MainDAO {

	private SqlSession sqlsession;

	public MainDAO() {
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 공지리스트 조회
	public List<NoticeDTO> getNoticeList() {
		List<NoticeDTO> noticeList = sqlsession.selectList("MainMapper.getNoticeList");
		return noticeList;

	}

	// 신규 등록 스터디
	public List<StudyDTO> getNewStudy() {
		System.out.println("신규 등록 스터디 조회");
		List<StudyDTO> newStudyList = sqlsession.selectList("MainMapper.newStudy");
		return newStudyList;
	}

	// 마감 임박 스터디
	public List<StudyDTO> getDeadlineStudy() {
		System.out.println("마감 임박 스터디 조회");
		List<StudyDTO> endStudyList = sqlsession.selectList("MainMapper.getDeadlineStudy");
		return endStudyList;
	}
	
}