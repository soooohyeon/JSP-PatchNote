document.addEventListener("DOMContentLoaded", function () {
	const idInput = document.getElementById("PASSWORDSELECT-INPUT-ID");
	const phoneNumberInput = document.getElementById("PASSWORDSELECT-INPUT-PHONENUMBER");
	const verificationCodeInput = document.getElementById("PASSWORDSELECT-AUTHENTICATIONNUMBER");
	const sendSMSBtn = document.getElementById("PASSWORDSELECT-BTN-SEND");
	
	
	const checkIdMsg = document.getElementById("JOIN-SPAN-ID");
	const verificationStatus = document.getElementById("JOIN-SPAN-VERIFICATION-STATUS");
	
	// 아이디 일치여부 검사
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
	                   checkIdMsg.textContent = "일치하지 않는 아이디입니다.";
	                   checkIdMsg.style.color = "red";
	               } else {
	                   checkIdMsg.textContent = "일치하는 아이디입니다.";
	                   checkIdMsg.style.color = "green";
	               }
	           })
	           .catch(error => {
	               console.error("아이디 중복 검사 오류:", error);
	               checkIdMsg.textContent = "아이디 중복 검사 중 오류가 발생했습니다.";
	               checkIdMsg.style.color = "red";
	           });
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
	   
	
	
});