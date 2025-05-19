package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
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
		
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();
		
		int userNumber = 0;
				
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		HttpSession session = request.getSession(); //session에 저장
		session.removeAttribute("userNum"); // 필요없는 세션 삭제 (비밀번호 찾기에서 사용)

		userDTO.setUserId(userId);
		userDTO.setUserPw(userPw);
		
		userNumber = loginDAO.login(userDTO);
		session.setAttribute("userNumber", userNumber);
		session.setAttribute("userDTO", userDTO.getUserId());
		session.setAttribute("userNick", userDTO.getUserNick());
		
		if(userNumber == -1) {
			session.invalidate(); // 저장된 -1 삭제
		}else {
			session.getAttribute("userDTO");
		}

		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().write(String.valueOf(userNumber));
		
		return null;
	}
	
	
}
