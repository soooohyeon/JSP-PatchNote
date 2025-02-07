<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>작성한 자유게시글</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/mypage/mypage-writtenboard.css" />

<script defer
	src="${pageContext.request.contextPath}/asset/js/mypage/mypage-writtenboard.js"></script>
</head>
<body>
	<div class="main-container">
		<!-- 사이드 메뉴 -->
		<aside id="MYPAGE-MENUCONTAINER">
			<nav class="mypage-div-menuwrap">
				<h1 id="MYPAGE-H2-TITLE">마이 페이지</h1>
				<ul class="mypage-ul-menuwrap">
					<li><a
						href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my">개인정보
							수정</a></li>
					<%--
            <li>
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my"
                >찜한 목록</a
              >
            </li>
            --%>
					<li><a
						href="${pageContext.request.contextPath}/mypage/mypage-hostboard.my">만든
							스터디</a></li>
					<li><a
						href="${pageContext.request.contextPath}/mypage/mypage-applylist.my">신청한
							스터디</a></li>
					<li class="mypage-li-menuactive"><a
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
				<li><a
					href="${pageContext.request.contextPath}/knowledgeForest.main">홈</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath}/login/logout.me">로그아웃</a>
				</li>
			</ul>
		</div>

		<!-- 메인 컨텐츠가 들어갈 컨테이너 -->
		<div id="MYPAGE-DIV-LAYOUTCONTAINER">
			<main class="mypage-div-container">
				<!-- 현재 페이지 제목 -->
				<div class="mypage-h1-maintitle">
					<h1>작성한 자유게시글</h1>
				</div>
				<!-- 게시판 컨텐츠 정렬을 위한 div -->
				<div class="mypage-div-contentscontainer">
					<!-- 자유게시판 -->
					<div class="board-div-list">
						<ul class="board-list">
							<li class="board-header"><span class="board-number">번호</span>
								<span class="board-title">제목</span> <span class="board-author">작성자</span>
								<span class="board-date">작성일</span></li>

							<c:forEach var="board" items="${boardList}">
								<a
									href="${pageContext.request.contextPath}/board/boarddetail.bo?boardNum=${board.boardNum}">
								</a>
								<li class="board-item" style="cursor: pointer"
									onclick="goPage(${board.boardNum})"><span
									class="board-number">2</span> <span class="board-title">${board.boardTitle}</span>
									<span class="board-author">${board.userNick}</span> <span
									class="board-date">${board.boardUploadDate}</span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<!-- 페이지네이션 -->

				<div class="mypage-div-paginationwrapper">
					<ul id="mypage-UL-PAGINATION">
						<c:if test="${prev}">
							<li class="mypage-li-paginationlist pre"
								onclick="movePage(${startPage - 1})">&lt;</li>
						</c:if>

						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${!(i == page)}">
									<li class="mypage-li-paginationlist" onclick="movePage(${i})">
										<c:out value="${i}" />
									</li>
								</c:when>
								<c:otherwise>
									<li class="mypage-li-paginationlist currentpage"
										onclick="movePage(${i})"><c:out value="${i}" /></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${next}">
							<li class="mypage-li-paginationlist next"
								onclick="movePage(${endPage + 1})">&#62;</li>
						</c:if>
					</ul>
				</div>

			</main>
		</div>
	</div>
</body>
</html>
