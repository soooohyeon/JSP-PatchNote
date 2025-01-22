package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardDTO;
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
		userNum = 11; // 수정 필요 ;
		System.out.println("회원정보" + userNum);
		UserDTO user = sqlsession.selectOne("UserMapper.getUserInfo", userNum);
		return user;
	}

	// 회원 정보 수정
	public int updateUserInfo(UserDTO user) {
		System.out.println("회원정보 수정 : " + user);
		int result = 0;
		result = sqlsession.update("UserMapper.updateUser", user);
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

	// 만든 스터디 조회
	public int countStudy(int userNum) {
		return sqlsession.selectOne("UserMapper.countStudy", userNum);
	}

	// 신청한 스터디 조회
	public List<StudyDTO> getStudyList(int userNum) {
		List<StudyDTO> studyList = sqlsession.selectList("UserMapper.getStudyList", userNum);
		System.out.println("userMapper.getStudyList: " + studyList);
		return studyList;
	}

	// 신청한 스터디 취소
	public void deleteStudyApply(int studyNum) {
		sqlsession.delete("UserMapper.deleteStudyApply", studyNum);
		System.out.println("스터디 신청 취소됨");
	}

	// 게시글 목록 조회
	public List<BoardDTO> getBoardList(int userNum) {
		List<BoardDTO> boardList = sqlsession.selectList("UserMapper.getBoardList", userNum);
		System.out.println("userMapper.getBoardList: " + boardList);
		return boardList;
	}

	// 유저 탈퇴
	public void deleteUser(int userNum) {
		System.out.println("유저 탈퇴 : " + userNum);
		sqlsession.delete("UserMapper.deleteUser", userNum);
	}

}
