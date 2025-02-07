package com.knowledgeForest.dao;

import java.io.File;
import java.util.HashMap;
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
	public AdminImgDTO selectNoticeImg(int noticeNum) {
		return sqlSession.selectOne("AdminImgMapper.selectNoticeImg", noticeNum);
	}
	
//	공지 이미지 삭제
	public void deleteNoticeImg(HashMap<String, String> imgInfo) {
		int noticeNum = Integer.parseInt(imgInfo.get("noticeNum"));
		sqlSession.delete("AdminImgMapper.deleteNoticeImg", noticeNum);
//		실제 폴더에서 이미지 삭제 메소드 실행
		removeAdminImg(imgInfo);
	}
	
//	실제 폴더에서 이미지 삭제
	public void removeAdminImg(HashMap<String, String> imgInfo) {
		String imgSrc = imgInfo.get("UPLOAD_PATH");
		String imgName = imgInfo.get("imgName");
		
		File file = new File(imgSrc, imgName);
		
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("파일 삭제 성공");
			} else {
				System.out.println("파일 삭제 실패");
			}
		} else {
			System.out.println("이미지 존재 안함");
		}
	}

}
