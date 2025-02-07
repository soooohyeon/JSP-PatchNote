function getContextPath() {
  var hostIndex = location.href.indexOf(location.host) + location.host.length;
  var contextPath = location.href.substring(
    hostIndex,
    location.href.indexOf("/", hostIndex + 1)
  );
  return contextPath; // contextPath 반환
}

function goPage(boardNum) {
  location.href =
    getContextPath() + "/board/boarddetail.bo?boardNum=" + boardNum;
}

// 페이지네이션 클릭시 페이지 이동
function movePage(page) {
  console.log("페이지 이동 요청됨, page:", page); // 디버깅용 콘솔 출력
  // 올바른 컨트롤러 경로로 baseUrl을 지정
  var baseUrl = getContextPath() + "/mypage/mypage-writtenboard.my";
  location.href = baseUrl + "?page=" + page;
}
