const idInput = document.getElementById("PASSWORDSELECT-INPUT-ID");
const phoneInput = document.getElementById("PASSWORDSELECT-INPUT-PHONENUMBER");
const verificationCodeInput = document.getElementById("PASSWORDSELECT-AUTHENTICATIONNUMBER");
const verificationStatus = document.getElementById("JOIN-SPAN-VERIFICATION-STATUS");
const sendSMSBtn = document.getElementById("PASSWORDSELECT-BTN-SEND");
const nextPageBtn = document.getElementById("PASSWORDSELECT-BTN-NEXT");

// 유효성 검사 여부
let isCheckUser = false;	// 존재하는 유저인지 확인 여부
let isPhone = false;		// 인증번호 확인 여부

/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 핸드폰 번호 형식 변환
function formatPhone(event) {
	isPhone = false;
	
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

// 인증번호 발송
function sendSms() {
	const phone = phoneInput.value.trim();
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
			verificationCodeInput.disabled = false;
		})
		.catch(error => {
			console.error("SMS 발송 오류:", error);
			alert("인증번호 발송 중 오류가 발생했습니다.");
		});
}

document.addEventListener("DOMContentLoaded", function() {

	idInput.addEventListener("input", function() {
		isPhone = false;
	});
		
	// 전화번호 유효성
	phoneInput.addEventListener('input', formatPhone);

	// 전화번호 옆 발송버튼 클릭시
	sendSMSBtn.addEventListener("click", function() {
		isPhone = false;
		verificationCodeInput.value ='';
		verificationStatus.textContent ='';
		const id = idInput.value.trim();
		const phone = phoneInput.value.trim();

		if (id ==="" || phone === "" || phone.length !== 13) {
			alert("아이디 또는 핸드폰 번호를 확인해주세요.");
			return;
		}
		
		// id와 전화번호 넘겨서 유저 여부 체크
		fetch(getContextPath() + `/login/checkUserOk.me?userId=${encodeURIComponent(id)}&&userPh=${encodeURIComponent(phone)}`)
			//경로 변경해야하는 부분
			.then(response => {
				if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
				return response.json();
			})
			.then(data => {
				if (data.available) {
					isCheckUser = true;
					sendSms();
					alert("인증번호를 발송했습니다.");
				} else {
					isCheckUser = false;
					alert("가입된 계정이 없습니다.");
					return;
				}
			})
			.catch(error => {
				console.error("유저 검사 오류:", error);
				alert("유저 확인 중 오류가 발생했습니다.");
			});
	});
	
	// 인증번호 확인
	verificationCodeInput.addEventListener("blur", function() {
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
					isPhone = true;
					verificationStatus.textContent = "인증에 성공했습니다.";
					verificationStatus.style.color = "green";
				} else {
					isPhone = false;
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
});

// 휴대폰 인증 후 다음페이진 비밀번호 수정페이지로 이동
nextPageBtn.addEventListener("click", function() {
	if (isPhone) {
		location.href = getContextPath() + "/login/passwrdUpdate.me";
	} else {
		alert("휴대폰 인증 먼저 진행해주세요.");
		
	}
});