package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class PasswordOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		LoginDAO loginDAO = new LoginDAO();
//		UserDTO userDTO = new UserDTO();
		Result result = new Result();
//		
		//userId와 userPH 부분에서 Error 발생함으로 인해 page가 안넘어감 -> 수정해야함
//		userDTO.setUserId(request.getParameter("userId"));
//		userDTO.setUserPH(request.getParameter("userPH"));
//		
//		loginDAO.selectPw(userDTO);
		
		result.setRedirect(true);
		result.setPath(request.getContextPath()+"/login/passwordDetail.me");
		
		return result;

	}
}