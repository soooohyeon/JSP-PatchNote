document.addEventListener("DOMContentLoaded", function () {
    const idInput = document.getElementById("JOIN-INPUT-ID");
 	const nickInput = document.getElementById("JOIN-INPUT-NICKNAME");
	const nameInput = document.getElementById("JOIN-INPUT-NAME");
	const birthInput = document.getElementById("JOIN-INPUT-BIRTH");
	
    const passwordInput = document.getElementById("INPUT-PASSWORD");
    const passwordConfirmInput = document.getElementById("JOIN-REPASSWORD");
    const sendSMSBtn = document.getElementById("JOIN-BTN-PHONNUMBER");
    const phoneNumberInput = document.getElementById("JOIN-INPUT-PHONNUMBER");
    const verificationCodeInput = document.getElementById("JOIN-INPUT-AUTHENTICATIONNUMBER");

    const checkIdMsg = document.getElementById("JOIN-DIV-IDCHECK");
    const checkNickMsg = document.getElementById("JOIN-DIV-NICKNAMECHECK");
    const checkPwMsg = document.getElementById("JOIN-DIV-PASSWORD");
	const checkNameMsg = document.getElementById("JOIN-DIV-NAME");
	const checkBirthMsg = document.getElementById("JOIN-DIV-BIRTH");
	
    const checkPwConfirmMsg = document.getElementById("JOIN-DIV-REPASSWORD");
	
	
	
    const verificationStatus = document.getElementById("JOIN-DIV-VERIFICATION-STATUS" );

    // 아이디 중복 검사
    idInput.addEventListener("change", function () {
        const userId = idInput.value.trim();
        if (userId === "") {
            checkIdMsg.textContent = "아이디를 입력해주세요.";
            checkIdMsg.style.color = "red";
            return;
        }

        fetch(`/login/checkIdOk.me?userId=${encodeURIComponent(userId)}`)
      //경로 변경해야하는 부분
            .then(response => {
                if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
                return response.json();
            })
            .then(data => {
                if (data.available) {
                    checkIdMsg.textContent = "사용 가능한 아이디입니다.";
                    checkIdMsg.style.color = "green";
                } else {
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
       nickInput.addEventListener("change", function () {
           const userNick = nickInput.value.trim();
           if (userNick === "") {
               checkNickMsg.textContent = "닉네임을 입력해주세요.";
               checkNickMsg.style.color = "red";
               return;
           }

           fetch(`/login/checkNickOk.me?userNick=${encodeURIComponent(userNick)}`)
         //경로 변경해야하는 부분
               .then(response => {
                   if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
                   return response.json();
               })
               .then(data => {
                   if (data.available) {
                       checkNickMsg.textContent = "사용 가능한 닉네임입니다.";
                       checkNickMsg.style.color = "green";
                   } else {
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
	
	
	// 이름 유효성
	const nameRegex =   /^[가-힣]{2,6}$/;

	nameInput.addEventListener("blur", function () {
	    const name = nameInput.value.trim();
	    if (nameRegex.test(name)) {
	        checkNameMsg.textContent = "이름이 입력되었습니다.";
	        checkNameMsg.style.color = "green";
	    } else {
	        checkNameMsg.textContent = "이름은 한글로 입력해주세요.";
	        checkNameMsg.style.color = "red";
	    }
	});

	//생일
	const birthRegex =/^[0-9]*$/;;  
	birthInput.addEventListener("blur", function () {
	    const birth = birthInput.value.trim();
	    if (birthRegex.test(birth)) {
			checkBirthMsg.textContent = "숫자가 정상적으 입력되었습니다.";
			checkBirthMsg.style.color = "green";
			
	    } else {
			
			checkBirthMsg.textContent = "숫자를 입력해주세요.";
			checkBirthMsg.style.color = "red";	
	    }
	});
	
	

    // SMS 인증번호 발송
    sendSMSBtn.addEventListener("click", function () {
        const phoneNumber = phoneNumberInput.value.trim();
        if (phoneNumber === "") {
            alert("핸드폰 번호를 입력해주세요.");
            return;
        }

        fetch("/login/sendSMS.me", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ phoneNumber: phoneNumber })
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
    verificationCodeInput.addEventListener("blur", function () {
        const verificationCode = verificationCodeInput.value.trim();
        if (verificationCode === "") {
            verificationStatus.textContent = "인증번호를 입력해주세요."; 
            verificationStatus.style.color = "red";
            return;
        }

        fetch("/login/verifyCode.me", {
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

    // 폼 제출 전 약관 확인
    document.querySelector("form").addEventListener("submit", function (e) {
        if (!agreeCheckbox.checked) {
            e.preventDefault();
            alert("약관에 동의해주세요.");
        }
    });
});


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



