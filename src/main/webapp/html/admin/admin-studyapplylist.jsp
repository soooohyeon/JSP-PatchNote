<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲 - 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-studyapplylist.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-studyapplylist.js"></script>
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
          <h1 class="admin-h1-maintitle">스터디 신청 관리</h1>

          <!-- 검색창 -->
          <form action="" method="">
            <div class="admin-div-wrapper">
              <input type="text" class="admin-input-search"
                placeholder="검색어를 입력해주세요." value=""/>
              <img src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
                alt="search" class="admin-img-search"/>
            </div>
          </form>

          <!-- 스터디 글 테이블 -->
          <div class="admin-div-listwrap">
            <!-- 테이블 컬럼명 -->
            <ul class="admin-ul-titlewrap">
              <li class="adminStudyApply-li-applyid">스터디 신청번호</li>
              <li class="adminStudyApply-li-studyid">스터디 번호</li>
              <li class="adminStudyApply-li-studymemberwrap">확정인원/모집인원</li>
              <li class="adminStudyApply-li-studystatus">진행 상태</li>
              <li class="adminStudyApply-li-applystatus">신청수락여부</li>
              <li class="adminStudyApply-li-userid">신청자ID</li>
              <li class="adminStudyApply-li-usernickname">신청자 닉네임</li>
              <li class="adminStudyApply-li-studydelete"></li>
            </ul>

            <!-- 데이터 넣는 부분 - 임시데이터 (1) -->
            <ul class="admin-ul-datawrap">
              <li class="adminStudyApply-li-applyid lightdata">
                <!-- 관리자 화면의 스터디 신청 상세페이지로 이동 -->
                <a href="./admin-studyapplydetail.html">
                  319
                </a>
              </li>
              <li class="adminStudyApply-li-studyid lightdata">
                <!-- 사용자 화면의 스터디 상세페이지로 이동 -->
                <a href="./../study/studylist-detail.html">
                  342
                </a>
              </li>
              <li class="adminStudyApply-li-studymemberwrap">(3 / 7)</li>
              <!-- 스터디 진행 상태(1) - 모집인원 = 제한인원 or 현재 날짜 > 마감날짜 일때 마감 출력 -->
              <li class="adminStudyApply-li-studystatus">마감</li>
              <!-- 스터디 진행 상태(2) - 그 외 -->
              <!-- <li class="adminStudyApply-li-studystatus">모집 중</li> -->
              <li class="adminStudyApply-li-applystatus">수락</li>
              <li class="adminStudyApply-li-userid lightdata">sdklfnewirfni97231</li>
              <li class="adminStudyApply-li-usernickname lightdata">풀잎나무</li>
              <li class="adminStudyApply-li-studydelete">
                <!-- 신청 수락 여부가 대기 중 일 때만 보이게 -->
                <input type="button" class="admin-btn-delete" onclick="clickDeleteBtn(event)" value="신청취소">
              </li>
            </ul>

          </div>
          <!-- 스터디 글 테이블 끝 -->
          
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