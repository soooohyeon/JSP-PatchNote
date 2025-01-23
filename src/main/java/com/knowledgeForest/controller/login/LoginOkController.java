package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class LoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		int userNumber = 0;
				
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		HttpSession session = request.getSession(); //session에 저장
		
		userDTO.setUserId(userId);
		userDTO.setUserPw(userPw);
		
		userNumber = loginDAO.login(userDTO);
		session.setAttribute("userNumber", userNumber);
		System.out.println("#############" + userNumber);
		session.setAttribute("userDTO", userDTO.getUserId());
		session.setAttribute("userNick", userDTO.getUserNick());
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!"+ session.getAttribute(userDTO.getUserNick()));
		
		if(userNumber == -1) {

		
//			if(userNumber != null) {
//			
//			session.setAttribute("userDTO", userDTO);
//			
//			Cookie cookie = new Cookie("userId", userId);
//			cookie.setMaxAge(60*60*24);
//			response.addCookie(cookie);
//			
//			// 왜 안넘어가질까..
//			result.setPath(request.getContextPath());
//			result.setRedirect(true);
			session.invalidate(); // 저장된 -1 삭제
			result.setPath(request.getContextPath()+"/login/login.me");
		}else {
			session.getAttribute("userDTO");
			result.setPath(request.getContextPath()+"/knowledgeForest.main");
			System.out.println("@@@@@@"+userNumber);
			
		}
		result.setRedirect(true);
		return result;
	}
	
	
}
