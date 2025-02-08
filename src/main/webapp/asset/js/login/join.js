// ID 중복 검사
const idInput = document.getElementById("JOIN-INPUT-ID");
const checkIdMsg = document.getElementById("JOIN-DIV-IDCHECK");
// 닉네임 중복 검사
const nickInput = document.getElementById("JOIN-INPUT-NICKNAME");
const checkNickMsg = document.getElementById("JOIN-DIV-NICKNAMECHECK");
// 비밀번호 일치 여부
const passwordInput = document.getElementById("INPUT-PASSWORD");
const checkPwMsg = document.getElementById("JOIN-DIV-PASSWORD");
const confirmPasswordInput = document.getElementById("JOIN-REPASSWORD");
const checkPwConfirmMsg = document.getElementById("JOIN-DIV-REPASSWORD");
// 이름 유효성 검사
const nameInput = document.getElementById("JOIN-INPUT-NAME");
const checkNameMsg = document.getElementById("JOIN-DIV-NAME");
// 생일 유효성 검사
const birthInput = document.getElementById("JOIN-INPUT-BIRTH");
const checkBirthMsg = document.getElementById("JOIN-DIV-BIRTH");
// 전화번호 유효성 검사
const phoneInput = document.getElementById('JOIN-INPUT-PHONNUMBER');
const sendSMSBtn = document.getElementById("JOIN-BTN-PHONNUMBER");
// 인증번호 검사
const verificationCodeInput = document.getElementById("JOIN-INPUT-AUTHENTICATIONNUMBER");
const verificationCheckBtn = document.getElementById("JOIN-BTN-AUTHENTICATIONNUMBER");
const verificationStatus = document.getElementById("JOIN-DIV-VERIFICATION-STATUS");
// 약관 동의 검사
const allAgreeCheck = document.getElementById("join-input-allcheck");
const agreeCheck = document.querySelectorAll('input.join-input-checkbox-small');
// 폼 제출 전 정보 유효성 검사 완료 여부 및 휴대폰 인증 여부 체크 후 데이터 전송
const submitBtn = document.getElementById("JOIN-BTN-INSITE");

// 유효성 검사 여부
let ischeckId = false;
let ischeckNick = false;
let ischeckPw = false;
let ischeckName = false;
let ischeckBirth = false;
let ischeckPhone = false;

/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 생일 형식 검사
function formatDate(birth) {
	const regex = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;
	const year = parseInt(birth.substring(0, 4), 10);
	const month = parseInt(birth.substring(4, 6), 10) - 1;
	const day = parseInt(birth.substring(6, 8), 10);
	const date = new Date(year, month, day);
	return date.getFullYear() === year && date.getMonth() === month && date.getDate() === day;
}

// 핸드폰 번호 형식 변환
function formatPhone(event) {
	ischeckPhone = false;
	verificationStatus.textContent ='';
	
	let phone = phoneInput.value.replace(/[^\d]/g, ''); // 숫자만 칠수있게 하기
	// 11자리에서 넘어가면 타자못침
	if (phone.length > 11) {
		phone = phone.slice(0, 11);
	}
	// '000-0000-0000' 형태로 변환
	if (phone.length > 7) {
		phone = phone.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
	} else if (phone.length > 3) {
		phone = phone.replace(/(\d{3})(\d{4})?/, '$1-$2');
	}
	phoneInput.value = phone;
}

// 인증번호 입력시 글자 수 제한 (input 타입이 Number일 때 사용)
function checkMaxLength(code) {
	const phone = phoneInput.value;
	if (phone === "" || phone.length !== 13) {
		alert("핸드폰 번호를 확인해주세요.");
	}
	if (code.value.length > 6) {
		code.value = code.value.slice(0, 6);
	}
}

// 전체 동의 클릭시 모두 채크 표시
allAgreeCheck.addEventListener('click', () => {
	agreeCheck.forEach((term) => {
		term.checked = allAgreeCheck.checked;
	});
});

// 약관동의 전부 체크시 전체 동의에 체크 표시
agreeCheck.forEach((term) => {
	term.addEventListener(`click`, () => {
		allAgreeCheck.checked = agreeCheck.map((term) => term.checked).filter((checked) => checked).length === 2;
	})
});

document.addEventListener("DOMContentLoaded", function() {

	// 아이디 중복 검사
	idInput.addEventListener("change", function() {
		const userId = idInput.value.trim();
		if (userId === "") {
			checkIdMsg.textContent = "아이디를 입력해주세요.";
			checkIdMsg.style.color = "red";
			return;
		}

		fetch(getContextPath() + `/login/checkIdOk.me?userId=${encodeURIComponent(userId)}`)
			//경로 변경해야하는 부분
			.then(response => {
				if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
				return response.json();
			})
			.then(data => {
				if (data.available) {
					ischeckId = true;
					checkIdMsg.textContent = "사용 가능한 아이디입니다.";
					checkIdMsg.style.color = "green";
				} else {
					ischeckId = false;
					checkIdMsg.textContent = "이미 사용 중인 아이디입니다.";
					checkIdMsg.style.color = "red";
				}
			})
			.catch(error => {
				console.error("아이디 중복 검사 오류:", error);
				checkIdMsg.textContent = "아이디 중복 검사 중 오류가 발생했습니다.";
				checkIdMsg.style.color = "red";
			});
	});

	// 닉네임 중복 검사
	nickInput.addEventListener("change", function() {
		const userNick = nickInput.value.trim();
		if (userNick === "") {
			checkNickMsg.textContent = "닉네임을 입력해주세요.";
			checkNickMsg.style.color = "red";
			return;
		}

		fetch(getContextPath() + `/login/checkNickOk.me?userNick=${encodeURIComponent(userNick)}`)
			//경로 변경해야하는 부분
			.then(response => {
				if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
				return response.json();
			})
			.then(data => {
				if (data.available) {
					ischeckNick = true;
					checkNickMsg.textContent = "사용 가능한 닉네임입니다.";
					checkNickMsg.style.color = "green";
				} else {
					ischeckNick = false;
					checkNickMsg.textContent = "이미 사용 중인 닉네임입니다.";
					checkNickMsg.style.color = "red";
				}
			})
			.catch(error => {
				console.error("닉네임 중복 검사 오류:", error);
				checkNickMsg.textContent = "닉네임 중복 검사 중 오류가 발생했습니다.";
				checkNickMsg.style.color = "red";
			});

	});

	// 비밀번호 유효성 검사
	const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
	passwordInput.addEventListener("keyup", function() {
		ischeckPw = false;
		checkPwConfirmMsg.textContent ='';
		const password = passwordInput.value.trim();
		if (passwordRegex.test(password)) {
			checkPwMsg.textContent = "사용 가능한 비밀번호입니다.";
			checkPwMsg.style.color = "green";
		} else {
			checkPwMsg.textContent = "비밀번호는 영문, 숫자, 특수문자를 포함하여 8자 이상 입력해야 합니다.";
			checkPwMsg.style.color = "red";
		}
	});

	confirmPasswordInput.addEventListener("keyup", function() {
		const password = passwordInput.value.trim();
		const confirmPassword = confirmPasswordInput.value.trim();

		if (password === confirmPassword && password !== "") {
			ischeckPw = true;
			checkPwConfirmMsg.textContent = "비밀번호가 일치합니다.";
			checkPwConfirmMsg.style.color = "green";
		} else {
			checkPwConfirmMsg.textContent = "비밀번호가 일치하지 않습니다.";
			checkPwConfirmMsg.style.color = "red";
		}
	});

	// 이름 유효성
	const nameRegex = /^[가-힣]{2,6}$/;
	nameInput.addEventListener("blur", function() {
		ischeckName = false;
		const name = nameInput.value.trim();
		if (nameRegex.test(name)) {
			ischeckName = true;
			checkNameMsg.textContent = "";
		} else {
			checkNameMsg.textContent = "이름은 한글로 입력해주세요.";
			checkNameMsg.style.color = "red";
		}
	});

	// 생일 유효성
	birthInput.addEventListener("blur", function() {
		ischeckBirth = false;
		const birth = birthInput.value.trim();
		if (formatDate(birth)) {
			ischeckBirth = true;
			checkBirthMsg.textContent = "";
		} else {
			checkBirthMsg.textContent = "생년월일을 확인해주세요.";
			checkBirthMsg.style.color = "red";
		}
	});

	// 전화번호 유효성
	phoneInput.addEventListener('input', formatPhone);

	// SMS 인증번호 발송
	sendSMSBtn.addEventListener("click", function() {
		verificationCodeInput.value = "";	// 인증번호 입력칸 비우기
		const phone = phoneInput.value;
		if (phone === "" || phone.length !== 13) {
			alert("핸드폰 번호를 확인해주세요.");
			return;
		} else {
			alert("인증번호를 보냈습니다.");
		}

		fetch(getContextPath() + "/login/sendSMS.me", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({ phoneNumber: phone })
		})
			.then(response => {
				if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
			})
			.then(() => {
				console.log("발송 성공");
				console.log(verificationCodeInput.disabled);
				verificationCodeInput.disabled = false;
				console.log(verificationCodeInput.disabled);
			})
			.catch(error => {
				console.error("SMS 발송 오류:", error);
				alert("인증번호 발송 중 오류가 발생했습니다.");
			});
	});

	// 인증번호 확인
	verificationCheckBtn.addEventListener("click", function() {
		const verificationCode = verificationCodeInput.value.trim();
		if (verificationCode === "") {
			verificationStatus.textContent = "인증번호를 입력해주세요.";
			verificationStatus.style.color = "red";
			return;
		}

		fetch(getContextPath() + "/login/verifyCode.me", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({ code: verificationCode })
		})
			.then(response => {
				if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
				return response.json();
			})
			.then(data => {
				console.log(data);
				if (data.success) {
					ischeckPhone = true;
					verificationStatus.textContent = "인증에 성공했습니다.";
					verificationStatus.style.color = "green";
				} else {
					verificationStatus.textContent = "인증번호가 일치하지 않습니다.";
					verificationStatus.style.color = "red";
				}
			})
			.catch(error => {
				console.error("인증 확인 오류:", error);
				verificationStatus.textContent = "인증 처리 중 오류가 발생했습니다.";
				verificationStatus.style.color = "red";
			});
	});

	// 폼 제출 전 정보 유효성 검사 완료 여부 및 휴대폰 인증 여부 체크
	submitBtn.addEventListener("click", function(e) {
		if (!ischeckId) {
			alert("아이디를 확인해주세요.");
		} else if (!ischeckNick) {
			alert("닉네임을 확인해주세요.");
		} else if (!ischeckPw) {
			alert("비밀번호를 확인해주세요.");
		} else if (!ischeckName) {
			alert("이름을 확인해주세요.");
		} else if (!ischeckBirth) {
			alert("생일을 확인해주세요.");
		} else if (!ischeckPhone) {
			alert("핸드폰 번호를 확인해주세요.");
		} else if (!allAgreeCheck.checked) {
			alert("약관에 동의해주세요.");
		} else {
			e.submit;
		}
	});
});

