/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

//로그인버튼 클릭시 알림창 노출
const btn_join = document.querySelector("#LOGIN-BTN-LOGIN");
function login(){
	const id = document.getElementById("LOGIN-INPUT-ID").value;
	const pw = document.getElementById("LOGIN-INPUT-PWD").value;
	
	if(!id || !pw){
		alert("아이디 또는 비밀번호를 입력해주세요.");
	}

		$.ajax({
			url: getContextPath() + "/login/loginOk.me",
			type: "POST",
			data: {
				userId : id,
				userPw : pw,
			},
			// 로그인 성공 시 알람창 뜨면서 유저 목록 페이지로 이동 
			success: (response) => {
				console.log("response:", response, typeof response);
				const userNo = parseInt(response.trim()); // ← r, 개행 등 제거
				console.log("userNo:", userNo);
					
				if(response === "1") {
					alert('로그인 되었습니다.');
					location.href = getContextPath() + "/knowledgeForest.main";
				} else {
					alert('아이디 또는 비밀번호를 확인해주세요.');
					location.href = getContextPath() + "/login/login.me";
				}
			},
			// 로그인 불가시 알람창 
			error: (xhr, status, error) => {
				console.error("로그인 실패:", error);
				alert("로그인 실패했습니다.");
				location.href = getContextPath() + "/login/login.me";
			}
		});
	
}


//페이지 이동함수
/*function moveSite(){

	window.location.href = "./../main/main-logout.html";

}*/


// 아이디 입력조건
function idCheck(){
	const idCheck = document.getElementById("LOGIN-INPUT-ID").value;
	
  const exr = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,10}$/; // 첫 글자는 문자만 허용, 최대 15자
    //console.log("TEST"); //입력값 확인
	
		if (!exr.test(idCheck)) {
			//console.log(idCheck); //값 출력확인
		}else{
		
		}
	}


//글자수 제한 로직 - 아이디 
const inpSec2 = document.querySelector('#LOGIN-INPUT-ID');

//글자수 제한 로직 - 아이디
function inputLenFunc2() {
	if (inpSec2.value.length > 10) {
			inpSec2.value = inpSec1.value.slice(0, 10);
	};
	console.log(inpSec2.value)
}
inpSec2.addEventListener('input', inputLenFunc2);

// 비밀번호 입력조건
function pwdCheck(){
	const pwdCheck = document.getElementById("LOGIN-INPUT-PWD").value;
	
  const exr = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,15}$/; // 첫 글자는 문자만 허용, 최대 15자
    //console.log("TEST"); //입력값 확인
	
		if (!exr.test(pwdCheck )) {
			//console.log(pwdCheck); //값 출력확인
		}else{
		
		}
	}

//글자수 제한 로직 - 비밀번호 
const inpSec = document.querySelector('#LOGIN-INPUT-PWD');

//글자수 제한 로직 - 비밀번호
function inputLenFunc1() {
	if (inpSec.value.length > 15) {
			inpSec.value = inpSec.value.slice(0, 15);
	};
	console.log(inpSec.value)
}
inpSec.addEventListener('input3', inputLenFunc1);