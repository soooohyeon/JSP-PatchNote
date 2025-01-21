package com.knowledgeForest.controller.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Result;
import com.knowledgeForest.controller.admin.AdminStudyListOkController;
import com.knowledgeForest.controller.admin.AdminUserDeleteOkController;
import com.knowledgeForest.controller.admin.AdminUserDetailOkController;
import com.knowledgeForest.controller.admin.AdminUserListOkController;

/**
 * Servlet implementation class MainFrontController
 */
//@WebServlet("/MainFrontController")
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainFrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
     }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
     }

     protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = request.getRequestURI().substring(request.getContextPath().length());
        Result result = null;
        
        switch(target) {
        case "/knowledgeForest.main":
      	  result = new MainContentController().execute(request, response);
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
