package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("joinOkController");
		
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		System.out.println("+++++++++++++++++++++"+userDTO);
		
		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserNick(request.getParameter("userNick"));
		userDTO.setUserPw(request.getParameter("userNick"));
		userDTO.setUserBirth(request.getParameter("userBirth"));
		userDTO.setUserPH(request.getParameter("userPH"));
		userDTO.setUserName(request.getParameter("userName"));
		
		
		loginDAO.join(userDTO);
		
		result.setRedirect(true);
		result.setPath(request.getContextPath());
		return result;
		
		
		
	}
	
	
	
	
}
