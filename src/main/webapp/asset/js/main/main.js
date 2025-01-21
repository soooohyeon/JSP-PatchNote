document.addEventListener("DOMContentLoaded", () => {
	const slides = document.querySelectorAll(".main-div-banner img");
	let currentIndex = 0;

	function showSlide(index) {
		slides.forEach((slide, i) => {
			slide.classList.remove("main-div-banneractive");
			if (i === index) {
				slide.classList.add("main-div-banneractive");
			}
		});
	}

	showSlide(currentIndex);

	setInterval(() => {
		currentIndex = (currentIndex + 1) % slides.length;
		showSlide(currentIndex);
	}, 3500);
});


/**
 * @feature 로그아웃 된 상태에서 스터디 항목을 클릭 했을 때, 로그인 페이지로 이동 시킵니다.
 * @see   goPage();
 * @author 강후현
 * @since 20250114
*  매개변수는 없고, 항목을 클릭했을때 실행되는 함수
*/

/*function clickLogo(){
	window.location.href = contextPath + "/login/main/main-logout.me";
	-> 추후 수정 예정
}
*/

// 스터디 글 클릭시 로그인 여부 확인 후 링크 이동
function notLogin() {
	// 비로그인일 때 스터디 글 클릭시
	alert("로그인 후 이용바랍니다.");
	// 비로그인 상태일때 로그인 페이지로 webapp/html이동
	window.location.href = contextPath + "/login/login.me";
}


/**
 * @feature 로그인 된 상태에서 스터디 항목을 클릭했을때, 그 상세 항목으로 이동합니다.
 * @see   notLogin();
 * @author 강후현
 * @since 20250114
 * @param {
 *  
 * } param
 * 
 * 매개 변수로 상세 페이지 id를 받습니다.
 *  
 */

function goPage(studyNum) {

	//  로그인 상태일때 스터디 상세페이지로 이동

	location.href = contextPath + "/login/login.me"; //<----이 링크는 추후 변경 될 수 있습니다.
}

// 비로그인 상태일 때 클릭 시 로그인 화면으로 이동

function wishList() {

	location.href = contextPath + "/login/login.me";
}


function goMain() {
	// 메인 페이지 이동 링크
	location.href = contextPath + "/knowledgeForest.main";
}