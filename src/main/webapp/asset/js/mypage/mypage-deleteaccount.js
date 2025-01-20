document.addEventListener('DOMContentLoaded', function () {
  const inputField = document.getElementById('DELETEINPUT');
  const deleteButton = document.getElementById('DELETEBUTTON');

  // 입력값 확인 후 버튼 활성화/비활성화
  inputField.addEventListener('input', function () {
    if (inputField.value === '내 계정 삭제') {
      deleteButton.disabled = false; // 버튼 활성화
    } else {
      deleteButton.disabled = true; // 버튼 비활성화
    }
  });

  // 버튼 클릭 시 alert 창 표시
  deleteButton.addEventListener('click', function () {
    alert('탈퇴되었습니다');
  });
});