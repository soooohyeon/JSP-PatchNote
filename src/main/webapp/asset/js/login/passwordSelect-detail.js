const passwordInput = document.getElementById("PASSWORDSELECT-INPUT-NEWPWD");
const checkPwMsg = document.getElementById("JOIN-SPAN-PWD-STATUS");
const confirmPasswordInput = document.getElementById("PASSWORDSELECT-INPUT-RENEWPWD");
const checkPwConfirmMsg = document.getElementById("JOIN-SPAN-REPWD-STATUS");
const submitBtn = document.getElementById("updatePwBtn");
const form = document.getElementById("updatePwFrom");

// 유효성 검사 여부
let ischeckPw = false;

document.addEventListener("DOMContentLoaded", function() {
	// 비밀번호 유효성 검사
	const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
	passwordInput.addEventListener("keyup", function() {
		ischeckPw = false;
		checkPwConfirmMsg.textContent = '';
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
			ischeckPw = false;
			checkPwConfirmMsg.textContent = "비밀번호가 일치하지 않습니다.";
			checkPwConfirmMsg.style.color = "red";
		}
	});
	
	// 비밀번호가 일치하다면 데이터 전송
	submitBtn.addEventListener("click", function(e) {
		console.log("비밀번호 수정임 ㅋㅋ");
		console.log("비밀번호 수정임 ㅋㅋ : " + ischeckPw);
		const password = passwordInput.value.trim();
		if (!ischeckPw) {
			alert("비밀번호를 확인해주세요.");
			return;
		} else {
			/*form.submit();*/
			$.ajax({
				/* 배너 삭제 컨트롤러로 이동, 배너 넘버 쿼리스트링으로 전달 */
				url: getContextPath() + "/login/passwordUpdateOk.me",
				type: "post",
				data: {
					userPw: password,
				},
				/* 배너 삭제 성공 시 알람창 뜨면서 배너 목록 페이지로 이동 */
				success: () => {
					alert('비밀번호가 수정되었습니다.');
					location.href = getContextPath() + "/login/login.me";
				},
				/* 삭제 불가시 알람창 */
				error: (xhr, status, error) => {
					console.error("비밀번호 수정 실패:", error);
					alert("비밀번호 수정 실패했습니다.");
				}
			});
		}
	});
});
