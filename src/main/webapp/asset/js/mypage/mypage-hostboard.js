document.addEventListener("click", function (event) {
  // 모달 리스트를 닫기
  const modal = document.getElementById("modal-list");
  if (!modal.contains(event.target) && event.target.className !== "mypage-div-morebtn") {
    closeModal();
  }
});

function openModal(element) {
  const modal = document.getElementById("modal-list");
  const rect = element.getBoundingClientRect();
  console.log(element)
  console.log("23452345");
  console.log(`${rect.left}px`);
  console.log(`${rect.bottom + window.scrollY}px`);
  // 모달 위치를 클릭된 img 버튼 근처로 설정
  modal.style.left = `${rect.left}px`;
  modal.style.top = `${rect.bottom + window.scrollY}px`;
  modal.style.display = "block";
}

function closeModal() {
  const modal = document.getElementById("modal-list");
  modal.style.display = "none";
}

function handleModalAction(action) {
  alert(`${action} go`);
  closeModal(); 
}


// 신청자 모달 열기
function openApplicantModal() {
  document.getElementById("REQUEST-LIST-MODAL").classList.remove("hidden");
}

// 신청자 모달 닫기
function closeApplicantModal() {
  document.getElementById("REQUEST-LIST-MODAL").classList.add("hidden");
}

// 드롭다운 토글
function toggleDropdown(img) {
  const body = img.parentElement.nextElementSibling;
  body.classList.toggle("hidden");

  console.log(img);

  if(img.src.includes("down.png")){
    img.src="./../../asset/img/mypage/up.png"

  } else{
    img.src="./../../asset/img/mypage/down.png"
  }
}

// 수락 버튼 동작
function acceptApplicant(name) {
  alert(`${name}님의 신청을 수락했습니다.`);
}

// 거절 버튼 동작
function rejectApplicant(name) {
  alert(`${name}님의 신청을 거절했습니다.`);
}