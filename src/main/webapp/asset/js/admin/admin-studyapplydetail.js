// 스터디 신청 관리 목록으로 되돌아가기 버튼
const backBannerList = document.querySelector('.adminDetail-span-backbtn');

backBannerList.addEventListener("click", () => {
  console.log("dd");
  history.back();
});

/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 신청 취소(삭제) 버튼 클릭시
function cancelStudy(applyNum) {
  let isCancel = confirm('해당 스터디 신청을 취소 하시겠습니까?');

  // 신청 취소에 동의하면 나오는 알람
  if (isCancel) {
	  $.ajax({
	  	/* 신청 삭제 컨트롤러로 이동, 신청 넘버 쿼리스트링으로 전달 */
	  	url: getContextPath() + "/admin/admin-studyapplyDeleteOk.ad?applyNum=" + applyNum,
	  	type: "GET",
	  	/* 신청 삭제 성공 시 알람창 뜨면서 신청 목록 페이지 새로고침 */
	  	success: () => {
			console.log("dfsdfsd");
	  		alert('신청이 취소되었습니다.');
	  		location.href = getContextPath() + "/admin/admin-studyapplylist.ad";
	  	},
	  	/* 신청 삭제 불가시 알람창 */
	  	error: (xhr, status, error) => {
	  		console.error("신청 취소 실패:", error);
	  		alert("신청 취소가 실패했습니다.");
	  	}
	  });
  }
}