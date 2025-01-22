package com.knowledgeForest.dao;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.UserDTO;

public class LoginDAO{
	
	public SqlSession sqlsession;
	
	public LoginDAO(){
//		System.out.println("=====SQLSESSION 확인======" + sqlsession);
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
//		System.out.println("fifjwfjwe : " + sqlsession);
		
	}
	
	//회원가입
	public void join(UserDTO userDTO) {
		sqlsession.insert("LoginMapper.join", userDTO);
	}
	
	//로그인
	public int login(UserDTO userDTO) {
		Integer userNumber = (int)sqlsession.selectOne("LoginMapper.Login", userDTO);
		return userNumber == null ? -1 : userNumber;
	}
	
	
}
