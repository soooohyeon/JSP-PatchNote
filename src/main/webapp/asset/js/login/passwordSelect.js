const btn_check = document.getElementById("PASSWORDSELECT-BTN-CHECK");

btn_check.addEventListener("click", (event)=>{
  if(false){
    alert("인증번호가 일치합니다.");
 
  }else{
    alert("인증번호가 일치하지 않습니다.");
    
  }
});

//핸드폰 번호 변수
const phoneNumInput = document.getElementById('PASSWORDSELECT-INPUT-PHONENUMBER');
const sendButtonPhone = document.getElementById('PASSWORDSELECT-BTN-SEND');

sendButtonPhone.addEventListener('click', (event) => {
  event.preventDefault(); 
  validatePhoneNumber();
});

// 핸드폰 번호 시작
// 핸드폰 번호 자동 포맷팅 및 길이 제한
function formatPhoneNumber() {
  let phoneNum = phoneNumInput.value.replace(/[^\d]/g, ''); // 숫자만 칠수있게 하기
console.log("######################"+phoneNum);
  if (phoneNum.length > 11) {
    phoneNum = phoneNum.slice(0, 11); // 11자리에서 넘어가면 타자못침
	consoel.log("!!!!!!!!!!!!"+phoneNum);
  }

  // '000-0000-0000' 형태로 변환
  if (phoneNum.length > 7) {
    phoneNum = phoneNum.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
  } else if (phoneNum.length > 3) {
    phoneNum = phoneNum.replace(/(\d{3})(\d{4})?/, '$1-$2');
  }

  phoneNumInput.value = phoneNum;
}

// 입력 이벤트: 사용자가 타자를 칠 때마다 호출
 phoneNumInput.addEventListener('input', formatPhoneNumber);

// 전송 버튼 클릭 이벤트
function validatePhoneNumber() {
  const phoneNum = phoneNumInput.value.replace(/[^\d]/g, ''); // 숫자만 남기기

  if (phoneNum.length !== 11) {
  
		alert('전화번호 양식이 아닙니다. 11자리를 입력해주세요.');
		
			return false;
  }
	  alert ('인증번호를 보냈습니다.');
  return true;
}




//글자수 제한 로직 - 인증번호 

//글자수 제한 로직 - 인증번호 
function inputLenFunc6() {
	const inpSec5 = document.querySelector('#PASSWORDSELECT-AUTHENTICATIONNUMBER');
	if (inpSec5.value.length > 6) {
			inpSec5.value = inpSec5.value.slice(0, 6);
	};
	console.log(inpSec5.value)
}
inpSec5.addEventListener('input', inputLenFunc6);



// 아이디 입력조건
function idCheck(){
	const idCheck = document.getElementById("PASSWORDSELECT-INPUT-ID").value;
	
  const exr = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,10}$/; // 첫 글자는 문자만 허용, 최대 15자
    
	
		if (!exr.test(idCheck)) { //거짓일 때
      console.log("TEST"); //입력값 확인
	  
		}else{
		 console.log("abc"); //입력값 확인
		}
	}


//글자수 제한 로직 - 아이디 
const inpSec2 = document.querySelector('#PASSWORDSELECT-INPUT-ID');

//글자수 제한 로직 - 아이디
function inputLenFunc2() {
	if (inpSec2.value.length > 10) {
			inpSec2.value = inpSec1.value.slice(0, 10);
	};
	console.log(inpSec2.value)
}
inpSec2.addEventListener('input', inputLenFunc2);