package com.knowledgeForest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.NoticeImgDTO;
import com.knowledgeForest.dto.StudyApplyDTO;
import com.knowledgeForest.dto.StudyApplyUserDTO;
import com.knowledgeForest.dto.StudyUserDTO;
import com.knowledgeForest.dto.UserDTO;

public class AdminDAO {
	
	public SqlSession sqlSession;

	public AdminDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	신규 유저 최대 5명
	public List<UserDTO> selectUserFive() {
		return sqlSession.selectList("AdminMapper.selectUserFive");
	}

//	최신 스터디 최대 5개
	public List<StudyUserDTO> selectStudyFive() {
		return sqlSession.selectList("AdminMapper.selectStudyFive");
	}

//	최신 자유게시판 최대 5개
	public List<BoardUserDTO> selectBoardFive() {
		return sqlSession.selectList("AdminMapper.selectBoardFive");
	}
	
//	최신 공지 최대 5개
	public List<NoticeDTO> selectNoticeFive() {
		return sqlSession.selectList("AdminMapper.selectNoticeFive");
	}
	
//	모든 유저 목록 조회
	public List<UserDTO> selectUserAll(Map<String, Object> paramMap) {
		return sqlSession.selectList("AdminMapper.selectUserAll", paramMap);
	}
	
//	총 유저 수
	public int getUserTotal(String keyword) {
		System.out.println("keyword : " + keyword);
		return sqlSession.selectOne("AdminMapper.getUserTotal", keyword);
	}
	
//	해당 유저 상세 조회
	public UserDTO selectUserOne(int userNum) {
		return sqlSession.selectOne("AdminMapper.selectUserOne", userNum);
	}
	
//	해당 유저가 작성한 스터디 개수 조회
	public int countStudy(int userNum) {
		return sqlSession.selectOne("AdminMapper.countStudy", userNum);
	}
	
//	해당 유저가 신청한 스터디 개수 조회
	public int countApply(int userNum) {
		return sqlSession.selectOne("AdminMapper.countApply", userNum);
	}
	
//	해당 유저가 작성한 스터디 댓글 개수 조회
	public int countStudyComment(int userNum) {
		return sqlSession.selectOne("AdminMapper.countStudyComment", userNum);
	}
	
//	해당 유저가 작성한 자유게시판 개수 조회
	public int countBoard(int userNum) {
		return sqlSession.selectOne("AdminMapper.countBoard", userNum);
	}
	
//	해당 유저가 작성한 자유게시판 댓글 개수 조회
	public int countBoardComment(int userNum) {
		return sqlSession.selectOne("AdminMapper.countBoardComment", userNum);
	}
	
//	해당 유저 탈퇴
	public void deleteUser(int userNum) {
		sqlSession.delete("AdminMapper.deleteUser", userNum);
	}
	
//	스터디 목록 조회
	public List<StudyUserDTO> selectStudyAll() {
		return sqlSession.selectList("AdminMapper.selectStudyAll");
	}
	
//	스터디 목록 조회 - 검색
	public List<StudyUserDTO> selectStudySearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectStudySearch", keyword);
	}
	
//	해당 스터디 삭제
	public void deleteStudy (int studyNum) {
		sqlSession.delete("AdminMapper.deleteStudy", studyNum);
	}
	
//	공지 목록 조회
	public List<NoticeDTO> selectNoticeAll() {
		return sqlSession.selectList("AdminMapper.selectNoticeAll");
	}
	
//	공지 목록 조회 - 검색
	public List<NoticeDTO> selectNoticeSearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectNoticeSearch", keyword);
	}
	
//	공지 상세 조회
	public NoticeImgDTO selectOneNotice(int noticeNum) {
		System.out.println("DAO : " + noticeNum);
		return sqlSession.selectOne("AdminMapper.selectOneNotice", noticeNum);
	}
	
//	해당 공지 삭제
	public void deleteNotice (int noticeNum) {
		sqlSession.delete("AdminMapper.deleteNotice", noticeNum);
	}
	
//	공지 등록
	public int insertNotice (NoticeDTO noticeDTO) {
//		공지 등록하는 쿼리 실행
		sqlSession.insert("AdminMapper.insertNotice", noticeDTO);
		
		System.out.println("최근 등록 : " + sqlSession.selectOne("AdminMapper.getCurrentNoticeNum"));
//		가장 최근에 생성된 공지 번호값 리턴 - 이미지 첨부를 위함
		return sqlSession.selectOne("AdminMapper.getCurrentNoticeNum");
	}
	
//	공지 수정
	public void updateNotice (NoticeDTO noticeDTO) {
		sqlSession.insert("AdminMapper.updateNotice", noticeDTO);
	}
	
//	스터디 신청 목록 조회
	public List<StudyApplyUserDTO> selectStudyApplyAll () {
		return sqlSession.selectList("AdminMapper.selectStudyApplyAll");
	}

//	스터디 신청 목록 조회 - 검색
	public List<StudyApplyUserDTO> selectStudyApplySearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectStudyApplySearch", keyword);
	}
	
//	스터디 신청 취소
	public void deleteStudyApply(int likeNum) {
		sqlSession.delete("AdminMapper.deleteStudyApply", likeNum);
	}
	
//	스터디 신청 상세 조회
	public StudyApplyDTO selectStudyApplyOne(int studyApplyNum) {
		return sqlSession.selectOne("AdminMapper.selectStudyApplyOne", studyApplyNum);
	}
	
//	자유게시판 목록 조회
	public List<BoardUserDTO> selectBoardAll () {
		return sqlSession.selectList("AdminMapper.selectBoardAll");
	}

//	자유게시판 목록 조회 - 검색
	public List<BoardUserDTO> selectBoardSearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectBoardSearch", keyword);
	}
	
//	자유게시판 글 삭제
	public void deleteBoard(int boardNum) {
		sqlSession.selectList("AdminMapper.deleteBoard", boardNum);
	}
}
