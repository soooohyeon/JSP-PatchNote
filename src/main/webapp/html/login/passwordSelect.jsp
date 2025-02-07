<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지식의 숲</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/login/passwordSelect.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
    <script src="${pageContext.request.contextPath}/asset/js/login/passwordSelect.js"></script>
</head>
<body>
	<!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />
	
	 <main>
	   <form action="${pageContext.request.contextPath}/login/passwordSelectOk.me">
      <div class="passwordSelect-div-wrapper-pwd-select">
        <div class="passwordSelect-div-h1-box">
          <h1 class="h1-title">비밀번호 찾기</h1>
        </div>
      
        <div class="passwordSelect-div-wrapper-all-box">
          <div class="passwordSelect-div-wrapper-input-box">
            <input type="text" class="passwordSelect-input" placeholder="아이디" name="userId" maxlength="10" id="PASSWORDSELECT-INPUT-ID">
          </div>
			 <span class="join-span-wrapper-text-alarm" id="JOIN-SPAN-ID"></span>
          <div class="passwordSelect-div-wrapper-input-box">
            <input
              type="text"
              class="passwordSelect-input"
              placeholder="휴대폰 번호" name="userPH" id="PASSWORDSELECT-INPUT-PHONENUMBER"/>
            <button type = "button" class="passwordSelect-btn" id="PASSWORDSELECT-BTN-SEND">발송</button>
          </div>

          <div class="passwordSelect-div-wrapper-input-box">
            <input
              type="number"
              class="passwordSelect-input"
              placeholder="인증번호" name="authenticationNumber" id="PASSWORDSELECT-AUTHENTICATIONNUMBER" />
           <button type="button" class="passwordSelect-btn" id="PASSWORDSELECT-BTN-CHECK">확인</button>
             
          </div>
          <span id="JOIN-SPAN-VERIFICATION-STATUS"></span>
        </div>
         <button type="submit" class="passwordSelect-btn1" id="PASSWORDSELECT-BTN-NEXT">이동</button>
      </div>
    </form>
    </main>
	
	
	
		<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp"/>
</body>
</html>