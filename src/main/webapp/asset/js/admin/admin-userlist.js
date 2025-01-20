/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 탈퇴 버튼 클릭시
function quitBtn(userNum) {
	// 확인, 취소 버튼 선택
	const isdelete = confirm('해당 유저가 작성했던 모든 게시글과 댓글이 삭제됩니다.\n정말로 삭제하시곘습니까?');

	// 확인 버튼 클릭시
	if (isdelete) {
		$.ajax({
			/* 유저 삭제 컨트롤러로 이동, 유저 넘버 쿼리스트링으로 전달 */
			url: getContextPath() + "/admin/userDeleteOk.ad?userNum=" + userNum,
			type: "GET",
			/* 유저 탈퇴 성공 시 알람창 뜨면서 유저 목록 페이지 새로고침 */
			success: () => {
				alert('탈퇴가 완료되었습니다.');
				location.href = getContextPath() + "/admin/admin-userlist.ad";
			},
			/* 탈퇴 불가시 알람창 */
			error: (xhr, status, error) => {
				console.error("유저 탈퇴 실패:", error);
				alert("유저 탈퇴에 실패했습니다.");
			}
		});
	}
}