//검색
const searchInput = document.querySelector(".boardlist-input-search");
const wrapper = document.querySelector(".boardlist-div-wrapper");


/* 루트 경로 담은 함수 */
function getContextPath() {
   var hostIndex = location.href.indexOf (location.host) + location.host.length;
   var contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1));
   
   return contextPath;
}


function movetodetailedpage(boardNum){
  window.location.href = getContextPath() + "/board/boarddetail.bo?boardNum=" + boardNum;
}

// input이 포커스 될 때 wrapper에 클래스 추가
searchInput.addEventListener("focus", () => {
  wrapper.classList.add("focused");
});

// input이 포커스 해제될 때 wrapper에서 클래스 제거
searchInput.addEventListener("blur", () => {
  wrapper.classList.remove("focused");
});

//비로그인시 writeInput에 이벤트를 클릭으로 주고  alret창을 띄움 그리고 로그인화면으로 이동
function notLogin(){
  window.location.href=getContextPath() + "/login/login.me";
};

/* 로그인일 때 글 작성 페이지로 이동 */
function goWrite(){
  window.location.href=getContextPath() + "/board/boardWrite.bo";
};

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