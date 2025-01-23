<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>지식의 숲 - 관리자</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-studyapplydetail.css"/>
    <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-studyapplydetail.js"></script>
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

            <h1 class="admin-h1-detail">
              <span class="adminDetail-span-backbtn">&lt;</span>스터디 신청 관리
            </h1>

            <!-- 전체 내용을 감싸는 래퍼-->
            <div class="adminApply-div-contentsWrapper">

                <!-- 카테고리 -->
                <div class="adminApply-div-infowrapperDual">
                  <div class="label">카테고리</div>
                  <div class="adminApply-div-categoryselectwrapper">
					<c:choose>
					    <c:when test="${studyApply.studyCategory == 0}">
				                <div class="adminApply-div-categoryselector categoryselected">개발</div>
				                <div class="adminApply-div-categoryselector">보안</div>
				            </c:when>
					    <c:otherwise>
				                <div class="adminApply-div-categoryselector">개발</div>
				                <div class="adminApply-div-categoryselector categoryselected">보안</div>
						</c:otherwise>
					</c:choose>
                  </div>
                </div>

                <!-- 한 행 -->
                <div class="adminApply-div-wrapperlayer">
                  <!-- label과 input을 묶은 div -->
                  <div class="adminApply-div-infowrapper">
                    <div class="label">스터디 모임 제목</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyTitle}" />
                    </div>
                  </div>
                </div>

                <!-- 2개씩 나눠진 div layer -->
                <div class="adminApply-div-wrapperlayerDual">
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">모임 글 번호</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyNum}" />
					</div>
                  </div>
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">스터디 신청 번호</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyApplyNum}" />
                    </div>
                  </div>
                </div>

                <!-- 2개씩 나눠진 div layer -->
                <div class="adminApply-div-wrapperlayerDual">
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">정원 수</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyLimit}" /> 명
                    </div>
                  </div>
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">신청 마감일</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyDeadline}" />
                    </div>
                  </div>
                </div>

                <!-- 2개씩 나눠진 div layer -->
                <div class="adminApply-div-wrapperlayerDual">
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">시작 날짜</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyStartDay}" />
                    </div>
                  </div>
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">종료 날짜</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyEndDay}" />
                    </div>
                  </div>
                </div>

                <!-- 2개씩 나눠진 div layer -->
                <div class="adminApply-div-wrapperlayerDual">
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">시작 시간</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyStartTime}" />
                    </div>
                  </div>
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">종료 시간</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyEndTime}" />
                    </div>
                  </div>
                </div>

                <!-- 2개씩 나눠진 div layer -->
                <div class="adminApply-div-wrapperlayerDual">
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">신청 수락 여부</div>
                    <div class="adminApply-input-groupinfo">
	                    <c:choose>
							<c:when test="${studyApply.studyApplyStatus == 0}">대기 중</c:when>
							<c:when test="${studyApply.studyApplyStatus == 1}">수락</c:when>
							<c:otherwise>거절</c:otherwise>
	                    </c:choose>
                    </div>
                  </div>
                  <div class="adminApply-div-infowrapperDual">
                    <div class="label">신청일자</div>
                    <div class="adminApply-input-groupinfo">
                    	<c:out value="${studyApply.studyApplyDate}" />
                    </div>
                  </div>
                </div>


                <div class="adminApply-div-longwrapperlayer">
                  <div class="adminApply-div-contentwrapper">
                    <div class="label">한 줄 각오</div>
                    <div class="adminApply-div-studycontents">
                    	<c:out value="${studyApply.userDetermination}" />
                    </div>
                  </div>
                </div>
                
				<!-- 신청 수락 여부가 대기 중 일 때만 보이게 -->
				<c:if test="${studyApply.studyApplyStatus == 0}">
	              <div class="adminApply-div-btnwrapper">
	                <button class="adminApply-btn-submit" onclick="cancelStudy(${studyApply.studyApplyNum})">
	                  신청 취소
	                </button>
	              </div>
              </c:if>
            </div>
          </div>
        </main>
        <!-- 메인 컨텐츠 끝 -->
      </div>
      <!-- 헤더 + 메인 컨텐츠 끝 -->
    </div>
  </body>
</html>
