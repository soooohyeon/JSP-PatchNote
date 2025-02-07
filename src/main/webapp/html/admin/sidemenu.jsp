<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 공통 css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/admin/adminMenuLayOut.css">
<!-- 공통 js -->	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-basic.js"></script>

<!-- 사이드 메뉴 -->
<aside id="ADMIN-MENUCONTAINER">
	<nav class="admin-div-menuwrap">
		<h1 id="ADMIN-H2-TITLE"><a href="${pageContext.request.contextPath}/admin/admin-main.ad">관리자 페이지</a></h1>
		<ul class="admin-ul-menuwrap">
			<!-- admin-li-menuactive : 메뉴 활성화 스타일 -->
			<li><a href="${pageContext.request.contextPath}/admin/admin-userlist.ad">유저 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/admin-studylist.ad">스터디 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/admin-studyapplylist.ad">스터디 신청 관리</a></li>
			<%-- <li><a href="${pageContext.request.contextPath}/admin/admin-studycommentlist.ad">스터디 후기댓글 목록</a></li> --%>
			<li><a href="${pageContext.request.contextPath}/admin/admin-boardlist.ad">자유게시판 관리</a></li>
			<%-- <li><a href="${pageContext.request.contextPath}/admin/admin-boardcommentlist.ad">자유게시판 댓글 관리</a></li> --%>
			<li><a href="${pageContext.request.contextPath}/admin/admin-noticelist.ad">공지 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/admin-bannerlist.ad">배너 목록</a></li>
		</ul>
	</nav>
</aside>
<!-- 사이드 메뉴 끝 -->