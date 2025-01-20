<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲 - 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-detail.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-bannerdetail.js"></script>
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
          <h1 class="admin-h1-detail">
            <span class="adminDetail-span-backbtn">&lt;</span>배너 상세
          </h1>

          <!-- 배너 데이터 출력하는 부분 -->
          <div class="adminDetail-div-contentsWrapper">
            <div id="adminBannerDetail-FORM">
              <!-- 한 행 -->
                <!-- label과 input을 묶은 div -->
                <div class="adminDetail-div-infowrapper">
                  <div class="label">제 목</div>
                  <div class="adminDetail-div-groupinfo">배너 1</div>
                </div>
    
                <div class="adminDetail-div-infowrapper">
                  <div class="label">닉네임</div>
                  <div class="adminDetail-div-groupinfo">관리자</div>
                </div>
                <div class="adminDetail-div-infowrapper">
                  <div class="label">등록일</div>
                  <div class="adminDetail-div-groupinfo">2025.01.14 01:41</div>
                </div>
                <div class="adminBannerDetail-div-bannerimgwrap">
                  <div class="label">파일</div>
                  <div class="adminDetail-div-bannerimg">
                    <img src="./../../asset/img/main/banner01.png" alt="배너1">
                  </div>
                </div>
                <div class="banner-div-imgname">
                  이미지1.jpg
                </div>
            </div>
          </div>


          <div id="ADMINDETAIL-DIV-BTNWRAP">
            <button class="admin-btn btn-update" onclick="clickUpdateBtn(this)">수정</button>
            <button class="admin-btn btn-delete" onclick="clickDeleteBtn(this)">삭제</button>
          </div>

        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>