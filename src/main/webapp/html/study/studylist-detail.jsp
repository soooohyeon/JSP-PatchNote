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
	href="${pageContext.request.contextPath}/asset/css/study/studylist-detail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/main/footer.css" />
<script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<!-- 상단 메뉴바 -->
	<nav class="main-nav-menuwrap">
		<img src="${pageContext.request.contextPath}/asset/img/main/logo.png"
			class="main-img-logo" />
		<ul class="main-nav-ul">
			<li><a
				href="${pageContext.request.contextPath}/html/notice/notice-list.jsp">공지</a></li>
			<li><a
				href="${pageContext.request.contextPath}/html/board/board-list.jsp">자유게시판</a></li>
			<li><a
				href="${pageContext.request.contextPath}/study/studyList.st">스터디
					모집</a></li>
			<li><a
				href="${pageContext.request.contextPath}/html/login/join.jsp">회원가입</a></li>
			<li><a
				href="${pageContext.request.contextPath}/html/login/login.jsp">로그인</a></li>
		</ul>
	</nav>
	<main>
		<!-- 페이지 타이틀 -->
		<div class="studylist-detail-div-titlewrapper">
			<img
				src="${pageContext.request.contextPath}/asset/img/study/back.png"
				alt="뒤로가기" class="studylist-detail-img-back" onclick="goBack()" />
			<h1 class="studylist-h1-title">
				<c:out value="${detailStudy.studyTitle}" />
			</h1>
		</div>
		<!-- 수정 / 삭제 버튼 -->
		<div class="studylist-detail-div-btnwrapper">
			<span onclick="updateStudy(${detailStudy.studyNum})"
				class="studylist-span-editbtn">수정</span> <span
				class="studylist-span-divider">|</span> <span
				onclick="deleteStudy(${detailStudy.studyNum})"
				class="studylist-span-deletebtn">삭제</span>
		</div>
		<!-- 전체 내용을 감싸는 래퍼-->
		<div class="studylist-div-contentsWrapper">
			<!-- 입력 폼을 감싸는 래퍼 -->
			<div id="STUDYLIST-FORM-WRITE">
				<!-- 한 행 -->
				<div class="studylist-div-wrapperlayer">
					<!-- label과 input을 묶은 div -->

					<div class="studylist-div-infowrapper">
						<div class="label">닉네임</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.userNick}" />
						</div>
					</div>
					<div class="studylist-div-infowrapper">
						<div class="label">작성일</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.studyUploadDate}" />
						</div>
					</div>
				</div>

				<div class="studylist-div-wrapperlayer">
					<div class="studylist-div-infowrapper">
						<div class="label">정원 수</div>
						<div class="studylist-div-groupinfo">
							[신청한 인원수] /
							<c:out value="${detailStudy.studyLimit}" />
							명
						</div>
					</div>
					<div class="studylist-div-infowrapper">
						<div class="label">신청 마감일</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.studyDeadline}" />
						</div>
					</div>
				</div>
				<div class="studylist-div-wrapperlayer">
					<div class="studylist-div-infowrapper">
						<div class="label">활동 시간</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.studyStartTime}" />
							~
							<c:out value="${detailStudy.studyEndTime}" />
						</div>
					</div>
					<div class="studylist-div-infowrapper">
						<div class="label">활동 기간</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.studyStartDay}" />
							~
							<c:out value="${detailStudy.studyEndDay}" />
						</div>
					</div>
				</div>
				<div class="studylist-div-wrapperlayer">
					<div class="studylist-div-infowrapper">
						<div class="label">연락처</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.userPh}" />
						</div>
					</div>
					<div class="studylist-div-infowrapper">
						<div class="label">장소</div>
						<div class="studylist-div-groupinfo">
							<c:out value="${detailStudy.studyLocation}" />
						</div>
					</div>
				</div>
				<div class="studylist-div-wrapperlayer">
					<div class="studylist-div-textareawrapper">
						<div class="label">본문</div>
						<div class="studylist-div-studycontents">
							<c:out value="${detailStudy.studyDescript}" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 등록 버튼 -->

		<button class="studylist-btn-submit" type="submit"
			form="STUDYLIST-FORM-WRITE" onclick="applyStudy()">
			스터디 신청</button>
		<!-- 스터디 신청 후 보이는 버튼 -->

		<!-- 
      <button
        class="studylist-btn-submit"
        type="submit"
        form="STUDYLIST-FORM-WRITE"
        onclick="cancelStudy()"
      >
        스터디 신청 취소
      </button>
  
      -->

		<!-- 댓글 입력 창 -->
		<div class="studylist-div-commentinputwrapper">
			<div class="studylist-div-userNickname">
				<span>[로그인한 계정닉네임]</span>
			</div>
			<div class="studylist-div-commentwrapper">
				<form action="">
					<textarea name="studyContents" id="STUDYLIST-TEXTAREA-COMMENT"
						placeholder="덧글을 남겨 보세요" data-counter="WRITE-COMMENT-COUNTER"
						oninput="updateCharacterCount(this, 200)"></textarea>
				</form>
			</div>

			<div class="studylist-div-counterwrapper">
				<span class="studylist-span-counter" id="WRITE-COMMENT-COUNTER">0/200</span>
			</div>
		</div>

		<button class="studylist-btn-commentsubmit" type="submit"
			form="STUDYLIST-TEXTAREA-COMMENT" onclick="writeComment()">
			등록</button>

		<!-- 댓글 목록 -->
		<div class="studylist-div-commentlistwrapper">
			<div class="studylist-div-commentlistheader">
				<span class="studylist-span-comment">댓글</span> <span
					class="studylist-span-commentcounter">총 2개</span>
			</div>
			<div class="studylist-div-commentlist">
				<div class="studylist-div-commentlayer">
					<span class="studylist-span-commentnickname">닉네임</span> <span
						class="studylist-span-commentdate">2025.01.03</span>
				</div>
				<div class="studylist-div-commentlayer">
					<span class="studylist-span-commentcontents"> 프로그래머스라는
						홈페이지에서 코테도 할 수 있고, 여러 강의도 들을 수 있어요. </span>
				</div>
			</div>
			<div class="studylist-div-commentlist">
				<div class="studylist-div-commentlayer">
					<span class="studylist-span-commentnickname">닉네임</span> <span
						class="studylist-span-commentdate">2025.01.03</span>
				</div>
				<div class="studylist-div-commentlayer">
					<span class="studylist-span-commentcontents"> 프로그래머스라는
						홈페이지에서 코테도 할 수 있고, 여러 강의도 들을 수 있어요. 프로그래머스라는 홈페이지에서 코테도 할 수 있고, 여러
						강의도 들을 수 있어요. 프로그래머스라는 홈페이지에서 코테도 할 수 있고, 여러 강의도 들을 수 있어요.
						프로그래머스라는 홈페이지에서 코테도 할 수 있고, 여러 강의도 들을 수 있어요. </span>
					<div class="studylist-detail-div-btnwrapper">
						<span class="studylist-span-commenteditbtn"
							onclick="updateComment()">수정</span> <span
							class="studylist-span-divider">|</span> <span
							class="studylist-span-commentdeletebtn" onclick="deleteComment()">삭제</span>
					</div>
				</div>
			</div>

			<!-- 수정 버튼을 눌렀을때 디스플레이 되는 댓글 입력 창 -->
			<div class="studylist-div-commentlist">
				<div class="studylist-div-commentlayer">
					<span class="studylist-span-commentnickname">닉네임</span> <span
						class="studylist-span-commentdate">2025.01.03</span>
				</div>
				<div class="studylist-div-commentlayer">
					<form action="" id="STUDYLIST-FORM-EDITCOMMENT">
						<textarea class="studylist-textarea-commentcontents"
							placeholder="댓글을 남겨보세요." data-counter="EDIT-COMMENT-COUNTER"
							oninput="updateCharacterCount(this, 200)"></textarea>
						<div class="studylist-div-counterwrapper">
							<span id="EDIT-COMMENT-COUNTER" class="studylist-span-counter">0/200</span>
						</div>
					</form>
				</div>
				<div class="studylist-div-commentlayer">
					<!-- 댓글 수정 버튼 -->
					<button class="studylist-btn-editcommentsubmit" type="submit"
						form="STUDYLIST-FORM-EDITCOMMENT">등록</button>
				</div>
			</div>
		</div>

		<!-- 페이지네이션 -->
		<div class="studylist-div-paginationwrapper">
			<ul id="STUDYLIST-UL-PAGINATION">
				<li class="studylist-li-paginationlist pre">&lt;</li>
				<li class="studylist-li-paginationlist currentpage">1</li>
				<li class="studylist-li-paginationlist">2</li>
				<li class="studylist-li-paginationlist">3</li>
				<li class="studylist-li-paginationlist">4</li>
				<li class="studylist-li-paginationlist">5</li>
				<li class="studylist-li-paginationlist next">&#62;</li>
			</ul>
		</div>
	</main>

	<footer class="main-footer-container">
		<div class="main-footer-content">
			<div class="main-footer-links">
				<div class="main-footer-policies">
					<a href="#" class="main-link-policy">개인정보처리방침</a> <span
						class="main-span-divider">|</span> <a href="#"
						class="main-link-terms">이용약관</a>
				</div>
				<p class="main-paragraph-contact">Contact:
					team.patchnote.official@gmail.com</p>
				<p class="main-paragraph-copyright">Copyright Forest Info. All
					rights reserved</p>
			</div>
			<div class="main-footer-logo">
				<img
					src="${pageContext.request.contextPath}/asset/img/main/logo.png"
					alt="Forest of Knowledge Logo" class="main-img-footerlogo" />
			</div>
		</div>
	</footer>
</body>

<div id="STUDYLIST-MODAL-APPLY">
	<div class="studylist-div-applywrapper">
		<div class="studylist-div-titlewrapper">
			<h1>STUDY 신청</h1>
		</div>

		<div class="studylist-div-couragewrapper">
			<form action="" id="STUDYLIST-FORM-WRITECOURAGE">
				<textarea name="studyContents" id="STUDYLIST-TEXTAREA-COURAGE"
					data-counter="COURAGE-COUNTER" placeholder="각오 한마디를 남기세요"
					oninput="updateCharacterCount(this, 200)"></textarea>
			</form>

			<div class="studylist-div-counterwrapper">
				<span id="COURAGE-COUNTER" class="studylist-span-counter">0/200</span>
			</div>
		</div>
		<div class="studylist-div-bottomlayer">
			<div class="studylist-div-checkboxwrapper">
				<!-- <img 
            src="/webapp/asset/img/study/checkboxOut.png"
             alt="체크" 
             class="studylist-img-checkboximg"
             /> -->
				<input type="checkbox" id="STUDYLIST-CHECKBOX-AGREE" onchange="" />
				<p class="studylist-p-infotext">스터디 모임 참여 후 발생할 수 있는 모든 문제는 참여자
					간의 사적 문제로 간주되며, 본 게시판 및 운영자는 이에 대해 어떠한 법적 책임도 지지 않음을 알려드립니다.</p>
			</div>
			<div class="studylist-div-btnwrapper">
				<button class="studylist-btn-couragewrite" type="submit"
					form="STUDYLIST-FORM-WRITECOURAGE" onclick="writeCourage(event)">
					등록</button>
				<button class="studylist-btn-couragecancel"
					form="STUDYLIST-FORM-WRITECOURAGE" onclick="closeModel()">
					취소</button>
			</div>
		</div>
	</div>
</div>

<script defer
	src="${pageContext.request.contextPath}/asset/js/study/studylist-detail.js"></script>
</html>
