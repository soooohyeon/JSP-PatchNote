
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
};

function goPage(studyNum) {
	location.href = getContextPath() + "/study/studyDetailOk.st?studyNum=?studyNum=" + studyNum;
}
// 페이지네이션 클릭시 페이지 이동
function movePage(page) {
  console.log("페이지 이동 요청됨, page:", page); // 디버깅용 콘솔 출력
  // 올바른 컨트롤러 경로로 baseUrl을 지정
  var baseUrl = getContextPath() + "/mypage/mypage-applylist.my";
  location.href = baseUrl + "?page=" + page;
}
