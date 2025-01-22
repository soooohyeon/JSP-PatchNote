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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-main.css">
</head>
<body>
  <div id="ADMIN-DIV-LAYOUTCONTAINER">
    <!-- 사이드 메뉴 -->
    <jsp:include page = "/html/admin/sidemenu.jsp" />
    <!-- 사이드 메뉴 끝 -->

    <!-- 상단 헤더 + 헤더 아래 컨텐츠 요소들 -->
    <div id="ADMIN-DIV-CONTENTWRAP">
      <!-- 상단 헤더 -->
	  <jsp:include page = "/html/admin/header.jsp" />
      <!-- 상단 헤더 끝 -->

      <!-- 메인 컨텐츠가 들어갈 컨테이너 -->
      <main class="admin-div-container">
        <div class="admin-div-contentcontainer adminMain-div-mainwrap">

          <!-- 유저 목록 테이블 -->
          <div class="adminMain-div-contentswrap">
            <!-- 관리할 테이블 이름 -->
            <div class="adminMain-div-contentheaderWrap">
              <div class="adminMain-div-contentstitle">유저 목록</div>
              <div class="adminMain-div-contentsall"><a href="${pageContext.request.contextPath}/admin/admin-userlist.ad">전체보기 &gt;</a></div>
            </div>
            <!-- 테이블 형식 시작 -->
            <div class="adminMain-div-tablewrap">
              <ul>
                <!-- 테이블 제목 -->
                <li>
                  <ul class="list-datatable adminMain-lists-titleswrap">
                    <li class="adminMain-li-userid">유저ID</li>
                    <li class="adminMain-li-usernickname">닉네임</li>
                    <li class="adminMain-li-userjoindate">가입일</li>
                  </ul>
                </li>
                <!-- 테이블 제목 끝 -->
                
				<c:choose>
					<c:when test="${not empty userList}">
						<c:forEach var="user" items="${userList}">
			                <!-- 임시 유저 데이터 (1) - 데이터가 들어가는 부분 -->
			                <li>
			                  <a href="${pageContext.request.contextPath}/admin/admin-userdetail.ad?userNum=${user.userNum}">
			                    <ul class="list-datatable adminMain-lists-dataswrap">
			                      <li class="adminMain-li-userid"><c:out value="${user.userId}" /></li>
			                      <li class="adminMain-li-usernickname"><c:out value="${user.userNick}" /></li>
			                      <li class="adminMain-li-userjoindate lightdata"><c:out value="${user.userJoinDate}" /></li>
			                    </ul>
			                  </a>
			                </li>
			                <!-- 데이터 끝 -->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="data-none">현재 가입된 유저가 없습니다.</div>
					</c:otherwise>
				</c:choose>
              </ul>
            </div>
            <!-- 테이블 형식 끝 -->
          </div>
          <!-- 유저 목록 끝 -->

          <!-- 스터디 목록 테이블 -->
          <div class="adminMain-div-contentswrap">
            <!-- 관리할 테이블 이름 -->
            <div class="adminMain-div-contentheaderWrap">
              <div class="adminMain-div-contentstitle">스터디 목록</div>
              <div class="adminMain-div-contentsall"><a href="${pageContext.request.contextPath}/admin/admin-studylist.ad">전체보기 &gt;</a></div>
            </div>
            <!-- 테이블 형식 시작 -->
            <div class="adminMain-div-tablewrap">
              <ul>
                <!-- 테이블 th -->
                <li>
                  <ul class="list-datatable adminMain-lists-titleswrap">
                    <li class="adminMain-li-posttitle">스터디명</li>
                    <li class="adminMain-li-writer">작성자</li>
                    <li class="adminMain-li-writerdate">작성일</li>
                  </ul>
                </li>
                
				<c:choose>
					<c:when test="${not empty studyList}">
						<c:forEach var="study" items="${studyList}">
			                <!-- 데이터가 들어가는 부분 - 임시 스터디 데이터 (1) -->
			                <li>
			                  <!-- 상세 페이지 링크 넣어줘야함 -->
			                  <a href="${pageContext.request.contextPath}/study/studyDetailOk.st?studyNum=${study.studyNum}">
			                    <ul class="list-datatable adminMain-lists-dataswrap">
			                      <li class="adminMain-li-posttitle">
			                        <div class="adminMain-div-title"><c:out value="${study.studyTitle}" /></div>
			                      </li>
			                      <li class="adminMain-li-writer lightdata"><c:out value="${study.userNick}" /></li>
			                      <li class="adminMain-li-writerdate lightdata"><c:out value="${study.studyUploadDate}" /></li>
			                    </ul>
			                  </a>
			                </li>
			         		<!-- 데이터 끝 -->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="data-none">현재 작성된 스터디가 없습니다.</div>
					</c:otherwise>
				</c:choose>
                

              </ul>
            </div>
            <!-- 테이블 형식 끝 -->
          </div>
          <!-- 스터디 목록 끝 -->

          <!-- 자유게시판 목록 테이블 -->
          <div class="adminMain-div-contentswrap">
            <!-- 관리할 테이블 이름 -->
            <div class="adminMain-div-contentheaderWrap">
              <div class="adminMain-div-contentstitle">자유게시판 목록</div>
              <div class="adminMain-div-contentsall"><a href="${pageContext.request.contextPath}/admin/admin-boardlist.ad">전체보기 &gt;</a></div>
            </div>
            <!-- 테이블 형식 시작 -->
            <div class="adminMain-div-tablewrap">
              <ul>
                <!-- 테이블 th -->
                <li>
                  <ul class="list-datatable adminMain-lists-titleswrap">
                    <li class="adminMain-li-posttitle">제목</li>
                    <li class="adminMain-li-writer">작성자</li>
                    <li class="adminMain-li-writerdate">작성일</li>
                  </ul>
                </li>

				<c:choose>
					<c:when test="${not empty boardList}">
						<c:forEach var="board" items="${boardList}">
			                <!-- 데이터가 들어가는 부분 - 임시 자유게시판 데이터 (1) -->
			                <li>
			                  <!-- 사용자 화면의 상세페이지 링크 넣어줘야함 -->
			                  <a href="${pageContext.request.contextPath}/board/boarddetail.bo?boardNum=${board.boardNum}">
			                    <ul class="list-datatable adminMain-lists-dataswrap">
			                      <li class="adminMain-li-posttitle">
			                        <div class="adminMain-div-title"><c:out value="${board.boardTitle}" /></div>
			                      </li>
			                      <li class="adminMain-li-writer lightdata"><c:out value="${board.userNick}" /></li>
			                      <li class="adminMain-li-writerdate lightdata"><c:out value="${board.boardUploadDate}" /></li>
			                    </ul>
			                  </a>
			                </li>
			                <!-- 데이터 끝 -->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="data-none">현재 작성된 게시글이 없습니다.</div>
					</c:otherwise>
				</c:choose>

              </ul>
            </div>
            <!-- 테이블 형식 끝 -->
          </div>
          <!-- 자유게시판 목록 끝 -->


          <!-- 공지 목록 테이블 -->
          <div class="adminMain-div-contentswrap">
            <!-- 관리할 테이블 이름 -->
            <div class="adminMain-div-contentheaderWrap">
              <div class="adminMain-div-contentstitle">공지 목록</div>
              <div class="adminMain-div-contentsall"><a href="${pageContext.request.contextPath}/admin/admin-noticelist.ad">전체보기 &gt;</a></div>
            </div>
            <!-- 테이블 형식 시작 -->
            <div class="adminMain-div-tablewrap">
              <ul>
                <!-- 테이블 th -->
                <li>
                  <ul class="list-datatable adminMain-lists-titleswrap">
                    <li class="adminMain-li-noticetitle">제목</li>
                    <li class="adminMain-li-writerdate">작성일</li>
                  </ul>
                </li>

				<c:choose>
					<c:when test="${not empty noticeList}">
						<c:forEach var="notice" items="${noticeList}">
			                <!-- 데이터가 들어가는 부분 - 임시 공지 데이터 (1) -->
			                <li>
			                  <a href="${pageContext.request.contextPath}/admin/admin-noticedetail.ad?noticeNum=${notice.noticeNum}">
			                    <ul class="list-datatable adminMain-lists-dataswrap">
			                      <li class="adminMain-li-noticetitle adminMain-notice-title"><c:out value="${notice.noticeTitle}" /></li>
			                      <li class="adminMain-li-writerdate lightdata"><c:out value="${notice.noticeUploadDate}" /></li>
			                    </ul>
			                  </a>
			                </li>
			                <!-- 데이터 끝 -->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="data-none">현재 작성된 공지가 없습니다.</div>
					</c:otherwise>
				</c:choose>

              </ul>
            </div>
            <!-- 테이블 형식 끝 -->
          </div>
          <!-- 공지 목록 끝 -->

        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>