<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.knowledgeForest.dto.UserDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <%
// 세션에서 사용자 정보 가져오기
HttpSession session = request.getSession();
int user = session.getAttribute("userDTO.getUserNum())");
boolean isLoggedIn = (user != null); // 로그인 여부 확인
%>
 --%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지식의 숲</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/footer.css">
<script>
	const contextPath = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/asset/js/main/main.js"></script>
</head>



<!-- 임시 / 로그인 테스트  -->
<%-- 		<c:choose>
					<c:when test="${sessionScope.userNumber eq null}">
						<div>로그인 안댐</div>
					</c:when>
					<c:otherwise>
						<div>로그인 댐 세션값 저장댐</div>
					</c:otherwise>
				</c:choose> --%>


<body>

	<!-- 상단 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />

	<!-- 메인 콘텐츠 -->

	<main>
		<div class="main-div-wrapper">

			<!-- 위시 리스트 아이콘 -->
			<div class="main-div-wishlist">
				<h2 style="text-align: center;">
					<img
						src="${pageContext.request.contextPath}/asset/img/main/pencil.png"
						alt="Atlas Icon"
						style="width: 40px; height: 40px; margin-right: 5px;">
					Forest of Knowledge
				</h2>
				
				<div class="main-div-wishlistcontainer">
					<div class="main-div-wishlistcontent">
						<div class="main-div-wishlisttitle">
							<h2>NOTICE</h2>
							<h2>LIST</h2>
						</div>
						<!-- 메인 공지 노출 -->
						<c:forEach var="notice" items="${noticeList}">
							<ul class="main-div-ulist">
								<li class="main-div-wish" onclick="goNotice(${notice.noticeNum})"><c:out value="${notice.noticeTitle}" /></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="main-div-banner">
				<div class="main-div-slide1">
					<img
						src="${pageContext.request.contextPath}/asset/img/main/banner01.png"
						alt="이미지1" class="main-img-banner01 main-div-banneractive">
				</div>
				<div class="main-div-slide2">
					<img
						src="${pageContext.request.contextPath}/asset/img/main/banner02.png"
						alt="이미지2" class="main-img-banner02">
				</div>
				<div class="main-div-slide3">
					<img
						src="${pageContext.request.contextPath}/asset/img/main/banner03.png"
						alt="이미지3" class="main-img-banner03">
				</div>
			</div>
		</div>

		<div class="main-div-container">

			<div class="main-div-studycard main-div-studynew">
				<header class="main-div-studycardheader">
					<span class="main-span-label"> NEW </span> <span
						class="main-span-title"> 신규 등록 스터디</span>
				</header>
				<div class="main-div-studycontent">

					<c:forEach var="newStudy" items="${newStudyList}">
						<c:choose>
							<c:when test="${not empty sessionScope.userNumber}">
								<div class="main-div-studyitem " onclick="goPage(${newStudy.studyNum})">
							</c:when>
							<c:otherwise>
								<div class="main-div-studyitem " onclick="notLogin(this)">
							</c:otherwise>
						</c:choose>
						<span class="main-span-icon">[개발]</span>
						<div class="main-div-studyname">
							<c:out value="${newStudy.studyTitle}" />
						</div>
						<div class="main-div-studytext">
							<c:out value="${newStudy.studyDescript}" />
						</div>
				</div>
				</c:forEach>
			</div>
		</div>

		<div class="main-div-studycard main-div-studyhurry">
         <header class="main-div-studycardheader">
            <span class="main-span-label">Hurry </span> <span class="main-span-title"> 마감 임박 스터디</span>
         </header>

         <div class="main-div-studycontent">


				<c:forEach var="deadlineStudy" items="${deadlineStudyList}">
					<c:choose>
						<c:when test="${not empty sessionScope.userNumber}">
							<div class="main-div-studyitem" onclick="goPage(${deadlineStudy.studyNum})">
						</c:when>
						<c:otherwise>
							<div class="main-div-studyitem" onclick="notLogin(this)">
						</c:otherwise>
					</c:choose>
					<span class="main-span-icon">[보안]</span>
					<div class="main-div-studyname">
						<c:out value="${deadlineStudy.studyTitle}" />
					</div>
					<div class="main-div-studytext">
						<c:out value="${deadlineStudy.studyDescript}" />
					</div>
			</div>
			</c:forEach>

		</div>
		</div>
		</div>

	</main>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


	<%-- <c:out value="${sessionScope.userNumber}"></c:out> --%>
	<%-- <c:out value="${sessionScope.userNum}" /> --%>

	<jsp:include page="/html/main/footer.jsp" />
</body>

</html>
