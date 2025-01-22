
/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(
		hostIndex,
		location.href.indexOf("/", hostIndex + 1)
	);

	return contextPath;
}


function cancelAction(studyNum) {
	$.ajax({
		url:
			getContextPath() +
			"/mypage/mypage-cancelStudy.my?studyNum=" + studyNum,
		type: "GET",
		success: () => {
			if (confirm("스터디 신청을 취소하시겠습니까?")) {
				alert("스터디 취소가 완료되었습니다.");
				location.href = getContextPath() + "/mypage/mypage-applylist.my";
			}
		},
		error: (xhr, status, error) => {
			console.error("스터디 취소 실패:", error);
			alert("스터디 취소에 실패했습니다.");
		},
	});
}