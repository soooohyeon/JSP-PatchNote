<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/notice/noticedetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/notice/noticedetail.js"></script>
</head>

<body>
<!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />

  <div class="noticedetail-div-h2">
    <h1>공지사항</h1>
  </div>
  <!-- 본문내용 닉네임 작성일 내용 -->
  <main>
    <div class="noticedetail-div-header">
      <div class="noticedetail-div-layer">
        <div class="title-rightline">
          <div>제목</div>
        </div>
        <div class="noticedetail-div-contents"><c:out value="${noticedetail.noticeTitle}" /></div>
      </div>
      <div class="noticedetail-div-layer">
        <div class="title-rightline">
          <div>닉네임</div>
        </div>
        <div class="noticedetail-div-contents">관리자</div>
      </div>
      <div class="noticedetail-div-layer">
        <div class="title-rightline">
          <div>등록일</div>
        </div>
        <div class="noticedetail-div-contents"><c:out value="${noticedetail.noticeEditDate}" /></div>
      </div>
      <div class="noticedetail-div-layers">
        <div class="noticedetail-div-infowrapper">

          <div class="title-rightlines">
            본문
          </div>
          <div class="noticedetail-div-contentslong">
            <c:out value="${noticedetail.noticeContents}" />
            <%-- <div class="notice-div-imgwrapper">
              <img class="notice-img" src="${pageContext.request.contextPath}/asset/img/main/banner01.png" alt="이미지" />
            </div> --%>
          </div>
        </div>

      </div>
    </div>
  </main>
  <div class="noticedetail-btn-change">
    <button class="noticedetail-btn-inventory" onclick="backList()">목록</button>

  </div>
  </div>
<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp"/>
 
</body>

</html>