<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>지식의 숲</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/board/boardlistregistration.css"
    />

    <script
      defer
      src="${pageContext.request.contextPath}/asset/js/board/boardlistregistration.js"
    ></script>
  </head>

  <body>
   <!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />
    <main>
      <!-- 페이지 타이틀 -->
      <h1 class="board-h1-title">게시글 등록</h1>

      <!-- 전체 내용을 감싸는 래퍼-->
      <div class="board-div-contentsWrapper">
        <!-- 입력 폼을 감싸는 래퍼 -->
        <form id="board-FORM-WRITE">
          <!-- 한 행 -->
          <div class="board-div-wrapperlayer">
            <!-- label과 input을 묶은 div -->
            <div class="board-div-infowrapper">
              <div class="label">제목</div>
              <input
                type="text"
                class="board-input-groupinfo"
                name="boardlistName"
                placeholder="제목을 입력해주세요"
              />
            </div>
          </div>

          <div class="board-div-longwrapperlayer">
            <div class="board-div-textareawrapper">
              <div class="label">설명</div>
              <textarea
                class="board-div-studycontents"
                name="boardDescription"
              ></textarea>
            </div>
            <div class="board-div-filewrap">
              <div class="label">첨부파일</div>
              <label id="BOARD-INPUT-FILELABEL" for="BOARD-INPUT-FILE">
                <input type="file" name="file" accept="image/*" id="BOARD-INPUT-FILE" />
                <div class="board-div-filebtn">첨부</div>
              </label>
            </div>
          </div>
        </form>

        <div class="board-div-btnwrapper">
          <button
            class="board-btn-submit"
            form="board-FORM-WRITE"
            onclick="updateBoard()"
          >
            등록
          </button>
          <button
            class="board-btn-cancel"
            form="board-FORM-WRITE"
            onclick="goBack()"
          >
            취소
          </button>
        </div>
      </div>
    </main>

	<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp"/>

  </body>
</html>
