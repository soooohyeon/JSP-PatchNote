// 각 배너의 ... 클릭 시 메뉴 펼쳐지기
const menuBtn = document.querySelectorAll('.adminBanner-img-menubtn');
const menubtnWrap = document.querySelectorAll('.adminBanner-div-buttonswrap');

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
  if (!e.target.classList.contains('adminBanner-img-menubtn') && !e.target.classList.contains('adminBanner-a-button')) {
    // 메뉴 닫기
    menubtnWrap.forEach((item) => {
      item.style.display = 'none';
    });
  }
});

/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 수정 버튼 클릭시
function clickUpdateBtn(event, bannerNum) {
	event.preventDefault();
	// 확인, 취소 버튼 선택
	const isEdit = confirm('수정하시게 되면 이미지가 사라집니다.\n수정하시겠습니까?');

	// 확인 버튼 클릭시
	if (isEdit) {
		location.href = getContextPath() + "/admin/admin-bannerupdate.ad?bannerNum=" + bannerNum;
	}
}
	
// 삭제 버튼 클릭시
function clickDeleteBtn(event, bannerNum) {
	event.preventDefault();
  // 확인, 취소 버튼 선택
  const isdelete = confirm('정말 삭제하시겠습니까?');

  // 확인 버튼 클릭시
  if (isdelete) {
	  $.ajax({
	  	/* 배너 삭제 컨트롤러로 이동, 배너 넘버 쿼리스트링으로 전달 */
	  	url: getContextPath() + "/admin/admin-bannerDeleteOk.ad?bannerNum=" + bannerNum,
	  	type: "GET",
	  	/* 배너 삭제 성공 시 알람창 뜨면서 배너 목록 페이지로 이동 */
	  	success: () => {
	  		alert('삭제가 완료되었습니다.');
	  		location.href = getContextPath() + "/admin/admin-bannerlist.ad";
	  	},
	  	/* 삭제 불가시 알람창 */
	  	error: (xhr, status, error) => {
	  		console.error("배너 삭제 실패:", error);
	  		alert("배너 삭제 실패했습니다.");
	  	}
	  });
  }
}