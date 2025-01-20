// 유저 관리 목록으로 되돌아가기 버튼
const backUserList = document.querySelector('.adminUserDetail-span-backbtn');

backUserList.addEventListener("click", () => {
  history.back();
});

// 탈퇴 버튼 클릭시
function quitBtn(event) {
  // 확인, 취소 버튼 선택
  const isdelete = confirm('해당 유저가 작성했던 모든 게시글과 댓글이 삭제됩니다.\n정말로 삭제하시곘습니까?');

  // 확인 버튼 클릭시
  if (isdelete) {
    // 해당 글 삭제 먼저 진행되어야 함
    // 삭제 후 알람
    alert('탈퇴가 완료되었습니다.');
    location.href = "./admin-userlist.html";
  }
}