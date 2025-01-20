<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲 - 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-userlist.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-userlist.js"></script>
</head>
<body>
  <div id="ADMIN-DIV-LAYOUTCONTAINER">
    <!-- 사이드 메뉴 -->
    <jsp:include page = "/html/admin/sidemenu.jsp" />
    <!-- 사이드 메뉴 끝 -->

    <!-- 상단 헤더 + 헤더 아래 컨텐츠 요소들 -->
    <div id="ADMIN-DIV-CONTENTWRAP">
      <!-- 상단 헤더 -->
	  <jsp:include page = "/html/admin/header.jsp" />
      <!-- 상단 헤더 끝 -->

      <!-- 메인 컨텐츠가 들어갈 컨테이너 -->
      <main class="admin-div-container">
        <div class="admin-div-contentcontainer adminMain-div-mainwrap">

          <!-- 현재 페이지 제목 -->
          <h1 class="admin-h1-maintitle">유저 관리</h1>

          <!-- 검색창 -->
          <form action="" method="">
            <div class="admin-div-wrapper">
              <input type="text" class="admin-input-search"
                placeholder="유저ID 또는 닉네임을 입력해주세요." value=""/>
              <img src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
                alt="search" class="admin-img-search"/>
            </div>
          </form>

          <!-- 유저 테이블 -->
          <div class="admin-div-listwrap">
            <!-- 테이블 컬럼명 -->
            <ul class="admin-ul-titlewrap">
              <li class="adminUser-li-userid">유저ID</li>
              <li class="adminUser-li-usernickname">닉네임</li>
              <li class="adminUser-li-userphone">전화번호</li>
              <li class="adminUser-li-userbirth">생년월일</li>
              <li class="adminUser-li-userquit">강제탈퇴</li>
            </ul>

            <!-- 데이터 넣는 부분 - 임시데이터 (1) -->
            <ul class="admin-ul-datawrap">
              <li class="adminUser-li-userid">
                <!-- 관리자 - 유저 상세페이지로 이동 -->
                <a href="./admin-userdetail.html">
                sdklfnewirfni97231
                </a>
              </li>
              <li class="adminUser-li-usernickname lightdata">풀잎나무</li>
              <li class="adminUser-li-userphone lightdata">010-1234-1234</li>
              <li class="adminUser-li-userbirth lightdata">1999.01.01</li>
              <li class="adminUser-li-userquit lightdata">
                <button class="admin-btn-delete" onclick="quitBtn(this)">탈퇴</button>
              </li>
            </ul>

            <!-- 임시데이터 (2) -->
            <ul class="admin-ul-datawrap">
              <li class="adminUser-li-userid">
                <!-- 관리자 화면의 유저 상세페이지로 이동 -->
                <a href="./admin-userdetail.html">
                sdklfnewirfni97231
                </a>
              </li>
              <li class="adminUser-li-usernickname lightdata">풀잎나무</li>
              <li class="adminUser-li-userphone lightdata">010-1234-1234</li>
              <li class="adminUser-li-userbirth lightdata">1999.01.01</li>
              <li class="adminUser-li-userquit lightdata">
                <button class="admin-btn-delete" onclick="quitBtn(this)">탈퇴</button>
              </li>
            </ul>

          </div>
          <!-- 유저 테이블 끝 -->
          
          <!-- 페이지네이션 -->
          <div class="admin-div-paginationwrapper">
            <ul id="admin-UL-PAGINATION">
              <li class="admin-li-paginationlist pre">&lt;</li>
              <li class="admin-li-paginationlist currentpage">1</li>
              <li class="admin-li-paginationlist">2</li>
              <li class="admin-li-paginationlist">3</li>
              <li class="admin-li-paginationlist">4</li>
              <li class="admin-li-paginationlist">5</li>
              <li class="admin-li-paginationlist next">&#62;</li>
            </ul>
          </div>

        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>