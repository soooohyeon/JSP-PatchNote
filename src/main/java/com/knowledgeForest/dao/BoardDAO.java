package com.knowledgeForest.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.BoardDTO;
import com.knowledgeForest.dto.BoardImgDTO;
import com.knowledgeForest.dto.BoardUserDTO;
import com.knowledgeForest.dto.UserImgDTO;

public class BoardDAO {

    public SqlSession sqlsession;

    public BoardDAO() {
        sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 게시글 목록 조회
    public List<BoardUserDTO> getBoard(Map<String, Object> paramMap) {
    	return sqlsession.selectList("BoardMapper.getBoardList", paramMap);
    }
    
    //게시글 총 개수 가져오기
    public int getTotal() {
    	return sqlsession.selectOne("BoardMapper.getTotal");
    }
    
	//	해당 게시글 상세 조회,  
	public BoardImgDTO selectBoard(int boardNum) {
		return sqlsession.selectOne("BoardMapper.selectBoard", boardNum);
	}
	
	// 등록
	public int insertBoard(BoardDTO boardDTO) {
		sqlsession.insert("BoardMapper.insertBoard", boardDTO);
		int boardNum = sqlsession.selectOne("BoardMapper.getCurrentBoard");
		System.out.println("보드 넘버 반환 : " + boardNum);
		return boardNum;
	}
	
	//이미지 등록
		public void insertBoardImg(UserImgDTO userImgDTO) {
			try {
				System.out.println("userimgdto" + userImgDTO);
				sqlsession.insert("BoardMapper.insertBoardImg", userImgDTO);
			} catch (Exception e) {
				System.out.println("파일 저장 실패" + e.getMessage());
				e.printStackTrace();
			}
		}
	
	public void editBoard(BoardDTO boardDTO){
		sqlsession.update("BoardMapper.editBoard",boardDTO);
	}
	
	// 삭제
		public void deleteBoard(int boardDTO) {
			sqlsession.delete("BoardMapper.deleteBoard", boardDTO);
		}
	// 이미지 조회
	public UserImgDTO selectBoardImg(int boardNumber) {
		return sqlsession.selectOne("BoardMapper.selectBoardImg", boardNumber);
	}
	
	//이미지 삭제
	public void deleteboardImg(HashMap<String, String> imgInfo) {
		System.out.println("==================== 이미지 테이블 삭제 메소드 ===================");
		int boardNum = Integer.parseInt(imgInfo.get("boardNum"));
		sqlsession.delete("BoardMapper.deleteboardImg", boardNum);
		removeBoardImg(imgInfo);
	}
	
	//폴더 이미지 삭제
	public void removeBoardImg(HashMap<String, String> imgInfo) {
		System.out.println("==================== 이미지 삭제 메소드 ===================");
		String imgSrc = imgInfo.get("UPLOAD_PATH");
		String imgName = imgInfo.get("imgName");
		
		File file = new File(imgSrc, imgName);
		
		System.out.println("이미지삭제 DAO imgSrc : " + imgSrc);
		System.out.println("이미지삭제 DAO imgName : " + imgName);
		
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일 삭제 성공");
			}else {
				System.out.println("파일 삭제 실패");
			}
		}else {
			System.out.println("이미지 없음");
		}
	}
}