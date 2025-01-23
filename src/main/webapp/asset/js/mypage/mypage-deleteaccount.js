document.addEventListener("DOMContentLoaded", function () {
  const inputField = document.getElementById("DELETEINPUT");
  const deleteButton = document.getElementById("DELETEBUTTON");

  // 입력값 확인 후 버튼 활성화/비활성화
  inputField.addEventListener("input", function () {
    if (inputField.value === "내 계정 삭제") {
      deleteButton.disabled = false; // 버튼 활성화
    } else {
      deleteButton.disabled = true; // 버튼 비활성화
    }
  });

  /* 루트 경로 담은 함수 */
  function getContextPath() {
    var hostIndex = location.href.indexOf(location.host) + location.host.length;
    var contextPath = location.href.substring(
      hostIndex,
      location.href.indexOf("/", hostIndex + 1)
    );

    return contextPath;
  }

  // 버튼 클릭 시 alert 창 표시
  deleteButton.addEventListener("click", function () {
	userNum = 30;
    $.ajax({
      /* 유저 삭제 컨트롤러로 이동, 유저 넘버 쿼리스트링으로 전달 */
      // url: getContextPath() + "/mypage/MyPageDeleteOkController.my?userNum=" + sessionStorage.getItem("userNum"),
      url:
        getContextPath() +
        "/mypage/MyPageDeleteOkController.my?userNum="+ userNum,
   
      type: "GET",
      /* 유저 탈퇴 성공 시 알람창 뜨면서 유저 목록 페이지 새로고침 */
      success: () => {
        alert("탈퇴가 완료되었습니다.");
        location.href = getContextPath() + "/main.jsp";
      },
      /* 탈퇴 불가시 알람창 */
      error: (xhr, status, error) => {
        console.error("유저 탈퇴 실패:", error);
        alert("유저 탈퇴에 실패했습니다.");
      },
    });
  });
});
