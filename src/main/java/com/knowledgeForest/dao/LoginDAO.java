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
		UserDTO user = sqlsession.selectOne("LoginMapper.Login", userDTO);
		int userNumber = -1;
		return user == null ? -1 : user.getUserNum();
	}
	
	//첫번째 비밀번호 찾기 페이지
	public void selectPw(UserDTO userDTO) {
		sqlsession.selectOne("LoginMapper.selectPw");
		
	}
	
	
	//두번째 비밀번호 찾기 페이지
}
