package com.knowledgeForest.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class PasswordOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("=========PasswordOkController넘어오기==========");
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		
		// key, value 한쌍으로 저장됨
		 
		HashMap<String, String> user = new HashMap<String, String>();
		
		String userId = request.getParameter("userId");
		String userPH = request.getParameter("userPH");
		HttpSession session = request.getSession();

		
		userDTO.setUserId(userId);
		userDTO.setUserPH(userPH);
	
		
		user.put("userId", userId);
		user.put("userPH", userPH);
		
		System.out.println("+++++user.put확인+++++ : " + user);
		System.out.println(user.get("userPH"));
		System.out.println(user.get("userId"));
		System.out.println("+++++++++확인++++++++++");
	
		userDTO =  loginDAO.passwd(user); //DAO.passwd 값 가져오는 것(해당 폰번호와 id가 일치하는 userNum으로 전체 데이터를 가져와야함 x / 폰번호와 id값만 가져옴)
	
		
		System.out.println("+++++loginDAO/USER확인+++++ : " + user); //빈값
		
		//PasswordOkController jsp 페이지 구조를 변경해서 진행해야함 (o)
		
		//userNum으로 세션에 저장해서 진행해야함(x)
		//LoginMapper에서는 PasswordDetailOkController의 sessionScope로 진행해서 넘겨줄 수 있음(x)
		
		
		session.setAttribute("user", user);
		session.setAttribute("userDTO", userDTO.getUserId());
		session.setAttribute("userDTO", userDTO.getUserPH());
		
		//참 것짓으로 변경해서 진행해야함(o)
		if(!(user.get(userPH) == null || user.get(userId) == null)) {
			session.getAttribute("userDTO");
			result.setPath(request.getContextPath()+"/login/passwordDetail.me");
			result.setRedirect(true);
			return result;
			
		}else {
			result.setPath(request.getContextPath()+"/login/passwordSelect.me");
			result.setRedirect(true);
			return result;
			
			
		}

	}
}