<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲 - 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/adminMenuLayOut.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-studycommentlist.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-basic.js"></script>
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-studycommentlist.js"></script>
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
          <h1 class="admin-h1-maintitle">스터디 댓글 관리</h1>

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
              <li class="adminStudyComment-li-studycommentid">댓글 번호</li>
              <li class="adminStudyComment-li-studyid">스터디 글 번호</li>
              <li class="adminStudyComment-li-studycommentcontentwrap">내용</li>
              <li class="adminStudyComment-li-userid">아이디</li>
              <li class="adminStudyComment-li-usernickname">닉네임</li>
              <li class="adminStudyComment-li-studycommentwritedate">댓글 작성일</li>
              <li class="adminStudyComment-li-commentdelete"></li>
            </ul>

            <!-- 데이터 넣는 부분 - 임시데이터 (1) -->
            <ul class="admin-ul-datawrap">
              <li class="adminStudyComment-li-studycommentid lightdata">319</li>
              <li class="adminStudyComment-li-studyid lightdata">
                <!-- 사용자 화면의 스터디 상세페이지로 이동 -->
                <a href="./../study/studylist-detail.html">
                  342
                </a>
              </li>
              <li class="adminStudyComment-li-studycommentcontent commentcontent">
                <div class="commentContent">
                  안녕하세요 분위기는 대충 어땠고 공부는 이런걸 했다는~~ 이런 댓글안녕하세요 분위기는 대충 어땠고 공부는 이런걸 했다는~~ 이런 댓글
                </div>
                <div class="toggleBtn"><img src="${pageContext.request.contextPath}/asset/img/admin/all-btn.png" alt="토글버튼"></div>
              </li>
              <li class="adminStudyComment-li-userid lightdata">sdklfnewirfni97231</li>
              <li class="adminStudyComment-li-usernickname lightdata">풀잎나무</li>
              <li class="adminStudyComment-li-studycommentwritedate lightdata">2025.01.12</li>
              <li class="adminStudyComment-li-commentdelete">
                <input type="button" class="admin-btn-delete" onclick="clickDeleteBtn(event)" value="삭제">
              </li>
            </ul>
            <div class="commentWrap">
              안녕하세요 분위기는 대충 어땠고 공부는 이런걸 했다는~~ 이런 댓글안녕하세요 분위기는 대충 어땠고 공부는 이런걸 했다는~~ 이런 댓글
            </div>

            <!-- 데이터 넣는 부분 - 임시데이터 (2) -->
            <ul class="admin-ul-datawrap">
              <li class="adminStudyComment-li-studycommentid lightdata">319</li>
              <li class="adminStudyComment-li-studyid lightdata">
                <!-- 사용자 화면의 스터디 상세페이지로 이동 -->
                <a href="./../study/studylist-detail.html">
                  342
                </a>
              </li>
              <li class="adminStudyComment-li-studycommentcontent commentcontent">
                <div class="commentContent">
                  대충 댓글이다
                </div>
                <div class="toggleBtn"><img src="${pageContext.request.contextPath}/asset/img/admin/all-btn.png" alt="토글버튼"></div>
              </li>
              <li class="adminStudyComment-li-userid lightdata">sdklfnewirfni97231</li>
              <li class="adminStudyComment-li-usernickname lightdata">풀잎나무</li>
              <li class="adminStudyComment-li-studycommentwritedate lightdata">2025.01.12</li>
              <li class="adminStudyComment-li-commentdelete">
                <input type="button" class="admin-btn-delete" onclick="clickDeleteBtn(event)" value="삭제">
              </li>
            </ul>
            <div class="commentWrap">
              대충 댓글이다
            </div>

          </div>
          <!-- 스터디 글 테이블 끝 -->
          
          <!-- <!-- 페이지네이션 -->
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
          </div> -->

        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>