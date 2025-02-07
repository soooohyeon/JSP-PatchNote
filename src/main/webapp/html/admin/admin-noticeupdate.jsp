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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/admin/admin-write.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/admin/admin-noticewrite.js"></script>
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
          
          <!-- 현재 페이지 제목 -->
          <h1 class="admin-h1-detailtitle">공지 수정</h1>
          
          <!--  폼 시작 -->
          <form action="admin-noticeupdateOk.ad" method="post" enctype="multipart/form-data">
            <!-- 공지 데이터 입력하는 부분 -->
            <div class="adminWrite-div-formwrapper">
				
				<!-- 공지 번호를 받기 위해 사용 -->
				<input type="hidden" name="noticeNum" value="${notice.noticeNum}">
				
              <!-- 공지 제목 -->
              <div class="adminWrite-div-datawrap">
                <div class="adminWrite-div-title">
                  <div class="titlewrap">제목</div>
                </div>
                <div class="adminWrite-div-content">
                  <div class="inputwrap">
                    <input type="text" name="noticeTitle" id="noticeTitle" class="inputStyle"
						placeholder="공지 제목을 입력하세요." value="${notice.noticeTitle}">
                  </div>
                </div>
              </div>
              <!-- 공지 본문 -->
              <div class="adminNoticeWrite-div-wrap">
                <!-- 내용 입력 -->
                <div class="adminWrite-div-datawrap">
                  <div class="adminWrite-div-title">
                    <div class="titlewrap">내용</div>
                  </div>
                  <div class="adminWrite-div-content">
                    <div class="inputwrap">
                      <textarea name="noticeContents" id="noticeContents" class="inputStyle" placeholder="공지 내용을 입력하세요."><c:out value="${notice.noticeContents}" /></textarea>
                    </div>
                  </div>
                </div>
                <!-- 이미지 첨부 -->
                <div class="adminWrite-div-datawrap">
                  <div class="adminWrite-div-title">
                    <div class="titlewrap">첨부파일</div>
                  </div>
                  <div class="adminWrite-div-content">
                    <div class="inputwrap fileBtn">
                      <span id="NOTICEIMAGE-NAME"></span>
                      <label for="noticeImg" class="admin-btn">파일 첨부</label>
                      <input type="file" name="noticeImage" id="noticeImg" accept="image/*" onchange="changeImgName(this)">
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- 저장, 취소 버튼 부분 -->
            <div id="ADMINWRITE-DIV-BTNWRAP">
              <button type="button" class="admin-btn btn-save" onclick="clickSaveBtn(this)">저장</button>
              <button type="button" class="admin-btn btn-cancel" onclick="clickCancelBtn()">취소</button>
            </div>

          </form>

        </div>
      </main>
      <!-- 메인 컨텐츠 끝 -->
      
    </div>
    <!-- 헤더 + 메인 컨텐츠 끝 -->

  </div>

</body>
</html>