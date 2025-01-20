// 전송 버튼 클릭 이벤트 리스너
const idCheckButton = document.getElementById("JOIN-BTN-IDCHECK");
idCheckButton.addEventListener('click', (event) => {
  idCheck();
});

// 아이디 중복검사
function idCheck(){
	const idCheck = document.getElementById("JOIN-INPUT-ID").value;
	const result = document.getElementById("JOIN-DIV-IDCHECK");
  const exr = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,15}$/; // 첫 글자는 문자만 허용, 최대 15자

	
		if (!exr.test(idCheck)) {
			result.innerHTML = '중복된 아이디가 없습니다.';
			result.style.color = 'green';
		}else{
			result.innerHTML = '중복된 아이디가 있습니다.';
			result.style.color = 'red';
		}
	}


//글자수 제한 로직 - 아이디 
const inpSec3 = document.querySelector('#JOIN-INPUT-ID');

//글자수 제한 로직 - 아이디
function inputLenFunc3() {
	if (inpSec3.value.length > 10) {
			inpSec3.value = inpSec3.value.slice(0, 10);
	};
	console.log(inpSec3.value)
}
inpSec3.addEventListener('input', inputLenFunc3);



//닉네임 버튼 클릭함수
const nickNameCheckButton = document.getElementById("JOIN-BTN-NICKNAMECHECK");
nickNameCheckButton.addEventListener('click', (event) => {
  nickNameCheck();
});



// 닉네임 유효성 검사 함수
function nickNameCheck(){
	const nickNameCheck = document.getElementById("JOIN-INPUT-NICKNAMECHECK").value;
	const result = document.getElementById("JOIN-DIV-NICKNAMECHECK");
  const exr = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,15}$/; // 첫 글자는 문자만 허용, 최대 15자
	
	
		if (!exr.test(nickNameCheck)) {
			result.innerHTML = '중복된 아이디가 없습니다.';
			result.style.color = 'green';
		}else{
			result.innerHTML = '중복된 아이디가 있습니다.';
			result.style.color = 'red';
		}
	}

//글자수 제한 로직 - 닉네임
const inpSec2 = document.querySelector('#JOIN-INPUT-NICKNAMECHECK');

//글자수 제한 로직 - 닉네임
function inputLenFunc2() {
	if (inpSec2.value.length > 10) {
			inpSec2.value = inpSec2.value.slice(0, 10);
	};
	console.log(inpSec2.value)
}
inpSec2.addEventListener('input', inputLenFunc2);


//이름을 입력여부
function nameCheck(){
	const name = document.getElementById("JOIN-INPUt-ID").value; 
	const result = document.getElementById('JOIN-DIV-NAME');
	//정규식 글자제한
	const exr = /^[a-zA-Z가-힣][a-zA-Z가-힣0-9]{0,6}$/; // 첫 글자는 문자만 허용, 최대 15자

	// console.log("test"); 정상출력

	
		if(!exr.test(name)){
			// console.log(name)
			result.innerHTML = '이름을 입력하세요.';
			result.style.color = 'red';
		
			
		}else{
		
			
			result.innerHTML = '이름이 입력되었습니다.';
			result.style.color = 'green';

	}	
}


//생년월일 입력여부
function birthCheck(){
	const birth = document.getElementById("JOIN-INPUT-BIRTH").value;
	const result = document.getElementById('JOIN-DIV-BIRTH');

	//생년월일 숫자만 입력
	const exr = /^[9-9]*$/;
	
	// console.log("test"); 정상출력

		if(exr.test(birth)){
			
			result.innerHTML = '생년월일을 입력하세요.';
			result.style.color = 'red';
	
		}else{
			result.innerHTML = '생년월일이 입력되었습니다.';
			result.style.color = 'green';
		}
	}


// 비밀번호 일치여부 검사 
function validatePassword() {
	let password = document.getElementById("INPUT-PASSWORD").value; //password input태그 값
  let confirmPassword = document.getElementById("JOIN-REPASSWORD").value; //repassword input 태그 값
	let result = document.getElementById('JOIN-DIV-PWALARM'); //div 태그 공간

	//특수문자 및 영어 등등 가져와서 쓰는 정규식 (8자리부터 15자리 이하까지)
	const exr = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,15}$/;

	if (exr.test(password)) {
		if (password=== confirmPassword) {
			result.innerHTML = '비밀번호가 일치합니다.';
			result.style.color = 'green';
		}else{
			result.innerHTML = '비밀번호가 일치하지 않습니다.';
			result.style.color = 'red';
		}
	}else{
		result.innerHTML = '비밀번호는 최소 8자에서 15자까지, 영문자, 숫자 및 특수 문자를 포함해야 합니다.';
		result.style.color = 'red';
	}
}








//핸드폰 번호 변수
const phoneNumInput = document.getElementById('JOIN-INPUT-PHONNUMBER');
const sendButtonPhone = document.getElementById('JOIN-BTN-PHONNUMBER');
const resultPhone = document.getElementById('JOIN-DIV-PHONENUMBER');



sendButtonPhone.addEventListener('click', (event) => {
  event.preventDefault(); 
  validatePhoneNumber();
});

// 핸드폰 번호 시작
// 핸드폰 번호 자동 포맷팅 및 길이 제한
function formatPhoneNumber(event) {
  let phoneNum = phoneNumInput.value.replace(/[^\d]/g, ''); // 숫자만 칠수있게 하기

  if (phoneNum.length > 11) {
    phoneNum = phoneNum.slice(0, 11); // 11자리에서 넘어가면 타자못침
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
   

		resultPhone.innerHTML = '전화번호 양식이 아닙니다. 11자리를 입력해주세요.';
		resultPhone.style.color = 'red';
			return false;
  }

	resultPhone.innerHTML = '인증번호를 보냈습니다.';
	resultPhone.style.color = 'green';
  return true;
}





// 인증번호 확인 버튼 클릭 이벤트 리스너
const authenButton = document.getElementById("JOIN-BTN-AUTHENTICATIONNUMBER");
authenButton.addEventListener('click', (event) => {
  authenCheck();
});


const phoneNumchkInput = document.getElementById('JOIN-INPUT-AUTHENTICATIONNUMBER');
const sendButtonAuthentication = document.getElementById('JOIN-BTN-AUTHENTICATIONNUMBER');

// 인증번호 확인 클릭 함수
	function authenCheck() {
		const authenNumber = document.getElementById("JOIN-INPUT-AUTHENTICATIONNUMBER").value;
		const exr = /^[0-9]*$/; 
		if (exr.test(authenNumber)) {
    	alert('정상적으로 인증되었습니다.');

  	}else{
			alert('인증번호가 일치하지 않습니다.');
		}

 }


//글자수 제한 로직 - 생년월일
const inpSec = document.querySelector('#JOIN-INPUT-BIRTH');

// input 입력 글자수 제한하기 (number) - 생년월일
function inputLenFunc() {
    if (inpSec.value.length > 6) {
        inpSec.value = inpSec.value.slice(0, 6);
    };
    console.log(inpSec.value)
}
inpSec.addEventListener('input', inputLenFunc);




//글자수 제한 로직 - 인증번호 
const inpSec1 = document.querySelector('#JOIN-INPUT-AUTHENTICATIONNUMBER');

//글자수 제한 로직 - 인증번호 
function inputLenFunc1() {
	if (inpSec1.value.length > 6) {
			inpSec1.value = inpSec1.value.slice(0, 6);
	};
	console.log(inpSec1.value)
}
inpSec1.addEventListener('input', inputLenFunc1);

//체크박스 아이디 변수 저장
const all = document.querySelector('input.join-input-checkbox-big');
const terms = document.querySelectorAll('input.join-input-checkbox-small');

NodeList.prototype.map = Array.prototype.map;

//전체동의 체크박스를 클릭할 때마다 실행되는 이벤트 리스너
all.addEventListener('click', () => {
  terms.forEach((term) => {
    console.log(term);
    term.checked = all.checked;
  });
});

//약관동의 체크박스를 클릭할 때마다 실행되는 이벤트 리스너
terms.forEach((term)=>{
  term.addEventListener(`click`, () =>{
    all.checked = terms.map((term) => term.checked).filter((checked)=>checked).length === 2;

  })
});


//가입하기 눌렀을 때 main page 이동
function moveSite(){
	
	window.location.href = "./../main/main-logout.html";

}


