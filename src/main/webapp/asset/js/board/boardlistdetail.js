//뒤로 가기 버튼을 눌렀을 때 이전 페이지로 이동
function goBack() {
  window.history.back();
}

// 글 수정을 눌렀을 때  alert, 글 수정 페이지로 이동
function updateStudy() {
  if (
    confirm("글 수정시 첨부파일이 삭제 됩니다." + "\n" + "수정하시겠습니까?")
  ) {
    alert("수정 페이지로 이동합니다.");
  }
}
//글 삭제를 눌렀을 때 띄워지는 alert
function deleteStudy() {
  if (confirm("해당 스터디 글을 삭제하시겠습니까?")) {
    //삭제 후 스터디 목록 화면으로 이동

    alert("해당 스터디 글이 삭제되었습니다.");
    window.location.href = "studylist.html"; // 이동
  } else {
    alert("취소되었습니다.");
  }
}
// 댓글 등록
function writeComment() {
  let comment = document.getElementById("BOARDLISTDETAIL-TEXTAREA-COMMENT").value;
  if (comment == "") {
    alert("댓글을 입력해주세요");
  } else {
    alert("댓글을 등록하였습니다.");
  }
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
// 스터디 신청시 모달 띄우기
function applyStudy() {
  document.getElementById("BOARDLISTDETAIL-MODAL-APPLY").style.display = "block";
}
//스터디 취소 버튼 클릭시 띄워지는 alert
function cancelStudy() {
  if (confirm("해당 스터디를 취소하겠습니까?")) {
    alert("해당 스터디가 취소 되었습니다.");
  }
}
//modal 닫기
function closeModal() {
  document.getElementById("BOARDLISTDETAIL-MODAL-APPLY").style.display = "none";
}
//각오 등록
function writeCourage() {
  //각오를 입력했는지 여부를 판단
  let courage = document.getElementById("BOARDLISTDETAIL-TEXTAREA-COURAGE").value;
  let disclaimer = document.getElementById("BOARDLISTDETAIL-CHECKBOX-AGREE").checked;

  if (courage === "") {
    alert("각오를 입력해주세요.");
    return;
  }
  //면책 사항 동의 여부를 판단
  console.log(disclaimer);
  if (disclaimer === false) {
    alert("주의사항 체크 후 진행바랍니다.");
    return;
  }

  alert("신청이 완료되었습니다.");
}
