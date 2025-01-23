/**
 * 
 */

function goPage(boardNum) {
	location.href = getContextPath() + "/board/boarddetail.bo?boardNum=" + boardNum;
}
