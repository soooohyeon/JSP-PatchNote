/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

//뒤로 가기 버튼을 눌렀을 때 이전 페이지로 이동
function goBack() {
	window.history.back();
}

// 글 수정을 눌렀을 때  alert, 글 수정 페이지로 이동
function updateStudy(studyNum) {
	if (
		confirm("글 수정시 첨부파일이 삭제 됩니다." + "\n" + "수정하시겠습니까?")
	) {
		alert("수정 페이지로 이동합니다.");

		window.location.href = getContextPath() + "/study/studyUpdate.st?studyNum=" + studyNum;
	}
}
//글 삭제를 눌렀을 때 띄워지는 alert
/*function deleteStudy() {

	console.log("delete Study 함수 실행");
	if (confirm("해당 스터디 글을 삭제하시겠습니까?")) {
		//삭제 후 스터디 목록 화면으로 이동

		console.log("예 버튼 클릭");
		
			window.location.href = getContextPath() + "/study/studyDeleteOk.st?studyNum=" + studyNum;
		alert("해당 스터디 글이 삭제되었습니다.");
	} else {
		alert("취소되었습니다.");
	}
}

*/
// 버튼 클릭 시 alert 창 표시
function deleteStudy(studyNum) {
	let userDetermination = document.getElementById("STUDYLIST-TEXTAREA-COURAGE").value;
	console.log(studyNum);
	$.ajax({

		url:
			getContextPath() + "/study/studyDeleteOk.st?studyNum=" + studyNum,
		type: "GET",
		success: () => {
			if (confirm("해당 스터디를 삭제하시겠습니까?")) {
				alert("스터디 삭제가 완료되었습니다.");
				location.href = getContextPath() + "/study/studyList.st";
			}

		},
		error: (xhr, status, error) => {
			console.error("스터디 삭제 실패:", error);
			alert("스터디 삭제에 실패했습니다.");
		},
	});
};


$(document).ready(function() {

	console.log("화면 로드됨.");
	//댓글 목록 로드 (fetch)
	async function loadComments() {
		try {
			console.log("studyNum" + studyNum);
			
			// <========= 여기서 막힘
			
			const response = await fetch(getContextPath() +`/study/studyCommentListOk.st?studyNum=${studyNum}`);
			if (!response.ok) throw new Error("댓글 목록을 불러오는 데 실패했습니다.");
			const comments = await response.json();
			renderComments(comments);
		} catch (error) {
			console.error("댓글 목록 불러오기 실패:", error);
			alert("댓글 목록을 불러오는데 실패했습니다.");
		}
	}

	//댓글 렌더링
	function renderComments(comments) {
		const commentList = document.querySelector("#studylist-div-commentlist");
		console.log("commentList" + commentList);
		commentList.innerHTML = "";

		if (comments.length === 0) {
			commentList.innerHTML = "<li>댓글이 없습니다.</li>";
			return;
		}

		console.log(comments);
		comments.forEach(comment => {
			console.log("comment" + comment);
			const isMyComment = comment.memberNumber == memberNumber;
			const div = document.createElement("div");
			div.innerHTML =
				`
				<div class="studylist-div-commentlayer">
									<span class="studylist-span-commentnickname">닉네임</span> <span
										class="studylist-span-commentdate">${comment.studyCommentUploadDate}</span>
								</div>
								<div class="studylist-div-commentlayer">
									<span class="studylist-span-commentcontents">${comment.studyComment}</span>
										
										${isMyComment ? `
									<div class="studylist-detail-div-btnwrapper">
										<span class="studylist-span-commenteditbtn"
											onclick="updateComment()">수정</span> <span
											class="studylist-span-divider">|</span> <span
											class="studylist-span-commentdeletebtn" onclick="deleteComment()">삭제</span>
											` : ""}
				</div>
			</div>
			`
			commentList.appendChild(div);
		});
	}

	// 초기 댓글 로드
	loadComments();

});




// 댓글 등록
function writeComment() {
	let comment = document.getElementById("STUDYLIST-TEXTAREA-COMMENT").value;
	if (comment == "") {
		alert("댓글을 입력해주세요");
	} else {
		alert("댓글을 등록하였습니다.");
	}
}
// 댓글 수정 함수
function updateComment() {
	if (confirm("댓글을 수정하시겠습니까?")) {
		// 수정 기능 구현 필요
	}
}

//댓글 삭제를 눌렀을 때 띄워지는 alert
function deleteComment() {
	if (confirm("해당 댓글을 삭제하시겠습니까?")) {
		//삭제 후 스터디 목록 화면으로 이동
		alert("해당 댓글이 삭제되었습니다.");
	} else {
		alert("취소되었습니다.");
	}
}

/**
 * 글자 수를 실시간 업데이트하는 함수
 * @param {HTMLElement} textarea - 텍스트 영역 요소
 * @param {number} maxCharacters - 최대 글자 수
 * @author 황어진
 * @since 2025-01-13
 *
 */
function updateCharacterCount(textarea, maxCharacters) {
	// 데이터 속성을 기반으로 카운터 요소 가져오기
	console.log(textarea.dataset)
	const counterId = textarea.dataset.counter;
	const counter = document.getElementById(counterId);

	// 현재 입력된 글자 수 계산
	const currentLength = textarea.value.trim().length;

	// 카운터 업데이트
	counter.textContent = `${currentLength}/${maxCharacters}`;

	// 200자 초과시 글자 입력 불가
	if (currentLength > maxCharacters) {
		textarea.value = textarea.value.substring(0, maxCharacters);
		counter.textContent = `${maxCharacters}/${maxCharacters}`;
	}

}
// 스터디 신청시 모달 띄우기
function applyStudy() {
	document.getElementById("STUDYLIST-MODAL-APPLY").style.display = "block";
}
//스터디 취소 버튼 클릭시 띄워지는 alert
function cancelStudy() {
	if (confirm("해당 스터디를 취소하겠습니까?")) {
		alert("해당 스터디가 취소 되었습니다.");
	}
}
//modal 닫기
function closeModal() {
	document.getElementById("STUDYLIST-MODAL-APPLY").style.display = "none";
}
//각오 등록
function writeCourage(studyNum) {
	//각오를 입력했는지 여부를 판단
	//event.preventDefault();

	console.log("함수실행!!!");

	let userDetermination = document.getElementById("STUDYLIST-TEXTAREA-COURAGE").value;
	let disclaimer = document.getElementById("STUDYLIST-CHECKBOX-AGREE").checked;

	console.log("dfsfsdf : " + userDetermination);

	if (userDetermination === "") {
		alert("각오를 입력해주세요.");
		return;
	}
	//면책 사항 동의 여부를 판단
	console.log(disclaimer);
	if (disclaimer === false) {
		alert("주의사항 체크 후 진행바랍니다.");
		return;
	}

	var formData = {
		name: $('input[name="name"]').val(),
		email: $('input[name="email"]').val()
	};

	if (confirm("스터디를 신청하시겠습니까?")) {
		$.ajax({
			url:
				getContextPath() + "/study/studyApplyInsertOk.st?studyNum=" + studyNum,
			type: "POST",
			data: {
				studyNum: studyNum,  // 전송할 데이터
				userDetermination: userDetermination
			},
			success: () => {
				alert("신청이 완료되었습니다.");
				closeModal();

				location.href = getContextPath() + "/study/studyDetailOk.st?studyNum=" + studyNum;
			},
			error: (xhr, status, error) => {
				console.error("스터디 신청 실패:", error);
				alert("스터디 신청에 실패했습니다.");
				console.log(studyNum);
			},
		});
	}

}
