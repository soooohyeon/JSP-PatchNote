// 유저 관리 목록으로 되돌아가기 버튼
const backNoticeList = document.querySelector('.adminDetail-span-backbtn');

backNoticeList.addEventListener("click", () => {
	history.back();
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
			/* 공지 삭제 성공 시 알람창 뜨면서 유저 목록 페이지로 이동 */
			success: () => {
				alert('삭제가 완료되었습니다.');
				location.href = getContextPath() + "/admin/admin-noticelist.ad";
			},
			/* 삭제 불가시 알람창 */
			error: (xhr, status, error) => {
				console.error("공지 삭제 실패:", error);
				alert("공지 삭제 실패했습니다.");
			}
		});
	}
}

// 수정 버튼 클릭시
function clickUpdateBtn(noticeNum) {
	// 확인, 취소 버튼 선택
	const isEdit = confirm('수정하시게 되면 이미지가 사라집니다.\n수정하시겠습니까?');

	// 확인 버튼 클릭시
	if (isEdit) {
		location.href = getContextPath() + "/admin/admin-noticeupdate.ad?noticeNum=" + noticeNum;
	}
}

