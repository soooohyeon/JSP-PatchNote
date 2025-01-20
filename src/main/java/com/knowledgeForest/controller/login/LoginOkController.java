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
		System.out.println("LoginOkcontroller test");
		
		
		
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		System.out.println("test");
		
		
		
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println("daotest");
		userDTO = loginDAO.login(userId, userPw);
		System.out.println("test");
		if(userDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", userDTO);
			
			System.out.println(userDTO);
			
			Cookie cookie = new Cookie("userId", userId);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			
			
			result.setPath(request.getContextPath());
			result.setRedirect(true);
			
		}else {
			result.setPath(request.getContextPath()+"/html/login/login.jsp");
			result.setRedirect(true);
		}
		
		return result;
	}
	
	
}
