package com.knowledgeForest.controller.notice;

import com.knowledgeForest.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doProcess(request, response);
   }

   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("공지 컨트롤러 들어옴");
      String target = request.getRequestURI().substring(request.getContextPath().length());
      Result result = null;
      
      switch(target) {
      case "/notice/noticedetail.no":
    	  result = new NoticeDetailOkController().execute(request, response);
    	  break;
    	  
      case "/notice/noticelist.no" :
    	  result = new NoticeListOkController().execute(request, response);
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
