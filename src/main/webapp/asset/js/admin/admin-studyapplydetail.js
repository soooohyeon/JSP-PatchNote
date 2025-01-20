// 스터디 신청 관리 목록으로 되돌아가기 버튼
const backBannerList = document.querySelector('.adminDetail-span-backbtn');

backBannerList.addEventListener("click", () => {
  console.log("dd");
  history.back();
});

// 신청 취소(삭제) 버튼 클릭시
function cancelStudy() {
  let isCancel = confirm('해당 스터디 신청을 취소 하시겠습니까?');

  // 신청 취소에 동의하면 나오는 알람
  if (isCancel) {
    alert('취소되었습니다');
  }
}