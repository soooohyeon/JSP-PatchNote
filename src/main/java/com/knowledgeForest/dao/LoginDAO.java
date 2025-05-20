package com.knowledgeForest.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.knowledgeForest.Result;
import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.UserDTO;

public class LoginDAO{
	
	public SqlSession sqlsession;

	
	public LoginDAO(){
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//회원가입
	public int join(UserDTO userDTO) {
		return sqlsession.insert("LoginMapper.join", userDTO);
	}
	
	//로그인
	public int login(UserDTO userDTO) {
		UserDTO user = sqlsession.selectOne("LoginMapper.Login", userDTO);
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
	
	//가입된 휴대폰번호인지 검사
	public boolean checkPhone(String userPH) {
		return (Integer)sqlsession.selectOne("LoginMapper.checkPhone", userPH) < 1;
	}
	
	//첫번째 비밀번호 찾기 페이지
	public int checkUser(Map<String, String> user) {
		System.out.println("checkUser 메소드 실행 중");
		System.out.println(user.get("userPh"));
		System.out.println(user.get("userId"));
		UserDTO userDTO = sqlsession.selectOne("LoginMapper.checkUser", user);
		System.out.println("==== 결과 : " + userDTO);
		return userDTO == null ? -1 : userDTO.getUserNum();
	}
	
	//두번째 비밀번호 찾기 페이지
	public void updatePw (Map<String, Object> userInfo) {
		sqlsession.update("LoginMapper.updatePw", userInfo);
	}

	
}
