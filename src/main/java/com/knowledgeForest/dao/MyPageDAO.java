package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.UserDTO;
public class MyPageDAO {

  public SqlSession sqlsession;

  public MyPageDAO(){
		System.out.println("=====SQLSESSION 확인======" + sqlsession);
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		System.out.println("접속확인 : " + sqlsession);
  }

  //회원정보 조회
  public UserDTO selectUserInfo(String userId) {
    UserDTO user = sqlsession.selectOne("MyPage.getUserInfo", userId);
    return user;
  }
  
  // 회원정보 수정
  public int updateUserInfo(UserDTO user) {
    int result = 0;
    result = sqlsession.update("MyPage.updateUser", user);
    return result;
  }

  
}
