/* 루트 경로 담은 함수 */
function getContextPath() {
   var hostIndex = location.href.indexOf (location.host) + location.host.length;
   var contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1));
   
   return contextPath;
}

/*function noticedetailpage(){
  history.back();*/
function inventory(){
	window.location.href = getContextPath() + "/notice/noticelist.no"
}