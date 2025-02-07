// 카테고리 선택시 selected 클래스 추가
const categoryWrapper = document.querySelector(
  ".studylist-div-categoryselectwrapper"
); // 상위 컨테이너 선택
const categoryList = document.querySelectorAll(
  ".studylist-div-categoryselector"
); // 모든 카테고리 요소 선택
categoryList.forEach((item) => {
  item.addEventListener("click", () => {
    // 현재 선택된 항목에서 selected 제거
    categoryWrapper
      .querySelector(".categoryselected")
      .classList.remove("categoryselected");
    // 클릭된 항목에 selected 추가
    item.classList.add("categoryselected");
    //선택된 카테고리의 값 저장
  });
});

//전화번호 탭 선택시 selected 클래스 추가
const phoneWrapper = document.querySelector(
  ".studylist-div-phoneselectwrapper"
);
const tabList = document.querySelectorAll(".studylist-div-shownumberselector");

tabList.forEach((item) => {
  item.addEventListener("click", () => {
    console.log(item);

    // 현재 선택된 요소 확인
    const selected = phoneWrapper.querySelector(".phoneselected");
    selected.classList.remove("phoneselected");

    // 새로운 요소에 클래스 추가
    item.classList.add("phoneselected");
  });
});

//정원 입력 시 숫자만 입력 가능
const capacityInput = document.querySelector("input[name='studyLimit']");
capacityInput.addEventListener("input", (e) => {
  e.target.value = e.target.value.replace(/[^0-9]/g, ""); // 숫자만 입력가능

  if (e.target.value > 20) {
    // 정원은 20명까지 가능
    alert("정원은 20명 까지 입니다.");
    e.target.value = 20;
  }
});

/*//파일 첨부시 파일명 표시

const fileInput = document.querySelector("input[name='file']");
const fileLabel = document.querySelector("#STUDYLIST-INPUT-FILELABEL");

fileInput.addEventListener("change", (e) => {
  const filename = e.target.files[0].name;
  fileLabel.textContent = filename;
});*/


//뒤로 가기 버튼을 눌렀을 때 이전 페이지로 이동
function goBack() {
  window.history.back();
}

/* 루트 경로 담은 함수 */
function getContextPath() {
   var hostIndex = location.href.indexOf (location.host) + location.host.length;
   var contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1));
   
   return contextPath;
}

// 글 등록을 눌렀을 때  alert, 스터디 목록 페이지로 이동
/*function insertStudy(e) {
	e.preventDefault(); // 기본 동작 방지
  if (confirm("스터디를 등록하시겠습니까?")) {
	document.getElementById("STUDYLIST-FORM-WRITE").submit();
    location.href = getContextPath() + "/study/studyWriteOk.st";
    alert("스터디가 등록되었습니다.");
  }
}*/

/*function insertStudy(e) {
    e.preventDefault(); // 기본 동작 방지

    const form = document.getElementById("STUDYLIST-FORM-WRITE");

    // 유효성 검사 (필요 시 추가)
    const studyDescript = document.querySelector("[name='studyDescript']").value;
    if (!studyDescript.trim()) {
        alert("설명을 작성해주세요.");
        return;
    }

    if (confirm("스터디를 등록하시겠습니까?")) {
        // alert 표시
        alert("스터디가 등록되었습니다.");

        // 폼을 전송하고, 서버 처리가 끝난 뒤 페이지 이동
        form.submit(); // 폼 데이터를 서버로 전송
        setTimeout(() => {
            location.href = getContextPath() + "/study/studyWriteOk.st"; // 페이지 이동
        }, 100); // 약간의 딜레이를 주어 submit 완료 후 동작
    }
}
*/
function insertStudy(e) {
    e.preventDefault(); // 기본 동작 방지
    const form = document.getElementById("STUDYLIST-FORM-WRITE");
    // 유효성 검사 (필요 시 추가)
    const studyDescript = document.querySelector("[name='studyDescript']").value;
    if (!studyDescript.trim()) {
        alert("설명을 작성해주세요.");
        return;
    }
    if (confirm("스터디를 등록하시겠습니까?")) {
        // alert 표시
        alert("스터디가 등록되었습니다.");
        // 폼을 전송하고, 서버 처리가 끝난 뒤 페이지 이동
        form.submit(); // 폼 데이터를 서버로 전송
        setTimeout(() => {
            location.href = getContextPath() + "/study/studyWriteOk.st"; // 페이지 이동
        }, 100); // 약간의 딜레이를 주어 submit 완료 후 동작
    }
}