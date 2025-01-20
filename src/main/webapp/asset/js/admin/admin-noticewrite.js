
// 첨부파일 등록 시 파일명 표시
const imgNameArea = document.querySelector('#NOTICEIMAGE-NAME');
function changeImgName(e) {
  imgNameArea.textContent = e.files[0].name;
}

// 공지 등록 / 수정 시 - 제목이나 내용 없이 저장 버튼 클릭시 알람창 띄우기
function clickSaveBtn(e) {
  let noticeTitle = document.querySelector('#noticeTitle').value;
  let noticeCotent = document.querySelector('#noticeCotent').value;
  if (!noticeTitle ) {  // 제목 미입력시
    alert('제목을 입력해주세요.');
  } else if (!noticeCotent) {  // 공지 내용 미첨부시
    alert('내용을 입력해주세요.');
  } else {  // 제목, 공지 내용 값이 전부 입력됐을 때
      e.setAttribute("type", "submit");
  }
}

// 취소 버튼 클릭시 목록으로 되돌아가기
function clickCancelBtn() {
  history.back();
}