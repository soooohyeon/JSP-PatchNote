package com.knowledgeForest.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutOkController
 */
@WebServlet("/login/logout.me") // URL 매핑
public class LogoutOkController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutOkController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 현재 세션 가져오기
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        // 메인 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/knowledgeForest.main");
    }
}