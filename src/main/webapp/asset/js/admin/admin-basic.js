// --------------- 검색 ---------------
// 검색칸
const searchInput = document.querySelector(".admin-input-search");
const wrapper = document.querySelector(".admin-div-wrapper");

// input이 포커스 될 때 wrapper에 클래스 추가
searchInput.addEventListener("focus", () => {
  wrapper.classList.add("focused");
});

// input이 포커스 해제될 때 wrapper에서 클래스 제거
searchInput.addEventListener("blur", () => {
  wrapper.classList.remove("focused");
});
// ------------------------------------