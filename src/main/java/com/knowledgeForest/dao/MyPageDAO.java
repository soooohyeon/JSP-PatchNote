package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.StudyApplyDTO;
import com.knowledgeForest.dto.StudyApplyUserDTO;
import com.knowledgeForest.dto.StudyDTO;
import com.knowledgeForest.dto.StudyUserDTO;
import com.knowledgeForest.dto.UserDTO;

public class MyPageDAO {

	public SqlSession sqlsession;

	public MyPageDAO() {
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 회원정보 조회
	public UserDTO getUserInfo(int userNum) {
		UserDTO user = sqlsession.selectOne("UserMapper.getUserInfo", userNum);
		return user;
	}

	// 회원 정보 수정
	public int updateUserInfo(UserDTO user) {
		System.out.println("회원정보 수정 : " + user);
		int result = 0;
		result = sqlsession.update("UserMapper.updateUser", user);
		System.out.println("result : " + result);
		return result;
	}

	// 닉네임 중복 체크
	public boolean checkNickname(String userNick) {
		System.out.println("닉네임 : " + userNick);
		int count = sqlsession.selectOne("UserMapper.checkNickname", userNick);
		System.out.println("count :" + count);
		return count > 0;
	}

	// 찜한 목록 조회
//	public List<StudyUserDTO> getLikeList(int userNum) {
//		List<StudyUserDTO> likeList = sqlsession.selectList("UserMapper.getLikeList", userNum);
//		System.out.println("userMapper.getLikeList: " + likeList);
//		return likeList;
//	}

	// 내가 작성한 스터디 목록 조회
	public List<StudyUserDTO> getMyStudies(int userNum) {
		return sqlsession.selectList("UserMapper.getMyStudies", userNum);
	}

	// 작성한 스터디 총 갯수 출력
	public int getMyStudyTotal(int userNum) {
		return sqlsession.selectOne("UserMapper.getMyStudyTotal", userNum);
	}

	// 신청한 스터디 조회
	public List<StudyApplyDTO> getStudyList(int userNum) {
		List<StudyApplyDTO> studyList = sqlsession.selectList("UserMapper.getStudyList", userNum);
		System.out.println("UserMapper.getStudyList: " + studyList);
		return studyList;
	}
	// 신청한 스터디 게시글 수
	public int getStudyListTotal(int userNum) {
		return sqlsession.selectOne("UserMapper.getStudyListTotal", userNum);
	}
	// 신청한 스터디 취소
	public void deleteStudyApply(int studyNum) {
		sqlsession.delete("UserMapper.deleteStudyApply", studyNum);
		System.out.println("스터디 신청 취소됨");
	}

	// 자유게시판 게시글 목록 조회
	public List<BoardUserDTO> getBoardList(Map<String, Object> paramMap) {
		System.out.println("paramMap " + paramMap);
		List<BoardUserDTO> boardList = sqlsession.selectList("UserMapper.getBoardList", paramMap);
		System.out.println("UserMapper.getBoardList: " + boardList);
		return boardList;
	}

	// 자유게시판 게시글 수
	public int getBoardTotal(int userNum) {
		return sqlsession.selectOne("UserMapper.getBoardTotal", userNum);
	}

	// 유저 탈퇴
	public void deleteUser(int userNum) {
		System.out.println("유저 탈퇴 : " + userNum);
		sqlsession.delete("UserMapper.deleteUser", userNum);
	}

	// 신청자 목록 조회
	public List<StudyApplyUserDTO> getApplicants(int studyNum) {
		return sqlsession.selectList("UserMapper.getApplicants", studyNum);
	}

	// 신청자 수락
	public int acceptApplicant(int studyApplyNum) {
		return sqlsession.update("UserMapper.acceptApplicant", studyApplyNum);
	}

	// 신청자 거절
	public void rejectApplicant(int studyApplyNum) {
		sqlsession.update("UserMapper.rejectApplicant", studyApplyNum);
	}

}
