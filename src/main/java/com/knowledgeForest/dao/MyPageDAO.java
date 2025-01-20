package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.UserDTO;
public class MyPageDAO {

  public SqlSession sqlsession;

  public MyPageDAO(){
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
  }

  //회원정보 조회
  public UserDTO getUserInfo(String userId) {
	  userId = "eunji69"; // 수정 필요 ;
	System.out.println("회원정보" + userId);
	UserDTO user = sqlsession.selectOne("UserMapper.getUserInfo", userId);
    return user;
  }
  
  // 회원정보 수정
  public int updateUserInfo(UserDTO user) {
    int result = 0;
    result = sqlsession.update("UserMapper.updateUser", user);
    return result;
  }

  
}
