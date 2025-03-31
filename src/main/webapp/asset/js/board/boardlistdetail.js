/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 페이지네이션 클릭시 페이지 이동
function movePage(page, boardNum) {
	console.log("페이지 이동");
	/* 현재 페이지의 경로 */
	var pathName= window.location.pathname;
	
	location.href = pathName + "?boardNum=" + boardNum + "&&page=" + page;
}

//뒤로 가기 버튼을 눌렀을 때 이전 페이지로 이동
function goBack() {
  window.history.back();
}

// 글 수정을 눌렀을 때  alert, 글 수정 페이지로 이동
function updateBoard(boardNum) {
/*  if (
    confirm("글 수정시 첨부파일이 삭제 됩니다." + "\n" + "수정하시겠습니까?")
  ) {*/
  alert("수정 페이지로 이동합니다.");
	location.href = getContextPath() + "/board/boardEdit.bo?boardNum=" + boardNum;
  /*}*/
}
//글 삭제를 눌렀을 때 띄워지는 alert
function deleteBoard(boardNum) {
  if (confirm("해당 스터디 글을 삭제하시겠습니까?")) {
	$.ajax({
		/* 글 삭제 컨트롤러로 이동, 보드넘버를 쿼리스트링으로 전달 */
		url: getContextPath() + "/board/boardDeleteOk.bo?boardNum=" + boardNum,
		type: "GET",
		/* 글 삭제 성공 시 알람창 뜨면서 자유게시판 목록 페이지로 이동 */
		success: () => {
			alert('삭제가 완료되었습니다.');
			location.href = getContextPath() + "/board/boardlist.bo";
		},
		/* 삭제 불가시 알람창 */
		error: (xhr, status, error) => {
			console.error("삭제 실패:", error);
			alert("글 삭제에 실패했습니다.");
		}
	});
}


// 댓글 수정 함수
function updateComment() {
  if (confirm("댓글을 수정하시겠습니까?")) {
    // 수정 기능 구현 필요
  }
}
//댓글 삭제를 눌렀을 때 띄워지는 alert
function deleteComment() {
  if (confirm("해당 댓글을 삭제하시겠습니까?")) {
    //삭제 후 스터디 목록 화면으로 이동
    alert("해당 댓글이 삭제되었습니다.");
  } else {
    alert("취소되었습니다.");
  }
}

/**
 * 글자 수를 실시간 업데이트하는 함수
 * @param {HTMLElement} textarea - 텍스트 영역 요소
 * @param {number} maxCharacters - 최대 글자 수
 * @author 허준혁
 * @since 2025-01-13
 *
 */
function updateCharacterCount(textarea, maxCharacters) {
  // 데이터 속성을 기반으로 카운터 요소 가져오기
  console.log(textarea.dataset)
  const counterId = textarea.dataset.counter;
  const counter = document.getElementById(counterId);

  // 현재 입력된 글자 수 계산
  const currentLength = textarea.value.trim().length;

  // 카운터 업데이트
  counter.textContent = `${currentLength}/${maxCharacters}`;

// 200자 초과시 글자 입력 불가
  if(currentLength > maxCharacters){
    textarea.value = textarea.value.substring(0,maxCharacters);
    counter.textContent = `${maxCharacters}/${maxCharacters}`;
  }

}

  
  
}