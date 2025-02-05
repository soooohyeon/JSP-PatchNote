<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>지식의 숲</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/study/studylist.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/footer.css">
</head>
<body>
	
	<!-- 상단 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />

	<main>
		<!-- 페이지 타이틀 -->
		<h1 class="studylist-h1-title">STUDY</h1>

		<!-- 검색창 -->
		<form class="studylist-form-wrapper"
			action="${pageContext.request.contextPath}/study/studyList.st"
			method="get">
			<input type="text" name="keyword" class="studylist-input-search"
				placeholder="검색어를 입력하세요." />
			<button type="submit" class="studylist-btn-search">
				<img
					src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
					alt="search" class="studylist-img-search" />
			</button>
		</form>

		<!-- 전체 내용을 감싸는 래퍼-->
		<div class="studylist-div-contentsWrapper">
			<div class="studylist-div-categoryWrapper">
				<div class="studylist-div-category selected">전체</div>
				<div class="studylist-div-category">개발</div>
				<div class="studylist-div-category">보안</div>
			</div>

			<!-- 모임 항목들을 감싸는 래퍼-->
			<div class="studylist-div-groupWrapper">
				<!-- 모임 항목-->

				<c:forEach var="study" items="${studyList}">
					<div class="studylist-div-group">
						<div class="studylist-div-groupinner">
							<div class="studylist-div-groupinfowrapper datecontent-wrap">
								<div class="studylist-div-enddate">마감일 &nbsp;| &nbsp;
									${study.studyDeadline}</div>
								<div class="studylist-div-groupstatus">
									<!-- 마감, 모집 중 -->
									<c:choose>
										<c:when
											test="${study.participants == study.studyLimit or study.studyDeadline < today}">
											<li class="studylist-div-groupstatus">마감</li>
										</c:when>
										<c:otherwise>
											<li class="studylist-div-groupstatus">모집 중</li>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<c:choose>
								<c:when test="${not empty sessionScope.userNumber}">
								<div class="studylist-div-grouptitle"
									onclick="moveDetail(${study.studyNum})">
								<c:out value="${study.studyTitle}" />
								</c:when>
								<c:otherwise>
								<div class="studylist-div-grouptitle"
									onclick="goLogin()">
								<c:out value="${study.studyTitle}" />
								</c:otherwise>
							</c:choose>
							</div>
							<div class="studylist-div-groupinfowrapper">
								<div class="studylist-div-groupcategory">
									<c:choose>
										<c:when test="${study.studyCategory == 0}">
				            개발
				        </c:when>
										<c:when test="${study.studyCategory == 1}">
				            보안
				        </c:when>
										<c:otherwise>
				            알 수 없음
				        </c:otherwise>
									</c:choose>
								</div>
								<div class="studylist-div-groupmember">
									<c:out value="${study.participants}" />
									/
									<c:out value="${study.studyLimit}" />
								</div>
							</div>
							<div class="studylist-div-groupmakerwrapper">
								<div class="studylist-div-groupmaker">
									<c:out value="${study.userNick}" />
								</div>
								<div class="studylist-div-likewrapper">

									<img
										src="${pageContext.request.contextPath}/asset/img/study/like.png"
										alt="찜" class="studylist-img-like" onclick="likeStudy(this)" />
									<div class="studylist-div-likecount">
										<c:out value="${study.likeCount}" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>

			<div class="studylist-div-btnwrapper">
				<c:choose>
					<c:when test="${not empty sessionScope.userNumber}">
						<button class="studylist-btn-write" onclick="registerStudy()" />
					</c:when>
					<c:otherwise>
						<button class="studylist-btn-write" onclick="goLogin()" />
					</c:otherwise>
				</c:choose>
					등록
				</button>
			</div>
		</div>

		<!-- 페이지네이션 -->
		<div class="studylist-div-paginationwrapper">
			<ul id="STUDYLIST-UL-PAGINATION">
				<c:if test="${prev}">
					<li class="studylist-li-paginationlist pre" onclick="movePage(${startPage - 1}, '${param.keyword}')">&lt;</li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:choose>
						<c:when test="${!(i == page)}">
							<li class="studylist-li-paginationlist" onclick="movePage(${i}, '${param.keyword}')">
								<c:out value="${i}"/>
							</li>
						</c:when>
						<c:otherwise>
							<li class="studylist-li-paginationlist currentpage" onclick="movePage(${i}, '${param.keyword}')">
								<c:out value="${i}"/>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${next}">
					<li class="studylist-li-paginationlist next" onclick="movePage(${endPage + 1}, '${param.keyword}')">&#62;</li>
				</c:if>
			</ul>
		</div>
	</main>

	<jsp:include page="/html/main/footer.jsp" />

</body>
<script defer
	src="${pageContext.request.contextPath}/asset/js/study/studylist.js"></script>
</html>
