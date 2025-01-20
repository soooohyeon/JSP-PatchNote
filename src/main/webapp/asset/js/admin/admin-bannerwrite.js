
// 배너 이미지 등록시 미리보기 사진 띄우기
const imgNameArea = document.querySelector('#BANNERIMAGE-NAME');
function setThumbnail(e) {
  var reader = new FileReader();

  reader.onload = function(e) {
    // img 태그 생성
    var img = document.createElement("img");
    // img 태그 src 속성에 해당 이미지 담기
    img.setAttribute("src", e.target.result);
    
    // 이미지를 넣을 공간
    let bannerimgwrap = document.querySelector("div.bannerimgwrap");
    
    bannerimgwrap.children[0].remove();
    bannerimgwrap.appendChild(img);
  };
  // 이미지명 화면에 뿌리기
  imgNameArea.textContent = e.target.files[0].name;
  reader.readAsDataURL(e.target.files[0]);
}

// 배너 최초 등록시 - 제목이나 사진 없이 저장 버튼 클릭시 알람창 띄우기
function clickSaveBtn(e) {
  let bannerTitle = document.querySelector('#bannerName').value;
  let bannerImg = document.querySelector('#bannerImg').value;
  if (!bannerTitle ) {  // 제목 미입력시
    alert('제목을 입력해주세요.');
  } else if (!bannerImg) {  // 배너 사진 미첨부시
    alert('배너를 등록해주세요.');
  } else {  // 제목, 배너 사진 값이 전부 입력됐을 때
      e.setAttribute("type", "submit");
  }
}

// 배너 수정시 - 제목이나 사진 없이 저장 버튼 클릭시 알람창 띄우기
function clickUpdateBtn(e) {
  let bannerTitle = document.querySelector('#bannerName').value;
  let bannerImg = document.querySelector('#bannerImg').value;
  if (!bannerTitle ) {  // 제목 미입력시
    alert('제목을 입력해주세요.');
  } else if (!bannerImg) {  // 배너 사진 미첨부시
    alert('배너를 다시 등록해주세요.');
  } else {  // 제목, 배너 사진 값이 전부 입력됐을 때
      e.setAttribute("type", "submit");
  }
}

// 취소 버튼 클릭시 목록으로 되돌아가기
function clickCancelBtn() {
  history.back();
}