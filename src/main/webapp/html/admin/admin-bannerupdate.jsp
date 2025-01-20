<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲 - 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-write.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-bannerwrite.js"></script>
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
          <h1 class="admin-h1-detailtitle">배너 수정</h1>
          
          <!--  폼 시작 -->
          <form action="" method="">
            <!-- 배너 데이터 입력하는 부분 -->
            <div class="adminWrite-div-formwrapper">

              <!-- 배너 제목 -->
              <div class="adminWrite-div-datawrap">
                <div class="adminWrite-div-title">
                  <div class="titlewrap">제목</div>
                </div>
                <div class="adminWrite-div-content">
                  <div class="inputwrap">
                    <input type="text" name="bannerName" id="bannerName" class="inputStyle" placeholder="배너 제목을 입력하세요.">
                  </div>
                </div>
              </div>
              <!-- 배너 이미지 -->
              <div class="adminWrite-div-datawrap">
                <div class="adminWrite-div-title">
                  <div class="titlewrap">배너 사진</div>
                </div>
                <div class="adminWrite-div-content">
                  <div class="inputwrap bannerimgwrap">
                    <img src="${pageContext.request.contextPath}/asset/img/main/banner01.png" alt="임시 배너">
                  </div>
                </div>
              </div>
              <div class="inputwrap bannerimgbtnwrap">
                <span id="BANNERIMAGE-NAME">banner01.png</span>
                <label for="bannerImg" class="admin-btn">파일 첨부</label>
                <input type="file" name="bannerImage" id="bannerImg" accept="image/*" onchange="setThumbnail(event); ">
              </div>
              
            </div>

            <!-- 저장, 취소 버튼 부분 -->
            <div id="ADMINWRITE-DIV-BTNWRAP">
              <button type="button" class="admin-btn btn-save" onclick="clickUpdateBtn(this)">저장</button>
              <button type="button" class="admin-btn btn-cancel" onclick="clickCancelBtn()">취소</button>
            </div>

          </form>

        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>