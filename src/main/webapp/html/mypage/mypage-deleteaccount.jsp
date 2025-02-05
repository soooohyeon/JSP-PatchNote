<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>찜한 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/mypage/mypage-deleteaccount.css" />
    <script defer src="${pageContext.request.contextPath}/asset/js/mypage/mypage-deleteaccount.js"></script>
    <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
  </head>
  <body>
    <!-- <header></header> -->

    <!-- 사이드 메뉴 -->
    <aside id="MYPAGE-MENUCONTAINER">
      <nav class="mypage-div-menuwrap">
        <h1 id="MYPAGE-H2-TITLE">마이 페이지</h1>
        <ul class="mypage-ul-menuwrap">
          <li><a href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my">개인정보 수정</a></li>
<%--           <li><a href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my">찜한 목록</a></li>--%>
           <li><a href="${pageContext.request.contextPath}/mypage/mypage-hostboard.my">만든 스터디</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/mypage-applylist.my">신청한 스터디</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/mypage-writtenboard.my">작성한 자유게시글</a></li>
          <li class="mypage-li-menuactive"><a href="${pageContext.request.contextPath}/mypage/mypage-deleteaccount.my">회원 탈퇴</a></li>
        </ul>
      </nav>
    </aside>
    <!-- 사이드 메뉴 끝 -->

    <!-- 상단 헤더 -->
   <div id="ADMIN-DIV-HEADERCONTAINER">
         <img src="${pageContext.request.contextPath}/asset/img/main/logo.png"
            class="admin-img-logo" alt="Logo" />
         <ul id="ADMIN-UL-HEADERWRAP">
            <li><a href="${pageContext.request.contextPath}/knowledgeForest.main">홈</a>
            </li>
            <li><a href="${pageContext.request.contextPath}/login/logout.me">로그아웃</a>
            </li>
         </ul>
      </div>
     
    <!-- 메인 컨텐츠가 들어갈 컨테이너 -->
    <div id="MYPAGE-DIV-LAYOUTCONTAINER">
      <main class="mypage-div-container">
        <div class="mypage-div-configure">
          <div class="mypage-div-delAccountTitle">
            <h2>계정 삭제</h2>
          </div>
          <p><b>지식의 숲 계정을 삭제하시겠습니까?</b><br><br>
            [이메일 주소]계정을 삭제하면
            여태까지 작성한 모든 글과 댓글은 사라지게 됩니다.<br>
            이 작업은 실행 취소할 수 없습니다.<br><br>
            <b>탈퇴를 진행하시길 원한다면 아래에 " 내 계정 삭제 "</b>를 입력하세요.</p>
            
            <input type="text" class="mypage-text-delComment" id="DELETEINPUT">
            <div class="mypage-btn-deleteandcancel">
              <button class="delete" id="DELETEBUTTON" disabled>탈퇴</button>
              <!-- <button class="cancel">취소</button> -->
            </div>
        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
    </div>
    <!-- </div> -->
  </body>
</html>
