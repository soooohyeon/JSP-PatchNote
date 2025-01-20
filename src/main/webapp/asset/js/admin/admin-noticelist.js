// 각 공지의 ... 클릭 시 메뉴 펼쳐지기
const menuBtn = document.querySelectorAll('.adminNotice-img-menubtn');
const menubtnWrap = document.querySelectorAll('.adminNotice-div-buttonswrap');

menuBtn.forEach((btn, idx) => {
  btn.addEventListener("click", (e) => {
    // 열린 배너의 메뉴를 제외한 다른 메뉴는 전부 숨기기
    menubtnWrap.forEach((item) => {
      item.style.display = 'none';
    });
    // 클릭한 배너의 메뉴만 보이기
    btn.nextElementSibling.style.display = 'flex';
    console.log(btn.nextElementSibling.style.display);
  });
});

// 메뉴나 수정 삭제 외 버튼 클릭시 메뉴 닫기
document.addEventListener("click", (e) => {
  // 클릭한 요소의 클래스명이 아닐 경우
  if (!e.target.classList.contains('adminNotice-img-menubtn') && !e.target.classList.contains('adminBanner-a-button')) {
    // 메뉴 닫기
    menubtnWrap.forEach((item) => {
      item.style.display = 'none';
    });
  }
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
