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
		System.out.println("joinOkController+++++++++");
		
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();

		
		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserNick(request.getParameter("userNick"));
		userDTO.setUserPw(request.getParameter("userPw"));
		userDTO.setUserBirth(request.getParameter("userBirth"));
		System.out.println(userDTO.getUserBirth());
		//수정중 -> Controller - mapper ORA-01861 : 리터럴 형식 문자열과 일치하지않음
		userDTO.setUserPH(request.getParameter("userPH"));
		userDTO.setUserName(request.getParameter("userName"));
		System.out.println("+++++++++++++++++++++"+userDTO);
		
		loginDAO.join(userDTO);
		
		
		result.setPath(request.getContextPath()+"/login/login.me");
		result.setRedirect(true);
		
		return result;
		
		
		
	}

	
	
}
