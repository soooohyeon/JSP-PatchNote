package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.UserDTO;

public class LoginDAO{
	
	public SqlSession sqlsession;
	
	public LoginDAO(){
		System.out.println("=====SQLSESSION 확인======" + sqlsession);
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		System.out.println("fifjwfjwe : " + sqlsession);
		
	}
	
	public void join(UserDTO userDTO) {
		
		sqlsession.insert("login.join", userDTO);
	}
	
	public UserDTO login(String userId, String userPw) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setUserPw(userPw);
		System.out.println("login이 되게 해줘");
		return sqlsession.selectOne("LoginMapper.userLogin", userDTO);
	}
	
	
}
