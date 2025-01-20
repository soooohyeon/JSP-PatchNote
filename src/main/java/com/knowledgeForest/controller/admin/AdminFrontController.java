package com.knowledgeForest.controller.admin;

import com.knowledgeForest.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doProcess(request, response);
   }

   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("관리자 컨트롤러 들어옴");
      String target = request.getRequestURI().substring(request.getContextPath().length());
      Result result = null;
      
      switch(target) {
      case "/admin/admin-main.ad":
    	  request.getRequestDispatcher("/html/admin/admin-main.jsp").forward(request, response);
    	  break;
      case "/admin/admin-userlist.ad":
    	  result = new AdminUserListOkController().execute(request, response);
    	  break;
      case "/admin/admin-studylist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-studylist.jsp").forward(request, response);
    	  break;
      case "/admin/admin-studyapplylist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-studyapplylist.jsp").forward(request, response);
    	  break;
      case "/admin/admin-studycommentlist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-studycommentlist.jsp").forward(request, response);
    	  break;
      case "/admin/admin-boardlist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-boardlist.jsp").forward(request, response);
    	  break;
      case "/admin/admin-boardcommentlist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-boardcommentlist.jsp").forward(request, response);
    	  break;
      case "/admin/admin-noticelist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-noticelist.jsp").forward(request, response);
    	  break;
      case "/admin/admin-bannerlist.ad":
    	  request.getRequestDispatcher("/html/admin/admin-bannerlist.jsp").forward(request, response);
    	  break;
      }

      if (result != null) {
         if (result.isRedirect()) {
            response.sendRedirect(result.getPath());
         } else {
            request.getRequestDispatcher(result.getPath()).forward(request, response);
         }
      }

   }
}