package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class PasswordDetailOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		LoginDAO loginDAO = new LoginDAO();
//		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		
		//비밀번호를 업데이하는 구문을 작성해야함
		
		
		result.setRedirect(true);
		result.setPath(request.getContextPath());
		return result;
	}

	
	
}
