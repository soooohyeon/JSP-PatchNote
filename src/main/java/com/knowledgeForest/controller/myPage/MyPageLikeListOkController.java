package com.knowledgeForest.controller.myPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knowledgeForest.Execute;
import com.knowledgeForest.Result;
import com.knowledgeForest.dao.MyPageDAO;
import com.knowledgeForest.dto.StudyUserDTO;

public class MyPageLikeListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageDAO mypageDAO = new MyPageDAO();
		Result result = new Result();
		
		// userNum = (int) request.getSession().getAttribute("userNum");
		int userNum = 13;

		List<StudyUserDTO> likeList = null;
		
//		likeList = mypageDAO.getLikeList(userNum);
		System.out.println("likeList : " + likeList);
		request.setAttribute("liekList", likeList);
		result.setPath(request.getContextPath()+"/mypage/mypage-jimlist.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
