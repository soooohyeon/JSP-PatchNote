const searchInput = document.querySelector(".studylist-input-search");
const wrapper = document.querySelector(".studylist-div-wrapper");

// input이 포커스 될 때 wrapper에 클래스 추가
searchInput.addEventListener("focus", () => {
	wrapper.classList.add("focused");
});

// input이 포커스 해제될 때 wrapper에서 클래스 제거
searchInput.addEventListener("blur", () => {
	wrapper.classList.remove("focused");
});

// 카테고리 선택시 selected 클래스 추가
const categoryWrapper = document.querySelector(
	".studylist-div-categoryWrapper"
); // 상위 컨테이너 선택
const categoryList = document.querySelectorAll(".studylist-div-category"); // 모든 카테고리 요소 선택
categoryList.forEach((item) => {
	item.addEventListener("click", () => {
		// 현재 선택된 항목에서 selected 제거
		categoryWrapper.querySelector(".selected").classList.remove("selected");

		// 클릭된 항목에 selected 추가
		item.classList.add("selected");
	});
});

/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

/*//스터디 리스트에서 스터디를 선택하면
//해당 스터디 상세로 이동시키는 함수
  const studyList = document.querySelectorAll(".studylist-div-grouptitle");
  studyList.forEach((item) => {
	item.addEventListener("click", () => {
	  window.location.href = "studylist-detail.jsp"; // 이동
	});
  });
*/

/* 게시글 클릭시 상세페이지로 이동하는 함수 */
function moveDetail(studyNum) {
	console.log("studyList.js : moveDetail 함수 실행");
	window.location.href = getContextPath() + "/study/studyDetailOk.st?studyNum=" + studyNum; // 이동
}

//등록 버튼을 누르면 스터디 등록으로 이동
function registerStudy() {
	window.location.href = getContextPath() + "/study/studyWrite.st";
}

//찜 버튼을 누르면 채워진 하트로 이미지를 바꾸는 함수

function likeStudy(imgElement) {
	// 이미지의 현재 src를 확인해서 조건에 맞게 변경
	if (imgElement.src.includes('no-like.png')) {
		// 비운 하트를 눌렀을 때, 채운 하트로 변경
		imgElement.src = getContextPath() + "/asset/img/study/like.png";
	} else {
		// 채운 하트를 눌렀을 때, 다시 비운 하트로 변경
		imgElement.src = getContextPath() + "/asset/img/study/no-like.png";
	}

	//찜 카운트를 갱신
	// const likeCountElement = imgElement.nextElementSibling;
	// .studylist-div-likecount
	// let likeCount = parseInt(likeCountElement.textContent);

	// 찜 상태에 따라 카운트를 증가/감소시킵니다.
	// if (imgElement.src.includes('like-like.png')) {
	//   likeCount++;
	// } else {
	//   likeCount--;
	// }
	// likeCountElement.textContent = likeCount;

}

// 페이지네이션 클릭시 페이지 이동
function movePage(page, keyword) {
	console.log("페이지 이동 함수");
	/* 현재 페이지의 경로 */
	var pathName= window.location.pathname;
	
	if (keyword == null) {
		location.href = pathName + "?page=" + page;
	} else {
		location.href = pathName + "?keyword=" + keyword + "&&page=" + page;
	}
}

/* 비로그인 상태일 때 로그인 페이지로 이동 */
function goLogin() {
	alert("로그인 후 이용 부탁드립니다.");
	location.href = getContextPath() + "/login/login.me";
}