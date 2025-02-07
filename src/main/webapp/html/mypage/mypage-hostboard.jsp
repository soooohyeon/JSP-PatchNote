<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>만든 스터디</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/mypage/mypage-hostboard.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/mypage/mypage-hostboard.js"></script>
</head>
<body>
	<!-- <div id="MYPAGE-DIV-LAYOUTCONTAINER"> -->
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
				<li class="mypage-li-menuactive"><a
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
			<li><a
				href="${pageContext.request.contextPath}/knowledgeForest.main">홈</a>
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
				<h1>만든 스터디</h1>
			</div>
			<!-- 게시판 컨텐츠 정렬을 위한 div -->
			<div class="mypage-div-contentscontainer">
				<div class="mypage-div-contentswrap">
					<c:forEach var="myStudyList" items="${myStudyList}">
						<!-- 모임 항목 컨텐츠 1 -->
						<div class="mypage-div-group">
							<div class="mypage-div-groupinner">
								<div class="mypage-div-groupinfowrapper datecontent-wrap">
									<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
										${myStudyList.studyDeadline}</div>

									<div class="mypage-div-morebtn" onclick="openModal(this)"></div>
									<!-- 모달 리스트 -->
									<div id="modal-list" class="modal hidden">
										<ul>
											<li onclick="handleModalAction('수정페이지')">수정</li>
											<li onclick="handleModalAction('삭제페이지')">삭제</li>
											<li onclick="openApplicantModal(`${myStudyList.studyNum}`)">
												신청자</li>
										</ul>
									</div>
								</div>
								<div class="mypage-div-grouptitle">
									<a
										href="${pageContext.request.contextPath}/study/studyDetailOk.st?studyNum=${myStudyList.studyNum}">${myStudyList.studyTitle}</a>
								</div>
								<div class="mypage-div-groupinfowrapper">
									<c:choose>
										<c:when test="${myStudyList.studyCategory == 0}">
											<div class="mypage-div-groupcategory">개발</div>
										</c:when>
										<c:when test="${myStudyList.studyCategory == 1}">
											<div class="mypage-div-groupcategory">보안</div>
										</c:when>
									</c:choose>
									<div class="mypage-div-groupmember">
										${myStudyList.participants}/${myStudyList.studyLimit}</div>
								</div>
								<div class="mypage-div-groupmakerwrapper">
									<div class="mypage-div-groupmaker">
										${myStudyList.userNick}</div>
									<!-- 마감, 모집 중 -->
									<c:choose>
										<c:when
											test="${myStudyList.participants == myStudyList.studyLimit or myStudyList.studyDeadline < today}">
											<div class="studylist-div-groupstatus">마감</div>
										</c:when>
										<c:otherwise>
											<div class="studylist-div-groupstatus">모집 중</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<!-- 게시판 컨텐츠 정렬을 위한 div 끝 -->


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
		<!-- 메인 컨텐츠 끝 -->
	</div>
	<!-- 모달 HTML 추가 -->
	<div id="REQUEST-LIST-MODAL" class="overlay hidden">
		<div class="modal-content">
			<h2>신청자 목록</h2>
			<div class="applicant-list"></div>
			<button class="close-btn" onclick="closeApplicantModal()">
				닫기</button>
		</div>
	</div>
</body>
</html>
