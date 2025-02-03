package com.knowledgeForest.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;

public class CheckIdOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			LoginDAO loginDAO = new LoginDAO();
			Result result = new Result();
			
			 String userId = request.getParameter("userId");
		     boolean isAvailable = loginDAO.checkId(userId);
		        
		     response.setContentType("application/json");
		     response.setCharacterEncoding("UTF-8");

		     try (PrintWriter out = response.getWriter()) {
		        	//printwriter 파일 입출력
		            out.print("{\"available\": " + isAvailable + "}");
		            out.flush();
		     }
		            result.setPath(null); // 페이지 이동이 없음을 명시
		            result.setRedirect(false); // 리다이렉트 설정 (false로 유지)
		            return result;
	}
	
}
