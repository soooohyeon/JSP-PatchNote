/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 로그아웃 클릭시 alert 띄우고 로그아웃 수행 
function logout() {
	fetch(getContextPath() + "/login/logout.me", { method: "GET" })
		.then(() => {
			alert('로그아웃 되었습니다.');
			location.href = getContextPath() + "/knowledgeForest.main";
		})
		.catch(error => {
			console.error("로그아웃 실패 : ", error);
			alert('로그아웃에 실패하였습니다.\n잠시 후 다시 시도해주세요');
		});
}

// --------------- 검색 ---------------
// 검색칸
const searchInput = document.querySelector(".admin-input-search");
const wrapper = document.querySelector(".admin-div-wrapper");

// input이 포커스 될 때 wrapper에 클래스 추가
searchInput.addEventListener("focus", () => {
	wrapper.classList.add("focused");
});

// input이 포커스 해제될 때 wrapper에서 클래스 제거
searchInput.addEventListener("blur", () => {
	wrapper.classList.remove("focused");
});

// ------------------------------------

// 페이지네이션 클릭시 페이지 이동
function movePage(page, keyword) {
	/* 현재 페이지의 경로 */
	var pathName = window.location.pathname;

	if (keyword == null) {
		location.href = pathName + "?page=" + page;
	} else {
		location.href = pathName + "?keyword=" + keyword + "&&page=" + page;
	}
}