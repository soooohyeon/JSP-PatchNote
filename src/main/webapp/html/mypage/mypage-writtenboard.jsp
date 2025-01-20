<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>작성한 자유게시글</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/mypage/mypage-writtenboard.css">
</head>
<body>
	<div class="main-container">
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
				<li><a href="${pageContext.request.contextPath}/main/main.jsp">홈</a></li>
				<li><a href="">로그아웃</a></li>
			</ul>
		</div>

		<!-- 메인 컨텐츠가 들어갈 컨테이너 -->
		<div id="MYPAGE-DIV-LAYOUTCONTAINER">
			<main class="mypage-div-container">
				<!-- 현재 페이지 제목 -->
				<div class="mypage-h1-maintitle">
					<h1>작성한 자유게시글</h1>
					<br />
					<p>''님이 작성한 자유게시글 목록 입니다</p>
				</div>
				<!-- 게시판 컨텐츠 정렬을 위한 div -->
				<div class="mypage-div-contentscontainer">
					<!-- 자유게시판 -->
					<div class="mypage-div-freeboard"></div>
					<div class="board-div-list">
						<ul class="board-list">
							<li class="board-header"><span class="board-number">번호</span>
								<span class="board-title">제목</span> <span class="board-author">작성자</span>
								<span class="board-date">작성일</span></li>
							<li class="board-item"><span class="board-number">1</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 1</a></span> <span
								class="board-author">작성자1</span> <span class="board-date">2025-01-11</span>
							</li>
							<li class="board-item"><span class="board-number">2</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 2</a></span> <span
								class="board-author">작성자2</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">3</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 3</a></span> <span
								class="board-author">작성자3</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">4</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 4</a></span> <span
								class="board-author">작성자4</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">5</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 5</a></span> <span
								class="board-author">작성자5</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">6</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 6</a></span> <span
								class="board-author">작성자6</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">7</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 7</a></span> <span
								class="board-author">작성자7</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">8</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 8</a></span> <span
								class="board-author">작성자8</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">9</span> <span
								class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 9</a></span> <span
								class="board-author">작성자9</span> <span class="board-date">2025-01-10</span>
							</li>
							<li class="board-item"><span class="board-number">10</span>
								<span class="board-title"><a
									href="./../board/boardlistdetail.html">게시판 제목 10</a></span> <span
								class="board-author">작성자10</span> <span class="board-date">2025-01-10</span>
							</li>
						</ul>
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

			</main>
		</div>
	</div>
</body>
</html>