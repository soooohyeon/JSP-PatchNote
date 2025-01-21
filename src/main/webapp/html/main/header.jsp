<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
    <!-- 상단 메뉴바 -->
    <nav class="main-nav-menuwrap">
        <img src="${pageContext.request.contextPath}/asset/img/main/logo.png" class="main-img-logo">
        <ul class="main-nav-ul">
            <li><a href="${pageContext.request.contextPath}/notice/noticelist.no">공지</a></li>
            <li><a href="${pageContext.request.contextPath}/board/boradlist.bo">자유게시판</a></li>
            <li><a href="${pageContext.request.contextPath}/study/studylist.st">스터디 모집</a></li>
            
            
            <li><a href="${pageContext.request.contextPath}/login/join.me">회원가입</a></li>
            <li><a href="${pageContext.request.contextPath}/login/login.me">로그인</a></li>
            
            
        </ul>
    </nav>