/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 삭제 버튼 클릭시
function clickDeleteBtn(fbCommentNum) {
	// 확인, 취소 버튼 선택
	const isdelete = confirm('정말 삭제하시겠습니까?');
	// 확인 버튼 클릭시
	if (isdelete) {
		$.ajax({
			/* 자유게시판 댓글 삭제 컨트롤러로 이동, 댓글 넘버 쿼리스트링으로 전달 */
			url: getContextPath() + "/admin/admin-boardcommentDeleteOk.ad?fbCommentNum=" + fbCommentNum,
			type: "GET",
			/* 자유게시판 댓글 삭제 성공 시 알람창 뜨면서 목록 페이지로 이동 */
			success: () => {
				alert('삭제가 완료되었습니다.');
				location.href = getContextPath() + "/admin/admin-boardcommentlist.ad";
			},
			/* 삭제 불가시 알람창 */
			error: (xhr, status, error) => {
				console.error("자유게시판 댓글 삭제 실패:", error);
				alert("삭제 실패했습니다.");
			}
		});
	}
}

// 댓글 내용 클릭시 댓글 내용 전체 보이기
const commentContent = document.querySelectorAll('.commentcontent');
commentContent.forEach((comment) => {
  // 해당 코멘트의 전체를 보여주는 div 선택
  let commentAll = comment.parentNode.nextElementSibling;
  let allBtn = comment.childNodes[3];
  comment.addEventListener("click", () => {
    // 해당 클래스가 없다면 부여 / 있으면 제거
    commentAll.classList.toggle('active');
    allBtn.classList.toggle('rotateBtn');
  });
  
  // 코멘트 글 눌러도 제거
  commentAll.addEventListener("click", () => {
    // 해당 클래스가 없다면 부여 / 있으면 제거
    commentAll.classList.toggle('active');
    allBtn.classList.toggle('rotateBtn');
  });
});


