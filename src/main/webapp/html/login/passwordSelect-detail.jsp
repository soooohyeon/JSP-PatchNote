<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지식의 숲</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/login/passwordSelect-detail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
    <script src="${pageContext.request.contextPath}/asset/js/login/passwordSelect-detail.js"></script>
</head>
<body>

	<!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />
	<form action="${pageContext.request.contextPath}/login/passwrdDetailOk.me" method = "post">
		<main>
			<div class="passwordSelect-detail-div-wrapper-h1-box">
				<h1 class="passwordSelect-detail-h1-title">비밀번호 변경</h1>
			</div>

			<div class="passwordSelect-detail-div-wrapper-allinput-box">
				<div class="passwordSelect-detail-div-wrapper-input-id">
					<input type="password" class="passwordSelect-detail-input-newpwd"
						maxlength="15" placeholder="새로운 비밀번호" name="pwd"
						id="PASSWORDSELECT-INPUT-NEWPWD" />
				</div>
				<span id="JOIN-SPAN-PWD-STATUS"></span>
				
				<div class="passwordSelect-detail-div-wrapper-input-id">
					<input type="password" class="passwordSelect-detail-input-newpwd"
						placeholder="새로운 비밀번호 재입력" name="newPwd" maxlength="15" id="PASSWORDSELECT-INPUT-RENEWPWD" />

				</div>
				<span id="JOIN-SPAN-REPWD-STATUS"></span>
				<button type="submit" class="passwordSelect-detail-btn-complete">완료</button>
			</div>

		</main>
	</form>

	<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp" />
</body>
</html>