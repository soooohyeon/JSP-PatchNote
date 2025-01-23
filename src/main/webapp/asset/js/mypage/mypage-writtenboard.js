/**
 * 
 */
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
