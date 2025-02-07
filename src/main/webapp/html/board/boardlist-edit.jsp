<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>지식의 숲</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/board/boardlistedit.css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css" />
    <script defer src="${pageContext.request.contextPath}/asset/js/board/boardlistedit.js"></script>

  </head>

  <body>
    <!-- 상단 메뉴바 -->
    <!-- <nav class="main-nav-menuwrap">
      <img src="../../asset/img/main/logo.png" class="main-img-logo" />
      <ul class="main-nav-ul">
        <li><a href="./../notice/noticelist.html">공지</a></li>
        <li><a href="./../board/boardlist.html">자유게시판</a></li>
        <li><a href="./../study/studylist.html">스터디 모집</a></li>
        <li><a href="./../login/join.html">회원가입</a></li>
        <li><a href="./../login/login.html">로그인</a></li>
      </ul>
    </nav> -->
    <!-- 상단 메뉴바  -->
	<jsp:include page="/html/main/header.jsp" />
	
    <main>
      <!-- 페이지 타이틀 -->
      <h1 class="board-h1-title">게시글 수정</h1>

      <!-- 전체 내용을 감싸는 래퍼-->
      <div class="board-div-contentsWrapper">
        <!-- 입력 폼을 감싸는 래퍼 -->
        <form id="board-FORM-WRITE" action="boardEditOk.bo" method="post" enctype="multipart/form-data">
          <!-- 한 행 -->
          <div class="board-div-wrapperlayer">
            <!-- label과 input을 묶은 div -->
            <div class="board-div-infowrapper">
              <div class="label">제목</div>
              <input type="hidden" name="boardNum" value = "${boardDetail.boardNum}">
              <input
                type="text"
                class="board-input-groupinfo"
                name="boardTitle"
                placeholder="제목을 입력해주세요"
                value = "${boardDetail.boardTitle}"
              />
            </div>
          </div>

          <div class="board-div-longwrapperlayer">
            <div class="board-div-textareawrapper">
              <div class="label">설명</div>
              <textarea class="board-div-studycontents" name="boardContents"><c:out value="${boardDetail.boardContents}" /></textarea>
            </div>
            <div class="board-div-filewrap">
              <div class="label">첨부파일</div>
              <label id="BOARD-INPUT-FILELABEL" for="BOARD-INPUT-FILE">
                <input type="file" name="file" accept="image/*" id="BOARD-INPUT-FILE" />
                <div class="board-div-filebtn">첨부</div>
              </label>
            </div>
          </div>
        </form>

        <div class="board-div-btnwrapper">
          <button
            class="board-btn-submit"
            form="board-FORM-WRITE"
            onclick="updateBoard(event)"
          >
            수정
          </button>
          <button
            class="board-btn-cancel"
            form="board-FORM-WRITE"
            onclick="goBack()"
          >
            취소
          </button>
        </div>
      </div>
    </main>

    <!-- <footer class="main-footer-container">
      <div class="main-footer-content">
        <div class="main-footer-links">
          <div class="main-footer-policies">
            <a href="#" class="main-link-policy">개인정보처리방침</a>
            <span class="main-span-divider">|</span>
            <a href="#" class="main-link-terms">이용약관</a>
          </div>
          <p class="main-paragraph-contact">
            Contact: team.patchnote.official@gmail.com
          </p>
          <p class="main-paragraph-copyright">
            Copyright Forest Info. All rights reserved
          </p>
        </div>
        <div class="main-footer-logo">
          <img
            src="/webapp/asset/img/main/logo.png"
            alt="Forest of Knowledge Logo"
            class="main-img-footerlogo"
          />
        </div>
      </div>
    </footer> -->
    	<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp" />
  </body>
</html>
