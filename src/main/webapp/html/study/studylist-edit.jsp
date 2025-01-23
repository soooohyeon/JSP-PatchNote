<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>지식의 숲</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/study/studylist-edit.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
  </head>
  
  <body>
  
	<!-- 상단 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />
	
    <main>
      <!-- 페이지 타이틀 -->
      <h1 class="studylist-h1-title">STUDY 수정</h1>

      <!-- 전체 내용을 감싸는 래퍼-->
      <div class="studylist-div-contentsWrapper">
        <!-- 입력 폼을 감싸는 래퍼 -->
        <form id="STUDYLIST-FORM-WRITE"
        	action="${pageContext.request.contextPath}/study/studyUpdateOk.st"
			method="post">
          <!-- 한 행 -->
          <input type="hidden" name="studyNum" value="${study.getStudyNum()}">
          <div class="studylist-div-wrapperlayer">
            <!-- label과 input을 묶은 div -->
            <div class="studylist-div-infowrapper">
              <div class="label">제목</div>
              <input
                type="text"
                class="studylist-input-groupinfo"
                name="studyTitle"
                placeholder="스터디 그룹명을 입력해주세요."
                value="${study.getStudyTitle()}"
              />
            </div>
          </div>

          <div class="studylist-div-wrapperlayerDual">
            <div class="studylist-div-infowrapperDual">
              <div class="label">카테고리</div>
              <div class="studylist-div-categoryselectwrapper">
                <div class="studylist-div-categoryselector categoryselected">개발</div>
                <div class="studylist-div-categoryselector">보안</div>
              </div>
            </div>
            <div class="studylist-div-infowrapperDual">
              <div class="label">전화번호</div>
              <div class="studylist-div-phoneselectwrapper">
                <div class="studylist-div-shownumberselector phoneselected">
                  보이기
                </div>
                <div class="studylist-div-shownumberselector">숨기기</div>
              </div>
            </div>
          </div>
          <div class="studylist-div-wrapperlayerDual">
            <div class="studylist-div-infowrapperDual">
              <div class="label">정원 수</div>
              <input
                type="text"
                class="studylist-input-groupinfo"
                name="studyLimit"
                placeholder="정원 수를 입력해주세요."
                value="${study.getStudyLimit()}"
              />
            </div>
            <div class="studylist-div-infowrapperDual">
              <div class="label">신청 마감일</div>
              <input
              	type="text"
                class="studylist-input-groupinfo"
                placeholder="신청 마감일을 입력해주세요 ex) 20250110"
                name = "studyDeadline"
                value="${study.getStudyDeadline()}"
              />
            </div>
          </div>
          <div class="studylist-div-wrapperlayerDual">
            <div class="studylist-div-infowrapperDual">
              <div class="label">시작날짜</div>
              <input
                class="studylist-input-groupinfo"
                placeholder="시작날짜를 입력해주세요 ex) 20250110"
                name ="studyStartDay"
                value="${study.getStudyStartDay()}"
              />
            </div>
            <div class="studylist-div-infowrapperDual">
              <div class="label">종료날짜</div>
              <input
                class="studylist-input-groupinfo"
                placeholder="시작날짜를 입력해주세요 ex) 20250110"
                name="studyEndDay"
                value="${study.getStudyEndDay()}"
              />
            </div>
          </div>

          <div class="studylist-div-wrapperlayerDual">
            <div class="studylist-div-infowrapperDual">
              <div class="label">시작시간</div>
              <input
                class="studylist-input-groupinfo"
                type="time"
                placeholder="시작시간을 입력해주세요 ex) 20250110"
                name ="studyStartTime"
                value="${study.getStudyStartTime()}"
              />
            </div>
            <div class="studylist-div-infowrapperDual">
              <div class="label">종료시간</div>
              <input
                class="studylist-input-groupinfo"
                type="time"
                placeholder="종료시간를 입력해주세요 ex) 20250110"
                name="studyEndTime"
                value="${study.getStudyEndTime()}"
              />
            </div>
          </div>

          <div class="studylist-div-wrapperlayer">
            <div class="studylist-div-infowrapper">
              <div class="label">모임장소</div>
              <input
                type="text"
                class="studylist-input-groupinfo"
                name="studyLocation"
                placeholder="장소를 입력해주세요."
                value="${study.getStudyLocation()}"
              />
            </div>
          </div>

          <div class="studylist-div-longwrapperlayer">
            <div class="studylist-div-textareawrapper">
              <div class="label">설명</div>
              <textarea 
              placeholder="설명을 작성해주세요."
              name="studyDescript"
              class="studylist-div-studycontents">${study.getStudyDescript()}</textarea>
            </div>
            <div class="studylist-div-filewrap">
              <div class="label">첨부파일</div>
              <label id="STUDYLIST-INPUT-FILELABEL" for="STUDYLIST-INPUT-FILE">
                <input type="file" accept="image/*" id="STUDYLIST-INPUT-FILE" />
                <div class="studylist-div-filebtn">첨부</div>
              </label>
            </div>
          </div>
        </form>
        
        <div class="studylist-div-btnwrapper">
          <button
            class="studylist-btn-submit"
            form="STUDYLIST-FORM-WRITE"
            type="submit"
            onclick="updateStudy()"
          >
            등록
          </button>
          <button
            class="studylist-btn-cancel"
            form="STUDYLIST-FORM-WRITE"
            type="button"
            onclick="goBack()"
          >
            취소
          </button>
        </div>
      </div>
    </main>
    
	<jsp:include page="/html/main/footer.jsp" />
	
  </body>
  <script defer src="../../asset/js/study/studylist-edit.js"></script>
</html>
