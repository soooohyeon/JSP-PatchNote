// 신청취소 버튼 클릭시
function clickDeleteBtn(event) {
  // 확인, 취소 버튼 선택
  const isdelete = confirm('해당 스터디 신청을 취소 하시겠습니까?');

  // 확인 버튼 클릭시
  if (isdelete) {
    // 해당 글 취소기 먼저 진행되어야 함
    // 취소 후 알람
    alert('취소가 완료되었습니다.');
  }
}