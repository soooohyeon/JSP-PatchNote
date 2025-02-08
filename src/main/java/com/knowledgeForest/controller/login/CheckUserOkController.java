package com.knowledgeForest.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class CheckUserOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		System.out.println("========= PasswordOkController ==========");
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();

		HttpSession session = request.getSession();
		// key, value 한쌍으로 저장됨
		HashMap<String, String> user = new HashMap<String, String>();
		String userId = request.getParameter("userId");
		String userPh = request.getParameter("userPh");

		user.put("userId", userId);
		user.put("userPh", userPh);

		System.out.println("+++++user.put확인+++++ : " + user);

//		조회 후 반환된 유저번호 담기
		int userNum = loginDAO.checkUser(user);
		boolean isAvailable = userNum == -1 ? false : true;
		System.out.println("+++++loginDAO/USER확인+++++ : " + userNum);
		System.out.println("++isAvailable : " + isAvailable);
		
		session.setAttribute("userNum", userNum);
		System.out.println("세션에 userNum 설정: " + userNum);


		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			out.print("{\"available\": " + isAvailable + "}");
			out.flush();
		}
		result.setPath(null); // 페이지 이동이 없음을 명시
		result.setRedirect(false); // 리다이렉트 설정 (false로 유지)
		return result;

	}
}
