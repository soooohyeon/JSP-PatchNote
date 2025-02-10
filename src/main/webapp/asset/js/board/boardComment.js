/* 루트 경로 담은 함수 */
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));

	return contextPath;
}

$(document).ready(function () {
    // jQuery 게시글 처리
    const title = $(".boardlistdetail-div-title h2");
    const boardNum = title.attr("data-boardNum"); // HTML의 data-boardnumber 값
    /*const memberNumber = listBtn.data("memberNumber"); // JSP에서 전역 변수로 전달된 값*/

    console.log("확인 title:", title);
    console.log("확인 boardNum:", boardNum);
    /*console.log("확인 memberNumber:", memberNumber);*/

/*    listBtn.on("click", () => window.location.href = "/board/boardListOk.bo");
    $(".modify-btn").on("click", () => window.location.href = `/board/boardUpdate.bo?boardNumber=${boardNumber}`);

    $(".delete-btn").on("click", function () {
        if (confirm("정말 삭제하시겠습니까?")) {
            $.ajax({
                url: `/board/boardDeleteOk.bo?boardNumber=${boardNumber}`,
                type: "GET",
                success: () => {
                    alert("게시글이 삭제되었습니다.");
                    window.location.href = "/board/boardListOk.bo";
                },
                error: (xhr, status, error) => {
                    console.error("게시글 삭제 실패 :", error);
                    alert("게시글 삭제에 실패했습니다.");
                }
            });
        }
    });*/

    // 댓글 작성 (fetch)
	const submitBtn = document.querySelector(".boardlistdetail-btn-commentsubmit");
    submitBtn?.addEventListener("click", async function () {
        const content = document.querySelector("#BOARDLISTDETAIL-TEXTAREA-COMMENT").value.trim();
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
                content.value = "";
                /*loadReplies();*/
            } else {
                alert("댓글 작성에 실패했습니다.");
            }
        } catch (error) {
            console.error("댓글 작성 실패:", error);
            alert("댓글 작성 중 오류가 발생했습니다.");
        }
    });

/*    // 댓글 삭제 (fetch, 이벤트 위임)
    document.querySelector(".comment-list").addEventListener("click", async function (event) {
        if (event.target.matches(".comment-delete")) {
            const replyNumber = event.target.dataset.number;
            if (confirm("댓글을 삭제하시겠습니까?")) {
                try {
                    const response = await fetch(`/reply/replyDeleteOk.re?replyNumber=${replyNumber}`, { method: "GET" });
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
    });

    //댓글 수정 준비 (fetch)
    document.querySelector(".comment-list").addEventListener("click", function (event) {
        if (event.target.matches(".comment-modify-ready")) {
            const li = event.target.closest("li");
            const contentDiv = li.querySelector(".comment-content");
            const originalContent = contentDiv.textContent.trim();

            contentDiv.innerHTML = `<textarea class="modify-content">${originalContent}</textarea>`;
            event.target.closest(".comment-btn-group").innerHTML = `
                <button type="button" class="comment-modify" data-number="${event.target.dataset.number}">수정 완료</button>
            `;
        }
    });

    //댓글 수정 완료 (fetch)
    document.querySelector(".comment-list").addEventListener("click", async function (event) {
        if (event.target.matches(".comment-modify")) {
            const replyNumber = event.target.dataset.number;
            const newContent = event.target.closest("li").querySelector(".modify-content").value.trim();

            if (!newContent) {
                alert("댓글 내용을 입력해주세요.");
                return;
            }

            try {
                const response = await fetch("/reply/replyUpdateOk.re", {
                    method: "POST",
                    headers: { "Content-Type": "application/json; charset=utf-8" },
                    body: JSON.stringify({ replyNumber, replyContent: newContent })
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
    });
	*/

    //댓글 목록 로드 (fetch)
    async function loadReplies() {
        try {
            const response = await fetch(`/board/boardReplyListOk.bo?boardNum=${boardNum}`);
            if (!response.ok) throw new Error("댓글 목록을 불러오는 데 실패했습니다.");
            const replies = await response.json();
            renderReplies(replies);
        } catch (error) {
            console.error("댓글 목록 불러오기 실패:", error);
            alert("댓글 목록을 불러오는데 실패했습니다.");
        }
    }

    //댓글 렌더링
    function renderReplies(replies) {
        const commentList = document.querySelector("#BOARD-COMMENT-AREA");
        commentList.innerHTML = "";

        if (replies.length === 0) {
            commentList.innerHTML = "<li>댓글이 없습니다.</li>";
            return;
        }

        replies.forEach(reply => {
            const isMyComment = reply.userNum== userNum;
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
						<div class="boardlistdetail-detail-div-btnwrapper">
						  <span class="boardlistdetail-span-commenteditbtn" onclick="updateComment()">수정</span>
						  <span class="boardlistdetail-span-divider">|</span>
						  <span class="boardlistdetail-span-commentdeletebtn" onclick="deleteComment()">삭제</span>
						</div>
					</div>
				</div>
                `;
            commentList.appendChild(li);
        });
    }

	
/*	<div class="comment-info">
	                    <span class="writer">${reply.memberId}</span>
	                    <span class="date">${reply.replyDate}</span>
	                </div>
	                <div class="comment-content-wrap">
	                    <div class="comment-content">${reply.replyContent}</div>
	                    ${isMyComment ? `
	                        <div class="comment-btn-group">
	                            <button type="button" class="comment-modify-ready" data-number="${reply.replyNumber}">수정</button>
	                            <button type="button" class="comment-delete" data-number="${reply.replyNumber}">삭제</button>
	                        </div>
	                    ` : ""}
	                </div>*/
					
    // 초기 댓글 로드
    loadReplies();
});
