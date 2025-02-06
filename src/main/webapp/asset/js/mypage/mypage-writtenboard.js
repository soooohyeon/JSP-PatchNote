
function getContextPath() {
   var hostIndex = location.href.indexOf(location.host) + location.host.length;
   var contextPath = location.href.substring(
     hostIndex,
     location.href.indexOf("/", hostIndex + 1)
   );
   return contextPath; // contextPath 반환   
}

function goPage(boardNum) {
	location.href =getContextPath()+"/board/boarddetail.bo?boardNum=" + boardNum;
}

// 페이지네이션 클릭시 페이지 이동
function movePage(page, keyword) {
	console.log("페이지 이동");
	/* 현재 페이지의 경로 */
	var pathName= window.location.pathname;
	
	if (keyword == null) {
		location.href = pathName + "?page=" + page;
	} else {
		location.href = pathName + "?keyword=" + keyword + "&&page=" + page;
	}
}