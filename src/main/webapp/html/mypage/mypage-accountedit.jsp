<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>개인정보 수정</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/mypage/mypage-accountedit.css"
    />
    <script
      defer
      src="${pageContext.request.contextPath}/asset/js/mypage/mypage-accountedit.js"
    ></script>
  </head>
  <body>
    <!-- <header></header> -->
    <div class="main-container">
      <!-- 사이드 메뉴 -->
      <aside id="MYPAGE-MENUCONTAINER">
        <nav class="mypage-div-menuwrap">
          <h1 id="MYPAGE-H2-TITLE">마이 페이지</h1>
          <ul class="mypage-ul-menuwrap">
            <li class="mypage-li-menuactive">
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my"
                >개인정보 수정</a
              >
            </li>
            <li>
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my"
                >찜한 목록</a
              >
            </li>
            <li>
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-hostboard.my"
                >만든 스터디</a
              >
            </li>
            <li>
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-applylist.my"
                >신청한 스터디</a
              >
            </li>
            <li>
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-writtenboard.my"
                >작성한 자유게시글</a
              >
            </li>
            <li>
              <a
                href="${pageContext.request.contextPath}/mypage/mypage-deleteaccount.my"
                >회원 탈퇴</a
              >
            </li>
          </ul>
        </nav>
      </aside>

      <!-- 상단 헤더 -->
      <div id="ADMIN-DIV-HEADERCONTAINER">
        <img
          src="${pageContext.request.contextPath}/asset/img/main/logo.png"
          class="admin-img-logo"
          alt="Logo"
        />
        <ul id="ADMIN-UL-HEADERWRAP">
          <li>
            <a href="${request.getContextPath}/main/main-login.jsp">홈</a>
          </li>
          <li>
            <a href="${request.getContextPath}/main/main-logout.jsp"
              >로그아웃</a
            >
          </li>
        </ul>
      </div>

      <main>
        <div class="mypage-div-main">
          <div class="mypage-title">
            <h1>개인정보 수정</h1>
          </div>
          <section class="mypage-section">
            <form
              action="${pageContext.request.contextPath}/mypage/mypage-accountedit.my"
              method="post"
            >
              <div class="mypage-div-wrapper">
                <label for="name">이름</label>
                <input
                  type="text"
                  id="name"
                  value="${userInfo.userName}"
                  name="userName"
                  readonly
                />
              </div>
              <div class="mypage-div-wrapper">
                <label for="birthdate">생년월일</label>
                <input
                  type="text"
                  id="birthdate"
                  name="userBirth"
                  value="${userInfo.userBirth}"
                  readonly
                />
              </div>
              <div class="mypage-div-wrapper">
                <label for="ID">ID</label>
                <input
                  type="text"
                  id="ID"
                  name="userId"
                  value="${userInfo.userId}"
                  readonly
                />
              </div>

              <div class="mypage-div-wrapper2">
                <div class="editpage-input-nickname">
                  <label for="nickname">닉네임</label>
                  <input 
                  	type="text" 
                  	id="nickname" 
                  	value="${userInfo.userNick}"
                  	name="userNick" />
                </div>
                <button
                  class="mypage-btn-nickname"
                  id="nickdupChkButton"
                  onclick="validateNickname()"
                >
                  중복검사
                </button>
              </div>
              <div id="nickname-error"></div>

              <div class="mypage-div-wrapper">
                <label for="password">비밀번호</label>
                <input
                  type="password"
                  id="password"
                  onkeydown="validatePasswordLive()"
                  name="userPw"
                />
              </div>
              <div id="password-error"></div>

              <div class="mypage-div-wrapper">
                <label for="passwordchk">비밀번호 확인</label>
                <input
                  type="password"
                  id="passwordchk"
                  placeholder="비밀번호를 한번 더 입력해주세요"
                  onkeydown="initializePasswordCheck()"
                />
              </div>
              <div id="passwordchk-error"></div>

              <div class="mypage-div-wrapper2">
                <div class="editpage-input-phoneNum">
                  <label for="phoneNum">전화번호</label>
                  <input
                    type="text"
                    id="phoneNum"
                    placeholder="숫자만 입력해주세요"
					name = ${userInfo.userPH}
                  />
                </div>
                <button class="mypage-btn-phoneNum-send">전송</button>
              </div>
              <div id="phoneNum-error" style="color: red"></div>

              <div class="mypage-div-wrapper2">
                <div class="editpage-input-phoneNumchk">
                  <label for="phoneNumchk">인증번호 확인</label>
                  <input
                    type="text"
                    id="phoneNumchk"
                    placeholder="인증번호를 입력해주세요"
                  />
                </div>
                <button class="mypage-btn-phoneNum-check">확인</button>
              </div>
            </form>
          </section>
          <div class="mypage-div-edit">
            <button class="mypage-btn-edit">저장</button>
          </div>
        </div>
      </main>
    </div>
  </body>
</html>
