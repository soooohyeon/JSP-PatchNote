/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

$(document).ready(function() {
	// jQuery 게시글 처리
	const title = $(".boardlistdetail-div-title h2");
	const boardNum = title.attr("data-boardNum"); // HTML의 data-boardnumber 값
	const userNum = title.attr("data-userNum"); // JSP에서 전역 변수로 전달된 값


	// 댓글 작성 (fetch)
	const submitBtn = document.querySelector(".boardlistdetail-btn-commentsubmit");
	submitBtn.addEventListener("click", async function() {
		const contentElement = document.querySelector("#BOARDLISTDETAIL-TEXTAREA-COMMENT");
		const content = contentElement.value.trim(); // content는 여전히 문자열 값
		if (!content) {
			alert("댓글 내용을 입력해주세요.");
			return;
		}
		
		try {
			const response = await fetch(getContextPath() + "/board/boardReplyWriteOk.bo", {
				method: "POST",
				headers: { "Content-Type": "application/json; charset=utf-8" },
				body: JSON.stringify({ boardNum, fbCommentContent: content })
			});

			const result = await response.json();
			
			if (result.status === "success") {
				alert("댓글이 작성되었습니다.");
				contentElement.value = "";
				loadReplies();
			} else {
				alert("댓글 작성에 실패했습니다.");
			}
		} catch (error) {
			console.error("댓글 작성 실패:", error);
			alert("댓글 작성 중 오류가 발생했습니다.");
		}
	});

	//댓글 목록 로드 (fetch)
	async function loadReplies() {
		try {
			const urlParams = new URLSearchParams(window.location.search);
			const page = urlParams.get("page");
			let response = null;
			
			if (page == null) {
				response = await fetch(getContextPath() + `/board/boardReplyListOk.bo?boardNum=${boardNum}`);
			} else {
				response = await fetch(getContextPath() + `/board/boardReplyListOk.bo?boardNum=${boardNum}&&page=` + page);
			}
			const data = await response.json();

			renderReplies(data.replies, data.pageInfo.total);
			loadPage(data.pageInfo, `${boardNum}`);
		} catch (error) {
			console.error("댓글 목록 불러오기 실패:", error);
			alert("댓글 목록을 불러오는데 실패했습니다.");
		}
	}

	//댓글 렌더링
	function renderReplies(replies, total) {
		const commentList = document.querySelector("#BOARD-COMMENT-AREA");
		const totalCount = document.querySelector(".boardlistdetail-span-commentcounter");
		commentList.innerHTML = "";

		if (replies.length === 0) {
			commentList.innerHTML = "<li>댓글이 없습니다.</li>";
			return;
		}
		
		total = "총 " + total + "개";
		totalCount.innerHTML = total;

		replies.forEach(reply => {
			const isMyComment = reply.userNum == userNum;
			const div = document.createElement("div");
			div.innerHTML = `
            <div class="boardlistdetail-div-commentlist">
               <div class="boardlistdetail-div-commentlayer">
                 <span class="boardlistdetail-span-commentnickname">${reply.userNick}</span>
                 <span class="boardlistdetail-span-commentdate">${reply.fbCommentUploadDate}</span>
               </div>
               <div class="boardlistdetail-div-commentlayer">
                 <span class="boardlistdetail-span-commentcontents">
                   ${reply.fbCommentContent}
                 </span>
				   ${isMyComment ? `
                  <div class="boardlistdetail-detail-div-btnwrapper">
                    <span class="boardlistdetail-span-commenteditbtn replyUpdate" data-number="${reply.fbCommentNum}">수정</span>
                    <span class="boardlistdetail-span-divider">|</span>
                    <span class="boardlistdetail-span-commentdeletebtn" data-number="${reply.fbCommentNum}">삭제</span>
                  </div>
					` : ""}
               </div>
            </div>
                `;
			commentList.appendChild(div);
		});
	}

	function loadPage(pageInfo, boardNum) {
		const pagination = document.querySelector("#BOARDLISTDETAIL-UL-PAGINATION");
		pagination.innerHTML = ""
		
		// 이전 버튼 (prev)
		if (pageInfo.prev) {
		    const prevLi = document.createElement("li");
		    prevLi.className = "boardlistdetail-li-paginationlist pre";
		    prevLi.innerHTML = "&lt;";
		    prevLi.onclick = () => movePage(pageInfo.startPage - 1, boardNum);
		    pagination.appendChild(prevLi);
		}

		// 페이지 번호 리스트
		for (let i = pageInfo.startPage; i <= pageInfo.endPage; i++) {
		    const pageLi = document.createElement("li");
		    pageLi.className = "boardlistdetail-li-paginationlist";
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
		    nextLi.className = "boardlistdetail-li-paginationlist next";
		    nextLi.innerHTML = "&#62;";
		    nextLi.onclick = () => movePage(pageInfo.endPage + 1, boardNum);
		    pagination.appendChild(nextLi);
		}
	}
	
	// 초기 댓글 로드
	loadReplies();
	
	document.addEventListener("click", function (event) {
	    const replyNum = event.target.dataset.number; // 댓글 번호 가져오기
		
	    // 댓글 수정 버튼 클릭 시
	    if (event.target.matches(".replyUpdate")) {
	        updateComment(event, replyNum);

	    // 댓글 수정취소 버튼 클릭 시
	    } else if (event.target.matches(".replyCancelBtn")) {
			console.log("replyNum : " + replyNum)
			cancelUpdateComment(event, replyNum);
			
		// 댓글 수정 완료 버튼 클릭 시
	    } else if (event.target.matches(".replyUpdateOk")) {
			updateOkComment(event, replyNum);
			
		// 댓글 삭제 버튼 클릭시
	    } else if (event.target.matches(".boardlistdetail-span-commentdeletebtn")) {
			console.log("댓글 삭제");
			deleteComment(replyNum);
	    }
	});
	
	//댓글 수정 완료 (fetch)
	async function updateOkComment(event, replyNum) {
		console.log("수정 완료 클릭");
		
		const newContent = event.target.closest(".boardlistdetail-div-commentlayer").querySelector("textarea").value.trim();

		console.log("replyNum : " + replyNum);
		console.log("newContent : " + newContent);
		
		if (!newContent) {
			alert("댓글 내용을 입력해주세요.");
			return;
		}

		try {
			const response = await fetch(getContextPath() + "/board/boardReplyUpdateOk.bo", {
				method: "POST",
				headers: { "Content-Type": "application/json; charset=utf-8" },
				body: JSON.stringify({ replyNum, replyContent: newContent })
			});

			const result = await response.json();
			if (result.status === "success") {
				alert("댓글이 수정되었습니다.");
				loadReplies();
			} else {
				alert("댓글 수정에 실패했습니다.");
			}
		} catch (error) {
			console.error("댓글 수정 실패:", error);
			alert("댓글 수정 중 오류가 발생했습니다.");
		}
	}

	// 댓글 삭제 (fetch, 이벤트 위임)
	async function deleteComment(replyNum) {
		console.log("replyNum : " + replyNum);
		if (confirm("댓글을 삭제하시겠습니까?")) {
			try {
				const response = await fetch(getContextPath() + `/board/boardReplyDeleteOk.bo?fbCommentNum=${replyNum}`);
				const result = await response.json();
				if (result.status === "success") {
					alert("댓글이 삭제되었습니다.");
					loadReplies();
				} else {
					alert("댓글 삭제에 실패했습니다.");
				}
			} catch (error) {
				console.error("댓글 삭제 실패:", error);
				alert("댓글 삭제 중 오류가 발생했습니다.");
			}
		}
	}
	 
function updateComment(event, replyNum) {
	console.log("*** replyNum : " + replyNum);
	console.log("*** event : " + event);
    const currentList = event.target.closest(".boardlistdetail-div-commentlist");

	// 모든 댓글 수정 모드 초기화
	const allLists = document.querySelectorAll(".boardlistdetail-div-commentlist");

	allLists.forEach(list => {
		const contentDiv = list.querySelector(".boardlistdetail-span-commentcontents");

		if (contentDiv && contentDiv.dataset.originalContent !== undefined) {
			// 1. 내용 복원
			contentDiv.innerText = contentDiv.dataset.originalContent;

			// 2. 버튼 복원
			const btnWrapper = list.querySelector(".boardlistdetail-detail-div-btnwrapper");

			if (btnWrapper) {
				// 버튼 중 아무거나에서 data-number 가져오기
				const numberElement = btnWrapper.querySelector("[data-number]");
				const replyNum = numberElement ? numberElement.dataset.number : null;

				if (replyNum) {
					btnWrapper.innerHTML = renderDefaultButtons(replyNum);
				}
			}

			// 3. 원본 content 삭제
			delete contentDiv.dataset.originalContent;
		}
	});

    // 현재 댓글 수정 모드로 전환
    const contentDiv = currentList.querySelector(".boardlistdetail-span-commentcontents");
    const originalContent = contentDiv.innerText;

    // 원래 내용 저장
    contentDiv.dataset.originalContent = originalContent;

    // input 삽입
    const inputElement = document.createElement("input");
    inputElement.type = "text";
    inputElement.value = originalContent;
    inputElement.className = "boardlistdetail-input-edit";
	inputElement.dataset.number = replyNum;

    contentDiv.innerHTML = "";
    contentDiv.appendChild(inputElement);

    currentList.querySelector(".boardlistdetail-detail-div-btnwrapper").innerHTML =
        renderEditButtons(replyNum);
}

function renderDefaultButtons(replyNum) {
    return `
        <span class="boardlistdetail-span-commenteditbtn replyUpdate" data-number="${replyNum}">수정</span>
        <span class="boardlistdetail-span-divider">|</span>
        <span class="boardlistdetail-span-commentdeletebtn" data-number="${replyNum}">삭제</span>
    `;
}

function renderEditButtons(replyNum) {
    return `
        <button type="button" class="boardlistdetail-span-commenteditbtn replyUpdateOk" data-number="${replyNum}">수정 완료</button>
        <button type="button" class="boardlistdetail-span-commenteditbtn replyCancelBtn" data-number="${replyNum}">취소</button>
    `;
}

function cancelUpdateComment(event, replyNum) {
    const list = event.target.closest(".boardlistdetail-div-commentlist");
    const contentDiv = list.querySelector(".boardlistdetail-span-commentcontents");

    const originalContent = contentDiv.dataset.originalContent;

    if (originalContent !== undefined) {
        contentDiv.innerText = originalContent;

        list.querySelector(".boardlistdetail-detail-div-btnwrapper").innerHTML =
            renderDefaultButtons(replyNum);

        delete contentDiv.dataset.originalContent;
    }
}

});


