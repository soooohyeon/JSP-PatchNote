package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;
import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.LikeDTO;

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

}
