<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지식의 숲</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/board/boardlist.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/footer.css">
<script defer
	src="${pageContext.request.contextPath}/asset/js/board/boardlist.js"></script>
</head>

<body>

	<!-- 상단 메뉴바  -->
	<jsp:include page="/html/main/header.jsp" />

	<h1 class="board-title ">자유게시판</h1>
	<!-- 검색창 -->
	<form class="boardlist-form-wrapper" action="${pageContext.request.contextPath}/board/boardlist.bo" method="get">
		<input type="text" class="boardlist-input-search" name="keyword" value="<c:out value='${param.keyword}'/>"
			placeholder="검색어를 입력하세요." />
		<button class="boardlist-btn-search">
			<img src="${pageContext.request.contextPath}/asset/img/study/search-btn.png" alt="search"
				class="boardlist-img-search" />
		</button>
	</form>
	
	<div class="boardlist-div-list">
		<ul class="boardlist-ul-list">
			<li class="boardlist-li-header">
				<span class="board-number">번호</span>
				<span class="board-title">제목</span>
				<span class="board-author">작성자</span>
				<span class="board-date">작성일</span>
			</li>
		<c:forEach var="board" items="${boardList}">
			<!-- 메인내용 내용들 -->
			<li class="boardlist-li-item" onclick="movetodetailedpage(${board.boardNum})">
				<span class="board-number">
					<c:out value="${board.boardNum}" />
				</span>
				<span class="board-title">
					<c:out value="${board.boardTitle}" />
				</span>
				<span class="board-author">
					<c:out value="${board.userNick}" />
				</span>
				<span class="board-date">
					<c:out value="${board.boardUploadDate}" />
				</span>
			</li>
		</c:forEach>
		</ul>
	</div>

	<!-- 글쓰기 버튼 -->
	<div class="borderlist-div-writewrap">
		<c:choose>
			<c:when test="${not empty sessionScope.userNumber}">
				<button class="boardlist-btn-write" onclick="goWrite()">글쓰기</button>
			</c:when>
			<c:otherwise>
				<button class="boardlist-btn-write" onclick="notLogin()">글쓰기</button>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- 페이지네이션 -->
	 <div class="boardlist-div-paginationwrapper">
		<ul id="BOARDLIST-UL-PAGINATION">
			<c:if test="${prev}">
				<li class="boardlist-li-paginationlist pre" onclick="movePage(${startPage -1}, '${param.keyword}')">$lt;</li>
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:choose>
					<c:when test="${!(i == page)}">
						<li class="boardlist-li-paginationlist" onclick="movePage(${i}, '${param.keyword}')">
							<c:out value="${i}"/>
						</li>
					</c:when>
					<c:otherwise>
						<li class="boardlist-li-paginationlist currentpage" onclick="movePage(${i}, '${param.keyword}')">
							<c:out value="${i}"/>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${next}">
				<li class="boardlist-li-paginationlist next" onclick="movePage(${endPage + 1}, '${param.keyword}')">&#62;</li>
			</c:if>
		</ul>
	</div> 

	<!-- footer -->
	<jsp:include page="/html/main/footer.jsp" />


</body>

</html>