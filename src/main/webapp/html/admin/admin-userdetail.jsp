<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲 - 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-userdetail.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-userdetail.js"></script>
</head>
<body>
  <div id="ADMIN-DIV-LAYOUTCONTAINER">
		<!-- 사이드 메뉴 -->
		<jsp:include page="/html/admin/sidemenu.jsp" />
		<!-- 사이드 메뉴 끝 -->

		<!-- 상단 헤더 + 헤더 아래 컨텐츠 요소들 -->
		<div id="ADMIN-DIV-CONTENTWRAP">
			<!-- 상단 헤더 -->
			<jsp:include page="/html/admin/header.jsp" />
			<!-- 상단 헤더 끝 -->


      <!-- 메인 컨텐츠가 들어갈 컨테이너 -->
      <main class="admin-div-container">
        <div class="admin-div-contentcontainer adminMain-div-mainwrap">

          <!-- 현재 페이지 제목 -->
          <h1 class="admin-h1-userdetailtitle">
            <span class="adminUserDetail-span-backbtn">&lt;</span>유저 관리
          </h1>

          <!-- 유저 테이블 -->
          <div class="admin-div-listwrap">
            <div class="admin-div-tablename">유저정보</div>
            <!-- 테이블 컬럼명 -->
            <ul class="admin-ul-titlewrap">
              <li class="adminUserDetail-li-username">이름</li>
              <li class="adminUserDetail-li-userid">아이디</li>
              <li class="adminUserDetail-li-usernickname">닉네임</li>
              <li class="adminUserDetail-li-userbirth">생년월일</li>
              <li class="adminUserDetail-li-userphone">전화번호</li>
              <li class="adminUserDetail-li-joindate">가입</li>
            </ul>

            <!-- 유저 정보가 들어가는 부분 -->
            <ul class="admin-ul-datawrap">
              <li class="adminUserDetail-li-username">${user.userName}</li>
              <li class="adminUserDetail-li-userid">${user.userId}</li>
              <li class="adminUserDetail-li-usernickname">${user.userNick}</li>
              <li class="adminUserDetail-li-userbirth">${user.userBirth}</li>
              <li class="adminUserDetail-li-userphone">${user.userPH}</li>
              <li class="adminUserDetail-li-joindate">${user.userJoinDate}</li>
              </li>
            </ul>
            
            <!-- 사용자가 작성한 글, 댓글 개수 -->
            <div class="adminUserDetail-div-countscontainer">
              <!-- 제목 -->
              <div class="admin-div-tablename">활동내역</div>

              <!-- 스터디 글, 신청, 댓글 개수 - 제목 -->
              <ul class="adminUserDetail-div-titlewrap">
                <li class="adminUserDetail-li-study">생성한 스터디</li>
                <li class="adminUserDetail-li-studyapply">신청한 스터디</li>
                <li class="adminUserDetail-li-studycomment">작성한 자유게시판 글</li>
              </ul>
              <!-- 스터디 글, 신청, 댓글 개수 - 데이터 -->
              <ul class="admin-ul-datawrap">
                <li class="adminUserDetail-li-study">
                  <span class="countText">${studyCount}</span>개
                </li>
                <li class="adminUserDetail-li-studyapply">
                  <span class="countText">${applyCount}</span>개
                </li>
                <li class="adminUserDetail-li-studycomment">
                  <span class="countText">${boardCount}</span>개
                </li>
              </ul>

              <%-- <ul class="adminUserDetail-div-titlewrap">
                <li class="adminUserDetail-li-study">생성한 스터디</li>
                <li class="adminUserDetail-li-studyapply">신청한 스터디</li>
                <li class="adminUserDetail-li-studycomment">작성한 스터디 댓글</li>
              </ul>
              <!-- 스터디 글, 신청, 댓글 개수 - 데이터 -->
              <ul class="admin-ul-datawrap">
                <li class="adminUserDetail-li-study">
                  <span class="countText">${studyCount}</span>개
                </li>
                <li class="adminUserDetail-li-studyapply">
                  <span class="countText">${applyCount}</span>개
                </li>
                <li class="adminUserDetail-li-studycomment">
                  <span class="countText">${studyCommentCount}</span>개
                </li>
              </ul>

              <!-- 자유게시판 글, 댓글 - 제목 -->
              <ul class="adminUserDetail-div-titlewrap">
                <li class="adminUserDetail-li-board">작성한 자유게시판 글</li>
                <li class="adminUserDetail-li-boardapply">작성한 자유게시판 댓글</li>
              </ul>
              <!-- 자유게시판 글, 댓글 - 데이터 -->
              <ul class="admin-ul-datawrap">
                <li class="adminUserDetail-li-board">
                  <span class="countText">${boardyCount}</span>개
                </li>
                <li class="adminUserDetail-li-boardapply">
                  <span class="countText">${boardCommentCount}</span>개
                </li>
              </ul> --%>

            </div>


            <div id="ADMINUSERDETAIL-DIV-DELETEWRAP">
              <button class="admin-btn-delete" onclick="quitBtn(${user.userNum})">탈퇴</button>
            </div>
          </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>