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
	//ID 중복검사
	public boolean checkId(String userId) {
		return (Integer)sqlsession.selectOne("LoginMapper.checkId", userId) < 1;
	}
	
	//닉네임 중복검사
	public boolean checkNick(String userNick) {
		return (Integer)sqlsession.selectOne("LoginMapper.checkNick", userNick) < 1;
	}
	
	//두번째 비밀번호 찾기 페이지
}
