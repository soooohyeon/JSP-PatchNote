document.addEventListener("DOMContentLoaded", function () {
	const passwordInput = document.getElementById("PASSWORDSELECT-INPUT-NEWPWD");
	const passwordConfirmInput = document.getElementById("PASSWORDSELECT-INPUT-RENEWPWD");
	
	
	const checkPwMsg = document.getElementById("JOIN-SPAN-PWD-STATUS");
	const checkPwConfirmMsg = document.getElementById("JOIN-SPAN-REPWD-STATUS");
	
	// 비밀번호 유효성 검사
	const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;

	passwordInput.addEventListener("blur", function () {
	    const password = passwordInput.value.trim();
	    if (passwordRegex.test(password)) {
	        checkPwMsg.textContent = "사용 가능한 비밀번호입니다.";
	        checkPwMsg.style.color = "green";
	    } else {
	        checkPwMsg.textContent = "비밀번호는 영문, 숫자, 특수문자를 포함하여 8자 이상 입력해야 합니다.";
	        checkPwMsg.style.color = "red";
	    }
	});

	passwordConfirmInput.addEventListener("blur", function () {
	    const password = passwordInput.value.trim();
	    const confirmPassword = passwordConfirmInput.value.trim();

	    if (password === confirmPassword && password !== "") {
	        checkPwConfirmMsg.textContent = "비밀번호가 일치합니다.";
	        checkPwConfirmMsg.style.color = "green";
	    } else {
	        checkPwConfirmMsg.textContent = "비밀번호가 일치하지 않습니다.";
	        checkPwConfirmMsg.style.color = "red";
	    }
	});
	
	});