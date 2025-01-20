<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/notice/noticelist.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/notice/noticelist.js"></script>
</head>

<body>
<!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />

  <h1>공지사항</h1>
  <div class="noticelist-div-list">
    <ul class="noticelist-ul-list">
      <li class="noticelist-li-header">
        <span class="notice-title">제목</span>
        <span class="notice-author">작성자</span>
        <span class="notice-date">작성일자</span>
      </li>

      <li class="noticelist-li-item" onclick="noticedetailpage()">
        <span class="notice-title">[공지] 게시글 작성 방법</span>
        <span class="notice-author">관리자</span>
        <span class="notice-date">2025.01.01</span>
      </li>
      <li class="noticelist-li-item">
        <span class="notice-title">[공지] 서버 점검 안내</span>
        <span class="notice-author">관리자</span>
        <span class="notice-date">2025.01.02</span>
      </li>
      <li class="noticelist-li-item">
        <span class="notice-title">[공지] 개인정보 처리방침 개정 안내</span>
        <span class="notice-author">관리자</span>
        <span class="notice-date">2025.01.03</span>
      </li>
    </ul>
    <!-- 페이지네이션 -->
    <div class="noticelist-div-paginationwrapper">
      <ul id="NOTICELIST-UL-PAGINATION">
        <li class="noticelist-li-paginationlist pre">&lt;</li>
        <li class="noticelist-li-paginationlist currentpage">1</li>
        <li class="noticelist-li-paginationlist">2</li>
        <li class="noticelist-li-paginationlist">3</li>
        <li class="noticelist-li-paginationlist">4</li>
        <li class="noticelist-li-paginationlist">5</li>
        <li class="noticelist-li-paginationlist next">&#62;</li>
      </ul>
    </div>
  </div>
  <!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp"/>
 
</body>

</html>