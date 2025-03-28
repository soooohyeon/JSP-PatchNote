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
	href="${pageContext.request.contextPath}/asset/css/admin/adminMenuLayOut.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/admin/admin-studycommentlist.css">
<script defer
	src="${pageContext.request.contextPath}/asset/js/admin/admin-basic.js"></script>
<script defer
	src="${pageContext.request.contextPath}/asset/js/admin/admin-studycommentlist.js"></script>
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
					<h1 class="admin-h1-maintitle">스터디 댓글 관리</h1>

					<!-- 검색창 -->
					<form
						action="${pageContext.request.contextPath}/admin/admin-studycommentlist.ad"
						method="get">
						<div class="admin-div-wrapper">
							<input type="text" name="keyword" class="admin-input-search"
								placeholder="댓글 내용 또는 아이디, 닉네임을 입력해주세요."
								value="<c:out value='${param.keyword}'/>" /> <img
								src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
								alt="search" class="admin-img-search" />
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
							<li class="adminStudyComment-li-studycommentwritedate">댓글
								작성일</li>
							<li class="adminStudyComment-li-commentdelete"></li>
						</ul>

						<c:choose>
							<c:when test="${not empty studyReplyList}">
								<c:forEach var="studyReply" items="${studyReplyList}">

						<!-- 데이터 넣는 부분 - 임시데이터 -->
						<ul class="admin-ul-datawrap">
							<li class="adminStudyComment-li-studycommentid lightdata">
								<c:out value="${studyReply.studyCommentNum}" />
							</li>
							<li class="adminStudyComment-li-studyid lightdata">
								<!-- 사용자 화면의 스터디 상세페이지로 이동 -->
								<a href="${pageContext.request.contextPath}/study/studyDetailOk.st?studyNum=${studyReply.studyNum}">
									<c:out value="${studyReply.studyNum}" />
								</a>
							</li>
							<li
								class="adminStudyComment-li-studycommentcontent commentcontent">
								<div class="commentContent"><c:out value="${studyReply.studyComment}" /></div>
								<div class="toggleBtn">
									<img
										src="${pageContext.request.contextPath}/asset/img/admin/all-btn.png"
										alt="토글버튼">
								</div>
							</li>
							<li class="adminStudyComment-li-userid lightdata"><c:out value="${studyReply.userId}" /></li>
							<li class="adminStudyComment-li-usernickname lightdata"><c:out value="${studyReply.userNick}" /></li>
							<li class="adminStudyComment-li-studycommentwritedate lightdata"><c:out value="${fn:substring(studyReply.studyCommentUploadDate, 0, 10)}" /></li>
							<li class="adminStudyComment-li-commentdelete"><input
								type="button" class="admin-btn-delete"
											onclick="clickDeleteBtn(${studyReply.studyCommentNum})" value="삭제"></li>
						</ul>
						<div class="commentWrap"><c:out value="${studyReply.studyComment}" /></div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="data-none">현재 등록된 스터디 댓글이 없습니다.</div>
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