<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>지식의 숲</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/study/studylist.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
  </head>
  <body>
     <!-- 상단 메뉴바 -->
     <nav class="main-nav-menuwrap">
      <img src="${pageContext.request.contextPath}/asset/img/main/logo.png" class="main-img-logo">
      <ul class="main-nav-ul">
        <li><a href="${pageContext.request.contextPath}/html/notice/notice-list.jsp">공지</a></li>
        <li><a href="${pageContext.request.contextPath}/html/board/board-list.jsp">자유게시판</a></li>
        <li><a href="${pageContext.request.contextPath}/html/study/studylist.jsp">스터디 모집</a></li>
        <li><a href="${pageContext.request.contextPath}/html/login/join.jsp">회원가입</a></li>
        <li><a href="${pageContext.request.contextPath}/html/login/login.jsp">로그인</a></li>
      </ul>
    </nav>
    <main>
      <!-- 페이지 타이틀 -->
      <h1 class="studylist-h1-title">STUDY</h1>
      <!-- 검색창 -->
      <form class="studylist-form-wrapper" action="">
        <input
          type="text"
          class="studylist-input-search"
          placeholder="검색어를 입력하세요."
        />
        <button type="submit" class="studylist-btn-search">
          <img
            src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
            alt="search"
            class="studylist-img-search"
          />
        </button>
      </form>
      <!-- 전체 내용을 감싸는 래퍼-->
      <div class="studylist-div-contentsWrapper">
        <div class="studylist-div-categoryWrapper">
          <div class="studylist-div-category selected">전체</div>
          <div class="studylist-div-category">개발</div>
          <div class="studylist-div-category">보안</div>
        </div>

        <!-- 모임 항목들을 감싸는 래퍼-->
        <div class="studylist-div-groupWrapper">
          <!-- 모임 항목-->

          <div class="studylist-div-group">
            <div class="studylist-div-groupinner">
              <div class="studylist-div-groupinfowrapper datecontent-wrap">
                <div class="studylist-div-enddate">
                  마감일 &nbsp;| &nbsp; ${study.studyDeadline}
                </div>
                <div class="studylist-div-groupstatus">모집 중</div>
              </div>
              <div class="studylist-div-grouptitle">
                웹 보안의 기초부터 간단한 토이 프로젝트까지
              </div>
              <div class="studylist-div-groupinfowrapper">
                <div class="studylist-div-groupcategory">보안</div>
                <div class="studylist-div-groupmember">7/7</div>
              </div>
              <div class="studylist-div-groupmakerwrapper">
                <div class="studylist-div-groupmaker">김철수</div>
                <div class="studylist-div-likewrapper">
      
                  <img
                    src="${pageContext.request.contextPath}/asset/img/study/like.png"
                    alt="찜"
                    class="studylist-img-like"
                    onclick="likeStudy(this)"
                  />
                  <div class="studylist-div-likecount">7</div>
                </div>
              </div>
            </div>
          </div>


        </div>

		<!--  
        <div class="studylist-div-groupWrapper">
          <div class="studylist-div-group">
            <div class="studylist-div-groupinner">
              <div class="studylist-div-groupinfowrapper datecontent-wrap">
                <div class="studylist-div-enddate">
                  마감일 &nbsp;| &nbsp; 2025.01.05
                </div>
                <div class="studylist-div-groupstatus">모집 중</div>
              </div>
              <div class="studylist-div-grouptitle">
                웹 보안의 기초부터 간단한 토이 프로젝트까지
              </div>
              <div class="studylist-div-groupinfowrapper">
                <div class="studylist-div-groupcategory">보안</div>
                <div class="studylist-div-groupmember">7/7</div>
              </div>
              <div class="studylist-div-groupmakerwrapper">
                <div class="studylist-div-groupmaker">김철수</div>
                <div class="studylist-div-likewrapper">     
                  <img
                    src="${pageContext.request.contextPath}/asset/img/study/like.png"
                    alt="찜"
                    class="studylist-img-like"
                    onclick="likeStudy(this)"
                  />
                  <div class="studylist-div-likecount">7</div>
                </div>
              </div>
            </div>
          </div>
        </div> -->

        <div class="studylist-div-btnwrapper">
          <button class="studylist-btn-write" onclick="registerStudy()">
            등록
          </button>
        </div>
      </div>

      <!-- 페이지네이션 -->
      <div class="studylist-div-paginationwrapper">
        <ul id="STUDYLIST-UL-PAGINATION">
          <li class="studylist-li-paginationlist pre">&lt;</li>
          <li class="studylist-li-paginationlist currentpage">1</li>
          <li class="studylist-li-paginationlist">2</li>
          <li class="studylist-li-paginationlist">3</li>
          <li class="studylist-li-paginationlist">4</li>
          <li class="studylist-li-paginationlist">5</li>
          <li class="studylist-li-paginationlist next">&#62;</li>
        </ul>
      </div>
    </main>
    <footer class="main-footer-container">
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
            src="${pageContext.request.contextPath}/asset/img/main/logo.png"
            alt="Forest of Knowledge Logo"
            class="main-img-footerlogo"
          />
        </div>
      </div>
    </footer>
  </body>
  <script defer src="${pageContext.request.contextPath}/asset/js/study/studylist.js"></script>
</html>
