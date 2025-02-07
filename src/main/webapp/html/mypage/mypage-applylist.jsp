<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>신청한 스터디</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/mypage/mypage-applylist.css"
    />
    <script
      defer
      src="${pageContext.request.contextPath}/asset/js/mypage/mypage-applylist.js"
    ></script>
    <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </head>
  <body>
    <!-- <header></header> -->

    <!-- 사이드 메뉴 -->
    <aside id="MYPAGE-MENUCONTAINER">
      <nav class="mypage-div-menuwrap">
        <h1 id="MYPAGE-H2-TITLE">마이 페이지</h1>
        <ul class="mypage-ul-menuwrap">
          <li>
            <a
              href="${pageContext.request.contextPath}/mypage/mypage-accountedit.my"
              >개인정보 수정</a
            >
          </li>
          <%--
          <li>
            <a
              href="${pageContext.request.contextPath}/mypage/mypage-jimlist.my"
              >찜한 목록</a
            >
          </li>
          --%>
          <li>
            <a
              href="${pageContext.request.contextPath}/mypage/mypage-hostboard.my"
              >만든 스터디</a
            >
          </li>
          <li class="mypage-li-menuactive">
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
    <!-- 사이드 메뉴 끝 -->

    <!-- 상단 헤더 -->
    <div id="ADMIN-DIV-HEADERCONTAINER">
      <img
        src="${pageContext.request.contextPath}/asset/img/main/logo.png"
        class="admin-img-logo"
        alt="Logo"
      />
      <ul id="ADMIN-UL-HEADERWRAP">
        <li>
          <a href="${pageContext.request.contextPath}/knowledgeForest.main"
            >홈</a
          >
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/login/logout.me"
            >로그아웃</a
          >
        </li>
      </ul>
    </div>

    <!-- 메인 컨텐츠가 들어갈 컨테이너 -->
    <div id="MYPAGE-DIV-LAYOUTCONTAINER">
      <main class="mypage-div-container">
        <!-- 현재 페이지 제목 -->
        <div class="mypage-h1-maintitle">
          <h1>신청한 스터디</h1>
        </div>
        <!-- 게시판 컨텐츠 정렬을 위한 div -->
        <div class="mypage-div-contentscontainer">
          <div class="mypage-div-contentswrap">
            <c:forEach var="study" items="${studyList}">
              <!-- 모임 항목 컨텐츠 -->
              <div class="mypage-div-group">
                <div class="mypage-div-groupinner">
                  <div class="mypage-div-groupinfowrapper datecontent-wrap">
                    <div class="mypage-div-enddate">
                      신청일 &nbsp;| &nbsp; ${study.studyApplyDate}
                    </div>
                    <!-- 마감, 모집 중 -->
                    <c:choose>
                      <c:when
                        test="${study.participants == study.studyLimit or study.studyDeadline < today}"
                      >
                        <li class="studylist-div-groupstatus">마감</li>
                      </c:when>
                      <c:otherwise>
                        <li class="studylist-div-groupstatus">모집 중</li>
                      </c:otherwise>
                    </c:choose>
                  </div>
                  <div class="mypage-div-grouptitle">
                    <a
                      href="${pageContext.request.contextPath}/study/studyDetailOk.st?studyNum=${study.studyNum}"
                      >${study.studyTitle}</a
                    >
                  </div>
                  <div class="mypage-div-groupinfowrapper">
                    <c:choose>
                      <c:when test="${study.studyCategory == 0}">
                        <div class="mypage-div-groupcategory">개발</div>
                      </c:when>
                      <c:when test="${study.studyCategory == 1}">
                        <div class="mypage-div-groupcategory">보안</div>
                      </c:when>
                    </c:choose>

                    <button
                      class="mypage-btn-cancel"
                      onclick="cancelAction(${study.studyNum})"
                    >
                      취소
                    </button>
                  </div>
                  <div class="mypage-div-groupmakerwrapper">
                    <div class="mypage-div-groupmaker">${study.userNick}</div>
                    <div class="mypage-div-likewrapper">
                      <div class="mypage-div-progress">
                        <c:choose>
                          <c:when test="${studyApplyStatus == 0}">
                            대기중
                          </c:when>
                          <c:when test="${studyApplyStatus == 1}">
                            수락
                          </c:when>
                          <c:when test="${studyApplyStatus == 2}">
                            거절
                          </c:when>
                        </c:choose>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
        <!-- 페이지네이션 -->
        <div class="mypage-div-paginationwrapper">
          <ul id="mypage-UL-PAGINATION">
            <c:if test="${prev}">
              <li
                class="mypage-li-paginationlist pre"
                onclick="movePage(${startPage - 1})"
              >
                &lt;
              </li>
            </c:if>

            <c:forEach var="i" begin="${startPage}" end="${endPage}">
              <c:choose>
                <c:when test="${!(i == page)}">
                  <li class="mypage-li-paginationlist" onclick="movePage(${i})">
                    <c:out value="${i}" />
                  </li>
                </c:when>
                <c:otherwise>
                  <li
                    class="mypage-li-paginationlist currentpage"
                    onclick="movePage(${i})"
                  >
                    <c:out value="${i}" />
                  </li>
                </c:otherwise>
              </c:choose>
            </c:forEach>

            <c:if test="${next}">
              <li
                class="mypage-li-paginationlist next"
                onclick="movePage(${endPage + 1})"
              >
                &#62;
              </li>
            </c:if>
          </ul>
        </div>
        <!-- 게시판 컨텐츠 정렬을 위한 div 끝 -->
      </main>
      <!-- 메인 컨텐츠 끝 -->
    </div>
  </body>
</html>
