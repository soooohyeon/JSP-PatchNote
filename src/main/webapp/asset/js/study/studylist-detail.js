/*let userNumFromSession = "${sessionScope.userNum}";*/

/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

// 페이지네이션 클릭시 페이지 이동
function movePage(page, studyNum) {
	console.log("페이지 이동2222");
	/* 현재 페이지의 경로 */
	var pathName= window.location.pathname;
	
	location.href = pathName + "?studyNum=" + studyNum + "&&page=" + page;
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

// 댓글 작성 (fetch)

$(document).ready(function() {
	// studyNum 저장
	const listBtn = $("#STUDY-LIST-BTN");
	const studyNum = listBtn.attr("data-studyNum"); // HTML의 data-studyNum 값 (상단에 목록가기 버튼에 작성)
	const userNum = listBtn.attr("data-userNum"); // HTML의 data-userNum 값 (상단에 목록가기 버튼에 작성)

	// 해당 게시글의 댓글 개수 조회
	const commentCountArea = document.getElementsByClassName("studylist-span-commentcounter");
	let commentCount = 0;
	commentCountArea.innerText = "총 " + commentCount + "개";


	// 댓글 작성시
	document.querySelector(".studylist-btn-commentsubmit")?.addEventListener("click", async function() {
		const content = document.querySelector("#STUDYLIST-TEXTAREA-COMMENT").value.trim();
		const contentElement = document.querySelector("#STUDYLIST-TEXTAREA-COMMENT");

		if (!content) {
			alert("댓글 내용을 입력해주세요.");
			return;
		}
		try {
			const response = await fetch(getContextPath() + "/study/studyCommentWriteOk.st", {
				method: "POST",
				headers: { "Content-Type": "application/json; charset=utf-8" },
				body: JSON.stringify({ studyNum, replyComment: content })
			});

			const result = await response.json();
			if (result.status === "success") {
				alert("댓글이 작성되었습니다.");
				contentElement.value = "";
				loadComments();
			} else {
				alert("댓글 작성에 실패했습니다.");
			}
		} catch (error) {
			console.error("댓글 작성 실패:", error);
			alert("댓글 작성 중 오류가 발생했습니다.");
		}
	});

	//댓글 목록 로드 (fetch)
	async function loadComments() {
		try {
			const urlParams = new URLSearchParams(window.location.search);
			const page = urlParams.get("page");
			let response = null;

			if (page == null) {
				response = await fetch(getContextPath() + `/study/studyCommentListOk.st?studyNum=${studyNum}`);
			} else {
				response = await fetch(getContextPath() + `/study/studyCommentListOk.st?studyNum=${studyNum}&&page=` + page);
			}
			const data = await response.json();

			renderComments(data.comments, data.pageInfo.total);
			loadPage(data.pageInfo, `${studyNum}`);
			
		} catch (error) {
			console.error("댓글 목록 불러오기 실패:", error);
			alert("댓글 목록을 불러오는데 실패했습니다.");
		}
	}

/*	//댓글 갯수 로드 (fetch)
	async function loadCommentCount() {
		try {

			const response = await fetch(getContextPath() + `/study/studyCommentCount.st?studyNum=${studyNum}`);
			const commentCount = await response.text(); // 숫자로 직접 받기
			document.querySelector(".studylist-span-commentcounter").innerText = `총 ${commentCount}개`;
			if (!response.ok) throw new Error("댓글 갯수를 불러오는 데 실패했습니다.");
		} catch (error) {
			console.error("댓글 갯수 불러오기 실패:", error);
			alert("댓글 갯수를 불러오는데 실패했습니다.");
		}
	}*/

	//댓글 렌더링
	function renderComments(comments, total) {
		const commentList = document.querySelector("#studylist-div-commentlist");
		commentList.innerHTML = "";

		// 댓글 개수 출력
		total = "총 " + total + "개";
		console.log(total);
		document.querySelector(".studylist-span-commentcounter").innerText = total;
		
		if (comments.length === 0) {
			commentList.innerHTML = "<li>댓글이 없습니다.</li>";
			return;
		}

		console.log(comments);
		comments.forEach(comment => {
			/* userNum은 studylist-detail.jsp 하단에 script 태그로 저장해둔 값을 받아옴 */
			const isMyComment = comment.userNum == userNum;

			const div = document.createElement("div");
			div.innerHTML =
				`
				<ul id="studylist-div-commentlist">
									<li>
            <div class="studylist-div-commentlayer">
                           <span class="studylist-span-commentnickname">${comment.userNick}</span> <span
                              class="studylist-span-commentdate">${comment.studyCommentUploadDate}</span>
                        </div>
                        <div class="studylist-div-commentlayer">
                           <span class="studylist-span-commentcontent">${comment.studyComment}</span>
						   
                              ${isMyComment ? `
                           <div class="studylist-detail-div-btnwrapper">
                              <span class="studylist-span-commenteditbtn"
                                 data-number="${comment.studyCommentNum}">수정</span> <span
                                 class="studylist-span-divider">|</span> <span
                                 class="studylist-span-commentdeletebtn" data-number="${comment.studyCommentNum}">삭제</span>
                                 ` : ""}
            </div>
         </div>
		 </li>
		 						   </ul>`
			commentList.appendChild(div);
		});
	}

	// 초기 댓글 로드
	loadComments();

});


// 페이지네이션 출력 함수
function loadPage(pageInfo, boardNum) {
	const pagination = document.querySelector("#STUDYLIST-UL-PAGINATION");
	pagination.innerHTML = ""
	
	// 이전 버튼 (prev)
	if (pageInfo.prev) {
	    const prevLi = document.createElement("li");
	    prevLi.className = "studylist-li-paginationlist pre";
	    prevLi.innerHTML = "&lt;";
	    prevLi.onclick = () => movePage(pageInfo.startPage - 1, boardNum);
	    pagination.appendChild(prevLi);
	}

	// 페이지 번호 리스트
	for (let i = pageInfo.startPage; i <= pageInfo.endPage; i++) {
	    const pageLi = document.createElement("li");
	    pageLi.className = "studylist-li-paginationlist";
	    pageLi.innerText = i;
	    pageLi.onclick = () => movePage(i, boardNum);

	    if (i === pageInfo.page) {
	        pageLi.classList.add("currentpage"); // 현재 페이지 강조
	    }

	    pagination.appendChild(pageLi);
	}

	// 다음 버튼 (next)
	if (pageInfo.next) {
	    const nextLi = document.createElement("li");
	    nextLi.className = "studylist-li-paginationlist next";
	    nextLi.innerHTML = "&#62;";
	    nextLi.onclick = () => movePage(pageInfo.endPage + 1, boardNum);
	    pagination.appendChild(nextLi);
	}
}

// 댓글 등록
/*function writeComment() {
   let comment = document.getElementById("STUDYLIST-TEXTAREA-COMMENT").value;
   if (comment == "") {
	  alert("댓글을 입력해주세요");
   } else {
	  alert("댓글을 등록하였습니다.");
   }
}*/


document.addEventListener("click", function(event) {
	if (event.target.matches(".studylist-span-commenteditbtn")) {
		console.log("수정 버튼 클릭됨!");

		const li = event.target.closest("li"); // 클릭한 댓글의 <li> 찾기
		const replyNum = event.target.dataset.number; // 댓글 ID 가져오기
		console.log("li 요소:", li);
		console.log("댓글 ID:", replyNum);

		updateComment(li, replyNum);
	}
});


/*document.addEventListener("click", function(event) {
	if (event.target.matches(".studylist-span-commenteditbtn2")) {
			console.log("수정 완료 버튼 클릭됨!");

			const li = event.target.closest("li"); // 클릭한 댓글의 <li> 찾기
			console.log("li 요소:", li);
			const replyNum = event.target.dataset.number; // 댓글 ID 가져오기
			console.log("댓글 ID:", replyNum);

		}
})*/

// 댓글 수정완료 버튼 클릭 시
document.addEventListener("click", function(event) {
	if (event.target.matches(".studylist-span-commenteditbtn2")) {
		console.log("수정 완료 버튼 클릭됨!");

		const li = event.target.closest("li"); // 클릭한 댓글의 <li> 찾기
		const replyNum = event.target.dataset.number; // 댓글 ID 가져오기

		// 수정된 내용 가져오기
		const textarea = li.querySelector(".comment-contents");
		const updatedContent = textarea.value.trim();

		if (!updatedContent) {
			alert("댓글 내용을 입력해주세요.");
			return;
		}
		console.log("댓글 내용 나와라 : ", updatedContent);

		// AJAX 요청으로 서버에 업데이트 요청 (예제 코드)
		fetch(getContextPath() + "/study/studyCommentUpdateOk.st", {
			method: "POST",
			headers: { "Content-Type": "application/json; charset=utf-8" },
			body: JSON.stringify({ commentNum: replyNum, commentContent: updatedContent })
		})
		.then(response => response.json())
		.then(result => {
			if (result.status === "success") {
				alert("댓글이 수정되었습니다.");

				// 댓글 내용 업데이트
				const contentDiv = li.querySelector(".studylist-span-commentcontent");
				contentDiv.innerText = updatedContent;

				// 버튼을 다시 "수정 | 삭제" 상태로 변경
				const btnGroup = li.querySelector(".studylist-detail-div-btnwrapper");
				btnGroup.innerHTML = `
					<span class="studylist-span-commenteditbtn" data-number="${replyNum}">수정</span> 
					<span class="studylist-span-divider">|</span> 
					<span class="studylist-span-commentdeletebtn" data-number="${replyNum}">삭제</span>
				`;
			} else {
				alert("댓글 수정에 실패했습니다.");
			}
		})
		.catch(error => {
			console.error("댓글 수정 실패:", error);
			alert("댓글 수정 중 오류가 발생했습니다.");
		});
	}
});



function updateComment(li, replyNum) {
	console.log("🔵 댓글 수정 시작!");

	const contentDiv = li.querySelector(".studylist-span-commentcontent"); // 기존 댓글 내용 찾기
	console.log("🟢 contentDiv 요소:", contentDiv);

	if (!contentDiv) {
		console.error("❌ 댓글 내용을 찾을 수 없습니다.");
		return;
	}

	const originalContent = contentDiv.textContent.trim();
	contentDiv.innerHTML = `<textarea class="comment-contents">${originalContent}</textarea>`;

	// "수정 완료" 버튼 추가
	const btnGroup = li.querySelector(".studylist-detail-div-btnwrapper");
	console.log("🟢 버튼 그룹:", btnGroup);

	if (!btnGroup) {
		console.error("❌ 버튼 그룹을 찾을 수 없습니다.");
		return;
	}

	btnGroup.innerHTML = `
        <span class="studylist-span-commenteditbtn2" data-number="${replyNum}">수정 완료</span>
		<span class="studylist-span-divider">|</span>
        <span class="studylist-span-commentcancelbtn2" data-number="${replyNum}">취소</span>
    `;
}


//댓글 수정 상태일때 취소를 누를 떄의 이벤트
document.addEventListener("click", function(event) {
    // "수정 완료" 버튼 클릭 시
    if (event.target.matches(".studylist-span-commentcancelbtn2")) {
        const li = event.target.closest("li"); // 해당 댓글의 <li> 찾기
        const replyNum = event.target.dataset.number; // 댓글 ID 가져오기

        if (!li || !replyNum) {
            console.error("❌ 댓글 요소 또는 ID를 찾을 수 없습니다.");
            return;
        }

        const contentDiv = li.querySelector(".studylist-span-commentcontent"); // 댓글 내용 요소 찾기
        const textarea = li.querySelector(".comment-contents"); // textarea 찾기

        if (!contentDiv || !textarea) {
            console.error("❌ 댓글 내용을 찾을 수 없습니다.");
            return;
        }

        const updatedContent = textarea.value.trim(); // 수정된 내용 가져오기
        contentDiv.innerHTML = updatedContent; // 댓글 내용 업데이트

        // 버튼 그룹 원래대로 복원
        const btnGroup = li.querySelector(".studylist-detail-div-btnwrapper");
        if (!btnGroup) {
            console.error("❌ 버튼 그룹을 찾을 수 없습니다.");
            return;
        }

        btnGroup.innerHTML = `
            <span class="studylist-span-commenteditbtn" data-number="${replyNum}">수정</span>
            <span class="studylist-span-divider">|</span>
			<span class="studylist-span-commentdeletebtn" data-number="${replyNum}">삭제</span>
        `;
    }
});



//댓글 삭제
document.addEventListener("click", function(event) {
    if (event.target.matches(".studylist-span-commentdeletebtn")) {
        const li = event.target.closest("li"); // 클릭한 댓글의 <li> 찾기
        const studyCommentNum = event.target.dataset.number; // 댓글 ID 가져오기

        if (!studyCommentNum) {
            console.error("❌ 댓글 ID를 찾을 수 없습니다.");
            return;
        }

        if (confirm("해당 댓글을 삭제하시겠습니까?")) {
            fetch(getContextPath() + `/study/studyCommentDeleteOk.st?studyCommentNum=${studyCommentNum}`, {
                method: "GET"
            })
            .then(response => {                
				if (!response.ok) {
                    throw new Error("서버 응답 실패");
                }
                return response.text(); // 성공 시 응답 받기
            })
            .then(() => {
                alert("댓글이 삭제되었습니다.");
                li.remove(); // UI에서 댓글 삭제
            })
            .catch(error => {
                console.error("❌ 댓글 삭제 실패:", error);
                alert("댓글 삭제 중 오류가 발생했습니다.");
            });
        }
    }
});

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
/*function closeModal() {
	document.getElementById("STUDYLIST-MODAL-APPLY").style.display = "none";
}*/
function closeModal() {
    let modal = document.getElementById("STUDYLIST-MODAL-APPLY");
    if (modal) {
        modal.style.display = "none";
    }
}


//각오 등록
function writeCourage(studyNum) {
	//각오를 입력했는지 여부를 판단
	//event.preventDefault();

	let userDetermination = document.getElementById("STUDYLIST-TEXTAREA-COURAGE").value;
	let disclaimer = document.getElementById("STUDYLIST-CHECKBOX-AGREE").checked;

	console.log("dfsfsdf : " + userDetermination);

	if (userDetermination === "") {
		alert("각오를 입력해주세요.");
		return;
	}

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
			},
		});
	}

}
