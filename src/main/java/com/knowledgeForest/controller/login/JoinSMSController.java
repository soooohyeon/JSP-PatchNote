package com.knowledgeForest.controller.login;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class JoinSMSController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		String phoneNumber = jsonObject.get("phoneNumber").getAsString();

		SmsService smsService = new SmsService();

		try {
		
			String verificationCode = smsService.sendVerificationSms(phoneNumber);

		
			HttpSession session = request.getSession();
			session.setAttribute("verificationCode", verificationCode);

		} catch (CoolsmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
}
