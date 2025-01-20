
//로그인버튼 클릭시 알림창 노출
const btn_join = document.querySelector("#LOGIN-BTN-LOGIN");

btn_join.addEventListener("click", (e)=>{
  if(true){
    alert("정상적으로 로그인이 되었습니다.");
    
  }else{
    alert("아이디 혹은 비밀번호가 일치하지 않습니다");
    
  }
});


//페이지 이동함수
function moveSite(){

	window.location.href = "./../main/main-logout.html";

}


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
    console.log("TEST"); //입력값 확인
	
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