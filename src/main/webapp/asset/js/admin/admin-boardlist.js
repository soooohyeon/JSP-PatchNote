// 삭제 버튼 클릭시
function clickDeleteBtn(event) {
  // 확인, 취소 버튼 선택
  const isdelete = confirm('정말 삭제하시겠습니까?');

  // 확인 버튼 클릭시
  if (isdelete) {
    // 해당 글 삭제 먼저 진행되어야 함
    // 삭제 후 알람
    alert('삭제가 완료되었습니다.');
  }
}