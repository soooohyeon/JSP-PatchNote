package com.knowledgeForest.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;

/**
 * Servlet implementation class LoginFrontController
 */
//@WebServlet("/LoginFrontController")
public class LoginFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFrontController() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      doProcess(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      doProcess(request, response);
   }
   
   protected void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String target = request.getRequestURI().substring(request.getContextPath().length());
   
      Result result = null;
      System.out.println("분기처리 전"); // 찍히는건 확인
      System.out.println(target); // 찍히는건 확인
//      경로 분기처리
      switch (target) {
         
      case "/login/login.me" :
         request.getRequestDispatcher("/html/login/login.jsp").forward(request, response);
         break;
         
      case "/login/join.me" :
         System.out.println("회원가입");
         request.getRequestDispatcher("/html/login/join.jsp").forward(request, response);
         break;
         
      case "/login/joinOk.me" :
         System.out.println("회원가입완료");
         result = new JoinOkController().execute(request, response); //404 에러 공존
//         request.getRequestDispatcher("/html/login/join.jsp").forward(request, response); //JoinOkController로 안넘어가짐
         break;
         
         //해야할것
      case "/login/passwordSelect.me" :
         System.out.println("비밀번호찾기");
         request.getRequestDispatcher("/html/login/passwordSelect.jsp").forward(request, response);
         break;
      
      case "/login/loginOk.me" :
         System.out.println("loginFrontController test");
         
         result = new LoginOkController().execute(request, response);
         break;
      }
      if(result != null) {
         System.out.println("로그인좀");
         if(result.isRedirect()) {
            response.sendRedirect(result.getPath());
            
         }else {
            request.getRequestDispatcher(result.getPath()).forward(request, response);
         }
      }
      
   }

}
