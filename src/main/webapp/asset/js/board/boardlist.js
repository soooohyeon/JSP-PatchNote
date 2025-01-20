const searchInput = document.querySelector(".boardlist-input-search");
const wrapper = document.querySelector(".boardlist-div-wrapper");

function movetodetailedpage(){
  window.location.href="./boardlistdetail.html";
}

// input이 포커스 될 때 wrapper에 클래스 추가
searchInput.addEventListener("focus", () => {
  wrapper.classList.add("focused");
});

// input이 포커스 해제될 때 wrapper에서 클래스 제거
searchInput.addEventListener("blur", () => {
  wrapper.classList.remove("focused");
});
// writeInput이라는 변수 선언 후 .bord..div-wr..를 불러옴옴
const writeInput = document.querySelector(".borderlist-div-writewrap");
//writeInput에 이벤트를 클릭으로 주고  alret창을 띄움 그리고 로그인화면으로 이동
writeInput.addEventListener("click", function(){
  alert("로그인먼저진행해주세요.");
  window.location.href="./../login/login.html";
});