<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/header.css">
	<script defer
	src="${pageContext.request.contextPath}/asset/js/main/main.js"></script>
	
	<!-- 상단 헤더 메뉴바 -->
	<%-- <jsp:include page="/html/main/header.jsp" /> --%> <!-- <<- 헤더 주석 해제 후 옆에 주소 내용 복사해서 사용 !! -->
	
	
<!-- 상단 메뉴바 -->
<nav class="main-nav-menuwrap">
	<img src="${pageContext.request.contextPath}/asset/img/main/logo.png"
		class="main-img-logo" onclick="goMain()">
	<ul class="main-nav-ul">
		<li><a
			href="${pageContext.request.contextPath}/notice/noticelist.no">공지</a></li>
		<li><a
			href="${pageContext.request.contextPath}/board/boradlist.bo">자유게시판</a></li>
		<li><a
			href="${pageContext.request.contextPath}/study/studylist.st">스터디 모집</a></li>

		<c:choose>
			<c:when test="${empty sessionScope.userNum}">
				<li><a href="${pageContext.request.contextPath}/login/join.me">회원가입</a></li>
				<li><a href="${pageContext.request.contextPath}/login/login.me">로그인</a></li>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${sessionScope.userNum <= 10}">
						<li><a href="${pageContext.request.contextPath}/admin/admin-main.ad">관리자페이지</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my">마이페이지</a></li>
					</c:otherwise>
				</c:choose>
				
				<li><a href="">로그아웃</a></li>
			</c:otherwise>
		</c:choose>
		
	</ul>
</nav>