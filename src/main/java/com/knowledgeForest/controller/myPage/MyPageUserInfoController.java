package com.knowledgeForest.controller.myPage;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;

public class MyPageUserInfoController implements Execute {
  @Override
  public Result execute(HttpServletRequest request, HttpServletResponse response) {
    String userId = request.getParameter("userId");
    UserDTO user = new MyPageDAO().selectUserInfo(userId);
    request.setAttribute("user", user);
    return new Result(false, "/html/mypage/mypage-accountedit.jsp");
  }

}
