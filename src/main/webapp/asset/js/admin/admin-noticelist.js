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


/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 삭제 버튼 클릭시
function clickDeleteBtn(noticeNum) {
	// 확인, 취소 버튼 선택
	const isdelete = confirm('정말 삭제하시겠습니까?');

	// 확인 버튼 클릭시
	if (isdelete) {
		$.ajax({
			/* 공지 삭제 컨트롤러로 이동, 공지 넘버 쿼리스트링으로 전달 */
			url: getContextPath() + "/admin/admin-noticeDeleteOk.ad?noticeNum=" + noticeNum,
			type: "GET",
			/* 유저 탈퇴 성공 시 알람창 뜨면서 유저 목록 페이지로 이동 */
			success: () => {
				alert('삭제가 완료되었습니다.');
				location.href = getContextPath() + "/admin/admin-noticelist.ad";
			},
			/* 탈퇴 불가시 알람창 */
			error: (xhr, status, error) => {
				console.error("공지 삭제 실패:", error);
				alert("공지 삭제 실패했습니다.");
			}
		});
	}
}
