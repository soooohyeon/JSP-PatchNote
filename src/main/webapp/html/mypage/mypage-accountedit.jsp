<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>개인정보 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/mypage/mypage-accountedit.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/mypage/mypage-accountedit.js"></script>
<script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
   <div class="main-container">
      <aside id="MYPAGE-MENUCONTAINER">
         <nav class="mypage-div-menuwrap">
            <h1 id="MYPAGE-H2-TITLE">마이 페이지</h1>
            <ul class="mypage-ul-menuwrap">
               <li class="mypage-li-menuactive"><a
                  href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my">개인정보
                     수정</a></li>
               <%-- <li><a
                  href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my">찜한
                     목록</a></li> --%>
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

		<main>
			<div class="mypage-div-main">
				<div class="mypage-title">
					<h1>개인정보 수정</h1>
				</div>
				<section class="mypage-section">
					<form id="editForm"
						action="${pageContext.request.contextPath}/mypage/mypage-accounteditOk.my"
						method="post">
						<div class="mypage-div-wrapper">
							<label for="name">이름</label> <input type="text" id="name"
								value="${userInfo.userName}" name="userName" readonly />
						</div>
						<div class="mypage-div-wrapper">
							<label for="birthdate">생년월일</label> <input type="text"
								id="birthdate" name="userBirth" value="${userInfo.userBirth}"
								readonly />
						</div>
						<div class="mypage-div-wrapper">
							<label for="ID">ID</label> <input type="text" id="ID"
								name="userId" value="${userInfo.userId}" readonly />
						</div>

						<div class="mypage-div-wrapper2">
							<div class="editpage-input-nickname">
								<label for="nickname">닉네임</label> <input type="text"
									id="nickname" value="${userInfo.userNick}" name="userNick" />
							</div>
							<button class="mypage-btn-nickname" id="nickdupChkButton"
								type="button">중복검사</button>
						</div>
						<div id="nickname-error"></div>

						<div class="mypage-div-wrapper">
							<label for="password">새로운 비밀번호</label> <input type="password"
								id="password" name="userPw" />
						</div>
						<div id="password-error"></div>

						<div class="mypage-div-wrapper">
							<label for="passwordchk">비밀번호 확인</label> <input type="password"
								id="passwordchk" placeholder="비밀번호를 한번 더 입력해주세요" />
						</div>
						<div id="passwordchk-error"></div>

					</form>
				</section>
				<div class="mypage-div-edit">
					<button class="mypage-btn-edit" type="button" form="editForm">저장</button>
				</div>
			</div>
		</main>
	</div>
</body>

</html>
