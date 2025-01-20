const btnComplete = document.querySelector(".passwordSelect-detail-btn-complete");

btnComplete.addEventListener("click", (e)=>{
  if(true){
    alert("정상적으로 비밀번호가 변경되었습니다.");
    window.location.href="./login.html";
  }else{
    alert("비밀번호가 변경되지 않았습니다");
    
  }
});


// 비밀번호 일치여부 검사 
function validatePassword() {
	let password = document.getElementById("PASSWORDSELECT-INPUT-NEWPWD").value; //newpassword input태그 값
  let confirmPassword = document.getElementById("PASSWORDSELECT-INPUT-RENEWPWD").value; //repassword input 태그 값
	let result = document.getElementById('JOIN-DIV-PWALARM'); //div 태그 공간

	//특수문자 및 영어 등등 가져와서 쓰는 정규식 (8자리부터 15자리 이하까지)
	const exr = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,15}$/;

	if (exr.test(password)) {
		if (password === confirmPassword) {
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
