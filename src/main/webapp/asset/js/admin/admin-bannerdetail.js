// 배너 관리 목록으로 되돌아가기 버튼
const backBannerList = document.querySelector('.adminDetail-span-backbtn');

backBannerList.addEventListener("click", () => {
  console.log("dd");
  history.back();
});

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

// 수정 버튼 클릭시
function clickUpdateBtn(event) {
  // 확인, 취소 버튼 선택
  const isdelete = confirm('수정하시게 되면 이미지가 사라집니다.\n수정하시겠습니까?');

  // 확인 버튼 클릭시
  if (isdelete) {
    location.href = "./admin-bannerupdate.html";
  }
}

