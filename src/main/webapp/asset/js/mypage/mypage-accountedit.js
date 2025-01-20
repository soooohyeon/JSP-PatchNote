//닉네임 유효성 변수
const nicknameInput = document.getElementById("nickname");
const nicknameError = document.getElementById("nickname-error");
const identifyBtn = document.querySelector(".mypage-btn-nickname");
const regex = /^[a-zA-Z가-힣][a-zA-Z가-힣0-9]{0,14}$/; // 첫 글자는 문자만 허용, 최대 15자

//비밀번호 유효성 변수
const passwordInput = document.getElementById("password");
const passwordchkInput = document.getElementById("passwordchk");
const passwordError = document.getElementById("password-error");
const passwordchkError = document.getElementById("passwordchk-error");

//핸드폰 번호 변수
const phoneNumInput = document.getElementById("phoneNum");
const phoneNumchkInput = document.getElementById("phoneNumchk");
const sendButton = document.querySelector(".mypage-btn-phoneNum-send");

//저장 버튼
const saveButton = document.querySelector(".mypage-btn-edit");

// 전역 변수로 선언
//유효성 검사 Flag
let nickCheckFlag = false;
let pwFlag = false;
let pwCheckFlag = false;
let phoneCheckFlag = false;

// 닉네임 유효성 검사 함수
// function validateNickname() {
//   const nickname = nicknameInput.value;
//   const regex = /^[a-zA-Z가-힣][a-zA-Z가-힣0-9]{0,14}$/; // 첫 글자는 문자만 허용, 최대 15자

//   if (!regex.test(nickname)) {
//     alert("잘못된 닉네임입니다. 다시 입력해주세요!");
//     nicknameError.textContent =
//       "닉네임은 첫 글자가 숫자가 될 수 없으며, 한글, 영어, 숫자만 사용할 수 있습니다. 최대 15자까지 입력 가능합니다.";
//     nicknameError.style.color = "red"; // 오류 메시지 빨간색
//     nicknameInput.style.borderColor = "red"; // 입력 필드 테두리 빨간색
//   } else {
//     nicknameError.textContent = "사용 가능한 닉네임입니다.";
//     nicknameError.style.color = "green"; // 메시지 초록색
//     nicknameInput.style.borderColor = "green"; // 입력 필드 테두리 초록색

//     nickCheckFlag = true;
//     console.log(nickCheckFlag);
//   }
// }

function validateNickname() {
  const nickname = nicknameInput.value;
  const regex = /^[a-zA-Z가-힣][a-zA-Z가-힣0-9]{0,14}$/; // 첫 글자는 문자만 허용, 최대 15자

  if (true) {  //조건식 : DB조회 후 중복된 값이 없을 때
    if(regex.test(nickname)) {
      nicknameError.textContent = "사용 가능한 닉네임입니다.";
      nicknameError.style.color = "green"; // 메시지 초록색
      nicknameInput.style.borderColor = "green"; // 입력 필드 테두리 초록색
  
      nickCheckFlag = true;
      console.log(nickCheckFlag);
    } else {
      nicknameError.textContent =
        "닉네임은 첫 글자가 숫자가 될 수 없으며, 한글, 영어, 숫자만 사용할 수 있습니다. 최대 15자까지 입력 가능합니다.";
      nicknameError.style.color = "red"; // 오류 메시지 빨간색
      nicknameInput.style.borderColor = "red"; // 입력 필드 테두리 빨간색
    }
  } else {
    alert("중복된 닉네임이 있습니다.");
  }
}

// nickdupChkButton.addEventListener("click", function () {
//   nickname = nicknameInput.value;

//   if (!regex.test(nickname)) {
//     alert("잘못된 닉네임입니다. 다시 입력해주세요!"); // alert 추가
//   } else {
//     alert("올바른 형식의 닉네임입니다.");
//     if (true) {
//       nicknameError.textContent = "사용 가능한 닉네임입니다.";
//       nicknameError.style.color = "green"; // 메시지 초록색
//       nicknameInput.style.borderColor = "green"; // 입력 필드 테두리 초록색
//     } else {
//       nicknameError.textContent = "중복된 닉네임 입니다.";
//       nicknameError.style.color = "red"; // 메시지 초록색
//       nicknameInput.style.borderColor = "red"; // 입력 필드 테두리 초록색
//     }
//   }
// });


// 전송 버튼 클릭 이벤트 리스너
// identifyBtn.addEventListener("click", (event) => {
//   event.preventDefault();
//   duplicateNickname();
// });

// 입력 이벤트 리스너
// nicknameInput.addEventListener('input', validateNickname);

//닉네임 끝

//비밀번호 시작
// 비밀번호 실시간 유효성 검사 함수
function validatePasswordLive() {
  const password = passwordInput.value;
  const regex =
    /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;

  if (!regex.test(password)) {
    if (password.length < 8) {
      passwordError.textContent = "비밀번호는 최소 8자 이상이어야 합니다.";
    } else if (password.length > 20) {
      passwordError.textContent = "비밀번호는 최대 20자까지 입력 가능합니다.";
    } else if (!/[A-Z]/.test(password)) {
      passwordError.textContent =
        "비밀번호에는 최소 하나의 대문자가 포함되어야 합니다.";
    } else if (!/[a-z]/.test(password)) {
      passwordError.textContent =
        "비밀번호에는 최소 하나의 소문자가 포함되어야 합니다.";
    } else if (!/\d/.test(password)) {
      passwordError.textContent =
        "비밀번호에는 최소 하나의 숫자가 포함되어야 합니다.";
    } else if (!/[@$!%*?&]/.test(password)) {
      passwordError.textContent =
        "비밀번호에는 최소 하나의 특수문자가 포함되어야 합니다.";
    } else {
      passwordError.textContent = "알 수 없는 오류가 발생했습니다.";
    }
    passwordError.style.color = "red";
    passwordInput.style.borderColor = "red"; // 입력 필드에 빨간 테두리 추가
    pwFlag = false;
  } else {
    passwordError.textContent = "사용 가능한 비밀번호입니다.";
    passwordError.style.color = "green"; // 메시지 색상을 초록색으로 변경
    passwordInput.style.borderColor = "green"; // 입력 필드에 초록색 테두리 추가
    pwFlag = true;
  }
  
  validatePasswordCheck(); // 비밀번호 변경 시 비밀번호 확인 실시간 검사
}

// 비밀번호 확인 유효성 검사 함수
function validatePasswordCheck() {
  const passwordField = document.getElementById("password");
  const passwordChkField = document.getElementById("passwordchk");
  const passwordChkError = document.getElementById("passwordchk-error");

  if (passwordChkField.value === "") {
    passwordChkError.textContent = ""; // 입력이 비어 있을 때 메시지 없음
  } else if (passwordChkField.value === passwordField.value) {
    passwordChkError.textContent = "동일한 비밀번호 입니다"; // 비밀번호가 동일
    passwordChkError.style.color = "green";

    pwCheckFlag = true;
    console.log("passwordCheckFlag:", pwCheckFlag);
  } else {
    passwordChkError.textContent = "비밀번호가 다릅니다"; // 비밀번호가 다름
    passwordChkError.style.color = "red";
  }
}

// DOMContentLoaded 이벤트가 발생하면 초기화 함수 실행
document.addEventListener("DOMContentLoaded", function () {
  passwordInput = document.getElementById("password");
  passwordChkField = document.getElementById("passwordchk");
  passwordError = document.getElementById("password-error");
  passwordChkError = document.getElementById("passwordchk-error");

  // 비밀번호 실시간 검사 이벤트 등록
  passwordInput.addEventListener("input", validatePasswordLive);

  // 비밀번호 확인 실시간 검사 이벤트 등록
  passwordChkField.addEventListener("input", validatePasswordCheck);
});

// 비밀번호 확인 입력칸 초기화 함수
function initializePasswordCheck() {
  const passwordField = document.getElementById("password");
  const passwordChkField = document.getElementById("passwordchk");
  const passwordChkError = document.getElementById("passwordchk-error");

  function handlePasswordCheck(event) {
    if (!pwFlag) {
      // pwFlag가 false일 경우 입력 차단 및 에러 메시지 표시
      passwordChkError.textContent = "먼저 비밀번호가 유효한 것을 입력해주세요.";
      passwordChkError.style.color = "red";
      event.preventDefault(); // 입력 차단
      passwordChkField.value = ""; // 입력값 초기화
      return;
    }

    if (passwordChkField.value === "") {
      passwordChkError.textContent = ""; // 입력이 비어 있을 때 메시지 없음
    } else if (passwordChkField.value === passwordField.value) {
      passwordChkError.textContent = "동일한 비밀번호 입니다"; // 비밀번호가 동일
      passwordChkError.style.color = "green";

      pwCheckFlag = true;
      console.log("passwordCheckFlag:", pwCheckFlag);
    } else {
      passwordChkError.textContent = "비밀번호가 다릅니다"; // 비밀번호가 다름
      passwordChkError.style.color = "red";
    }
  }

  passwordChkField.addEventListener("input", handlePasswordCheck);
}

// DOMContentLoaded 이벤트가 발생하면 초기화 함수 실행
document.addEventListener("DOMContentLoaded", function () {
  const passwordInput = document.getElementById("password");
  const passwordChkField = document.getElementById("passwordchk");

  // 비밀번호 실시간 검사 이벤트 등록
  passwordInput.addEventListener("input", validatePasswordLive);

  // 비밀번호 확인 입력 이벤트 등록
  initializePasswordCheck();
});




// 핸드폰 번호 시작
// 핸드폰 번호 자동 포맷팅 및 길이 제한
function formatPhoneNumber(event) {
  let phoneNum = phoneNumInput.value.replace(/[^\d]/g, ""); // 숫자만 칠수있게 하기

  if (phoneNum.length > 11) {
    phoneNum = phoneNum.slice(0, 11); // 11자리에서 넘어가면 타자못침
  }

  // '000-0000-0000' 형태로 변환
  if (phoneNum.length > 7) {
    phoneNum = phoneNum.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
  } else if (phoneNum.length > 3) {
    phoneNum = phoneNum.replace(/(\d{3})(\d{4})?/, "$1-$2");
  }

  phoneNumInput.value = phoneNum;
}

// 입력 이벤트: 사용자가 타자를 칠 때마다 호출
phoneNumInput.addEventListener("input", formatPhoneNumber);

//인증번호 확인
document.addEventListener("DOMContentLoaded", function () {
  const phoneNumChkField = document.getElementById("phoneNumchk");
  const phoneNumChkError = document.getElementById("phoneNumchk-error");
  const nickdupChkButton = document.querySelector(".mypage-btn-phoneNum-check");

  phoneNumChkField.addEventListener("input", function () {
    // 현재 입력값에서 숫자가 아닌 문자를 제거
    phoneNumChkField.value = phoneNumChkField.value.replace(/[^0-9]/g, "");

    // 길이를 6자로 제한
    if (phoneNumChkField.value.length > 6) {
      phoneNumChkField.value = phoneNumChkField.value.slice(0, 6);
    }

    // 유효성 검사 메시지
    if (phoneNumChkField.value.length < 6) {
      phoneNumChkError.textContent = "6자리 숫자를 입력해주세요.";
      phoneNumChkError.style.color = "red";
    } else {
      phoneNumChkError.textContent = "";
    }
  });

  nickdupChkButton.addEventListener("click", function () {
    if (phoneNumChkField.value.length === 6) {
      alert("확인되었습니다");

      phoneCheckFlag = true;
      console.log("phoneCheck" + phoneCheckFlag);
    } else {
      alert("다시 입력하세요");
    }
  });
});

// 전송 버튼 클릭 이벤트
function validatePhoneNumber() {
  const phoneNum = phoneNumInput.value.replace(/[^\d]/g, ""); // 숫자만 남기기

  if (phoneNum.length !== 11) {
    alert("전화번호 양식이 아닙니다. 11자리를 입력해주세요.");
    return false;
  }

  alert("인증번호를 보냈습니다.");
  return true;
}

// 전송 버튼 클릭 이벤트 리스너
sendButton.addEventListener("click", (event) => {
  event.preventDefault();
  validatePhoneNumber();
});

// 핸드폰 번호 끝

// 저장 버튼 클릭 이벤트
saveButton.addEventListener("click", (e) => {
  e.preventDefault();

  // 모든 입력 필드 값 확인
  const name = document.getElementById("name").value.trim();
  const birthdate = document.getElementById("birthdate").value.trim();
  const ID = document.getElementById("ID").value.trim();
  const nickname = nicknameInput.value.trim();
  const password = passwordInput.value.trim();
  const passwordchk = passwordchkInput.value.trim();
  const phoneNum = phoneNumInput.value.replace(/[^\d]/g, "");
  const phoneNumchk = phoneNumchkInput.value.trim();

  // 입력값 유효성 검사
  if (
    !name ||
    !birthdate ||
    !ID ||
    !nickname ||
    !password ||
    !passwordchk ||
    !phoneNum ||
    !phoneNumchk
  ) {
    alert("정보를 입력하세요");
    console.log(name);
    console.log(birthdate);
    console.log(ID);
    console.log(nickname);
    console.log(password);
    console.log(passwordchk);
    console.log(phoneNum);
    console.log(phoneNumchk);
    return;
  }

  // 모든 유효성 검사 통과
  if (nickCheckFlag && pwFlag && pwCheckFlag && phoneCheckFlag) {
    console.log(nickCheckFlag, pwCheckFlag, phoneCheckFlag);
    alert("회원정보가 수정되었습니다.");
  } else {
    alert("모든 정보를 입력하세요.");
  }
  // window.location.href = "./..//html/main/main-logout.html";
  nickCheckFlag = false;
  pwFlag = false;
  pwCheckFlag = false;
  phoneCheckFlag = false;
});
