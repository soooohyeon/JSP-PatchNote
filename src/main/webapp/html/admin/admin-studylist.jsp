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
	href="${pageContext.request.contextPath}/asset/css/admin/admin-studylist.css">
<script defer
	src="${pageContext.request.contextPath}/asset/js/admin/admin-studylist.js"></script>
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
					<h1 class="admin-h1-maintitle">스터디 관리</h1>

					<!-- 검색창 -->
					<form
						action="${pageContext.request.contextPath}/admin/admin-studylist.ad"
						method="get">
						<div class="admin-div-wrapper">
							<input type="text" name="keyword" class="admin-input-search"
								placeholder="제목 또는 내용을 입력해주세요." value="<c:out value='${param.keyword}'/>" /> <img
								src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
								alt="search" class="admin-img-search" />
						</div>
					</form>

					<!-- 스터디 글 테이블 -->
					<div class="admin-div-listwrap">
						<!-- 테이블 컬럼명 -->
						<ul class="admin-ul-titlewrap">
							<li class="adminStudy-li-studyid">글번호</li>
							<li class="adminStudy-li-studytitle">제목</li>
							<li class="adminStudy-li-studymemberwrap">확정인원/모집인원</li>
							<li class="adminStudy-li-studystatus">스터디 상태</li>
							<li class="adminStudy-li-userid">아이디</li>
							<li class="adminStudy-li-usernickname">작성자</li>
							<li class="adminStudy-li-studywritedate">작성일</li>
							<li class="adminStudy-li-studydelete"></li>
						</ul>

						<c:choose>
							<c:when test="${not empty studyList}">
								<c:forEach var="study" items="${studyList}">
									<!-- 데이터 넣는 부분 - 임시데이터 (1) -->
									<ul class="admin-ul-datawrap">
										<li class="adminStudy-li-studyid lightdata">
											<c:out value="${study.studyNum}" />
										</li>
										<li class="adminStudy-li-studytitle">
											<!-- 사용자 화면의 스터디 상세페이지로 이동 -->
											<a href="${pageContext.request.contextPath}/study/studyDetailOk.st?studyNum=${study.studyNum}">
												<c:out value="${study.studyTitle}" />
											</a>
										</li>
										<li class="adminStudy-li-studymemberwrap">
											(<c:out value="${study.participants}" />/<c:out value="${study.studyLimit}" />)
										</li>
										<c:choose>
										    <c:when test="${study.participants == study.studyLimit or study.studyDeadline < today}">
										        <li class="adminStudy-li-studystatus lightdata">마감</li>
										    </c:when>
										    <c:otherwise>
										        <li class="adminStudy-li-studystatus">모집 중</li>
										    </c:otherwise>
										</c:choose>
										<li class="adminStudy-li-userid lightdata">
											<c:out value="${study.userId}" />
										</li>
										<li class="adminStudy-li-usernickname lightdata">
											<c:out value="${study.userNick}" />
										</li>
										<li class="adminStudy-li-studywritedate lightdata">
											<c:out value="${study.studyUploadDate}" />
										</li>
										<li class="adminStudy-li-studydelete"><input
											type="button" class="admin-btn-delete"
											onclick="clickDeleteBtn(${study.studyNum})" value="삭제">
										</li>
									</ul>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="data-none">현재 가입된 유저가 없습니다.</div>
							</c:otherwise>
						</c:choose>

					</div>
					<!-- 스터디 글 테이블 끝 -->

					<!-- 페이지네이션 -->
					<div class="admin-div-paginationwrapper">
						<ul id="admin-UL-PAGINATION">
							<c:if test="${prev}">
								<li class="admin-li-paginationlist pre" onclick="movePage(${startPage - 1}, '${param.keyword}')">&lt;</li>
							</c:if>
							
							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${!(i == page)}">
										<li class="admin-li-paginationlist" onclick="movePage(${i}, '${param.keyword}')">
											<c:out value="${i}"/>
										</li>
									</c:when>
									<c:otherwise>
										<li class="admin-li-paginationlist currentpage" onclick="movePage(${i}, '${param.keyword}')">
											<c:out value="${i}"/>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<c:if test="${next}">
								<li class="admin-li-paginationlist next" onclick="movePage(${endPage + 1}, '${param.keyword}')">&#62;</li>
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