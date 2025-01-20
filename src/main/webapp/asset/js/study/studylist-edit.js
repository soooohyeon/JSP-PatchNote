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
  const capacityInput = document.querySelector("input[name='groupLimit']");
  capacityInput.addEventListener("input", (e) => {
    e.target.value = e.target.value.replace(/[^0-9]/g, ""); // 숫자만 입력가능
  
    if (e.target.value > 20) {
      // 정원은 20명까지 가능
      alert("정원은 20명 까지 입니다.");
      e.target.value = 20;
    }
  });
  