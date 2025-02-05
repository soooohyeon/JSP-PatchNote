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
	href="${pageContext.request.contextPath}/asset/css/admin/admin-studyapplylist.css">
<script defer
	src="${pageContext.request.contextPath}/asset/js/admin/admin-studyapplylist.js"></script>
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
					<h1 class="admin-h1-maintitle">스터디 신청 관리</h1>

					<!-- 검색창 -->
					<form action="admin-studyapplylist.ad" method="get">
						<div class="admin-div-wrapper">
							<input type="text" name="keyword" class="admin-input-search"
								placeholder="신청 회원의 아이디나 닉네임을 입력해주세요." value="<c:out value='${param.keyword}'/>" /> <img
								src="${pageContext.request.contextPath}/asset/img/study/search-btn.png"
								alt="search" class="admin-img-search" />
						</div>
					</form>

					<!-- 스터디 글 테이블 -->
					<div class="admin-div-listwrap">
						<!-- 테이블 컬럼명 -->
						<ul class="admin-ul-titlewrap">
							<li class="adminStudyApply-li-applyid">스터디 신청번호</li>
							<li class="adminStudyApply-li-studyid">스터디 번호</li>
							<li class="adminStudyApply-li-studymemberwrap">확정인원/모집인원</li>
							<li class="adminStudyApply-li-studystatus">진행 상태</li>
							<li class="adminStudyApply-li-applystatus">신청수락여부</li>
							<li class="adminStudyApply-li-userid">신청자ID</li>
							<li class="adminStudyApply-li-usernickname">신청자 닉네임</li>
							<li class="adminStudyApply-li-studydelete"></li>
						</ul>


						<c:choose>
							<c:when test="${not empty studyApplyList}">
								<c:forEach var="studyApply" items="${studyApplyList}">
									<!-- 데이터 넣는 부분 - 임시데이터 (1) -->
									<ul class="admin-ul-datawrap">
										<li class="adminStudyApply-li-applyid lightdata">
											<!-- 관리자 화면의 스터디 신청 상세페이지로 이동 -->
											<a href="${pageContext.request.contextPath}/admin/admin-studyapplydetail.ad?studyApplyNum=${studyApply.studyApplyNum}">
												<c:out value="${studyApply.studyApplyNum}" />
											</a>
										</li>
										<li class="adminStudyApply-li-studyid lightdata">
											<!-- 사용자 화면의 스터디 상세페이지로 이동 -->
											<a href="${pageContext.request.contextPath}/study/studyDetailOk.st?studyNum=${studyApply.studyNum}">
												<c:out value="${studyApply.studyNum}" />
											</a>
										</li>
										<li class="adminStudyApply-li-studymemberwrap">
											<c:out value="${studyApply.participants}" /> / <c:out value="${studyApply.limitParticipants}" />
										</li>

										<c:choose>
										    <c:when test="${studyApply.participants == studyApply.limitParticipants or studyApply.deadline < today}">
										        <li class="adminStudyApply-li-studystatus lightdata">마감</li>
										    </c:when>
										    <c:otherwise>
										        <li class="adminStudyApply-li-studystatus">모집 중</li>
										    </c:otherwise>
										</c:choose>
										
										<li class="adminStudyApply-li-applystatus">
											<c:choose>
											    <c:when test="${studyApply.studyApplyStatus == 0}">대기 중</c:when>
											    <c:when test="${studyApply.studyApplyStatus == 1}">수락</c:when>
											    <c:otherwise>거절</c:otherwise>
											</c:choose>
										</li>
										<li class="adminStudyApply-li-userid lightdata">
											<c:out value="${studyApply.userId}" /></li>
										<li class="adminStudyApply-li-usernickname lightdata"><c:out
												value="${studyApply.userNick}" /></li>
										<li class="adminStudyApply-li-studydelete">
											<!-- 신청 수락 여부가 대기 중 일 때만 보이게 -->
											<c:if test="${studyApply.studyApplyStatus == 0}">
												<input type="button" class="admin-btn-delete"
													onclick="clickDeleteBtn(${studyApply.studyApplyNum})" value="신청취소">
											</c:if>
										</li>
									</ul>
								</c:forEach>
							</c:when>
							
							<c:otherwise>
								<div class="data-none">스터디 신청 목록이 없습니다.</div>
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