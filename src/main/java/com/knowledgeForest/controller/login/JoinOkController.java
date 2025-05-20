package com.knowledgeForest.controller.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.LoginDAO;
import com.knowledgeForest.dto.UserDTO;

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();

		BufferedReader reader = request.getReader(); // getReader()는 HTTP 요청 본문을 읽을 수 있는 BufferedReader 반환
		String line = reader.readLine(); // JSON 데이터를 줄단위로 불러옴
		JsonElement jsonElement = JsonParser.parseString(line); // 문자열 형태의 JSON을 JsonElement로 변환
		JsonObject jsonObject = jsonElement.getAsJsonObject(); // JsonObject 형태로 변환하여 key-value값을 쉽게 추출하도록 함

//		회원가입 성공 여부를 담을 플래그 변수
		int isJoin = 0;

		userDTO.setUserId(jsonObject.get("userId").getAsString());
		userDTO.setUserNick(jsonObject.get("userNick").getAsString());
		userDTO.setUserPw(jsonObject.get("userPw").getAsString());
		userDTO.setUserBirth(jsonObject.get("userBirth").getAsString());
		userDTO.setUserPH(jsonObject.get("userPH").getAsString());
		userDTO.setUserName(jsonObject.get("userName").getAsString());

		isJoin = loginDAO.join(userDTO);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			// printwriter 파일 입출력
			out.print("{\"available\": " + isJoin + "}");
			out.flush();
		}

		return null;

	}

}
