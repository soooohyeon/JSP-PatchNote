<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>신청한 스터디</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/mypage/mypage-applylist.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/mypage/mypage-applylist.js"></script>
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
			class="admin-img-logo" alt="Logo">
		<ul id="ADMIN-UL-HEADERWRAP">
			<li><a href="${pageContext.request.contextPath}/main/main.html">홈</a></li>
			<li><a href="">로그아웃</a></li>
		</ul>
	</div>

	<!-- 메인 컨텐츠가 들어갈 컨테이너 -->
	<div id="MYPAGE-DIV-LAYOUTCONTAINER">
		<main class="mypage-div-container">
			<!-- 현재 페이지 제목 -->
			<div class="mypage-h1-maintitle">
				<h1>신청한 스터디</h1>
				<br />
				<p>''님이 신청하신 스터디 목록 입니다</p>
			</div>
			<!-- 게시판 컨텐츠 정렬을 위한 div -->
			<div class="mypage-div-contentscontainer">
				<div class="mypage-div-contentswrap">
					<c:forEach var="study" items="${studyList}">

						<!-- 모임 항목 컨텐츠 1 -->
						<div class="mypage-div-group">
							<div class="mypage-div-groupinner">
								<div class="mypage-div-groupinfowrapper datecontent-wrap">
									<div class="mypage-div-enddate">${studyList.studyApplyDate} &nbsp;| &nbsp;
										2025.01.05</div>
									<div class="mypage-div-groupstatus">모집 중</div>
								</div>
								<div class="mypage-div-grouptitle">
									<a href="/webapp/html/study/studylist-detail.html">${studyList.studyTitle}</a>
								</div>
								<div class="mypage-div-groupinfowrapper">
									<div class="mypage-div-groupcategory">${studyList.category}</div>
									<button class="mypage-btn-cancel" onclick="cancelAction()">취소</button>
								</div>
								<div class="mypage-div-groupmakerwrapper">
									<div class="mypage-div-groupmaker">${studyList.studyTitle}</div>
									<div class="mypage-div-likewrapper">
										<div class="mypage-div-progress">승인</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
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
