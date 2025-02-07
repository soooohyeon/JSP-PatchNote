<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지식의 숲 - 관리자</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/admin/admin-bannerlist.css">
<script defer
	src="${pageContext.request.contextPath}/asset/js/admin/admin-bannerlist.js"></script>
</head>
<body>
	<div id="ADMIN-DIV-LAYOUTCONTAINER">
		<!-- 사이드 메뉴 -->
		<jsp:include page="/html/admin/sidemenu.jsp" />
		<!-- 사이드 메뉴 끝 -->

		<!-- 상단 헤더 + 헤더 아래 컨텐츠 요소들 -->
		<div id="ADMIN-DIV-CONTENTWRAP">
			<!-- 상단 헤더 -->
			<jsp:include page="/html/admin/header.jsp" />
			<!-- 상단 헤더 끝 -->

			<!-- 메인 컨텐츠가 들어갈 컨테이너 -->
			<main class="admin-div-container">
				<div class="admin-div-contentcontainer adminMain-div-mainwrap">

					<!-- 현재 페이지 제목 -->
					<h1 class="admin-h1-maintitle">배너 관리</h1>

					<!-- 검색창 -->
					<form action="${pageContext.request.contextPath}/admin/admin-bannerlist.ad" method="get">
						<div class="admin-div-wrapper">
							<input type="text" name="keyword" class="admin-input-search"
								placeholder="배너명을 입력해주세요." value="<c:out value='${param.keyword}'/>" /> <img
								src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
								alt="search" class="admin-img-search" />
						</div>
					</form>

					<!-- 자유게시판 글 테이블 -->
					<div class="admin-div-listwrap">
						<!-- 테이블 컬럼명 -->
						<ul class="admin-ul-titlewrap">
							<li class="adminBanner-li-bannerid">글번호</li>
							<li class="adminBanner-li-bannertitle">배너명</li>
							<li class="adminBanner-li-bannerwritedate">작성일</li>
							<li class="adminBanner-li-bannerbtncontainer"></li>
						</ul>

						<c:choose>
							<c:when test="${not empty bannerList}">
								<c:forEach var="banner" items="${bannerList}">
									<!-- 데이터 넣는 부분 - 임시데이터 -->
									<ul class="admin-ul-datawrap">
										<li class="adminBanner-li-bannerid lightdata">
											<c:out value="${banner.bannerNum}" />
										</li>
										<li class="adminBanner-li-bannertitle">
											<a href="${pageContext.request.contextPath}/admin/admin-bannerdetail.ad?bannerNum=${banner.bannerNum}">
												<c:out value="${banner.bannerName}" />
											</a>
										</li>
										<li class="adminBanner-li-bannerwritedate lightdata"><c:out value="${fn:substring(banner.bannerUploadDate, 0, 10)}" /></li>
										<li class="adminBanner-li-bannerbtncontainer">
											<img src="${pageContext.request.contextPath}/asset/img/admin/menu-btn.png" class="adminBanner-img-menubtn" alt="메뉴 버튼">
											<div class="adminBanner-div-buttonswrap">
												<a href="" onclick="clickUpdateBtn(event, ${banner.bannerNum})" class="adminBanner-a-button">수정</a>
												<a href="" onclick="clickDeleteBtn(event, ${banner.bannerNum})" class="adminBanner-a-button">삭제</a>
											</div>
										</li>
									</ul>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="data-none">현재 등록된 공지가 없습니다.</div>
							</c:otherwise>
						</c:choose>

					</div>
					<!-- 배너 글 테이블 끝 -->

					<!-- 작성 버튼 -->
					<div id="ADMIN-DIV-BTNWRAP">
						<button class="admin-btn-write"
							onclick="location.href='${pageContext.request.contextPath}/admin/admin-bannerwrite.ad'">등록</button>
					</div>


					<!-- 페이지네이션 -->
					<div class="admin-div-paginationwrapper">
						<ul id="admin-UL-PAGINATION">
							<c:if test="${prev}">
								<li class="admin-li-paginationlist pre"
									onclick="movePage(${startPage - 1}, '${param.keyword}')">&lt;</li>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${!(i == page)}">
										<li class="admin-li-paginationlist"
											onclick="movePage(${i}, '${param.keyword}')"><c:out
												value="${i}" /></li>
									</c:when>
									<c:otherwise>
										<li class="admin-li-paginationlist currentpage"
											onclick="movePage(${i}, '${param.keyword}')"><c:out
												value="${i}" /></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${next}">
								<li class="admin-li-paginationlist next"
									onclick="movePage(${endPage + 1}, '${param.keyword}')">&#62;</li>
							</c:if>
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