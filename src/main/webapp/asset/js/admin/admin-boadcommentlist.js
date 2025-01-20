// 삭제 버튼 클릭시
function clickDeleteBtn(event) {
  // 확인, 취소 버튼 선택
  const isdelete = confirm('해당 댓글을 삭제 하시겠습니까?');

  // 확인 버튼 클릭시
  if (isdelete) {
    // 해당 댓글 삭제 먼저 진행되어야 함
    // 삭제 후 알람
    alert('삭제가 완료되었습니다.');
  }
}

// 댓글 내용 클릭시 댓글 내용 전체 보이기
const commentContent = document.querySelectorAll('.commentcontent');
commentContent.forEach((comment) => {
  // 해당 코멘트의 전체를 보여주는 div 선택
  let commentAll = comment.parentNode.nextElementSibling;
  let allBtn = comment.childNodes[3];
  comment.addEventListener("click", () => {
    // 해당 클래스가 없다면 부여 / 있으면 제거
    commentAll.classList.toggle('active');
    allBtn.classList.toggle('rotateBtn');
  });
  
  // 코멘트 글 눌러도 제거
  commentAll.addEventListener("click", () => {
    // 해당 클래스가 없다면 부여 / 있으면 제거
    commentAll.classList.toggle('active');
    allBtn.classList.toggle('rotateBtn');
  });
});
