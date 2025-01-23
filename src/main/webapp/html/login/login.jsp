<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지식의 숲</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/login/login.css"> <!-- css링크걸기 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/login/login.js"></script>
</head>

<body>
	<!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />

  <main>
    <div class="login-div-wrapper-input-loginbox">
      <div class="login-div-h1-box">
        <h1 class="login-h1-title">로그인</h1>
      </div>
      <form action="${pageContext.request.contextPath}/login/loginOk.me" method = "post">
      <div class="login-div-wrapper-input-box">
        <input type="text" class="login-input" placeholder="아이디" name="userId" id="LOGIN-INPUT-ID" maxlength="10" onblur="idCheck()" onkeyup="inputLenFunc2()" > 

        <input type="password" class="login-input" placeholder="비밀번호" name="userPw" id="LOGIN-INPUT-PWD" maxlength="15" onblur="pwdCheck()" onkeyup="inputLenFunc1()" >
      </div>

      <div class="login-div-wrapper-join-box">
        <a href="${pageContext.request.contextPath}/login/join.me" target="_self" class="login-a-join">회원가입</a>
      </div>

      	<div class="login-div-wrapper-btn-box">
        	<button type = "submit" class="login-btn-join" id="LOGIN-BTN-LOGIN" onclick="login()">로그인</button>
      	</div>
	  </form>
      <div class="login-div-wrapper-pwd-box">
        <a href="${pageContext.request.contextPath}/login/passwordSelect.me" target="_self" class="login-a-pwd">비밀번호를 까먹었나요?</a>
      
      </div>
    </div>
   
  </main>


	<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp"/>

</body>
<script>
   let userNum = "${sessionScope.userNum}";
</script>
</html>