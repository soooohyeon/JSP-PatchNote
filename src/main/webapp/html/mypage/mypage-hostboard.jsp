<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
				<li class="mypage-li-menuactive"><a
					href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my">개인정보
						수정</a></li>
				<li><a
					href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my">찜한
						목록</a></li>
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
	<!-- 사이드 메뉴 끝 -->

	<!-- 상단 헤더 -->
	<div id="ADMIN-DIV-HEADERCONTAINER">
		<img src="${pageContext.request.contextPath}/asset/img/main/logo.png" class="admin-img-logo"
			alt="Logo">
		<ul id="ADMIN-UL-HEADERWRAP">
			<li><a href="./../main/main.html">홈</a></li>
			<li><a href="">로그아웃</a></li>
		</ul>
	</div>

	<!-- 메인 컨텐츠가 들어갈 컨테이너 -->
	<div id="MYPAGE-DIV-LAYOUTCONTAINER">
		<main class="mypage-div-container">

			<!-- 현재 페이지 제목 -->
			<div class="mypage-h1-maintitle">
				<h1>만든 스터디</h1>
				<br />
				<p>''님이 만드신 게시글 목록 입니다</p>
			</div>
			<!-- 게시판 컨텐츠 정렬을 위한 div -->
			<div class="mypage-div-contentscontainer">
				<div class="mypage-div-contentswrap">

					<!-- 모임 항목 컨텐츠 1 -->
					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
								<div class="mypage-div-morebtn" onclick="openModal(this)">

								</div>
								<!-- 모달 리스트 -->
								<div id="modal-list" class="modal hidden">
									<ul>
										<li onclick="handleModalAction('수정페이지')">수정</li>
										<li onclick="handleModalAction('삭제페이지')">삭제</li>
										<li onclick="openApplicantModal()">신청자</li>
									</ul>
								</div>
							</div>
							<div class="mypage-div-grouptitle">
								<a href="/webapp/html/study/studylist-detail.html"> 웹 보안의
									기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px;" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 모임 항목 컨텐츠 2 -->
					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
								<div class="mypage-div-morebtn" onclick="openModal(this)"></div>
							</div>
							<div class="mypage-div-grouptitle">
								<a
									href="${pageContext.request.contextPath}/html/study/studylist-detail.html">
									웹 보안의 기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px;" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 모임 항목 컨텐츠 3 -->
					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
								<div class="mypage-div-morebtn" onclick="openModal(this)"></div>
							</div>
							<div class="mypage-div-grouptitle">
								<a href="/webapp/html/study/studylist-detail.html"> 웹 보안의
									기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px;" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 모임 항목 컨텐츠 4 -->
					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
								<div class="mypage-div-morebtn" onclick="openModal(this)"></div>
							</div>
							<div class="mypage-div-grouptitle">
								<a href="/webapp/html/study/studylist-detail.html"> 웹 보안의
									기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px;" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 모임 항목 컨텐츠 5 -->
					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
								<div class="mypage-div-morebtn" onclick="openModal(this)"></div>
							</div>
							<div class="mypage-div-grouptitle">
								<a href="/webapp/html/study/studylist-detail.html"> 웹 보안의
									기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px;" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 모임 항목 컨텐츠 6 -->
					<div class="mypage-div-group">
						<div class="mypage-div-groupinner">
							<div class="mypage-div-groupinfowrapper datecontent-wrap">
								<div class="mypage-div-enddate">마감일 &nbsp;| &nbsp;
									2025.01.05</div>
								<div class="mypage-div-groupstatus">모집 중</div>
								<div class="mypage-div-morebtn" onclick="openModal(this)"></div>
							</div>
							<div class="mypage-div-grouptitle">
								<a href="/webapp/html/study/studylist-detail.html"> 웹 보안의
									기초부터 간단한 토이 프로젝트까지 </a>
							</div>
							<div class="mypage-div-groupinfowrapper">
								<div class="mypage-div-groupcategory">보안</div>
								<div class="mypage-div-groupmember">7/7</div>
							</div>
							<div class="mypage-div-groupmakerwrapper">
								<div class="mypage-div-groupmaker">김철수</div>
								<div class="mypage-div-likewrapper">
									<img
										src="${pageContext.request.contextPath}/asset/img/mypage/no-like.png"
										alt="찜" class="mypage-img-nolike"
										style="width: 30px; height: 30px;" />
									<div class="mypage-div-likecount">7</div>
								</div>
							</div>
						</div>
					</div>

				</div>

				<!-- 페이지네이션 -->
				<div class="mypage-div-paginationwrapper">
					<ul id="mypage-UL-PAGINATION">
						<li class="mypage-li-paginationlist pre">&lt;</li>
						<li class="mypage-li-paginationlist currentpage">1</li>
						<li class="mypage-li-paginationlist">2</li>
						<li class="mypage-li-paginationlist">3</li>
						<li class="mypage-li-paginationlist">4</li>
						<li class="mypage-li-paginationlist">5</li>
						<li class="mypage-li-paginationlist next">&#62;</li>
					</ul>
				</div>
			</div>


			<!-- 게시판 컨텐츠 정렬을 위한 div 끝 -->


		</main>
		<!-- 메인 컨텐츠 끝 -->
	</div>

	<!-- </div> -->
	<!-- 모달 HTML 추가 -->
	<div id="REQUEST-LIST-MODAL" class="overlay hidden">
		<div class="modal-content">
			<h2>신청자 목록</h2>
			<div class="applicant-list">
				<!-- 신청자 항목 -->
				<div class="applicant-item">
					<div class="applicant-header">
						<span class="applicant-name">김철수</span>
						<p class="applicant-content">안녕하세요 참여하고 싶습니다.</p>
						<div class="applicant-actions">
							<button class="accept-btn" onclick="acceptApplicant('김철수')">수락</button>
							<button class="reject-btn" onclick="rejectApplicant('김철수')">거절</button>
						</div>
						<img src="./../../asset/img/mypage/down.png" alt="찜"
							class="mypage-img-nolike" style="width: 30px; height: 30px;"
							onclick="toggleDropdown(this)" />
						<!-- <button class="dropdown-btn" onclick="toggleDropdown(this)">⬇</button> -->
					</div>
					<div class="applicant-body hidden">
						<p class="applicant-message">안녕하세요! 참여하고 싶습니다.</p>
					</div>
					<div class="applicant-header">
						<span class="applicant-name">김철수</span>
						<p class="applicant-content">안녕하세요 참여하고 싶습니다.</p>
						<div class="applicant-actions">
							<button class="accept-btn" onclick="acceptApplicant('김철수')">수락</button>
							<button class="reject-btn" onclick="rejectApplicant('김철수')">거절</button>
						</div>
						<img src="./../../asset/img/mypage/down.png" alt="찜"
							class="mypage-img-nolike" style="width: 30px; height: 30px;"
							onclick="toggleDropdown(this)" />
					</div>
					<div class="applicant-body hidden">
						<p class="applicant-message">안녕하세요! 참여하고 싶습니다.</p>
					</div>
					<div class="applicant-header">
						<span class="applicant-name">김철수</span>
						<p class="applicant-content">안녕하세요 참여하고 싶습니다.</p>
						<div class="applicant-actions">
							<button class="accept-btn" onclick="acceptApplicant('김철수')">수락</button>
							<button class="reject-btn" onclick="rejectApplicant('김철수')">거절</button>
						</div>
						<img src="./../../asset/img/mypage/down.png" alt="찜"
							class="mypage-img-nolike" style="width: 30px; height: 30px;"
							onclick="toggleDropdown(this)" />
					</div>
					<div class="applicant-body hidden">
						<p class="applicant-message">안녕하세요! 참여하고 싶습니다.</p>
					</div>
					<div class="applicant-header">
						<span class="applicant-name">김철수</span>
						<p class="applicant-content">안녕하세요 참여하고 싶습니다.</p>
						<div class="applicant-actions">
							<button class="accept-btn" onclick="acceptApplicant('김철수')">수락</button>
							<button class="reject-btn" onclick="rejectApplicant('김철수')">거절</button>
						</div>
						<img src="./../../asset/img/mypage/down.png" alt="찜"
							class="mypage-img-nolike" style="width: 30px; height: 30px;"
							onclick="toggleDropdown(this)" />
					</div>
					<div class="applicant-body hidden">
						<p class="applicant-message">안녕하세요! 참여하고 싶습니다.</p>
					</div>
					<div class="applicant-header">
						<span class="applicant-name">김철수</span>
						<p class="applicant-content">안녕하세요 참여하고 싶습니다.</p>
						<div class="applicant-actions">
							<button class="accept-btn" onclick="acceptApplicant('김철수')">수락</button>
							<button class="reject-btn" onclick="rejectApplicant('김철수')">거절</button>
						</div>
						<img src="./../../asset/img/mypage/down.png" alt="찜"
							class="mypage-img-nolike" style="width: 30px; height: 30px;"
							onclick="toggleDropdown(this)" />
					</div>
					<div class="applicant-body hidden">
						<p class="applicant-message">안녕하세요! 참여하고 싶습니다.</p>
					</div>
				</div>
			</div>
			<button class="close-btn" onclick="closeApplicantModal()">닫기</button>
		</div>
	</div>
</body>
</html>