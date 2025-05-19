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

public class CheckPhoneOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAO();
		boolean isAvailable = false;
		
		BufferedReader reader = request.getReader(); //getReader()는 HTTP 요청 본문을 읽을 수 있는 BufferedReader 반환
		String line = reader.readLine(); //JSON 데이터를 줄단위로 불러옴
		JsonElement jsonElement = JsonParser.parseString(line);	// 문자열 형태의 JSON을 JsonElement로 변환
		JsonObject jsonObject = jsonElement.getAsJsonObject();	// JsonObject 형태로 변환하여 key-value값을 쉽게 추출하도록 함

		String userPhone = jsonObject.get("phoneNumber").getAsString();
		isAvailable = loginDAO.checkPhone(userPhone);	// true면 해당 전화번호 사용 가능

		System.out.println("isAvailable : " + isAvailable);
		
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			// printwriter 파일 입출력
			out.print("{\"available\": " + isAvailable + "}");
			out.flush();
		}
		
		return null;
	}

}
