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
	
	//첫번째 비밀번호 찾기 페이지
	public UserDTO passwd(Map<String, String> user) {
		// TODO Auto-generated method stub
		System.out.println("[[[[[[[[[TEST]]]]]]]]");
		
		//Map<String, String> user1 = user;
		System.out.println("확인 =======");
		System.out.println(user.get("userPH"));
		System.out.println(user.get("userId"));

		//변수로 받아온 키값에 대응되는 value값 String 타입으로 저장
		
		UserDTO userValue = new UserDTO();
		
		userValue.setUserId(user.get("userId"));
		userValue.setUserPH(user.get("userPH"));
		
		UserDTO userDTO = sqlsession.selectOne("LoginMapper.pwd", userValue);
		System.out.println("++++userValue+++++ : " + userValue);
//		return user == null ? null :userValue;
		//userDTO로 넘겨서 진행해야함
		return userDTO;
	}
	
	
	
	//두번째 비밀번호 찾기 페이지
	public void pwd(String userPw) {
		sqlsession.update("LoginMapper.pwdUpate", userPw);
		//LoginMapper에서는 PasswordDetailOkController의 sessionScope로 진행해서 넘겨줄 수 있음
	}



	


	
}
