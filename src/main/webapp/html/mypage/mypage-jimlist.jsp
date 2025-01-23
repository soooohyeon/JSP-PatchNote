<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>찜한 목록</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/mypage/mypage-jimlist.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/mypage/mypage-jimlist.js"></script>
</head>
<body>
	<!-- <header></header> -->

	<!-- 사이드 메뉴 -->
	<aside id="MYPAGE-MENUCONTAINER">
		<nav class="mypage-div-menuwrap">
			<h1 id="MYPAGE-H2-TITLE">마이 페이지</h1>
			<ul class="mypage-ul-menuwrap">
				<li class="mypage-li-menuactive"><a
					href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my">개인정보
						수정</a></li>
				<li><a
					href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my">찜한
						목록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/mypage/mypage-hostboard.my">만든
						스터디</a></li>
				<li><a
					href="${pageContext.request.contextPath}/mypage/mypage-applylist.my">신청한
						스터디</a></li>
				<li><a
					href="${pageContext.request.contextPath}/mypage/mypage-writtenboard.my">작성한
						자유게시글</a></li>
				<li><a
					href="${pageContext.request.contextPath}/mypage/mypage-deleteaccount.my">회원
						탈퇴</a></li>
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

			<!-- 현재 페이지 제목 -->
			<div class="mypage-h1-maintitle">
				<h1>찜한 목록</h1>
			</div>
			<!-- 게시판 컨텐츠 정렬을 위한 div -->
			<div class="mypage-div-contentscontainer">
				<div class="mypage-div-contentswrap">

					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
							</div>
							<div class="mypage-div-grouptitle">
								<a href="/webapp/html/study/studylist-detail.html"> 웹 보안의
									기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/like.png"
										alt="찜" class="mypage-img-like"
										style="width: 30px; height: 30px; display: inline-block;"
										onclick="toggleLike(this, true)" /> <img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px; display: none;"
										onclick="toggleLike(this, false)" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- 페이지네이션 -->
				<div class="mypage-div-paginationwrapper">
					<ul id="mypage-UL-PAGINATION">
						<li class="mypage-li-paginationlist pre">&lt;</li>
						<li class="mypage-li-paginationlist currentpage">1</li>
						<li class="mypage-li-paginationlist">2</li>
						<li class="mypage-li-paginationlist">3</li>
						<li class="mypage-li-paginationlist">4</li>
						<li class="mypage-li-paginationlist">5</li>
						<li class="mypage-li-paginationlist next">&#62;</li>
					</ul>
				</div>
			</div>
			<!-- 게시판 컨텐츠 정렬을 위한 div 끝 -->

		</main>
		<!-- 메인 컨텐츠 끝 -->
	</div>
	<!-- </div> -->
</body>
</html>
